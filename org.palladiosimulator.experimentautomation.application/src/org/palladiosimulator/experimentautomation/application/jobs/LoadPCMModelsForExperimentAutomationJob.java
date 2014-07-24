package org.palladiosimulator.experimentautomation.application.jobs;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import org.palladiosimulator.simulizar.launcher.jobs.LoadPMSModelIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadSDMModelsIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.partitions.PMSResourceSetPartition;
import org.palladiosimulator.simulizar.launcher.partitions.SDMResourceSetPartition;
import org.palladiosimulator.simulizar.pms.PMSModel;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Loads the PCM models given in the configuration into an MDSD blackboard. Uses the initial model
 * of Experiment Automation to receive the referred PCM models.
 * 
 * TODO Copy model before putting it into blackboard [Lehrig]
 * 
 * @author Sebastian Lehrig
 */
public class LoadPCMModelsForExperimentAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(LoadPCMModelsForExperimentAutomationJob.class);

    private final InitialModel initialModel;

    public LoadPCMModelsForExperimentAutomationJob(InitialModel initialModel) {
        super(false);
        this.initialModel = initialModel;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // Load the PCM model itself
        final ResourceSetPartition pcmPartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading PCM models");
        }
        pcmPartition.loadModel(this.initialModel.getAllocation().eResource().getURI());
        pcmPartition.loadModel(this.initialModel.getUsageModel().eResource().getURI());
        pcmPartition.resolveAllProxies();

        // load the middleware completion
        final ResourceSetPartition middlewarePartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.MIDDLEWARE_PARTITION_ID);
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading middleware completion models");
        }
        middlewarePartition.loadModel(this.initialModel.getMiddlewareRepository().eResource().getURI());
        middlewarePartition.resolveAllProxies();

        // load the event middleware repository
        final ResourceSetPartition eventMiddlewarePartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID);
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading event middleware models");
        }
        eventMiddlewarePartition.loadModel(this.initialModel.getEventMiddleWareRepository().eResource().getURI());
        eventMiddlewarePartition.resolveAllProxies();

        // configure partition & load PMS model
        final PMSResourceSetPartition pmsPartition = new PMSResourceSetPartition((PCMResourceSetPartition) pcmPartition);
        final PMSModel pmsModel = this.initialModel.getPlatformMonitoringSpecification();
        if (pmsModel != null) {
            pmsPartition.loadModel(pmsModel.eResource().getURI());
        }
        this.getBlackboard().addPartition(LoadPMSModelIntoBlackboardJob.PMS_MODEL_PARTITION_ID, pmsPartition);
        pmsPartition.resolveAllProxiesToPCM();

        // configure partition & load SDM models
        final SDMResourceSetPartition sdmPartition = new SDMResourceSetPartition();
        final ReconfigurationRulesFolder reconfigurationRulesFolder = this.initialModel.getReconfigurationRules();

        this.getBlackboard().addPartition(LoadSDMModelsIntoBlackboardJob.SDM_MODEL_PARTITION_ID, sdmPartition);
        if (reconfigurationRulesFolder != null) {

            // add file protocol only if necessary
            File folder = null;
            if (!reconfigurationRulesFolder.getFolderUri().startsWith("platform:")) {
                final String filePath = "file:///" + reconfigurationRulesFolder.getFolderUri();
                final URI pathToSDM = URI.createURI(filePath);

                folder = new File(pathToSDM.toFileString());
            } else {
                try {
                    final URL pathURL = FileLocator.resolve(new URL(reconfigurationRulesFolder.getFolderUri()));
                    final String folderString = pathURL.toExternalForm().replace("file:", "");

                    folder = new File(folderString);
                } catch (IOException e) {
                    LOGGER.warn("No SDM models found, SD reconfigurations disabled.", e);
                    return;
                }
            }

            if (!folder.exists()) {
                LOGGER.warn("Folder " + folder + " does not exist. No reconfiguration rules will be loaded.");
                return;
            }
            final File[] files = folder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(final File dir, final String name) {
                    return name.endsWith(LoadSDMModelsIntoBlackboardJob.STORYDIAGRAMS_FILE_EXTENSION);
                }
            });
            if (files != null && files.length > 0) {
                for (final File file : files) {
                    sdmPartition.loadModel(URI.createFileURI(file.getPath()));
                }
            } else {
                LOGGER.warn("No SDM models found, SD reconfigurations disabled.");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform PCM Model Load";
    }
}
