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

import de.uka.ipd.sdq.experimentautomation.application.ConfigurationModel;
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

public class ExperimentController {

    private static final Logger logger = Logger.getLogger(ExperimentController.class); 
   
    private final ConfigurationModel config;
    private final Path experimentsLocation;
    private final Path variationsLocation;
    private final Path bookkeepingLocation;
    private final String args[];
    private final boolean copyAuxModelFiles;

    /**
     * 
     * @param config
     * @param args
     *            the command line arguments passed to this application
     */
    public ExperimentController(final ConfigurationModel config, final Path experimentsLocation,
            final Path variationsLocation, final Path bookkeepingLocation, final String[] args) {
        this.config = config;
        this.experimentsLocation = experimentsLocation;
        this.variationsLocation = variationsLocation;
        this.bookkeepingLocation = bookkeepingLocation;
        this.args = args;
        this.copyAuxModelFiles = true;
    }

    public ExperimentController(final Path bookkeepingLocation) {
        this.bookkeepingLocation = bookkeepingLocation;
        this.args = new String[] { "none (call by code)" };
        this.copyAuxModelFiles = false;
        this.variationsLocation = null;
        this.experimentsLocation = null;
        this.config = null;
    }

    private IVariationStrategy initialiseVariations(final Variation v, final ResourceSet rs) {
        final EObject variedObject = PCMModelHelper.findModelElementById(rs, v.getVariedObjectId());
        final IVariationStrategy s = VariationStrategyFactory.createStrategy(v.getType());
        s.setVariedObject(variedObject);
        return s;
    }

    public void runExperiment(final Experiment experiment) {
        final List<Experiment> experiments = new ArrayList<Experiment>(1);
        experiments.add(experiment);
        this.runExperiment(experiments, 1);
    }

    public void runExperiment(final List<Experiment> experiments, final int repetitions) {
        for (final Experiment exp : experiments) {
            for (final ToolConfiguration c : exp.getToolConfiguration()) {
                this.runExperiment(exp, c, repetitions);
            }
        }
    }

    public void runExperiments(final int repetitions) {
        this.runExperiment(this.config.getExperiments().getExperiments(), repetitions);
    }

    private void runExperiment(final Experiment exp, final ToolConfiguration toolConfig, final int repetitions) {
        final String experimentName = "(" + exp.getId() + ", " + toolConfig.getName() + ") " + exp.getName();
        final File experimentFolder = new File(this.bookkeepingLocation.toOSString() + File.separator + experimentName
                + " (" + System.currentTimeMillis() + ")" + File.separator);
        final ExperimentMetadata metadata = new ExperimentMetadata();
        metadata.setExperimentName(experimentName);
        metadata.setStartTime(new Date());
        metadata.setCommandLineArguments(this.args);
        metadata.setVirtualMachineArguments("TODO");

        final String[] factorNames = new String[exp.getVariations().size()];
        for (int i = 0; i < factorNames.length; i++) {
            factorNames[i] = exp.getVariations().get(i).getName();
        }

        final ExperimentContext settings = new ExperimentContext(experimentName, experimentFolder,
                toolConfig, repetitions, exp);
        this.runExperiments(exp.getVariations(), settings, new ArrayList<Variation>(), new ArrayList<Long>());

        metadata.setEndTime(new Date());
    }

    private class ExperimentContext {

        private final String experimentName;
        private final File experimentFolder;
        private final ToolConfiguration toolConfiguration;
        private final int repetitions;
        private final Experiment experiment;

        public ExperimentContext(final String experimentName,
                final File experimentFolder, final ToolConfiguration toolConfiguration, final int repetitions,
                final Experiment experiment) {
            super();
            this.experimentName = experimentName;
            this.experimentFolder = experimentFolder;
            this.toolConfiguration = toolConfiguration;
            this.repetitions = repetitions;
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

        public int getRepetitions() {
            return this.repetitions;
        }

        public Experiment getExperiment() {
            return this.experiment;
        }

    }

    public void runExperiments(final List<Variation> list, final ExperimentContext settings,
            final List<Variation> variants, final List<Long> currentFactorLevels) {
        if (!list.isEmpty()) {
            // obtain variation description
            final List<Variation> copy = new ArrayList<Variation>();
            copy.addAll(list);
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

                    this.runExperiments(copy, settings, variants, currentFactorLevels);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        } else {
            this.variateModelAndSimulate(settings, variants, currentFactorLevels);
        }
    }

    private void variateModelAndSimulate(final ExperimentContext settings, final List<Variation> variations,
            final List<Long> factorLevels) {
        final Experiment exp = settings.getExperiment();

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
            modelCopy = PCMModelHelper.copyToExperimentFolder(exp.getInitialModel(), this.experimentsLocation,
                    this.variationsLocation, variationFolderUri);
        } else {
            modelCopy = PCMModelHelper.copyToExperimentFolder(exp.getInitialModel(), variationFolderUri);
        }

        // load PCM model from copied model files
        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(URI.createFileURI(modelCopy.getUsagemodelFile()), true);
        resourceSet.getResource(URI.createFileURI(modelCopy.getAllocationFile()), true);
        EcoreUtil.resolveAll(resourceSet);

        // modify the copied PCM model according to the variation descriptions
        final List<String> variationDescriptions = new ArrayList<String>();
        for (int i = 0; i < variations.size(); i++) {
            final Variation v = variations.get(i);
            final long currentValue = factorLevels.get(i);
            final IVariationStrategy variationStrategy = this.initialiseVariations(v, resourceSet);
            final String desc = variationStrategy.vary(currentValue);
            variationDescriptions.add(desc);
        }

        // save the varied PCM model
        try {
            this.saveResources(resourceSet);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        // simulate the varied PCM model one or more times as specified by the replication count
        for (int i = 1; i <= settings.getRepetitions(); i++) {
            // ISimulationListener l = new
            // SimulationDurationSimulationListener(settings.getBookkeeping(), factorLevels);
            try {
                final IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(settings
                        .getToolConfiguration());
                analysisTool.runExperiment(settings.getExperimentname() + " "
                        + settings.getToolConfiguration().getName(), modelCopy, settings.getToolConfiguration(),
                        settings.getExperiment().getStopConditions());
            } catch (final Exception ex) {
                // settings.getBookkeeping().logException(ex);
                throw new RuntimeException("The simulation failed", ex);
            }
        }
    }


    private void saveResources(final ResourceSet rs) throws IOException {
        for (final Resource r : rs.getResources()) {
            final URI n = rs.getURIConverter().normalize(r.getURI());
            if (n.isFile()) {
                final OutputStream out = rs.getURIConverter().createOutputStream(r.getURI());
                r.save(out, null);
                logger.info("Saving resource: " + r.toString());
            }
        }
    }

}
