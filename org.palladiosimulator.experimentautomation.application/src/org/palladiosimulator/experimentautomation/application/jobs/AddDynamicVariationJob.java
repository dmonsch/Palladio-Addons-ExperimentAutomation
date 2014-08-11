package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.NestedIntervalsValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.Measurement;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.recorderframework.AbstractRecorderConfiguration;
import org.palladiosimulator.recorderframework.IRecorderConfigurationFactory;
import org.palladiosimulator.recorderframework.Recorder;
import org.palladiosimulator.recorderframework.edp2.EDP2RawRecorder;
import org.palladiosimulator.recorderframework.edp2.EDP2ReportRecorderConfigurationFactory;
import org.palladiosimulator.recorderframework.launch.IRecorderConfiguration;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class AddDynamicVariationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final MeasuringpointFactory MEASURING_POINT_FACTORY = MeasuringpointFactory.eINSTANCE;

    private final IToolAdapter toolAdapter;
    private final Experiment experiment;
    private final AbstractSimulationConfiguration simulationConfiguration;
    private final List<VariationFactorTuple> variationFactorTuples;
    private final int repetition;
    private final Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> tuples2nestedIntervals;

    private RunAnalysisJob runAnalysisJob;

    public AddDynamicVariationJob(final RunAnalysisJob runAnalysisJob, final IToolAdapter toolAdapter,
            final Experiment experiment, final AbstractSimulationConfiguration simulationConfiguration,
            final List<VariationFactorTuple> variationFactorTuples, final int repetition) {
        super(true);

        this.runAnalysisJob = runAnalysisJob;
        this.toolAdapter = toolAdapter;
        this.experiment = experiment;
        this.simulationConfiguration = simulationConfiguration;
        this.variationFactorTuples = variationFactorTuples;
        this.repetition = repetition;

        this.tuples2nestedIntervals = computeNestedIntervalsValueProviders();
    }

    private Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> computeNestedIntervalsValueProviders() {
        final Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> result;
        result = new HashMap<VariationFactorTuple, NestedIntervalsValueProviderStrategy>();

        for (final VariationFactorTuple variationFactorTuple : this.variationFactorTuples) {
            final IValueProviderStrategy valueProvider = ValueProviderFactory.createValueProvider(variationFactorTuple
                    .getVariation().getValueProvider());

            if (valueProvider instanceof NestedIntervalsValueProviderStrategy) {
                final NestedIntervalsValueProviderStrategy nestedInterval = (NestedIntervalsValueProviderStrategy) valueProvider;
                result.put(variationFactorTuple, nestedInterval);

                // TODO where to output this data?
                System.out.println(nestedInterval);
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        if (this.tuples2nestedIntervals.size() > 0) {
            for (final VariationFactorTuple variationFactorTuple : this.tuples2nestedIntervals.keySet()) {
                final NestedIntervalsValueProviderStrategy nestedInterval = this.tuples2nestedIntervals
                        .get(variationFactorTuple);
                if (this.runAnalysisJob.sloWasViolated()) {
                    nestedInterval.setMax(nestedInterval.valueAtPosition(0) - 1L);
                } else {
                    nestedInterval.setMin(nestedInterval.valueAtPosition(0));
                }

                if (nestedInterval.isConverged()) {
                    this.tuples2nestedIntervals.remove(variationFactorTuple);

                    // Measurement
                    final Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(0d, SI.SECOND);
                    final Measure<Long, Dimensionless> capacityMeasure = Measure.valueOf(
                            nestedInterval.valueAtPosition(0), Dimensionless.UNIT);

                    final List<Measurement> result = new ArrayList<Measurement>(2);
                    result.add(new BasicMeasurement<Double, Duration>(pointInTimeMeasure,
                            MetricDescriptionConstants.POINT_IN_TIME_METRIC));
                    result.add(new BasicMeasurement<Long, Dimensionless>(capacityMeasure,
                            MetricDescriptionConstants.USER_CAPACITY));

                    final Measurement resultMeasurement = new TupleMeasurement(result,
                            MetricDescriptionConstants.USER_CAPACITY_TUPLE);

                    // Measuring Point
                    final StringMeasuringPoint capacityMeasuringPoint = MEASURING_POINT_FACTORY
                            .createStringMeasuringPoint(); // FIXME
                    capacityMeasuringPoint.setMeasuringPoint("System Capacity");

                    // Config
                    final Map<String, Object> recorderConfigurationMap = runAnalysisJob.getConfiguration();

                    recorderConfigurationMap.put(AbstractRecorderConfiguration.RECORDER_ACCEPTED_METRIC,
                            MetricDescriptionConstants.USER_CAPACITY_TUPLE);
                    recorderConfigurationMap.put(AbstractRecorderConfiguration.MEASURING_POINT, capacityMeasuringPoint);

                    // Recorder
                    final IRecorderConfigurationFactory edp2ConfigFactory = new EDP2ReportRecorderConfigurationFactory();
                    edp2ConfigFactory.initialize(recorderConfigurationMap);
                    final IRecorderConfiguration recorderConfiguration = edp2ConfigFactory
                            .createRecorderConfiguration(recorderConfigurationMap);
                    final Recorder reportRecorder = new EDP2RawRecorder();

                    // Write data
                    reportRecorder.initialize(recorderConfiguration);
                    reportRecorder.writeData(resultMeasurement);
                    reportRecorder.flush();

                    // Finish
                    edp2ConfigFactory.finalizeRecorderConfigurationFactory();

                    // TODO Remove debug output
                    System.out.println("CAPACITY=" + nestedInterval.valueAtPosition(0));
                } else {
                    variationFactorTuple.setFactor(nestedInterval.valueAtPosition(0));
                }

                // TODO where to output this data?
                System.out.println(nestedInterval);
            }

            if (this.tuples2nestedIntervals.size() > 0) {
                final IBlackboardInteractingJob<MDSDBlackboard> varyJob = new VaryJob(this.variationFactorTuples);
                varyJob.setBlackboard(this.getBlackboard());
                varyJob.execute(monitor);

                this.runAnalysisJob = this.toolAdapter.createRunAnalysisJob(this.experiment,
                        this.simulationConfiguration, this.variationFactorTuples, this.repetition);
                this.runAnalysisJob.setBlackboard(this.getBlackboard());
                this.runAnalysisJob.execute(monitor);

                this.execute(monitor);
            }
        }
    }
}
