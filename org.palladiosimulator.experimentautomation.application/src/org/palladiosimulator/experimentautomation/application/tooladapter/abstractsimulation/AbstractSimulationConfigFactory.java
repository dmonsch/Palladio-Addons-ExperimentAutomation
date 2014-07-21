package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2;
import org.palladiosimulator.experimentautomation.abstractsimulation.MeasurementCountStopCondition;
import org.palladiosimulator.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.SimTimeStopCondition;
import org.palladiosimulator.experimentautomation.abstractsimulation.StopCondition;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.edp2.EDP2Factory;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import org.palladiosimulator.recorderframework.edp2.EDP2RecorderConfigurationFactory;
import org.palladiosimulator.recorderframework.sensorframework.SensorFrameworkRecorderConfigurationFactory;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * This class allows to create the properties of a run configuration for an analyzer.
 * 
 * @author Merkle, Sebastian Lehrig
 */
public class AbstractSimulationConfigFactory {

    public static Map<String, Object> createConfigMap(final AbstractSimulationConfiguration config,
            final List<StopCondition> stopConditions, final String experimentName) {
        final Map<String, Object> map = new HashMap<String, Object>();

        map.put(AbstractSimulationConfig.EXPERIMENT_RUN, experimentName);
        map.put(AbstractSimulationConfig.SIMULATION_TIME, getMaximumSimulationTime(config, stopConditions));
        map.put(AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT, getMaximumMeasurementCount(config, stopConditions));
        map.put(AbstractSimulationConfig.VERBOSE_LOGGING, false);
        map.put(AbstractSimulationConfig.BLACKBOARD_TYPE, config.getProbeSpecConfiguration().getBlackboardType());

        // FIXME Remove next few lines if done with replacement. [Lehrig]
        // Lehrig: Remove configuration via files. To be replaced by direct access to blackboard.
        // map.put(ConstantsContainer.ALLOCATION_FILE, model.getAllocationFile());
        // map.put(ConstantsContainer.USAGE_FILE, model.getUsagemodelFile());

        fillRandomNumberGeneratorSeed(config, map);
        // fillConfidenceStopCondition(config, map);
        fillAndConfigurePersistenceFramework(config, map);

        // the class SimuComConfig expects map entries to have a value of type String
        adjustMapValueTypes(map);

        return map;
    }

    /**
     * Converts the values contained in the map to the data types that are expected by
     * {@link AbstractSimulationConfig}.
     * 
     * @param map
     */
    private static void adjustMapValueTypes(final Map<String, Object> map) {
        for (final Entry<String, Object> entry : map.entrySet()) {
            final String key = entry.getKey();
            final Object value = entry.getValue();
            if (key.equals(SensorFrameworkRecorderConfigurationFactory.DATASOURCE_ID)) {
                // FIXME the DATASOURCE_ID should be of type String. Fix this in the class
                // de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkTab
                entry.setValue(((Long) value).intValue());
            } else if (value instanceof Boolean) {
                // do nothing: As an exception, Booleans are not represented by string
            } else {
                entry.setValue(value.toString());
            }
        }
    }

