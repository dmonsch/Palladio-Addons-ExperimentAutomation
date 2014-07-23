package org.palladiosimulator.experimentautomation.application.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * Loads the Experiment Automation models given in the configuration into a MDSD blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class LoadExperimentAutomationModelsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements
        IJob, IBlackboardInteractingJob<MDSDBlackboard> {
    private static final Logger LOGGER = Logger.getLogger(LoadExperimentAutomationModelsJob.class);

    private final URI experimentRepositoryURI;
    private final URI variationRepositoryURI;

    public LoadExperimentAutomationModelsJob(final IPath experimentRepositoryPath, final IPath variationRepositoryPath) {
        super(false);

        this.experimentRepositoryURI = URI.createFileURI(experimentRepositoryPath.toOSString());
        this.variationRepositoryURI = URI.createFileURI(variationRepositoryPath.toOSString());
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        ResourceSetPartition experimentRepositoryPartition = this.getBlackboard().getPartition(
                PrepareExperimentAutomationBlackboardPartionJob.EXPERIMENT_REPOSITORY_PARTITION_ID);
        ResourceSetPartition variationRepositoryPartition = this.getBlackboard().getPartition(
                PrepareExperimentAutomationBlackboardPartionJob.VARIATION_REPOSITORY_PARTITION_ID);

        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading Experiment Automation models");
        }
        experimentRepositoryPartition.loadModel(this.experimentRepositoryURI);
        experimentRepositoryPartition.resolveAllProxies();

        variationRepositoryPartition.loadModel(this.variationRepositoryURI);
        variationRepositoryPartition.resolveAllProxies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform Experiment Automation Model Load";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cleanup(final IProgressMonitor monitor) throws CleanupFailedException {
    }
}
