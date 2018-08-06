package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation;

import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.workflow.blackboard.Blackboard;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public abstract class AbstractSimulationRun extends SequentialBlackboardInteractingJob<Blackboard<MDSDBlackboard>> {

    private final ToolConfiguration config;

    /**
     * Default constructor.
     * 
     * @param config
     *            the tool configuration
     */
    public AbstractSimulationRun(final ToolConfiguration config) {
        this.config = config;
    }

    public ToolConfiguration getConfig() {
        return this.config;
    }

}
