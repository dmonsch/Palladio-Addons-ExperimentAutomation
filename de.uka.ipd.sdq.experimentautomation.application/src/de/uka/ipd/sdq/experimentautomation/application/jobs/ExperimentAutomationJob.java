package de.uka.ipd.sdq.experimentautomation.application.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.experimentautomation.application.config.ExperimentAutomationConfiguration;
import de.uka.ipd.sdq.experimentautomation.application.controller.ExperimentMetadata;
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
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job is conducts a given experiment. The job assumes that involved models are already loaded
 * to the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class ExperimentAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(ExperimentAutomationJob.class);

    private final ExperimentAutomationConfiguration configuration;
    private final Experiment experiment;

    private MDSDBlackboard blackboard;

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration of the experiment.
     * @param experiment
     *            The experiment to be conducted.
     */
    public ExperimentAutomationJob(ExperimentAutomationConfiguration configuration, Experiment experiment) {
        super(false);
        this.configuration = configuration;
        this.experiment = experiment;
    }

    /**
     * Runs an experiment as registered and configured for this job.
     */
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        LOGGER.info("Experiment Automation Job started");

        for (final ToolConfiguration toolConfiguration : experiment.getToolConfiguration()) {
            this.runExperiment(toolConfiguration);
        }

        LOGGER.info("Experiment Automation Job finished");
    }

    /**
     * Runs an experiment for a given tool. Note that the experiment comes with variations, each
     * potentially repeated as specified by the experiment.
     * 
     * @param toolConfiguration
     *            The given tool, e.g., SimuCom.
     */
    private void runExperiment(final ToolConfiguration toolConfiguration) {
        final String experimentName = "(" + this.experiment.getId() + ", " + toolConfiguration.getName() + ") "
                + this.experiment.getName();
        final ExperimentMetadata metadata = new ExperimentMetadata();

        metadata.setExperimentName(experimentName);
        metadata.setStartTime(new Date());
        metadata.setVirtualMachineArguments("TODO");
        this.runExperimentVariations(this.experiment.getVariations(), new ArrayList<Variation>(),
                new ArrayList<Long>(), experimentName, toolConfiguration);
        metadata.setEndTime(new Date());
        LOGGER.info(metadata);
    }

    /**
     * TODO There should really be an explanation here describing variations vs. variants! I guess,
     * Philipp has some clue? [Lehrig]
     * 
     * Recursive call, each time reducing variations by 1. Initially, variants and
     * currentFactorLevels are empty. Seems to be something statistical done here like trying out
     * each pair-wise combination...
     */
    private void runExperimentVariations(final List<Variation> variations, final List<Variation> variants,
            final List<Long> currentFactorLevels, String experimentName, ToolConfiguration toolConfiguration) {
        if (variations.isEmpty()) {
            this.variateModelAndSimulate(variants, currentFactorLevels, experimentName, toolConfiguration);
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

                    this.runExperimentVariations(copy, variants, currentFactorLevels, experimentName, toolConfiguration);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        }
    }

    private void variateModelAndSimulate(final List<Variation> variations, final List<Long> factorLevels,
            String experimentName, ToolConfiguration toolConfiguration) {
        // copy initial PCM model
        ExperimentAutomationConfiguration clonedConfiguration = this.configuration.clone();

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
        for (int i = 1; i <= this.experiment.getRepetitions(); i++) {
            final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(toolConfiguration);
            try {
                analysisTool.runExperiment(experimentName + " " + toolConfiguration.getName(),
                        this.experiment.getInitialModel(), toolConfiguration, this.experiment.getStopConditions());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBlackboard(MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform Experiment Automation";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
    }
}
