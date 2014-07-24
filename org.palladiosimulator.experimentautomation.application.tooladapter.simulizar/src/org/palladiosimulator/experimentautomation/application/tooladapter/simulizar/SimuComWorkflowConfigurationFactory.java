package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuComWorkflowConfigurationFactory {

    public static SimuComWorkflowConfiguration createWorkflowConfiguration(
            final AbstractSimulationConfiguration configuration, final SimuComConfig simConfig) {
        final Map<String, Object> attributesMap = new HashMap<String, Object>();
        final SimuComWorkflowConfiguration workflowConfig = new SimuComWorkflowConfiguration(attributesMap);

        workflowConfig.setSimulateFailures(configuration.isSimulateFailures());
        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setSimuComConfiguration(simConfig);
        // workflowConfig.setOverwriteWithoutAsking(true);

        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, configuration,
                simConfig);

        return workflowConfig;
    }

}
