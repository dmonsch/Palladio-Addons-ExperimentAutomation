package org.palladiosimulator.experimentautomation.application.tooladapter;

import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public interface IToolAdapter {

    public SequentialBlackboardInteractingJob<MDSDBlackboard> createRunAnalysisJob(final Experiment experiment,
            final ToolConfiguration configuration, int repetition, final MDSDBlackboard blackboard);

    public boolean hasSupportFor(final ToolConfiguration configuration);
    
}
