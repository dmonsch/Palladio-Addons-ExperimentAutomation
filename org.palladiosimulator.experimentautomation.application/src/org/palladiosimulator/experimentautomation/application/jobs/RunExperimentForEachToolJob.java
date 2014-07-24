package org.palladiosimulator.experimentautomation.application.jobs;

import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job conducts a given experiment, consisting of subexperiments for each registered analysis
 * tool. The job assumes that involved models are already loaded to the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentForEachToolJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param experiment
     *            The experiment to be conducted.
     */
    public RunExperimentForEachToolJob(final Experiment experiment) {
        super(false);

        for (final ToolConfiguration toolConfiguration : experiment.getToolConfiguration()) {
            this.add(new ComputeVariantsAndAddExperimentJob(experiment, toolConfiguration));
        }
    }
}
