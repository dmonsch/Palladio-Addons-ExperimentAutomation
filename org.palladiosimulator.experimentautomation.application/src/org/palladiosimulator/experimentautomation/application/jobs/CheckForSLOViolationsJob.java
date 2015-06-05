package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2Datasource;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;
import org.palladiosimulator.servicelevelobjective.edp2.filters.SLOViolationEDP2DatasourceFilter;
import org.palladiosimulator.servicelevelobjective.edp2.filters.SLOViolationEDP2DatasourceFilterConfiguration;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This jobs checks for SLO violations and calls
 * <code>this.runAnalysisJob.setSloWasViolated()</code> if it was violated at least once. Therefore,
 * such SLO-violating analysis runs are marked.
 * 
 * @author Sebastian Lehrig
 */
public class CheckForSLOViolationsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * The job conducting an analysis and providing measurement results to the persistence
     * framework.
     */
    private final RunAnalysisJob runAnalysisJob;

    /** A set of SLOs to be checked for. */
    private final ServiceLevelObjectiveRepository serviceLevelObjectives;

    /** The experiment setting to be investigated for SLO violations. */
    private final ExperimentSetting experimentSetting;

    /**
     * Default constructor.
     * 
     * @param runAnalysisJob
     *            the job conducting an analysis and providing measurement results to the
     *            persistence framework.
     * @param serviceLevelObjectives
     *            a set of SLOs to be checked for.
     * @param edp2datasource
     *            the EDP2 persistence framework providing measurement data.
     * @param experimentGroupPurpose
     *            the unique name of an experiment run; used to identify the experiment group of the
     *            last analysis run.
     * @param experimentSettingDescription
     *            a unique identifier string for the experiment setting description to check SLOs
     *            for.
     */
    public CheckForSLOViolationsJob(final RunAnalysisJob runAnalysisJob,
            final ServiceLevelObjectiveRepository serviceLevelObjectives, final EDP2Datasource edp2datasource,
            final String experimentGroupPurpose, final String experimentSettingDescription) {
        this.runAnalysisJob = runAnalysisJob;
        this.serviceLevelObjectives = serviceLevelObjectives;

        final Repository repository = ExperimentMasurementsUtils.getEDP2Repository(edp2datasource.getId());
        final ExperimentGroup experimentGroup = ExperimentMasurementsUtils.getExperimentGroup(repository,
                experimentGroupPurpose);
        this.experimentSetting = ExperimentMasurementsUtils.getExperimentSetting(experimentGroup,
                experimentSettingDescription);
    }

    /**
     * Computes the number of SLO violations and marks <code>this.runAnalysisJob</code> if at least
     * one was detected.
     * 
     * {@inheritDoc}
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        final long sloViolations = computeSloViolations();

        // TODO We are really intolerant against SLO violations. Instead, we may want that 99,99% of
        // all requests do not violate our SLO. This would require to extend the current SLO
        // metamodel. [Lehrig]
        if (sloViolations > 0) {
            this.runAnalysisJob.setSloWasViolated();
        }
    }

    /**
     * Computes the number of SLO violations.
     * 
     * @return the number of found SLO violations.
     */
    private long computeSloViolations() {
        final int lastExperiment = this.experimentSetting.getExperimentRuns().size() - 1;
        final ExperimentRun experimentRun = this.experimentSetting.getExperimentRuns().get(lastExperiment);

        long sloViolations = 0L;
        for (final ServiceLevelObjective serviceLevelObjective : this.serviceLevelObjectives
                .getServicelevelobjectives()) {
            final Measurement measurement = ExperimentMasurementsUtils.findMeasurement(experimentRun.getMeasurement(),
                    serviceLevelObjective);
            final RawMeasurements rawMeasurements = measurement.getMeasurementRanges().get(0).getRawMeasurements();

            final Map<String, Object> properties = new HashMap<String, Object>(1);
            properties.put(SLOViolationEDP2DatasourceFilterConfiguration.SLO_KEY, serviceLevelObjective);

            final IDataSource dataSource = new Edp2DataTupleDataSource(rawMeasurements);
            final SLOViolationEDP2DatasourceFilter sloFilter = new SLOViolationEDP2DatasourceFilter(dataSource);
            sloFilter.setProperties(properties);
            final IDataStream<MeasuringValue> dataStream = sloFilter.getDataStream();

            sloViolations += dataStream.size();
            dataStream.close();
        }

        return sloViolations;
    }

}
