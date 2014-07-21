/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Measurement Count Stop Condition</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.MeasurementCountStopCondition#getMeasurementCount
 * <em>Measurement Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getMeasurementCountStopCondition()
 * @model
 * @generated
 */
public interface MeasurementCountStopCondition extends StopCondition {
    /**
     * Returns the value of the '<em><b>Measurement Count</b></em>' attribute. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Measurement Count</em>' attribute isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Measurement Count</em>' attribute.
     * @see #setMeasurementCount(int)
     * @see org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage#getMeasurementCountStopCondition_MeasurementCount()
     * @model required="true" ordered="false"
     * @generated
     */
    int getMeasurementCount();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.abstractsimulation.MeasurementCountStopCondition#getMeasurementCount
     * <em>Measurement Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Measurement Count</em>' attribute.
     * @see #getMeasurementCount()
     * @generated
     */
    void setMeasurementCount(int value);

} // MeasurementCountStopCondition
