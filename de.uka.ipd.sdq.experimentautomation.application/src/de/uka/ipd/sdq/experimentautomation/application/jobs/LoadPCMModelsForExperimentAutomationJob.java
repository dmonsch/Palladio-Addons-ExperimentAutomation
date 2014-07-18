package org.palladiosimulator.experimentautomation.application.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Loads the PCM models given in the configuration into a MDSD blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class LoadPCMModelsForExperimentAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard>
        implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {
    private static final Logger LOGGER = Logger.getLogger(LoadPCMModelsForExperimentAutomationJob.class);
    private final InitialModel initialModel;

    private MDSDBlackboard blackboard;

    public LoadPCMModelsForExperimentAutomationJob(InitialModel initialModel) {
        super(false);
        this.initialModel = initialModel;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        ResourceSetPartition pcmPartition = this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        ResourceSetPartition middlewarePartition = this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.MIDDLEWARE_PARTITION_ID);
        ResourceSetPartition eventMiddlewarePartition = this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID);

        // Load the PCM model itself
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading PCM models");
        }
        pcmPartition.loadModel(this.initialModel.getAllocation().eResource().getURI());
        pcmPartition.loadModel(this.initialModel.getUsageModel().eResource().getURI());
        pcmPartition.resolveAllProxies();
        
        // load the middleware completion
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading middleware completion models");
        }
        middlewarePartition.loadModel(this.initialModel.getMiddlewareRepository().eResource().getURI());
        middlewarePartition.resolveAllProxies();

        // load the event middleware repository
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Loading event middleware models");
        }
        eventMiddlewarePartition.loadModel(this.initialModel.getEventMiddleWareRepository().eResource().getURI());
        eventMiddlewarePartition.resolveAllProxies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform PCM Model Load";
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
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
    }
}
