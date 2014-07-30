package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.application.tooladapter.RunAnalysisJob;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * FIXME Actually check for SLO violations.
 * 
 * @author Sebastian Lehrig
 */
public class CheckForSLOViolationsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final RunAnalysisJob runAnalysisJob;
    private final ServiceLevelObjectiveRepository serviceLevelObjectives;
    private final PersistenceFramework persistenceFramework;

    public CheckForSLOViolationsJob(final RunAnalysisJob runAnalysisJob,
            final ServiceLevelObjectiveRepository serviceLevelObjectives,
            final PersistenceFramework persistenceFramework) {
        this.runAnalysisJob = runAnalysisJob;
        this.serviceLevelObjectives = serviceLevelObjectives;
        this.persistenceFramework = persistenceFramework;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        if (false) {
            this.runAnalysisJob.sloWasViolated();
        }

    }
}
