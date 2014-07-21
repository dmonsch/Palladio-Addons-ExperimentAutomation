/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Probe Spec Configuration</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.ProbeSpecConfiguration#getBlackboardType
 * <em>Blackboard Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getProbeSpecConfiguration()
 * @model
 * @generated
 */
public interface ProbeSpecConfiguration extends EObject {
    /**
     * Returns the value of the '<em><b>Blackboard Type</b></em>' attribute. The literals are from
     * the enumeration
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.BlackboardType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blackboard Type</em>' attribute isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Blackboard Type</em>' attribute.
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.BlackboardType
     * @see #setBlackboardType(BlackboardType)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getProbeSpecConfiguration_BlackboardType()
     * @model required="true" ordered="false"
     * @generated
     */
    BlackboardType getBlackboardType();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.ProbeSpecConfiguration#getBlackboardType
     * <em>Blackboard Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Blackboard Type</em>' attribute.
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.BlackboardType
     * @see #getBlackboardType()
     * @generated
     */
    void setBlackboardType(BlackboardType value);

} // ProbeSpecConfiguration
