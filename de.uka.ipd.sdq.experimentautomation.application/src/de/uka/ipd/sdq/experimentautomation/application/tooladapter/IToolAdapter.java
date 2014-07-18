package org.palladiosimulator.experimentautomation.application.tooladapter;

import java.util.List;

import org.palladiosimulator.experimentautomation.abstractsimulation.StopCondition;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public interface IToolAdapter {

    public SequentialBlackboardInteractingJob<MDSDBlackboard> createRunAnalysisJob(final String experimentName,
            final InitialModel model, final ToolConfiguration configuration, final List<StopCondition> stopConditions,
            final MDSDBlackboard blackboard);

    public boolean hasSupportFor(final ToolConfiguration configuration);
    
}
