package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class LogExperimentInformationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    // private static final Logger LOGGER = Logger.getLogger(LogExperimentInformationJob.class);

    private final Experiment experiment;
    private final AbstractSimulationConfig simulationConfig;
    private final List<Variation> variations;
    private final List<Long> factorLevels;
    private final int repetition;

    public LogExperimentInformationJob(final Experiment experiment, final AbstractSimulationConfig simulationConfig,
            final List<Variation> variations, final List<Long> factorLevels, final int repetition) {
        this.experiment = experiment;
        this.simulationConfig = simulationConfig;
        this.variations = variations;
        this.factorLevels = factorLevels;
        this.repetition = repetition;
    }

    /**
     * TODO How to enable logging? [Lehrig]
     * 
     * {@inheritDoc}
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // if(LOGGER.isInfoEnabled()) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("============= Experiment Automation: Experiment Run =============\n");

        stringBuilder.append("NAME: \"");
        stringBuilder.append(this.simulationConfig.getNameBase());
        stringBuilder.append("\"\n");

        for (int i = 0; i < this.variations.size(); i++) {
            final Variation variation = this.variations.get(i);
            final Long factor = this.factorLevels.get(i);

            stringBuilder.append("VARIATION: ");
            stringBuilder.append(variation.getName());
            stringBuilder.append("[");
            stringBuilder.append(factor);
            stringBuilder.append("](");
            stringBuilder.append(variation.getVariedObjectId());
            stringBuilder.append(")\n");
        }

        stringBuilder.append("REPETITION: ");
        stringBuilder.append(this.repetition);
        stringBuilder.append(" of ");
        stringBuilder.append(this.experiment.getRepetitions());
        stringBuilder.append("\n");

        stringBuilder.append("SIMULATOR ID: \"");
        stringBuilder.append(this.simulationConfig.getSimulatorId());
        stringBuilder.append("\"\n");

        stringBuilder.append("RECORDER: \"");
        stringBuilder.append(this.simulationConfig.getRecorderName());
        stringBuilder.append("\"\n");

        System.out.print(stringBuilder.toString());

        // LOGGER.info(stringBuilder.toString());
        // }

        super.execute(monitor);
    }
}
