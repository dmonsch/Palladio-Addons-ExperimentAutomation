package de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.InitialModel;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice;

public class AbstractSimulationWorkflowConfigurationFactory {

    // copied from de.uka.ipd.sdq.codegen.simucontroller.runconfig.FeatureOptionsTab
    private static final String DEFAULT_CONNECTOR_FEATURE_CONFIG = "pathmap://PCM_MODELS/ConnectorConfig.featureconfig";

    public static void fillWorkflowConfiguration(final AbstractSimulationWorkflowConfiguration workflowConfig,
            final AbstractSimulationConfiguration configuration, final InitialModel pcm,
            final AbstractSimulationConfig simConfig) {
        // PCMModel pcm = experimentRepository.getInitialModel();
        
// TODO Remove next few lines if done with replacement. [Lehrig]
// Lehrig: Remove configuration via files. To be replaced by direct access to blackboard.
//        final List<String> allocationFiles = new ArrayList<String>();
//        allocationFiles.add(pcm.getAllocationFile());
//        workflowConfig.setAllocationFiles(allocationFiles);
//        workflowConfig.setUsageModelFile(pcm.getUsagemodelFile());
//        workflowConfig.setMiddlewareFile(pcm.getMiddlewareRepositoryFile());
//        workflowConfig.setEventMiddlewareFile(pcm.getEventMiddlewareRepositoryFile());

        workflowConfig.setCodeGenerationAdvicesFile(CodeGenerationAdvice.SIMULATION);

        workflowConfig.setDebug(simConfig.isDebug());
        workflowConfig.setInteractive(false); // TODO
        // if (hasAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION))
        // config.setInteractive(getBooleanAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION));
        // else
        // config.setInteractive(true);

        // AbstractSimulationConfiguration configuration = (AbstractSimulationConfiguration)
        // experimentRepository.getToolConfiguration();

        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setDeleteTemporaryDataAfterAnalysis(true); // TODO
        workflowConfig.setOverwriteWithoutAsking(true); // TODO ensure that no folders can be
                                                        // deleted accidentally
        workflowConfig.setStoragePluginID(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
        // workflowConfig.setPluginID(ConstantsContainer.SIMUCOM_DEFAULT_PROJECT_ID); // TODO
        workflowConfig.setFeatureConfigFile(DEFAULT_CONNECTOR_FEATURE_CONFIG);

        workflowConfig.setSensitivityAnalysisEnabled(false); // TODO

        // config.setCompletionConfiguration(new PCMCompletionRunConfiguration(config, properties));

    }

}
