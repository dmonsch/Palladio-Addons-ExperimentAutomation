package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.palladiosimulator.commons.emfutils.EMFCopyHelper;
import org.palladiosimulator.simulizar.launcher.jobs.LoadSimuLizarModelsIntoBlackboardJob;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Copies the original PCM models to the standard PCM model blackboard partition.
 * 
 * @author Matthias Becker
 */
public class CopyOriginalPCMModelsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(CopyOriginalPCMModelsJob.class);

    public CopyOriginalPCMModelsJob() {
        super(false);
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        LOGGER.info("Cloning original PCM models for experiment run.");
        // copy the original initial PCM model into the PCM model partition
        this.getBlackboard().removePartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        final PCMResourceSetPartition newPartition = new PCMResourceSetPartition();

        final ResourceSetPartition orginalPCMModelPartition = this.getBlackboard().getPartition(
                LoadSimuLizarModelsIntoBlackboardJob.PCM_MODELS_ANALYZED_PARTITION_ID);

        final List<EObject> modelCopy = EMFCopyHelper.deepCopyToEObjectList(orginalPCMModelPartition.getResourceSet());
        for (int i = 0; i < modelCopy.size(); i++) {
            final Resource resource = newPartition.getResourceSet().createResource(URI.createFileURI("/temp" + i));
            resource.getContents().add(modelCopy.get(i));
        }

        this.getBlackboard().addPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, newPartition);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Clone PCM models";
    }
}
