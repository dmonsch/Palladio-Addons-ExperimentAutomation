package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataFactory;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroupRun;
import org.palladiosimulator.edp2.models.ExperimentData.Measurements;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementsRange;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2Datasource;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.NestedIntervalsValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.Measurement;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class AddDynamicVariationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final ExperimentDataFactory EXPERIMENT_DATA_FACTORY = ExperimentDataFactory.eINSTANCE;

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

                    final EDP2Datasource edp2datasource = this.simulationConfiguration.getDatasource();
                    final Repository repository = RepositoryManager.getRepositoryFromUUID(edp2datasource.getId());
                    final String purpose = AbstractSimulationConfigFactory
                            .computeExperimentGroupPurpose(this.experiment);

                    // FIXME store current exp. group ID in analysis run and use it here. [Lehrig]
                    ExperimentGroup experimentGroup = null;
                    for (final ExperimentGroup expGroup : repository.getExperimentGroups()) {
                        if (expGroup.getPurpose().equals(purpose)) {
                            experimentGroup = expGroup;
                            break;
                        }
                    }
                    if (experimentGroup == null) {
                        throw new RuntimeException("Could not find referenced Experiment Group");
                    }

                    // FIXME store current exp. group run ID in analysis run and use it here.
                    // [Lehrig]
                    ExperimentGroupRun experimentGroupRun = null;
                    for (final ExperimentGroupRun expGroupRun : experimentGroup.getReports()) {
                        if (true) {
                            experimentGroupRun = expGroupRun;
                            break;
                        }
                    }
                    if (experimentGroupRun == null) {
                        experimentGroupRun = EXPERIMENT_DATA_FACTORY.createExperimentGroupRun();
                        experimentGroupRun.setStartTime(new Date()); // FIXME
                        experimentGroupRun.setDuration(Measure.valueOf(10, SI.SECOND)); // FIXME
                        experimentGroupRun.setExperimentgroup(experimentGroup);
                    }

                    Measurements measurements = null;
                    for (final Measurements measurem : experimentGroupRun.getMeasurements()) {
                        if (measurem.getMeasure().getMetric().getId()
                                .equals(MetricDescriptionConstants.USER_CAPACITY_TUPLE.getId())) {
                            measurements = measurem;
                            break;
                        }
                    }
                    if (measurements == null) {
                        final StringMeasuringPoint capacityAMeasuringPoint = MEASURING_POINT_FACTORY
                                .createStringMeasuringPoint(); // FIXME
                        capacityAMeasuringPoint.setMeasuringPoint("System Capacity");

                        final org.palladiosimulator.edp2.models.ExperimentData.Measure measure = EXPERIMENT_DATA_FACTORY
                                .createMeasure();
                        measure.setMetric(MetricDescriptionConstants.USER_CAPACITY_TUPLE);
                        measure.setMeasuringPoint(capacityAMeasuringPoint);
                        measure.setExperimentGroup(experimentGroup);

                        measurements = EXPERIMENT_DATA_FACTORY.createMeasurements();
                        measurements.setMeasure(measure);
                        measurements.setRun(experimentGroupRun);

                        final MeasurementsRange measurementRange = EXPERIMENT_DATA_FACTORY.createMeasurementsRange();
                        measurementRange.setMeasurements(measurements);

                        final RawMeasurements rawMeasurements = EXPERIMENT_DATA_FACTORY.createRawMeasurements();
                        rawMeasurements.setMeasurementsRange(measurementRange);

                        MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
                    }

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
                    MeasurementsUtility.storeMeasurement(measurements, resultMeasurement);
                    repository.flush();
                    // object
                    // MeasurementsUtility.ensureOpenRepository(repo);
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
