package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.palladiosimulator.experimentautomation.experiments.Experiment;

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
     *            Configuration of the experiment.
     */
    public RunExperimentAutomationJob(final IPath experimentRepositoryPath, final IPath variationRepositoryPath,
            final List<Experiment> experiments) {
        super(false);

        this.add(new PrepareExperimentAutomationBlackboardPartionJob());
        this.add(new LoadExperimentAutomationModelsJob(experimentRepositoryPath, variationRepositoryPath));
        
        this.add(new PreparePCMBlackboardPartionJob());
        for (final Experiment experiment : experiments) {
            this.add(new LoadPCMModelsForExperimentAutomationJob(experiment.getInitialModel()));
            this.add(new RunExperimentForEachToolJob(experiment));
        }
    }

}
