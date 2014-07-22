package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.palladiosimulator.experimentautomation.application.config.ExperimentAutomationConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.AnalysisToolFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.application.variation.IVariationStrategy;
import org.palladiosimulator.experimentautomation.application.variation.VariationStrategyFactory;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job conducts a given experiment for a given analysis tool. The job assumes that involved
 * models are already loaded to the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentForToolJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration of the experiment.
     * @param experiment
     *            The experiment to be conducted.
     * @param toolConfiguration
     *            The given analysis tool, e.g., SimuCom.
     */
    public RunExperimentForToolJob(ExperimentAutomationConfiguration configuration, Experiment experiment,
            ToolConfiguration toolConfiguration) {
        super(false);

        // Note: Calling recursive method
        this.computeVariationsAndAddVariationJob(configuration, experiment, experiment.getVariations(),
                new ArrayList<Variation>(), new ArrayList<Long>(), toolConfiguration);
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
    private void computeVariationsAndAddVariationJob(ExperimentAutomationConfiguration configuration,
            Experiment experiment, final List<Variation> variations, final List<Variation> variants,
            final List<Long> currentFactorLevels, ToolConfiguration toolConfiguration) {
        if (variations.isEmpty()) {
            this.variateModelAndAddVariationJob(configuration, experiment, variants, currentFactorLevels,
                    toolConfiguration);
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

                    this.computeVariationsAndAddVariationJob(configuration, experiment, copy, variants,
                            currentFactorLevels, toolConfiguration);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        }
    }

    private void variateModelAndAddVariationJob(ExperimentAutomationConfiguration configuration, Experiment experiment,
            final List<Variation> variations, final List<Long> factorLevels, ToolConfiguration toolConfiguration) {
        // copy initial PCM model
        ExperimentAutomationConfiguration clonedConfiguration = configuration.clone();

        // modify the copied PCM model according to the variation descriptions
        StringBuilder appliedVariations = new StringBuilder();        
        for (int i = 0; i < variations.size(); i++) {
            final Variation variation = variations.get(i);
            final long currentValue = factorLevels.get(i);
            final IVariationStrategy variationStrategy = this.initialiseVariations(variation,
                    clonedConfiguration.getResourceSet()); // FIXME Modify in blackboard?
            
            final String variationName = variationStrategy.vary(currentValue);
            
            appliedVariations.append("VARIATION: ");
            appliedVariations.append(variationName);
            appliedVariations.append("\n");
        }

        // add simulation jobs of the varied PCM model (one or more times as specified by the
        // repetition count)
        for (int repetition = 1; repetition <= experiment.getRepetitions(); repetition++) {
            final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(toolConfiguration);
            final IJob runAnalysisJob = analysisTool.createRunAnalysisJob(experiment, toolConfiguration, factorLevels, appliedVariations.toString(), repetition, 
                    this.getBlackboard());

            this.add(runAnalysisJob);
        }
    }

    private IVariationStrategy initialiseVariations(final Variation variation, final ResourceSet resourceSet) {
        final EObject variedObject = EcoreHelper.findModelElementById(resourceSet, variation.getVariedObjectId());
        if (variedObject == null) {
            throw new RuntimeException("Unable to find model element with ID " + variation.getVariedObjectId()
                    + " in resource set");
        }
        final IVariationStrategy variationStrategy = VariationStrategyFactory.createStrategy(variation.getType());
        variationStrategy.setVariedObject(variedObject);
        return variationStrategy;
    }
}
