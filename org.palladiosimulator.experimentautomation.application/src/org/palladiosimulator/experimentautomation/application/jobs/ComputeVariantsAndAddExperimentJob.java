package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.List;

import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job computes all variation variants that should be executed in an experiment run.
 * Furthermore, it adds vary and run experiment jobs for each considered variant.
 * 
 * @author Sebastian Lehrig
 */
public class ComputeVariantsAndAddExperimentJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param experiment
     *            The experiment to be conducted.
     * @param toolConfiguration
     *            The given analysis tool, e.g., SimuCom.
     */
    public ComputeVariantsAndAddExperimentJob(final Experiment experiment, final ToolConfiguration toolConfiguration) {
        super(false);

        // Note: Calling recursive method
        this.computeVariantsAndAddJob(experiment, toolConfiguration, experiment.getVariations(),
                new ArrayList<Variation>(), new ArrayList<Long>());
    }

    /**
     * TODO There should really be an explanation here describing variations vs. variants! I guess,
     * Philipp has some clue? [Lehrig]
     * 
     * Recursive call, each time reducing variations by 1. Initially, variants and
     * currentFactorLevels are empty. Seems to be something statistical done here like trying out
     * each pair-wise combination... Related to
     * http://en.wikipedia.org/wiki/Fractional_factorial_design ?
     */
    private void computeVariantsAndAddJob(final Experiment experiment, final ToolConfiguration toolConfiguration,
            final List<Variation> variations, final List<Variation> variants, final List<Long> currentFactorLevels) {
        if (variations.isEmpty()) {
            final List<Variation> variantsCopy = new ArrayList<Variation>();
            variantsCopy.addAll(variants);

            final List<Long> factorsCopy = new ArrayList<Long>();
            factorsCopy.addAll(currentFactorLevels);

            this.add(new VaryJob(variantsCopy, factorsCopy));
            this.add(new RepeatExperimentJob(experiment, toolConfiguration, variantsCopy, factorsCopy));
        } else {
            // obtain variation description
            final List<Variation> copy = new ArrayList<Variation>();
            copy.addAll(variations);
            final Variation variation = copy.remove(0);

            // obtain value provider
            final IValueProviderStrategy valueProvider = ValueProviderFactory.createValueProvider(variation
                    .getValueProvider());

            long factorLevel = 0;
            int iteration = 0;
            while (factorLevel <= variation.getMaxValue() && iteration < variation.getMaxVariations()) {
                factorLevel = valueProvider.valueAtPosition(iteration);
                if (factorLevel == -1) {
                    break;
                }

                if (factorLevel >= variation.getMinValue() && factorLevel <= variation.getMaxValue()) {
                    variants.add(variation);
                    currentFactorLevels.add(factorLevel);

                    this.computeVariantsAndAddJob(experiment, toolConfiguration, copy, variants, currentFactorLevels);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        }
    }
}
