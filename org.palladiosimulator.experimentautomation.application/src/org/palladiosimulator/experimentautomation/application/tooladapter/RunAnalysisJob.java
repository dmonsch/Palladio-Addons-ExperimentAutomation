package org.palladiosimulator.experimentautomation.application.tooladapter;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class RunAnalysisJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    public RunAnalysisJob() {
        super(true);
    }

}
