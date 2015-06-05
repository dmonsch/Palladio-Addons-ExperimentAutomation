package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.Iterator;
import java.util.List;

import javax.measure.Measure;
import javax.measure.unit.SI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2Datasource;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.StaticBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.IConfidenceEstimator;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Repeats the given experiment for a given tool and a given set of variations.
 * 
 * @author Sebastian Lehrig
 */
public class RepeatExperimentJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(RepeatExperimentJob.class);

    private final EDP2Datasource datasoruce;

    /** mean of the observations and the corresponding confidence interval */
    private ConfidenceInterval confidence;

    private boolean confidenceReached = false;

    private final IBatchAlgorithm batchAlgorithm;

    private final IConfidenceEstimator estimator;

    private final double confidenceLevel;

    private final double halfWidth;

    private int minBatches;

    private final Experiment experiment;
    private final AbstractSimulationConfiguration simulationConfiguration;
    private final List<VariationFactorTuple> variationFactorTuples;

    /**
     * Default Constructor.
     * 
     * @param experiment
     *            the experiment to be conducted.
     * @param simulationConfiguration
     *            the given analysis tool, e.g., SimuCom.
     * @param variationFactorTuples
     *            the variations and according value factors.
     */
    public RepeatExperimentJob(final Experiment experiment,
            final AbstractSimulationConfiguration simulationConfiguration,
            final List<VariationFactorTuple> variationFactorTuples) {
        super(false);

        datasoruce = simulationConfiguration.getDatasource();
        this.batchAlgorithm = new StaticBatchAlgorithm(10, 5);
        this.estimator = new SampleMeanEstimator();
        // TODO: Decide about real values here.
        this.confidenceLevel = 0.5;
        this.halfWidth = 0.5;
        this.minBatches = 0;
        this.experiment = experiment;
        this.simulationConfiguration = simulationConfiguration;
        this.variationFactorTuples = variationFactorTuples;
        this.add(new RunExperimentJob(experiment, simulationConfiguration, variationFactorTuples, 1));

    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        do {
            super.execute(monitor);
            analyzeLastExperimentsReconfigurationTimes();
            this.add(new RunExperimentJob(experiment, simulationConfiguration, variationFactorTuples, 1));
        } while (!confidenceReached);
    }

    private void analyzeLastExperimentsReconfigurationTimes() {
        final Repository repository = ExperimentMasurementsUtils.getEDP2Repository(datasoruce.getId());
        final ExperimentGroup experimentGroup = ExperimentMasurementsUtils.getExperimentGroup(repository,
                this.experiment.getName() + " []");
        ExperimentSetting experimentSetting = ExperimentMasurementsUtils.getExperimentSetting(experimentGroup,
                "Variation [] [" + this.simulationConfiguration.getName() + "]");

        final int lastExperiment = experimentSetting.getExperimentRuns().size() - 1;
        final ExperimentRun experimentRun = experimentSetting.getExperimentRuns().get(lastExperiment);

        for (Measurement measurement : experimentRun.getMeasurement()) {
            if (measurement.getMeasuringType().getMetric()
                    .equals(MetricDescriptionConstants.RECONFIGURATION_TIME_METRIC_TUPLE)) {
                for (MeasurementRange measurementRange : measurement.getMeasurementRanges()) {

                    final RawMeasurements rawMeasurements = measurementRange.getRawMeasurements();

                    final IDataSource dataSource = new Edp2DataTupleDataSource(rawMeasurements);

                    for (Iterator<IMeasureProvider> iterator = dataSource.getDataStream().iterator(); iterator
                            .hasNext();) {
                        TupleMeasurement tuple = (TupleMeasurement) iterator.next();
                        Measure reconfigurationPoint = tuple
                                .getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC);
                        Measure reconfigurationTime = tuple
                                .getMeasureForMetric(MetricDescriptionConstants.RECONFIGURATION_TIME_METRIC);
                        LOGGER.info("---- Point: " + reconfigurationPoint + " --> " + reconfigurationTime);

                        computeConfidenceInterval(reconfigurationTime.doubleValue(SI.SECOND));
                    }
                }
            }
        }
    }

    private void computeConfidenceInterval(double sample) {
        batchAlgorithm.offerSample(sample);
        if (batchAlgorithm.hasValidBatches() && batchAlgorithm.getBatchMeans().size() >= minBatches) {
            // estimate actual confidence interval
            final ConfidenceInterval ci = estimator.estimateConfidence(batchAlgorithm.getBatchMeans(), confidenceLevel);

            if (ci != null) {
                // construct target confidence interval
                final ConfidenceInterval targetCI = new ConfidenceInterval(ci.getMean(), halfWidth, confidenceLevel);

                if (targetCI.contains(ci)) {
                    if (LOGGER.isEnabledFor(Level.INFO)) {
                        LOGGER.info("Requested confidence reached.");
                    }
                    confidenceReached = true;
                    this.confidence = ci;

                    // request another batch in order to proceed with improving
                    // confidence interval's half-width until the simulation
                    // actually stops.
                    minBatches = batchAlgorithm.getBatchMeans().size() + 1;
                } else {
                    if (LOGGER.isEnabledFor(Level.INFO)) {
                        LOGGER.info("Requested confidence not yet reached.");
                    }

                    // request another batch in order to reduce the confidence
                    // interval's half-width
                    minBatches = batchAlgorithm.getBatchMeans().size() + 1;
                }
                if (LOGGER.isEnabledFor(Level.INFO)) {
                    LOGGER.info("Current confidence interval: Mean " + ci.getMean() + ", " + confidenceLevel * 100
                            + "% Confidence Interval " + "[" + ci.getLowerBound() + "," + ci.getUpperBound() + "]");
                }
            }
        }
    }

}
