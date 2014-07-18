package org.palladiosimulator.experimentautomation.application.tooladapter.simucom;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

public class SimuComWorkflowConfigurationFactory {

    public static SimuComWorkflowConfiguration createWorkflowConfiguration(
            final AbstractSimulationConfiguration configuration, final AbstractSimulationConfig simConfig) {
        final Map<String, Object> attributesMap = new HashMap<String, Object>();
        final SimuComWorkflowConfiguration workflowConfig = new SimuComWorkflowConfiguration(attributesMap);

        workflowConfig.setSimulateFailures(configuration.isSimulateFailures());
        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setSimuComConfiguration((SimuComConfig) simConfig);
        // workflowConfig.setOverwriteWithoutAsking(true);

        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, configuration,
                simConfig);

        return workflowConfig;
    }

}
