package org.palladiosimulator.experimentautomation.application.tooladapter.simucom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.palladiosimulator.experimentautomation.application.jobs.CleanUpRecorderJob;
import org.palladiosimulator.experimentautomation.application.jobs.LogExperimentInformationJob;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimuComConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimucomtooladapterPackage;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * @author Sebastian Lehrig
 */
public class SimuComToolAdapter implements IToolAdapter {

    private static final String SIMULATOR_ID_SIMUCOM = "de.uka.ipd.sdq.codegen.simucontroller.simucom";
    private static final Logger LOGGER = Logger.getLogger(SimuComToolAdapter.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public SequentialBlackboardInteractingJob<MDSDBlackboard> createRunAnalysisJob(final Experiment experiment,
            final ToolConfiguration toolConfig, final List<Variation> variations, final List<Long> factorLevels,
            final int repetition) {
        final SimuComConfiguration simuComToolConfig = (SimuComConfiguration) toolConfig;
        final SimuComConfig simuComConfig = createSimuComConfig(simuComToolConfig, experiment, factorLevels, repetition);
        final SimuComWorkflowConfiguration workflowConfig = createSimuComWorkflowConfiguration(simuComConfig);

        final SequentialBlackboardInteractingJob<MDSDBlackboard> result;
        result = new SequentialBlackboardInteractingJob<MDSDBlackboard>();
        try {
            result.add(new LogExperimentInformationJob(experiment, simuComConfig, variations, factorLevels, repetition));
            result.add(new SimuComJob(workflowConfig, null, false));
            result.add(new CleanUpRecorderJob(simuComToolConfig.getPersistenceFramework()));
        } catch (CoreException e) {
            LOGGER.error("SimuCom execution failed: " + e);
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasSupportFor(final ToolConfiguration configuration) {
        return SimucomtooladapterPackage.eINSTANCE.getSimuComConfiguration().isInstance(configuration);
    }

    private SimuComConfig createSimuComConfig(final SimuComConfiguration simuComConfiguration,
            final Experiment experiment, final List<Long> factorLevels, final int repetition) {
        final Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(experiment,
                simuComConfiguration, SIMULATOR_ID_SIMUCOM, factorLevels, repetition);

        configMap.put(SimuComConfig.SIMULATE_LINKING_RESOURCES, false);
        configMap.put(SimuComConfig.SIMULATE_FAILURES, false);

        return new SimuComConfig(configMap, false);
    }

    private SimuComWorkflowConfiguration createSimuComWorkflowConfiguration(final SimuComConfig simuComConfig) {
        final SimuComWorkflowConfiguration workflowConfig = new SimuComWorkflowConfiguration(
                new HashMap<String, Object>());

        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig);
        workflowConfig.setSimuComConfiguration(simuComConfig);

        return workflowConfig;
    }
}
