package org.palladiosimulator.experimentautomation.application.tooladapter.simucom;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;

import org.palladiosimulator.experimentautomation.abstractsimulation.StopCondition;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.jobs.CleanUpRecorderJob;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimuComConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimucomtooladapterPackage;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * @author Sebastian Lehrig
 */
public class SimuComToolAdapter implements IToolAdapter {

    private static final Logger LOGGER = Logger.getLogger(SimuComToolAdapter.class);

    @Override
    public SequentialBlackboardInteractingJob<MDSDBlackboard> createRunAnalysisJob(final String experimentName,
            final InitialModel initialModel, final ToolConfiguration configuration,
            final List<StopCondition> stopConditions, MDSDBlackboard blackboard) {
        final SimuComConfiguration simuComConfiguration = (SimuComConfiguration) configuration;

        // create simulation configuration
        final SimuComConfig simuComConfig = SimuComConfigFactory.createConfig(simuComConfiguration, stopConditions,
                experimentName);

        // create workflow configuration
        final SimuComWorkflowConfiguration workflowConfig = SimuComWorkflowConfigurationFactory
                .createWorkflowConfiguration(simuComConfiguration, simuComConfig);

        SequentialBlackboardInteractingJob<MDSDBlackboard> result = new SequentialBlackboardInteractingJob<MDSDBlackboard>();
        try {
            result.add(new SimuComJob(workflowConfig, null, false));
            result.add(new CleanUpRecorderJob(simuComConfiguration));
        } catch (CoreException e) {
            LOGGER.error("SimuCom execution failed: " + e);
        }

        return result;
    }

    @Override
    public boolean hasSupportFor(ToolConfiguration configuration) {
        return SimucomtooladapterPackage.eINSTANCE.getSimuComConfiguration().isInstance(configuration);
    }

}
