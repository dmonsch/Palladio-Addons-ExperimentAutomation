/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Persistence Framework</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework#getDatasource
 * <em>Datasource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getPersistenceFramework()
 * @model abstract="true"
 * @generated
 */
public interface PersistenceFramework extends EObject {

    /**
     * Returns the value of the '<em><b>Datasource</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Datasource</em>' containment reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Datasource</em>' containment reference.
     * @see #setDatasource(Datasource)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getPersistenceFramework_Datasource()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Datasource getDatasource();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework#getDatasource
     * <em>Datasource</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Datasource</em>' containment reference.
     * @see #getDatasource()
     * @generated
     */
    void setDatasource(Datasource value);
} // PersistenceFramework
