package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.experimentautomation.experiments.Modification;
import org.palladiosimulator.experimentautomation.experiments.ObjectModification;
import org.palladiosimulator.experimentautomation.experiments.SchedulingPolicy2DelayModification;
import org.palladiosimulator.experimentautomation.experiments.util.ExperimentsSwitch;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Job to handle different kinds of modifications to models within the blackboard. For example,
 * attributes within a model may be added or whole parts of a model may be transformed.
 * 
 * @author Sebastian Lehrig
 */
public class ModifyModelsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /** A switch to apply the concretely given modification. */
    private final ExperimentsSwitch<Void> applyModificationSwitch = new ExperimentsSwitch<Void>() {

        @Override
        public Void caseObjectModification(final ObjectModification objectModification) {
            ModifyModelsJob.this.add(new ObjectModificationJob(objectModification));
            return null;
        };

        @Override
        public Void caseSchedulingPolicy2DelayModification(final SchedulingPolicy2DelayModification object) {
            ModifyModelsJob.this.add(new SchedulingPolicy2DelayModificationJob());
            return null;
        };

    };

    /**
     * Default constructor. Initializes modifications to be applied.
     * 
     * @param modifications
     *            Modifications to be applied within the job.
     */
    public ModifyModelsJob(final EList<Modification> modifications) {
        super(false);

        for (final Modification modification : modifications) {
            applyModificationSwitch.doSwitch(modification);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Perform Model Modification";
    }

}
