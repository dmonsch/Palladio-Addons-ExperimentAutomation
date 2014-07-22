package org.palladiosimulator.experimentautomation.application.tooladapter.simucom;

import java.util.Map;

import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimuComConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Experiment;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * The factory provides methods to build a {@link AbstractSimulationConfig} object based on a
 * configuration model. The configuration model is represented by a
 * {@link AbstractSimulationConfiguration} object.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimuComConfigFactory {

    public static final String SIMULATOR_ID = "simulatorId";

    public static SimuComConfig createConfig(final Experiment experiment, final SimuComConfiguration simuComConfig,
            final int repetition) {
        final Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(experiment,
                simuComConfig, repetition);
        configMap.put(AbstractSimulationConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.simucom");
        return new SimuComConfig(configMap, false);
    }

}
