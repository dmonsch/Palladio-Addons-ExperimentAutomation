package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.dao.exception.DataNotAccessibleException;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurements;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.edp2.util.MeasuringPointUtility;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.application.filters.SLOFilter;
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
    private final String experimentSettingDescription;

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
            final PersistenceFramework persistenceFramework, final String experimentGroupPurpose,
            final String experimentSettingDescription) {
        if (!AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            throw new IllegalArgumentException("CheckForSLOViolationsJob currently only works with EDP2");
        }

        this.runAnalysisJob = runAnalysisJob;
        this.serviceLevelObjectives = serviceLevelObjectives;
        this.persistenceFramework = persistenceFramework;
        this.experimentGroupPurpose = experimentGroupPurpose;
        this.experimentSettingDescription = experimentSettingDescription;
    }

    /**
     * Computes the number of SLO violations and marks <code>this.runAnalysisJob</code> if at least
     * one was detected.
     * 
     * {@inheritDoc}
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final Datasource datasource = this.persistenceFramework.getDatasource();
        final Repository repository = getEDP2Repository(datasource);
        final ExperimentGroup experimentGroup = getExperimentGroup(repository);
        final ExperimentSetting experimentSetting = getExperimentSetting(experimentGroup);
        final long sloViolations = computeSloViolations(experimentSetting);

        // TODO We are really intolerant against SLO violations. Instead, we may want that 99,99% of
        // all requests do not violate our SLO. This would require to extend the current SLO
        // metamodel. [Lehrig]
        if (sloViolations > 0) {
            this.runAnalysisJob.setSloWasViolated();
        }

        // TODO Move output to dedicated EDP2 Measurement? Store somewhere else?
        System.out.println("SLO Violations: " + sloViolations);
    }

    /**
     * Computes the number of SLO violations in the given data source.
     * 
     * @param experimentSetting
     *            the experiment setting to be investigated for SLO violations.
     * @return the number of found SLO violations.
     */
    private long computeSloViolations(final ExperimentSetting experimentSetting) {
        final int lastExperiment = experimentSetting.getExperimentRuns().size() - 1;
        final ExperimentRun experimentRun = experimentSetting.getExperimentRuns().get(lastExperiment);

        long sloViolations = 0L;
        for (final ServiceLevelObjective serviceLevelObjective : this.serviceLevelObjectives
                .getServicelevelobjectives()) {
            final Measurements measurements = findMeasurements(experimentRun.getMeasurements(), serviceLevelObjective);
            final RawMeasurements rawMeasurements = measurements.getMeasurementsRanges().get(0).getRawMeasurements();

            final IDataSource dataSource = new Edp2DataTupleDataSource(rawMeasurements);
            final SLOFilter sloFilter = new SLOFilter(dataSource, serviceLevelObjective);
            final IDataStream<Measurement> dataStream = sloFilter.getDataStream();
            for (final IMeasureProvider tuple : dataStream) {
                // process whole data stream

                // TODO Is that really how it should work? [Lehrig]
            }
            sloViolations += sloFilter.getSloViolations();
            dataStream.close();
        }

        return sloViolations;
    }

    /**
     * Finds the measurements referenced by the SLO in the given measurements lists. For
     * identification, this methods tries to match metric IDs and measuring point names.
     * 
     * @param measurementsList
     *            the list of measurements to be investigated for a match.
     * @param serviceLevelObjective
     *            the SLO providing metric and measuring point for matching.
     * @return the found measurements object.
     * @throws RuntimeException
     *             if no measurements object can be found.
     */
    private Measurements findMeasurements(final List<Measurements> measurementsList,
            final ServiceLevelObjective serviceLevelObjective) {
        for (final Measurements measurements : measurementsList) {
            final String measureMetric = measurements.getMeasure().getMetric().getId();
            final String sloMetric = serviceLevelObjective.getMetricDescription().getId();

            if (measureMetric.equals(sloMetric)) {
                final String measureMeasuringPoint = MeasuringPointUtility.measuringPointToString(measurements
                        .getMeasure().getMeasuringPoint());
                final String sloMeasuringPoint = MeasuringPointUtility.measuringPointToString(serviceLevelObjective
                        .getMeasuringPoint());

                // TODO Comparing the name of Measuring points is not the best solution (as the name
                // is generally not unique). I see three options, all requiring some architectural
                // refactoring at several places: (1) Require that every measuring point is an URI
                // measuring point -- then, the URI could be used to uniquely identify the measuring
                // point; (2) just use 1 measuring point for the same entity at a time -- then two
                // equal measuring points objects literally point to the same entity. For the
                // latter, we should attach measuring points directly to PCM elements and make them
                // intrinsic part of such elements; (3) create a MeasuringPointUtility method for
                // generating a measuring points ID based on the type of measuring point; URI
                // measuring points should generate the same ID as dedicated PCM measuring points if
                // they reference the same entity. Options should be discussed if this becomes an
                // important issue. [Lehrig]
                if (measureMeasuringPoint.equals(sloMeasuringPoint)) {
                    return measurements;
                }
            }
        }
        throw new RuntimeException("Measurement for SLO \"" + serviceLevelObjective.getName() + "\" not found");
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
        for (final ExperimentGroup experimentGroup : repository.getExperimentGroups()) {
            if (experimentGroup.getPurpose().equals(this.experimentGroupPurpose)) {
                return experimentGroup;
            }
        }

        throw new IllegalArgumentException("Could not find experiment group with purpose \""
                + this.experimentGroupPurpose + "\"");
    }

    private ExperimentSetting getExperimentSetting(final ExperimentGroup experimentGroup) {
        for (final ExperimentSetting experimentSetting : experimentGroup.getExperimentSettings()) {
            if (experimentSetting.getDescription().equals(this.experimentSettingDescription)) {
                return experimentSetting;
            }
        }

        throw new IllegalArgumentException("Could not find experiment setting for variation \""
                + this.experimentSettingDescription + "\"");
    }

    /**
     * Returns the EDP2 repository containing measurements from the last analysis run.
     * 
     * @param datasource
     *            the EDP2 datasource to get measurements from.
     * @return the EDP2 repository.
     */
    private Repository getEDP2Repository(final Datasource datasource) {
        final Repository repository = RepositoryManager.getRepositoryFromUUID(datasource.getId());

        if (repository == null) {
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
