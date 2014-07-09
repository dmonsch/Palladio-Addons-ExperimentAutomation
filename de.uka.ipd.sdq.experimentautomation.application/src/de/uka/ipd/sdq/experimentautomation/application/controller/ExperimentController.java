package de.uka.ipd.sdq.experimentautomation.application.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.experimentautomation.application.config.ExperimentAutomationConfiguration;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.AnalysisToolFactory;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.utils.EcoreHelper;
import de.uka.ipd.sdq.experimentautomation.application.variation.IVariationStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.VariationStrategyFactory;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;

/**
 * This class is responsible for executing a given experiment configuration. Such a configuration
 * includes the list of experiments to conduct and the tools to use for these experiments (e.g.,
 * SimuCom). A single experiment includes a list of variations, each analyzed according to a
 * configurable number of repetitions.
 * 
 * Objects of this class are completely configured via their constructor. Afterwards, experiments
 * can be conducted by invoking their <code>runExperiments()</code> method.
 * 
 * @author Merkle, Sebastian Lehrig
 */
public class ExperimentController {

    private static final Logger LOGGER = Logger.getLogger(ExperimentController.class);

    private final ExperimentAutomationConfiguration config;

    private class ExperimentContext {
        private final String experimentName;
        private final ToolConfiguration toolConfiguration;
        private final Experiment experiment;

        public ExperimentContext(final String experimentName, final ToolConfiguration toolConfiguration,
                final Experiment experiment) {
            super();
            this.experimentName = experimentName;
            this.toolConfiguration = toolConfiguration;
            this.experiment = experiment;
        }

        public String getExperimentname() {
            return this.experimentName;
        }

        public ToolConfiguration getToolConfiguration() {
            return this.toolConfiguration;
        }

        public Experiment getExperiment() {
            return this.experiment;
        }
    }

    public ExperimentController(final ExperimentAutomationConfiguration config) {
        this.config = config;
    }

    /**
     * Runs the list of experiments as registered and configured at this controller.
     */
    public void runExperiments() {
        for (final Experiment experiment : config.getFilteredExperiments()) {
            for (final ToolConfiguration toolConfiguration : experiment.getToolConfiguration()) {
                this.runExperiment(experiment, toolConfiguration);
            }
        }
    }

    /**
     * Runs a single experiment for a given tool. Note that a single experiment comes with
     * variations, each potentially repeated according the configuration of this experiment
     * controller.
     * 
     * @param experiment
     *            The experiment to run.
     * @param toolConfiguration
     *            The given tool, e.g., SimuCom.
     */
    private void runExperiment(final Experiment experiment, final ToolConfiguration toolConfiguration) {
        final String experimentName = "(" + experiment.getId() + ", " + toolConfiguration.getName() + ") "
                + experiment.getName();
        final ExperimentContext settings = new ExperimentContext(experimentName, toolConfiguration, experiment);
        final ExperimentMetadata metadata = new ExperimentMetadata();

        metadata.setExperimentName(experimentName);
        metadata.setStartTime(new Date());
        metadata.setVirtualMachineArguments("TODO");
        this.runExperimentVariations(experiment.getVariations(), settings, new ArrayList<Variation>(),
                new ArrayList<Long>());
        metadata.setEndTime(new Date());
        LOGGER.info(metadata);
    }

    /**
     * TODO There should really be an explanation here describing variations vs. variants! [Lehrig]
     * 
     * Recursive call, each time reducing variations by 1. Initially, variants and
     * currentFactorLevels are empty. Seems to be something statistical done here like trying out
     * each pair-wise combination...
     */
    private void runExperimentVariations(final List<Variation> variations, final ExperimentContext settings,
            final List<Variation> variants, final List<Long> currentFactorLevels) {
        if (variations.isEmpty()) {
            this.variateModelAndSimulate(settings, variants, currentFactorLevels);
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

                    this.runExperimentVariations(copy, settings, variants, currentFactorLevels);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        }
    }

    private void variateModelAndSimulate(final ExperimentContext settings, final List<Variation> variations,
            final List<Long> factorLevels) {
        final Experiment experiment = settings.getExperiment();

        // copy initial PCM model
        ExperimentAutomationConfiguration clonedConfiguration = this.config.clone();

        // modify the copied PCM model according to the variation descriptions
        for (int i = 0; i < variations.size(); i++) {
            final Variation variation = variations.get(i);
            final long currentValue = factorLevels.get(i);
            final IVariationStrategy variationStrategy = this.initialiseVariations(variation,
                    clonedConfiguration.getResourceSet());
            final String desc = variationStrategy.vary(currentValue);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Varyied: " + desc);
            }
        }

        // simulate the varied PCM model one or more times as specified by the replication count
        for (int i = 1; i <= config.getExperiments().getRepetitions(); i++) {
            try {
                final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(settings
                        .getToolConfiguration());
                analysisTool.runExperiment(settings.getExperimentname() + " "
                        + settings.getToolConfiguration().getName(), experiment.getInitialModel(),
                        settings.getToolConfiguration(), settings.getExperiment().getStopConditions());
            } catch (final Exception ex) {
                throw new RuntimeException("The simulation failed", ex);
            }
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
