package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimuLizarConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Experiment;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * 
 * @author Sebastian Lehrig
 */
public class SimuComConfigFactory {

    public static SimuComConfig createConfig(final Experiment experiment, final SimuLizarConfiguration simuLizarConfig,
            final List<Long> factorLevels, final int repetition) {
        final Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(experiment,
                simuLizarConfig, factorLevels, repetition);
        configMap.put(AbstractSimulationConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.simucom");
        return new SimuComConfig(configMap, false);
    }

}
