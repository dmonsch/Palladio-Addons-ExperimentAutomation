package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.simulizar.launcher.jobs.LoadMonitorRepositoryModelIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.jobs.LoadSimuLizarModelsIntoBlackboardJob;
import org.palladiosimulator.simulizar.launcher.partitions.MonitorRepositoryResourceSetPartition;
import org.palladiosimulator.simulizar.reconfiguration.storydiagram.jobs.LoadSDMModelsIntoBlackboardJob;
import org.palladiosimulator.simulizar.reconfiguration.storydiagram.modelaccess.SDMResourceSetPartition;

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
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // get PCM partition
        final ResourceSetPartition pcmPartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        // configure the original PCM model partition
        final PCMResourceSetPartition originalPcmPartition = new PCMResourceSetPartition();
        this.getBlackboard().addPartition(LoadSimuLizarModelsIntoBlackboardJob.ORIGINAL_PCM_MODELS_PARTITION_ID,
                originalPcmPartition);

        // configure MonitorRepository model partition
        final MonitorRepositoryResourceSetPartition monitorRepositoryPartition = new MonitorRepositoryResourceSetPartition(
                (PCMResourceSetPartition) pcmPartition);
        this.getBlackboard().addPartition(
                LoadMonitorRepositoryModelIntoBlackboardJob.MONITOR_REPOSITORY_MODEL_PARTITION_ID,
                monitorRepositoryPartition);

        // configure SDM models partition
        final SDMResourceSetPartition sdmPartition = new SDMResourceSetPartition();
        this.getBlackboard().addPartition(LoadSDMModelsIntoBlackboardJob.SDM_MODEL_PARTITION_ID, sdmPartition);

    }

}
