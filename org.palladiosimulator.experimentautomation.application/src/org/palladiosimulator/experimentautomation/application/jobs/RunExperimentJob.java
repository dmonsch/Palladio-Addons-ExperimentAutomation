package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.tooladapter.AnalysisToolFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
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
     * @param variationFactorTuples
     *            the variations and according value factors.
     * @param repetition
     *            Gives the current number of repetitions for this exact experiment; for statistical
     *            significance. Note that repetition>1 makes only sense for non-fixed random seeds.
     */
    public RunExperimentJob(final Experiment experiment, final ToolConfiguration toolConfiguration,
            final List<VariationFactorTuple> variationFactorTuples, final int repetition) {
        super(false);

        final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(toolConfiguration);
        final IBlackboardInteractingJob<MDSDBlackboard> runAnalysisJob = analysisTool.createRunAnalysisJob(experiment,
                toolConfiguration, variationFactorTuples, repetition);

        this.add(runAnalysisJob);
        this.add(new AddDynamicVariationJob(analysisTool, experiment, toolConfiguration, variationFactorTuples,
                repetition));
    }
}
