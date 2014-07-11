package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import java.util.List;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.InitialModel;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public interface IToolAdapter {

    public void runExperiment(final String experimentName, final InitialModel model,
            final ToolConfiguration configuration, final List<StopCondition> stopConditions, final MDSDBlackboard blackboard) throws Exception;

    public boolean hasSupportFor(final ToolConfiguration configuration);
}
