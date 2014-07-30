package org.palladiosimulator.experimentautomation.application.tooladapter;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class RunAnalysisJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private boolean sloWasViolated = false;
    
    public RunAnalysisJob() {
        super(true);
    }

    public void setSloWasViolated() {
        this.sloWasViolated = true;
    }
    
    public boolean sloWasViolated() {
        return this.sloWasViolated;
    }
}
