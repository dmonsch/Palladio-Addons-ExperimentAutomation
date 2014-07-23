package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.palladiosimulator.experimentautomation.application.tooladapter.AnalysisToolFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Runs a given, completely specified experiment out of an experiment run series.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param experiment
     *            The experiment to be conducted.
     * @param toolConfiguration
     *            The given analysis tool, e.g., SimuCom.
     */
    public RunExperimentJob(final Experiment experiment, final ToolConfiguration toolConfiguration,
            final List<Variation> variations, final List<Long> factorLevels, final int repetition) {
        super(false);

        final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(toolConfiguration);
        final IJob runAnalysisJob = analysisTool.createRunAnalysisJob(experiment, toolConfiguration, variations,
                factorLevels, repetition, this.getBlackboard());
        
        this.add(runAnalysisJob);
    }
}
