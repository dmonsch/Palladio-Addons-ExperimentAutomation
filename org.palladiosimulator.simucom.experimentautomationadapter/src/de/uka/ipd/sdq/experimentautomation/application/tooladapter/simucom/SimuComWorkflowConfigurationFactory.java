package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.InitialModel;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

public class SimuComWorkflowConfigurationFactory {

    public static SimuComWorkflowConfiguration createWorkflowConfiguration(
            final AbstractSimulationConfiguration configuration, final InitialModel pcm,
            final AbstractSimulationConfig simConfig) {
        final Map<String, Object> attributesMap = new HashMap<String, Object>();
        final SimuComWorkflowConfiguration workflowConfig = new SimuComWorkflowConfiguration(attributesMap);
        workflowConfig.setSimulateFailures(configuration.isSimulateFailures());
        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setSimuComConfiguration((SimuComConfig) simConfig);
        // workflowConfig.setOverwriteWithoutAsking(true);

        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, configuration, pcm,
                simConfig);

        return workflowConfig;
    }

}
