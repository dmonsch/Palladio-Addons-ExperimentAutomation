package org.palladiosimulator.experimentautomation.application.workflow;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableTabGroup;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;

/**
 * Configuration tabs for Experiment Automation.
 * 
 * @author Sebastian Lehrig
 */
public class ExperimentAutomationTabGroup extends ExtendableTabGroup {

    /**
     * {@inheritDoc}
     */
    @Override
    public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
        final List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();

        tabs.add(new ExperimentAutomationConfigurationTab());
        for (final String workflowExtensionPointId : WorkflowHooks.getAllWorkflowHookIDs()) {
            tabs.addAll(createExtensionTabs(dialog, mode, workflowExtensionPointId));
        }
        tabs.add(new DebugEnabledCommonTab());

        setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
    }
}
