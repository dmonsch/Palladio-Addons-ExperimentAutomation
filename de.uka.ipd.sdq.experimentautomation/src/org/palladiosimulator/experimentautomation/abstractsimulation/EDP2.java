/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

import org.palladiosimulator.edp2.models.Repository.Repository;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EDP2</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.experimentautomation.abstractsimulation.EDP2#getRepository <em>
 * Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getEDP2()
 * @model
 * @generated
 */
public interface EDP2 extends PersistenceFramework {
    /**
     * Returns the value of the '<em><b>Repository</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repository</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Repository</em>' reference.
     * @see #setRepository(Repository)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getEDP2_Repository()
     * @model required="true"
     * @generated
     */
    Repository getRepository();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.EDP2#getRepository
     * <em>Repository</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Repository</em>' reference.
     * @see #getRepository()
     * @generated
     */
    void setRepository(Repository value);

} // EDP2
