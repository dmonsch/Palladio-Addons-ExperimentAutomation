package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2Datasource;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

// TODO this class is obsolete?
public class CleanUpRecorderJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final EDP2Datasource edp2datasource;

    public CleanUpRecorderJob(final EDP2Datasource edp2datasource) {
        this.edp2datasource = edp2datasource;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        super.execute(monitor);
    }
}
