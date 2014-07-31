package org.palladiosimulator.experimentautomation.application.jobs;

import javax.measure.Measure;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.dao.exception.DataNotAccessibleException;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.measurementframework.Measurement;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;

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

    private final RunAnalysisJob runAnalysisJob;
    private final ServiceLevelObjectiveRepository serviceLevelObjectives;
    private final PersistenceFramework persistenceFramework;
    private final String experimentGroupPurpose;

    /**
     * Default constructor.
     * 
     * @param runAnalysisJob
     *            the job conducting an analysis and providing measurement results to the
     *            persistence framework.
     * @param serviceLevelObjectives
     *            a set of SLOs to be checked for.
     * @param persistenceFramework
     *            the persistence framework providing measurement data. Currently, only EDP2 is
     *            supported.
     * @param experimentGroupPurpose
     *            the (hopefully?) unique name of an experiment run; used to identify the experiment
     *            group of the last analysis run.
     */
    public CheckForSLOViolationsJob(final RunAnalysisJob runAnalysisJob,
            final ServiceLevelObjectiveRepository serviceLevelObjectives,
            final PersistenceFramework persistenceFramework, final String experimentGroupPurpose) {
        if (!AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            throw new IllegalArgumentException("CheckForSLOViolationsJob currently only works with EDP2");
        }

        this.runAnalysisJob = runAnalysisJob;
        this.serviceLevelObjectives = serviceLevelObjectives;
        this.persistenceFramework = persistenceFramework;
        this.experimentGroupPurpose = experimentGroupPurpose;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final Datasource datasource = this.persistenceFramework.getDatasource();
        final Repository repository = getEDP2Repository(datasource);
        final ExperimentGroup experimentGroup = getExperimentGroup(repository);

        // FIXME I guess this code works only for special cases. Check that. [Lehrig]
        final IDataSource dataSource = new Edp2DataTupleDataSource(experimentGroup.getExperimentSettings().get(0)
                .getExperimentRuns().get(0).getMeasurements().get(2).getMeasurementsRanges().get(0)
                .getRawMeasurements());

        final long sloViolations = computeSloViolations(dataSource);
        if (sloViolations > 0) {
            this.runAnalysisJob.setSloWasViolated();
        }

        // TODO Move output to dedicated EDP2 Measurement? Store somewhere else?
        System.out.println("SLO Violations: " + sloViolations);
    }

    /**
     * Computes the number of SLO violations in the given data source.
     * 
     * FIXME Currently only checks for upper (hard) threshold. Lower and fuzzy thresholds are not
     * supported. [Lehrig]
     * 
     * @param dataSource
     *            the EDP2 datasource to get measurements from.
     * @return the number of found SLO violations.
     */
    @SuppressWarnings({
            "rawtypes", "unchecked"
    })
    private long computeSloViolations(final IDataSource dataSource) {
        long sloViolations = 0;
        final IDataStream<Measurement> dataStream = dataSource.getDataStream();

        for (final IMeasureProvider tuple : dataStream) {
            for (final ServiceLevelObjective serviceLevelObjective : this.serviceLevelObjectives
                    .getServicelevelobjectives()) {
                final Measure threshold = serviceLevelObjective.getUpperThreshold().getThresholdLimit();
                final Measure measurement = tuple.getMeasureForMetric(serviceLevelObjective.getMetricDescription());

                if (measurement.compareTo(threshold) > 0) {
                    sloViolations++;
                }
            }
        }
        dataStream.close();

        return sloViolations;
    }

    /**
     * Returns an experiment group object from the given repository, based on the experiment group
     * purpose member variable.
     * 
     * @param repository
     *            the repository containing the experiment group.
     * @return the experiment group of interest.
     */
    private ExperimentGroup getExperimentGroup(final Repository repository) {
        ExperimentGroup experimentGroup = null;
        for (final ExperimentGroup expGroup : repository.getExperimentGroups()) {
            if (expGroup.getPurpose().equals(this.experimentGroupPurpose)) {
                experimentGroup = expGroup;
                break;
            }
        }
        if (experimentGroup == null) {
            throw new IllegalArgumentException("CheckForSLOViolationsJob currently only works with EDP2");
        }
        return experimentGroup;
    }

    /**
     * Returns the EDP2 repository containing measurements from the last analysis run.
     * 
     * FIXME Memory datasources do not work. [Lehrig]
     * 
     * FIXME Repository IDs are hard coded; it currently only works because localfile IDs are
     * non-unique (which is a bug on its own). [Lehrig]
     * 
     * @param datasource
     *            the EDP2 datasource to get measurements from.
     * @return the EDP2 repository.
     */
    private Repository getEDP2Repository(final Datasource datasource) {
        final Repository repository;

        if (AbstractsimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            throw new RuntimeException(
                    "FIXME: Implement support for EDP2 memory datasouces. Only local files work as of now.");
        } else if (AbstractsimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            repository = RepositoryManager.getRepositoryFromUUID("org.palladiosimulator.edp2.dao.localfile.dao");
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }

        try {
            MeasurementsUtility.ensureOpenRepository(repository);
        } catch (DataNotAccessibleException e) {
            throw new RuntimeException("Could not open EDP2 repository");
        }

        return repository;
    }
}
