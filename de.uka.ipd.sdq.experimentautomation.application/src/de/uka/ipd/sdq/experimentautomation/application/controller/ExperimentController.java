package de.uka.ipd.sdq.experimentautomation.application.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentMetadata;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.AnalysisToolFactory;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.utils.PCMModelHelper;
import de.uka.ipd.sdq.experimentautomation.application.variation.IVariationStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.VariationStrategyFactory;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
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
 * TODO Instead of using ExperimentContext, we should use EDP2 constructs. [Lehrig]
 * 
 * @author Merkle, Sebastian Lehrig
 */
public class ExperimentController {

    private static final Logger LOGGER = Logger.getLogger(ExperimentController.class);

    private final List<Experiment> experiments;
    private final int repetitions;
    private final Path experimentsLocation;
    private final Path variationsLocation;
    private final String args[];
    private final boolean copyAuxModelFiles;

    private class ExperimentContext {
        private final String experimentName;
        private final File experimentFolder;
        private final ToolConfiguration toolConfiguration;
        private final Experiment experiment;

        public ExperimentContext(final String experimentName, final File experimentFolder,
                final ToolConfiguration toolConfiguration, final Experiment experiment) {
            super();
            this.experimentName = experimentName;
            this.experimentFolder = experimentFolder;
            this.toolConfiguration = toolConfiguration;
            this.experiment = experiment;
        }

        public String getExperimentname() {
            return this.experimentName;
        }

        public File getExperimentFolder() {
            return this.experimentFolder;
        }

        public ToolConfiguration getToolConfiguration() {
            return this.toolConfiguration;
        }

        public Experiment getExperiment() {
            return this.experiment;
        }
    }

    /**
     * @param experiments
     *            List of experiments to be run.
     * @param repetitions
     *            States how often a single experiment is repeated for a single tool. Has an
     *            influence on the statistical significance of an experiment.
     * @param args
     *            The command line arguments passed to this application. Only used to store metadata
     *            information.
     */
    public ExperimentController(final List<Experiment> experiments, final int repetitions,
            final Path experimentsLocation, final Path variationsLocation, final String[] args) {
        this.experiments = experiments;
        this.repetitions = repetitions;
        this.experimentsLocation = experimentsLocation;
        this.variationsLocation = variationsLocation;
        this.args = args;
        this.copyAuxModelFiles = true;
    }

    /**
     * Runs the list of experiments as registered and configured at this controller.
     */
    public void runExperiments() {
        for (final Experiment experiment : this.experiments) {
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
        final File experimentFolder = new File(File.separator + experimentName + " (" + System.currentTimeMillis()
                + ")" + File.separator);
        final ExperimentContext settings = new ExperimentContext(experimentName, experimentFolder, toolConfiguration,
                experiment);
        final ExperimentMetadata metadata = new ExperimentMetadata();

        metadata.setExperimentName(experimentName);
        metadata.setStartTime(new Date());
        metadata.setCommandLineArguments(this.args);
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

        // build experiment folder URI
        String factorLevelsString = "";
        for (int i = 0; i < factorLevels.size(); i++) {
            factorLevelsString += variations.get(i).getName() + "=" + factorLevels.get(i);
            if (i + 1 < factorLevels.size()) {
                factorLevelsString += ", ";
            }
        }
        final URI variationFolderUri = URI.createFileURI(settings.getExperimentFolder().toString() + "/"
                + factorLevelsString + "/");

        // copy initial PCM model files to experiment folder
        PCMModelFiles modelCopy;
        if (this.copyAuxModelFiles) {
            modelCopy = PCMModelHelper.copyToExperimentFolder(experiment.getInitialModel(), this.experimentsLocation,
                    this.variationsLocation, variationFolderUri);
        } else {
            modelCopy = PCMModelHelper.copyToExperimentFolder(experiment.getInitialModel(), variationFolderUri);
        }

        // load PCM model from copied model files
        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(URI.createFileURI(modelCopy.getUsagemodelFile()), true);
        resourceSet.getResource(URI.createFileURI(modelCopy.getAllocationFile()), true);
        EcoreUtil.resolveAll(resourceSet);

        // modify the copied PCM model according to the variation descriptions
        for (int i = 0; i < variations.size(); i++) {
            final Variation variation = variations.get(i);
            final long currentValue = factorLevels.get(i);
            final IVariationStrategy variationStrategy = this.initialiseVariations(variation, resourceSet);
            final String desc = variationStrategy.vary(currentValue);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Varyied: " + desc);
            }
        }

        // save the varied PCM model
        try {
            this.saveResources(resourceSet);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        // simulate the varied PCM model one or more times as specified by the replication count
        for (int i = 1; i <= this.repetitions; i++) {
            try {
                final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(settings
                        .getToolConfiguration());
                analysisTool.runExperiment(settings.getExperimentname() + " "
                        + settings.getToolConfiguration().getName(), modelCopy, settings.getToolConfiguration(),
                        settings.getExperiment().getStopConditions());
            } catch (final Exception ex) {
                throw new RuntimeException("The simulation failed", ex);
            }
        }
    }

    private IVariationStrategy initialiseVariations(final Variation variation, final ResourceSet resourceSet) {
        final EObject variedObject = PCMModelHelper.findModelElementById(resourceSet, variation.getVariedObjectId());
        final IVariationStrategy variationStrategy = VariationStrategyFactory.createStrategy(variation.getType());
        variationStrategy.setVariedObject(variedObject);
        return variationStrategy;
    }

    private void saveResources(final ResourceSet rs) throws IOException {
        for (final Resource r : rs.getResources()) {
            final URI n = rs.getURIConverter().normalize(r.getURI());
            if (n.isFile()) {
                final OutputStream out = rs.getURIConverter().createOutputStream(r.getURI());
                r.save(out, null);
                LOGGER.info("Saving resource: " + r.toString());
            }
        }
    }

}
