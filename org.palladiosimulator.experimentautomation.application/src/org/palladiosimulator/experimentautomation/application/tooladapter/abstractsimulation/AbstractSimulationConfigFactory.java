package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2;
import org.palladiosimulator.experimentautomation.abstractsimulation.MeasurementCountStopCondition;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.SimTimeStopCondition;
import org.palladiosimulator.experimentautomation.abstractsimulation.StopCondition;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.edp2.EDP2Factory;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.recorderframework.edp2.EDP2RecorderConfigurationFactory;
import org.palladiosimulator.recorderframework.sensorframework.SensorFrameworkRecorderConfigurationFactory;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * This class allows to create the properties of an {@link AbstractSimulationConfig} run
 * configuration for an analyzer.
 * 
 * @author Sebastian Lehrig
 */
public class AbstractSimulationConfigFactory {

    private static final String EDP2_ID = "Experiment Data Persistency & Presentation (EDP2)";

    private static final String SENSOR_FRAMEWORK_ID = "SensorFramework";

    /**
     * Fills out the run configuration features of an {@link AbstractSimulationConfig}.
     * 
     * @param experiment
     *            the experiment specification.
     * @param simConfig
     *            the configuration of the concrete analyzer.
     * @param simulatorID
     *            the ID of the used analyzer.
     * @param variationFactorTuples
     *            the variations and according value factors.
     * @param repetition
     *            the current repetition number for the given experiment and variant. Needed for
     *            computing the name of the experiment run.
     * @return a filled-out run configuration.
     */
    public static Map<String, Object> createConfigMap(final Experiment experiment,
            final AbstractSimulationConfiguration simConfig, final String simulatorID,
            final List<VariationFactorTuple> variationFactorTuples) {
        final Map<String, Object> map = new HashMap<String, Object>();

        /***************************************************/
        /** Simulation Tab *********************************/
        /***************************************************/
        /** Simulator */
        map.put(AbstractSimulationConfig.SIMULATOR_ID, simulatorID);

        /** Experiment Run */
        map.put(AbstractSimulationConfig.EXPERIMENT_RUN, computeExperimentRunName(experiment));
        map.put(EDP2RecorderConfigurationFactory.VARIATION_ID,
                computeVariationName(simConfig, variationFactorTuples));

        /** Simulation Results */
        final PersistenceFramework persistenceFramework = simConfig.getPersistenceFramework();
        map.put(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, getPersistenceRecorderName(persistenceFramework));
        map.put(getPersistenceRecorderID(persistenceFramework), getPersistenceRecorder(persistenceFramework));

        /** Stop Conditions */
        map.put(AbstractSimulationConfig.SIMULATION_TIME, getMaximumSimulationTime(experiment, simConfig));
        map.put(AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT, getMaximumMeasurementCount(experiment, simConfig));

        /** Logging */
        map.put(AbstractSimulationConfig.VERBOSE_LOGGING, false);

        /***************************************************/
        /** Analysis Configuration Tab *********************/
        /***************************************************/
        /** Random Number Generator Seed */
        if (simConfig.getRandomNumberGeneratorSeed() != null) {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, true);

            final RandomNumberGeneratorSeed seed = simConfig.getRandomNumberGeneratorSeed();
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "0", seed.getSeed0());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "1", seed.getSeed1());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "2", seed.getSeed2());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "3", seed.getSeed3());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "4", seed.getSeed4());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "5", seed.getSeed5());
        } else {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, false);
        }

        // the class SimuComConfig expects map entries to have a value of type String
        adjustMapValueTypes(map);

        return map;
    }

    private static String computeExperimentRunName(final Experiment experiment) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(experiment.getName());
        stringBuilder.append(" [");
        stringBuilder.append(experiment.getId());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private static String computeVariationName(final AbstractSimulationConfiguration simConfig,
            final List<VariationFactorTuple> variationFactorTuples) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Variation ");
        stringBuilder.append(variationFactorTuples.toString());
        stringBuilder.append(" [");
        stringBuilder.append(simConfig.getName());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private static int getMaximumSimulationTime(final Experiment experiment,
            final AbstractSimulationConfiguration simConfig) {

        int result = getMaximumSimulationTime(experiment.getStopConditions());
        if (result == -1) { // Stick to defaults
            result = getMaximumSimulationTime(simConfig.getStopConditions());
        }

        return result;
    }

    private static int getMaximumSimulationTime(final EList<StopCondition> stopConditions) {
        for (final StopCondition s : stopConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getSimTimeStopCondition().isInstance(s)) {
                return ((SimTimeStopCondition) s).getSimulationTime();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the simulation time
        return -1;
    }

    private static int getMaximumMeasurementCount(final Experiment experiment,
            final AbstractSimulationConfiguration simConfig) {
        int result = getMaximumMeasurementCount(experiment.getStopConditions());
        if (result == -1) { // Stick to defaults
            result = getMaximumMeasurementCount(simConfig.getStopConditions());
        }

        return result;
    }

    private static int getMaximumMeasurementCount(final EList<StopCondition> stopConditions) {
        for (final StopCondition s : stopConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getMeasurementCountStopCondition().isInstance(s)) {
                return ((MeasurementCountStopCondition) s).getMeasurementCount();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the measurement count
        return -1;
    }

    private static String getPersistenceRecorderName(final PersistenceFramework persistenceFramework) {
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            return SENSOR_FRAMEWORK_ID;
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            return EDP2_ID;
        } else {
            throw new IllegalArgumentException("Tried to load unknown persistency framework");
        }
    }

    private static String getPersistenceRecorderID(final PersistenceFramework persistenceFramework) {
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            return SensorFrameworkRecorderConfigurationFactory.DATASOURCE_ID;
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            return EDP2RecorderConfigurationFactory.REPOSITORY_ID;
        } else {
            throw new IllegalArgumentException("Tried to load unknown persistency framework");
        }
    }

    private static String getPersistenceRecorder(final PersistenceFramework persistenceFramework) {
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            final SensorFramework sensorFramework = (SensorFramework) persistenceFramework;
            final Datasource datasource = sensorFramework.getDatasource();
            final IDAOFactory daoFactory = SensorFrameworkFactory.createOrOpenDatasource(datasource);

            return "" + daoFactory.getID();
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            final EDP2 edp2 = (EDP2) persistenceFramework;
            final Datasource datasource = edp2.getDatasource();
            final Repository repository = EDP2Factory.createOrOpenDatasource(datasource);

            return repository.getId();
        } else {
            throw new IllegalArgumentException("Tried to load unknown persistency framework");
        }
    }

    /**
     * TODO Check whether this method is actually still needed. [Lehrig]
     * 
     * Converts the values contained in the map to the data types that are expected by
     * {@link AbstractSimulationConfig}.
     * 
     * @param map
     *            the attributes map for a run configuration.
     */
    private static void adjustMapValueTypes(final Map<String, Object> map) {
        for (final Entry<String, Object> entry : map.entrySet()) {
            final Object value = entry.getValue();

            // As an exception, Booleans are not represented by string
            if (!(value instanceof Boolean)) {
                entry.setValue(value.toString());
            }
        }
    }
}
