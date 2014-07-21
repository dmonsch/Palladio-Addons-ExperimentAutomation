/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>File Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource#getLocation
 * <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getFileDatasource()
 * @model
 * @generated
 */
public interface FileDatasource extends Datasource {
    /**
     * Returns the value of the '<em><b>Location</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Location</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Location</em>' attribute.
     * @see #setLocation(String)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getFileDatasource_Location()
     * @model required="true" ordered="false"
     * @generated
     */
    String getLocation();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource#getLocation
     * <em>Location</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Location</em>' attribute.
     * @see #getLocation()
     * @generated
     */
    void setLocation(String value);

} // FileDatasource
