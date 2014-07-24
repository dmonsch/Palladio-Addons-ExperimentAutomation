package org.palladiosimulator.experimentautomation.application.tooladapter;

import java.util.List;

import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public interface IToolAdapter {

    public SequentialBlackboardInteractingJob<MDSDBlackboard> createRunAnalysisJob(final Experiment experiment,
            final ToolConfiguration toolConfiguration, final List<Variation> variations, final List<Long> factorLevels,
            final int repetition);

    public boolean hasSupportFor(final ToolConfiguration toolConfiguration);

}
