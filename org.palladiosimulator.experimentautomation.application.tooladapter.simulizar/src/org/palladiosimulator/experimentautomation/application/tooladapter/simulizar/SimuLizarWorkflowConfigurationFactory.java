package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import org.palladiosimulator.simulizar.runconfig.SimuLizarWorkflowConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuLizarWorkflowConfigurationFactory {

    public static SimuLizarWorkflowConfiguration createWorkflowConfiguration(
            final AbstractSimulationConfiguration configuration, final SimuComConfig simConfig) {
        final Map<String, Object> attributesMap = new HashMap<String, Object>();
        final SimuLizarWorkflowConfiguration workflowConfig = new SimuLizarWorkflowConfiguration(attributesMap);

        workflowConfig.setSimulateFailures(configuration.isSimulateFailures());
        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setSimuComConfiguration(simConfig);
        // workflowConfig.setOverwriteWithoutAsking(true);

        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, configuration,
                simConfig);

        return workflowConfig;
    }

}
