package org.palladiosimulator.experimentautomation.application.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.variation.VariationPackage;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class PrepareExperimentAutomationBlackboardPartionJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(PrepareExperimentAutomationBlackboardPartionJob.class);

    public static final String EXPERIMENT_REPOSITORY_PARTITION_ID = "org.palladiosimulator.experimentautomation.application.partition.experimentrepository";

    public static final String VARIATION_REPOSITORY_PARTITION_ID = "org.palladiosimulator.experimentautomation.application.partition.variationrepository";

    public static final EPackage[] EXPERIMENT_AUTOMATION_EPACKAGES = new EPackage[] { ExperimentsPackage.eINSTANCE,
            AbstractsimulationPackage.eINSTANCE, VariationPackage.eINSTANCE };

    private MDSDBlackboard blackboard;

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // Create and add the Experiment Automation model partition
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating Experiment Automation Model Partition");
        }

        ResourceSetPartition experimentRepositoryPartition = new ResourceSetPartition();
        this.blackboard.addPartition(EXPERIMENT_REPOSITORY_PARTITION_ID, experimentRepositoryPartition);

        ResourceSetPartition variationRepositoryPartition = new ResourceSetPartition();
        this.blackboard.addPartition(VARIATION_REPOSITORY_PARTITION_ID, variationRepositoryPartition);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initializing Experiment Automation EPackages");
        }

        experimentRepositoryPartition.initialiseResourceSetEPackages(EXPERIMENT_AUTOMATION_EPACKAGES);
        variationRepositoryPartition.initialiseResourceSetEPackages(EXPERIMENT_AUTOMATION_EPACKAGES);
    }

    @Override
    public String getName() {
        return "Prepare Experiment Automation Blackboard Partions";
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        this.blackboard.removePartition(EXPERIMENT_REPOSITORY_PARTITION_ID);
        this.blackboard.removePartition(VARIATION_REPOSITORY_PARTITION_ID);
    }

    @Override
    public void setBlackboard(MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

}
