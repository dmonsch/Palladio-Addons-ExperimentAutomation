package de.uka.ipd.sdq.experimentautomation.application.jobs;

import de.uka.ipd.sdq.experimentautomation.application.config.ExperimentAutomationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job conducts a given experiment, consisting of subexperiments for each registered analysis
 * tool. The job assumes that involved models are already loaded to the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration of the experiment.
     * @param experiment
     *            The experiment to be conducted.
     */
    public RunExperimentAutomationJob(ExperimentAutomationConfiguration configuration, Experiment experiment) {
        super(false);

        for (final ToolConfiguration toolConfiguration : experiment.getToolConfiguration()) {
            this.add(new RunExperimentForToolJob(configuration, experiment, toolConfiguration));
        }
    }
}