    private static void fillAndConfigurePersistenceFramework(final AbstractSimulationConfiguration config,
            final Map<String, Object> map) {
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(config.getPersistenceFramework())) {
            final SensorFramework sensorFramework = (SensorFramework) config.getPersistenceFramework();
            final Datasource datasource = sensorFramework.getDatasource();
            final IDAOFactory daoFactory = SensorFrameworkFactory.createOrOpenDatasource(datasource);

            map.put(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, "SensorFramework");
            map.put(SensorFrameworkRecorderConfigurationFactory.DATASOURCE_ID, daoFactory.getID());
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(config.getPersistenceFramework())) {
            final EDP2 edp2 = (EDP2) config.getPersistenceFramework();
            final Datasource datasource = edp2.getDatasource();
            final Repository repository = EDP2Factory.createOrOpenDatasource(datasource);
            
            //final Repository repository = RepositoryManager.getRepositoryFromUUID(edp2.getRepositoryUUID());
//            
//            try {
//                MeasurementsUtility.ensureOpenRepository(RepositoryManager.getRepositoryFromUUID(edp2.getRepositoryUUID()));
//            } catch (DataNotAccessibleException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }            
            
            map.put(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, "Experiment Data Persistency & Presentation (EDP2)");
            map.put(EDP2RecorderConfigurationFactory.REPOSITORY_ID, repository.getId());
        } else {
            throw new IllegalArgumentException("Tried to load unknown persistency framework");
        }
    }

    // TODO
    // private static void fillConfidenceStopCondition(ToolConfiguration config, Map<String, Object>
    // map) {
    // if (getConfidenceStopCondition(config) != null) {
    // ConfidenceStopCondition confidenceConfig = getConfidenceStopCondition(config);
    // map.put(SimuComConfig.USE_CONFIDENCE, true);
    // map.put(SimuComConfig.CONFIDENCE_LEVEL, confidenceConfig.getConfidenceLevel());
    // map.put(SimuComConfig.CONFIDENCE_HALFWIDTH, confidenceConfig.getHalfWidth());
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, ""); // TODO
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, ""); // TODO
    // } else {
    // map.put(SimuComConfig.USE_CONFIDENCE, false);
    // map.put(SimuComConfig.CONFIDENCE_LEVEL, 95);
    // map.put(SimuComConfig.CONFIDENCE_HALFWIDTH, 10);
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, "");
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, "");
    // }
    // }

    private static void fillRandomNumberGeneratorSeed(final AbstractSimulationConfiguration config,
            final Map<String, Object> map) {
        if (config.getRandomNumberGeneratorSeed() != null) {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, true);

            final RandomNumberGeneratorSeed seed = config.getRandomNumberGeneratorSeed();
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "0", seed.getSeed0());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "1", seed.getSeed1());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "2", seed.getSeed2());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "3", seed.getSeed3());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "4", seed.getSeed4());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "5", seed.getSeed5());
        } else {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, false);
        }
    }

    private static int getMaximumSimulationTime(final AbstractSimulationConfiguration config,
            final List<StopCondition> stopConditions) {
        for (final StopCondition s : stopConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getSimTimeStopCondition().isInstance(s)) {
                return ((SimTimeStopCondition) s).getSimulationTime();
            }
        }

        final List<StopCondition> defaultConditions = config.getStopConditions();
        for (final StopCondition s : defaultConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getSimTimeStopCondition().isInstance(s)) {
                return ((SimTimeStopCondition) s).getSimulationTime();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the simulation time
        return -1;
    }

    private static int getMaximumMeasurementCount(final AbstractSimulationConfiguration config,
            final List<StopCondition> stopConditions) {
        for (final StopCondition s : stopConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getMeasurementCountStopCondition().isInstance(s)) {
                return ((MeasurementCountStopCondition) s).getMeasurementCount();
            }
        }

        final List<StopCondition> defaultConditions = config.getStopConditions();
        for (final StopCondition s : defaultConditions) {
            if (AbstractsimulationPackage.eINSTANCE.getMeasurementCountStopCondition().isInstance(s)) {
                return ((MeasurementCountStopCondition) s).getMeasurementCount();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the measurement amount
        return -1;
    }

    // TODO
    // /**
    // * @return the stop condition, if there is one configured; null else.
    // */
    // private static ConfidenceStopCondition
    // getConfidenceStopCondition(AbstractSimulationConfiguration config) {
    // List<StopCondition> stopConditions = config.getStopConditions();
    // for (StopCondition s : stopConditions) {
    // if (s.eClass().isInstance(ConfidenceStopCondition.class)) {
    // return (ConfidenceStopCondition) s;
    // }
    // }
    //
    // return null;
    // }
}
