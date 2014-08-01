package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.jobs.CheckForSLOViolationsJob;
import org.palladiosimulator.experimentautomation.application.jobs.CleanUpRecorderJob;
import org.palladiosimulator.experimentautomation.application.jobs.LogExperimentInformationJob;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimuLizarConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimulizartooladapterPackage;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.simulizar.launcher.jobs.PCMStartInterpretationJob;
import org.palladiosimulator.simulizar.runconfig.SimuLizarWorkflowConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * @author Sebastian Lehrig
 */
public class SimuLizarToolAdapter implements IToolAdapter {

    private static final String SIMULATOR_ID_SIMULIZAR = "de.uka.ipd.sdq.codegen.simucontroller.simucom";

    /**
     * {@inheritDoc}
     */
    @Override
    public RunAnalysisJob createRunAnalysisJob(final Experiment experiment, final ToolConfiguration toolConfig,
            final List<VariationFactorTuple> variationFactorTuples, final int repetition) {
        final SimuLizarConfiguration simuLizarToolConfig = (SimuLizarConfiguration) toolConfig;
        final SimuComConfig simuComConfig = createSimuComConfig(simuLizarToolConfig, experiment, variationFactorTuples,
                repetition);
        final SimuLizarWorkflowConfiguration workflowConfig = createSimuLizarWorkflowConfiguration(simuComConfig,
                experiment.getInitialModel().getReconfigurationRules());

        final RunAnalysisJob result = new RunAnalysisJob();
        result.addJob(new LogExperimentInformationJob(experiment, simuComConfig, variationFactorTuples, repetition));
        result.addJob(new PCMStartInterpretationJob(workflowConfig));
        result.addJob(new CheckForSLOViolationsJob(result, experiment.getInitialModel().getServiceLevelObjectives(),
                simuLizarToolConfig.getPersistenceFramework(), simuComConfig.getNameBase(), simuComConfig
                        .getVariationId()));
        result.addJob(new CleanUpRecorderJob(simuLizarToolConfig.getPersistenceFramework()));

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasSupportFor(final ToolConfiguration configuration) {
        return SimulizartooladapterPackage.eINSTANCE.getSimuLizarConfiguration().isInstance(configuration);
    }

    private SimuComConfig createSimuComConfig(final SimuLizarConfiguration simuComConfiguration,
            final Experiment experiment, final List<VariationFactorTuple> variationFactorTuples, final int repetition) {
        final Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(experiment,
                simuComConfiguration, SIMULATOR_ID_SIMULIZAR, variationFactorTuples, repetition);

        configMap.put(SimuComConfig.SIMULATE_LINKING_RESOURCES, false);
        configMap.put(SimuComConfig.SIMULATE_FAILURES, false);

        return new SimuComConfig(configMap, false);
    }

    private SimuLizarWorkflowConfiguration createSimuLizarWorkflowConfiguration(final SimuComConfig simuComConfig,
            final ReconfigurationRulesFolder reconfigurationRulesFolder) {
        final SimuLizarWorkflowConfiguration workflowConfig = new SimuLizarWorkflowConfiguration(
                new HashMap<String, Object>());
        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig);
        workflowConfig.setSimuComConfiguration(simuComConfig);

        if (reconfigurationRulesFolder == null) {
            workflowConfig.setReconfigurationRulesFolder("");
        } else {
            workflowConfig.setReconfigurationRulesFolder(reconfigurationRulesFolder.getFolderUri());
        }

        return workflowConfig;
    }
}
