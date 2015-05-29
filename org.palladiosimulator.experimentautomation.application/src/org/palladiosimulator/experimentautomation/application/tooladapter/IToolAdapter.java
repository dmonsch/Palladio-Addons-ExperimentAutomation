package org.palladiosimulator.experimentautomation.application.tooladapter;

import java.util.List;

import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

/**
 * Adapter interface for analysis tools to be used by Experiment Automation.
 * 
 * @author Sebastian Lehrig
 */
public interface IToolAdapter {

    /**
     * Creates a workflow job for the given analysis run and tool. The analysis run is characterized
     * by the given parameters calculated by Experiment Automation.
     * 
     * @param experiment
     *            the experiment to be conducted.
     * @param toolConfiguration
     *            the analysis tool to be used.
     * @param variationFactorTuples
     *            the variations and according value factors.
     * @param repetition
     *            the current repetition number of this experiment run; used for statistical
     *            significance.
     * @return the job conducting the specified experiment run.
     */
    public RunAnalysisJob createRunAnalysisJob(final Experiment experiment, final ToolConfiguration toolConfiguration,
            final List<VariationFactorTuple> variationFactorTuples, final int repetition);

    /**
     * States whether a tool adapter supports the given concrete tool configuration.
     * 
     * @param toolConfiguration
     *            the given tool configuration.
     * @return <code>true</code> if the tool configuration is support; <code>false</code> otherwise.
     */
    public boolean hasSupportFor(final ToolConfiguration toolConfiguration);

}
