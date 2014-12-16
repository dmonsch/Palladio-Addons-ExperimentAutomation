package org.palladiosimulator.experimentautomation.application.jobs;

import org.palladiosimulator.experimentautomation.application.config.ExperimentAutomationConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.scaledl.architecturaltemplates.completion.config.ATExtensionJobConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.workflow.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.PreparePCMBlackboardPartionJob;

/**
 * This job conducts a series of experiments. Each experiment has its own initial set of Palladio
 * models.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentAutomationJob extends AbstractExtendableJob<MDSDBlackboard> {

    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_BEFORE_EXPERIMENT_RUN = "workflow.extension.experimentautomation.before.experimentrun";

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration for Experiment Automation runs.
     */
    public RunExperimentAutomationJob(final ExperimentAutomationConfiguration configuration) {
        this(configuration, null);
    }

    /**
     * Default constructor.
     * 
     * @param configuration
     *            Configuration for Experiment Automation runs.
     * @param listener
     *            DebugListener for simulations.
     */
    public RunExperimentAutomationJob(final ExperimentAutomationConfiguration configuration,
            final IDebugListener listener) {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }

        this.add(new PreparePCMBlackboardPartionJob());
        for (final Experiment experiment : configuration.getExperiments()) {
            final ATExtensionJobConfiguration config = new ATExtensionJobConfiguration();
            this.add(new PrepareBlackboardJob());
            this.add(new LoadModelsIntoBlackboardJob(experiment.getInitialModel()));

            // All Workflow extension jobs with the extension hook id
            // WORKFLOW_ID_BEFORE_EXPERIMENT_RUN
            handleJobExtensions(WORKFLOW_ID_BEFORE_EXPERIMENT_RUN, configuration);

            // this.add(new RunATJob(config)); // Loads completed PCM models to PCM partition
            this.add(new RunExperimentForEachToolJob(experiment));
        }
    }

}
