package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.palladiosimulator.edp2.dao.exception.DataNotAccessibleException;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

public class ExperimentMasurementsUtils {

    /**
     * Finds the measurements referenced by the SLO in the given measurements lists. For
     * identification, this methods tries to match metric IDs and measuring point names.
     * 
     * @param measurementList
     *            the list of measurements to be investigated for a match.
     * @param serviceLevelObjective
     *            the SLO providing metric and measuring point for matching.
     * @return the found measurements object.
     * @throws RuntimeException
     *             if no measurements object can be found.
     */
    public static Measurement findMeasurement(final List<Measurement> measurementList,
            final ServiceLevelObjective serviceLevelObjective) {
        for (final Measurement measurement : measurementList) {
            if (containsMetric(measurement.getMeasuringType().getMetric(), serviceLevelObjective
                    .getMeasurementSpecification().getMetricDescription())) {
                final String measureMeasuringPoint = measurement.getMeasuringType().getMeasuringPoint()
                        .getStringRepresentation();
                final String sloMeasuringPoint = serviceLevelObjective.getMeasurementSpecification().getMonitor()
                        .getMeasuringPoint().getStringRepresentation();

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
                    return measurement;
                }
            }
        }
        throw new RuntimeException("Measurement for SLO \"" + serviceLevelObjective.getName()
                + "\" not found. MeasurementList has " + measurementList.size() + " elements.");
    }

    public static boolean containsMetric(MetricDescription metric, MetricDescription metricToCheckFor) {
        if (metric == metricToCheckFor || metric.getId().equals(metricToCheckFor.getId())) {
            return true;
        }

        if (metric instanceof MetricSetDescription) {
            for (MetricDescription subMetric : ((MetricSetDescription) metric).getSubsumedMetrics()) {
                if (containsMetric(subMetric, metricToCheckFor)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns an experiment group object from the given repository, based on the experiment group
     * purpose member variable.
     * 
     * @param repository
     *            the repository containing the experiment group.
     * @param purpose
     *            the unique name of an experiment run; used to identify the experiment group of the
     *            last analysis run.
     * @return the experiment group of interest.
     */
    public static ExperimentGroup getExperimentGroup(final Repository repository, final String purpose) {
        for (final ExperimentGroup experimentGroup : repository.getExperimentGroups()) {
            if (experimentGroup.getPurpose().equals(purpose)) {
                return experimentGroup;
            }
        }

        throw new IllegalArgumentException("Could not find experiment group with purpose \"" + purpose + "\"");
    }

    /**
     * Returns the experiment setting from the given experiment group that is identified by the
     * unique experiment setting description string.
     * 
     * @param experimentGroup
     *            the experiment group to be investigated.
     * @param experimentSettingDescription
     *            the unique experiment setting description identifier.
     * @return the experiment setting whose description matches the given identifier string.
     */
    public static ExperimentSetting getExperimentSetting(final ExperimentGroup experimentGroup,
            final String experimentSettingDescription) {
        for (final ExperimentSetting expSetting : experimentGroup.getExperimentSettings()) {
            if (expSetting.getDescription().equals(experimentSettingDescription)) {
                return expSetting;
            }
        }

        throw new IllegalArgumentException("Could not find experiment setting for variation \""
                + experimentSettingDescription + "\"");
    }

    /**
     * Returns the EDP2 repository containing measurements from the last analysis run.
     * 
     * @param edp2datasourceID
     *            the EDP2 datasource ID to get measurements from.
     * @return the EDP2 repository.
     */
    public static Repository getEDP2Repository(final String edp2datasourceID) {
        final Repository repository = RepositoryManager.getRepositoryFromUUID(edp2datasourceID);

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