/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sensor Framework</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework#getDatasource
 * <em>Datasource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getSensorFramework()
 * @model
 * @generated
 */
public interface SensorFramework extends PersistenceFramework {
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
     * @see #setDatasource(SensorFrameworkDatasource)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getSensorFramework_Datasource()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    SensorFrameworkDatasource getDatasource();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework#getDatasource
     * <em>Datasource</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Datasource</em>' containment reference.
     * @see #getDatasource()
     * @generated
     */
    void setDatasource(SensorFrameworkDatasource value);

} // SensorFramework
