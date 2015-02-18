package org.palladiosimulator.experimentautomation.application.jobs;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import org.palladiosimulator.simulizar.launcher.jobs.LoadMonitorRepositoryModelIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadSDMModelsIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadUEModelIntoBlackboardJob;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Loads all needed source PCM models into the PCM blackboard partition. Uses the initial model of
 * Experiment Automation to receive the referred PCM models. These PCM models may be uncompleted,
 * i.e., no AT completion was executed yet. Therefore, such models require stereotypes that
 * reference AT models. These AT models can be used to execute AT completions.
 * 
 * @author Sebastian Lehrig
 */
public class LoadModelsIntoBlackboardJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(LoadModelsIntoBlackboardJob.class);

    private final InitialModel initialModel;

    public LoadModelsIntoBlackboardJob(final InitialModel initialModel) {
        super(false);
        this.initialModel = initialModel;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // Load the PCM models
        List<EObject> pcmModels = new ArrayList<EObject>();
        pcmModels.add(this.initialModel.getRepository());
        pcmModels.add(this.initialModel.getSystem());
        pcmModels.add(this.initialModel.getResourceEnvironment());
        pcmModels.add(this.initialModel.getAllocation());
        pcmModels.add(this.initialModel.getUsageModel());
        loadIntoBlackboard(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, pcmModels);

        // load the middleware completion
        loadIntoBlackboard(LoadPCMModelsIntoBlackboardJob.RMI_MIDDLEWARE_PARTITION_ID,
                this.initialModel.getMiddlewareRepository());

        // load the event middleware repository
        loadIntoBlackboard(LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID,
                this.initialModel.getEventMiddleWareRepository());

        // load monitor repository model
        loadIntoBlackboard(LoadMonitorRepositoryModelIntoBlackboardJob.MONITOR_REPOSITORY_MODEL_PARTITION_ID,
                this.initialModel.getMonitorRepository());

        // load Usage Evolution model
        loadIntoBlackboard(LoadUEModelIntoBlackboardJob.UE_MODEL_PARTITION_ID, this.initialModel.getUsageEvolution());

        // load SDM models
        final ReconfigurationRulesFolder reconfigurationRulesFolder = this.initialModel.getReconfigurationRules();
        if (reconfigurationRulesFolder != null) {
            if (LOGGER.isEnabledFor(Level.INFO)) {
                LOGGER.info("Loading models for partition " + LoadSDMModelsIntoBlackboardJob.SDM_MODEL_PARTITION_ID);
            }
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
                } catch (final IOException e) {
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
                    this.getBlackboard().getPartition(LoadSDMModelsIntoBlackboardJob.SDM_MODEL_PARTITION_ID)
                            .loadModel(URI.createFileURI(file.getPath()));
                }
            } else {
                LOGGER.info("No SDM models found, SD reconfigurations disabled.");
            }
        }
    }

    private void loadIntoBlackboard(final String partitionId, final EObject eObject) {
        loadIntoBlackboard(partitionId, Arrays.asList(eObject));
    }

    private void loadIntoBlackboard(final String partitionId, final List<EObject> eObjects) {
        final ResourceSetPartition partition = this.getBlackboard().getPartition(partitionId);
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading models for partition " + partitionId);
        }
        for (final EObject eObject : eObjects) {
            loadIfExisting(partition, eObject);
        }
        partition.resolveAllProxies();
    }

    private static void loadIfExisting(final ResourceSetPartition resourceSetPartition, final EObject eObject) {
        if (eObject != null) {
            resourceSetPartition.loadModel(eObject.eResource().getURI());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform AT PCM Model Load";
    }
}
