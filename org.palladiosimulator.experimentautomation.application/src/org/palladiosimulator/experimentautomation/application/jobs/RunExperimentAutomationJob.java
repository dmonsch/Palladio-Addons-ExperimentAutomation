package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.palladiosimulator.experimentautomation.application.config.ExperimentAutomationConfiguration;
import org.palladiosimulator.experimentautomation.experiments.Experiment;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.PreparePCMBlackboardPartionJob;

/**
 * This job conducts a series of experiments. Each experiment has its own initial set of Palladio
 * models.
 * 
 * @author Sebastian Lehrig
 */
public class RunExperimentAutomationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Default Constructor.
     * 
     * @param configuration
     *            Configuration for Experiment Automation runs.
     */
    public RunExperimentAutomationJob(final ExperimentAutomationConfiguration configuration) {
        this(configuration, null);
    }

    /**
     * Default constructor.
     * 
     * @param configuration
     *            Configuration for Experiment Automation runs.
     * @param listener
     *            DebugListener for simulations.
     */
    public RunExperimentAutomationJob(final ExperimentAutomationConfiguration configuration,
            final IDebugListener listener) {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }

        final List<Experiment> experiments = configuration.getExperiments();

        this.add(new PreparePCMBlackboardPartionJob());
        for (final Experiment experiment : experiments) {
            this.add(new LoadPCMModelsForExperimentAutomationJob(experiment.getInitialModel()));
            this.add(new RunExperimentForEachToolJob(experiment));
        }
    }

}
