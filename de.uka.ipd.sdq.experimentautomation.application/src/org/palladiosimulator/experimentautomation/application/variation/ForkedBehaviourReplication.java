package org.palladiosimulator.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.application.utils.PCMModelHelper;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;

public class ForkedBehaviourReplication implements IVariationStrategy {

    /** the action that is to be replicated */
    private ForkAction fork;

    @Override
    public void setVariedObject(final EObject o) {
        if (!ForkAction.class.isInstance(o)) {
            throw new RuntimeException("Expected an instance of " + ForkAction.class.getName() + ", but encountered a "
                    + o.getClass().getName());
        }
        this.fork = (ForkAction) o;

        if (this.fork.getAsynchronousForkedBehaviours_ForkAction().size() != 1) {
            throw new RuntimeException("Expected a fork with a single (asynchronous) "
                    + ForkedBehaviour.class.getName() + ", but encountered two or more behaviours.");
        }
    }

    @Override
    public String vary(final long value) {
        final ForkedBehaviour referenceBehaviour = this.fork.getAsynchronousForkedBehaviours_ForkAction().get(0);
        for (int i = 0; i < value; i++) {
            final ForkedBehaviour copy = EcoreHelper.copy(referenceBehaviour);
            copy.setForkAction_ForkedBehaivour(this.fork);
        }

        return "Replication count = " + value + ": ForkedBehaviour of " + PCMModelHelper.toString(this.fork);
    }

}
