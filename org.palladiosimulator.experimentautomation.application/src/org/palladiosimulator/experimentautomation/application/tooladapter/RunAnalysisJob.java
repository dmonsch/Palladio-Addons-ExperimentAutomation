package org.palladiosimulator.experimentautomation.application.tooladapter;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class RunAnalysisJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private boolean sloWasViolated = false;
    private Map<String, Object> configurationMap = null;

    public RunAnalysisJob() {
        super(true);
    }

    public void setSloWasViolated() {
        this.sloWasViolated = true;
    }

    public boolean sloWasViolated() {
        return this.sloWasViolated;
    }

    public void setConfiguration(Map<String, Object> configurationMap) {
        this.configurationMap = configurationMap;
    }

    public Map<String, Object> getConfiguration() {
        if (this.configurationMap == null) {
            throw new RuntimeException("No configuration map found; ensure that it was set during the analysis job");
        }

        return this.configurationMap;
    }
}
