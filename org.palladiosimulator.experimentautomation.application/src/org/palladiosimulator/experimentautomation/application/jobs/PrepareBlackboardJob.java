package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.simulizar.launcher.jobs.LoadPMSModelIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadSDMModelsIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadUEModelIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.partitions.PMSResourceSetPartition;
import org.palladiosimulator.simulizar.launcher.partitions.SDMResourceSetPartition;
import org.palladiosimulator.simulizar.launcher.partitions.UEResourceSetPartition;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Prepares the MDSD blackboard for partitions needed by Experiment Automation's initial model.
 * 
 * @author Sebastian Lehrig
 */
public class PrepareBlackboardJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    public PrepareBlackboardJob() {
        super(false);
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // get PCM partition
        final ResourceSetPartition pcmPartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        // configure PMS model partition
        final PMSResourceSetPartition pmsPartition = new PMSResourceSetPartition((PCMResourceSetPartition) pcmPartition);
        this.getBlackboard().addPartition(LoadPMSModelIntoBlackboardJob.PMS_MODEL_PARTITION_ID, pmsPartition);

        // configure Usage Evolution model partition
        final UEResourceSetPartition uePartition = new UEResourceSetPartition((PCMResourceSetPartition) pcmPartition);
        this.getBlackboard().addPartition(LoadUEModelIntoBlackboardJob.UE_MODEL_PARTITION_ID, uePartition);

        // configure SDM models partition
        final SDMResourceSetPartition sdmPartition = new SDMResourceSetPartition();
        this.getBlackboard().addPartition(LoadSDMModelsIntoBlackboardJob.SDM_MODEL_PARTITION_ID, sdmPartition);
    }

}
