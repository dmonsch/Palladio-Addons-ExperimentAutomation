package org.palladiosimulator.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface for specifying variation strategies of PCM elements. For example, the population number
 * of a closed workload can be varied. For specifying a variation strategy, the strategy has to
 * allow two things. First, a strategy must to allow to specify the element to be varied (e.g., a
 * closed workload). Second, a strategy must allow to assign a concrete value to the specified
 * element (e.g., 10 users).
 * 
 * Implementing classes are can be referenced from Experiment Automation's variation meta class. The
 * "pcm.variation" model includes such references that are used in the PCM context.
 * 
 * @author Sebastian Lehrig
 */
public interface IVariationStrategy {

    /**
     * Sets the given EObject as the element top be varied.
     * 
     * @param eObject
     *            the given EObject.
     */
    public void setVariedObject(EObject eObject);

    /**
     * Sets the given concrete value to the object to be varied.
     * 
     * @param value
     *            the concrete value to assigned to the varied object.
     * @return a textual description of the variation.
     */
    public String vary(Double value);

}
