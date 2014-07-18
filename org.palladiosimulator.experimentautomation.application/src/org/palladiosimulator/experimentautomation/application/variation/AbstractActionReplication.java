package org.palladiosimulator.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.application.utils.PCMModelHelper;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;

public class AbstractActionReplication implements IVariationStrategy {

    /** the action that is to be replicated */
    private AbstractAction action;

    @Override
    public void setVariedObject(final EObject o) {
        if (!AbstractAction.class.isInstance(o)) {
            throw new RuntimeException("Expected an instance of " + AbstractAction.class.getName()
                    + ", but encountered a " + o.getClass().getName());
        }
        this.action = (AbstractAction) o;
    }

    @Override
    public String vary(final long value) {
        AbstractAction lastAction = this.action;
        for (int i = 0; i < value; i++) {
            final AbstractAction previousSuccessor = lastAction.getSuccessor_AbstractAction();
            final AbstractAction copy = EcoreHelper.copy(this.action);
            lastAction.setSuccessor_AbstractAction(copy);
            copy.setResourceDemandingBehaviour_AbstractAction(this.action
                    .getResourceDemandingBehaviour_AbstractAction());
            copy.setPredecessor_AbstractAction(lastAction);
            copy.setSuccessor_AbstractAction(previousSuccessor);
            copy.setEntityName(copy.getEntityName() + (i + 1));
            lastAction = copy;
        }

        return "Replication count = " + value + ": " + PCMModelHelper.toString(this.action);
    }

}
