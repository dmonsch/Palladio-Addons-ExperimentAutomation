package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Repeats the given experiment for a given tool and a given set of variations.
 * 
 * @author Sebastian Lehrig
 */
public class RepeatExperimentJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param experiment
     *            The experiment to be conducted.
     * @param toolConfiguration
     *            The given analysis tool, e.g., SimuCom.
     * @param variations
     *            Variations considered for the experiment.
     * @param factorLevels
     *            Factor levels considered for the experiment.
     */
    public RepeatExperimentJob(final Experiment experiment, final ToolConfiguration toolConfiguration,
            final List<Variation> variations, final List<Long> factorLevels) {
        super(false);

        for (int repetition = 1; repetition <= experiment.getRepetitions(); repetition++) {
            this.add(new RunExperimentJob(experiment, toolConfiguration, variations, factorLevels, repetition));
        }
    }
}
