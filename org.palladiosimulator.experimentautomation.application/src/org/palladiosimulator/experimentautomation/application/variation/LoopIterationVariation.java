package org.palladiosimulator.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.experimentautomation.application.utils.PCMModelHelper;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;

public class LoopIterationVariation implements IVariationStrategy<Long> {

    private Loop loop;

    @Override
    public void setVariedObject(final EObject o) {
        if (!Loop.class.isInstance(o)) {
            throw new RuntimeException("Expected a Loop, but encountered a " + o.getClass().getName());
        }
        this.loop = (Loop) o;
    }

    @Override
    public String vary(final Long value) {
        final PCMRandomVariable r = CoreFactory.eINSTANCE.createPCMRandomVariable();
        r.setSpecification(value.toString());
        this.loop.setLoopIteration_Loop(r);

        return "Loop Iteration Count = " + value + ": " + PCMModelHelper.toString(this.loop);
    }

}
