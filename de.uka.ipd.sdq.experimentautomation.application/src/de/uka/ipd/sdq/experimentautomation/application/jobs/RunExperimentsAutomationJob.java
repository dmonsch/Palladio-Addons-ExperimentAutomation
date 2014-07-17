package de.uka.ipd.sdq.experimentautomation.application.jobs;

import de.uka.ipd.sdq.experimentautomation.application.config.ExperimentAutomationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.PreparePCMBlackboardPartionJob;

/**
 * This job conducts a series of experiments. Each experiment has its own initial set of Palladio
 * models.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentsAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration of the experiment.
     */
    public RunExperimentsAutomationJob(ExperimentAutomationConfiguration configuration) {
        super(false);

        this.add(new PreparePCMBlackboardPartionJob());
        for (final Experiment experiment : configuration.getFilteredExperiments()) {
            this.add(new LoadPCMModelsForExperimentAutomationJob(experiment.getInitialModel()));
            this.add(new RunExperimentAutomationJob(configuration, experiment));
        }
    }

}
