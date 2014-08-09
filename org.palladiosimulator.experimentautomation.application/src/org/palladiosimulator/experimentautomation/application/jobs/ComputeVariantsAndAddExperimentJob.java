package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.List;

import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
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
     *            the experiment to be conducted.
     * @param simulationConfiguration
     *            the given analysis tool, e.g., SimuCom.
     */
    public ComputeVariantsAndAddExperimentJob(final Experiment experiment, final AbstractSimulationConfiguration simulationConfiguration) {
        super(false);

        // Note: Calling recursive method
        this.computeVariantsAndAddJob(experiment, simulationConfiguration, experiment.getVariations(),
                new ArrayList<VariationFactorTuple>());
    }

    /**
     * TODO There should really be an explanation here describing variations vs. variants! I guess,
     * Philipp has some clue? [Lehrig]
     * 
     * Recursive call, each time reducing variations by 1. Initially, variants and
     * currentFactorLevels are empty. Seems to be something statistical done here like trying out
     * each pair-wise combination... Related to
     * http://en.wikipedia.org/wiki/Fractional_factorial_design ?
     * 
     * @param experiment
     *            the experiment to be conducted.
     * @param simulationConfiguration
     *            the given analysis tool, e.g., SimuCom.
     * @param variations
     *            the given variations to be considered.
     * @param variationFactorTuples
     *            the variants of the given variations as well as the concrete values to be used for
     *            a given variation.
     */
    private void computeVariantsAndAddJob(final Experiment experiment, final AbstractSimulationConfiguration simulationConfiguration,
            final List<Variation> variations, final List<VariationFactorTuple> variationFactorTuples) {
        if (variations.isEmpty()) {
            final List<VariationFactorTuple> variationsAndFactorsCopy = new ArrayList<VariationFactorTuple>();
            variationsAndFactorsCopy.addAll(variationFactorTuples);

            this.add(new VaryJob(variationsAndFactorsCopy));
            this.add(new RepeatExperimentJob(experiment, simulationConfiguration, variationsAndFactorsCopy));
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
                    variationFactorTuples.add(new VariationFactorTuple(variation, factorLevel));
                    this.computeVariantsAndAddJob(experiment, simulationConfiguration, copy, variationFactorTuples);
                    variationFactorTuples.remove(variationFactorTuples.size() - 1);
                }

                iteration++;
            }
        }
    }
}
