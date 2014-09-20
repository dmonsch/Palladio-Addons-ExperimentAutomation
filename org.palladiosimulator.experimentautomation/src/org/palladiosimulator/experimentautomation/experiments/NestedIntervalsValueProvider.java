/**
 */
package org.palladiosimulator.experimentautomation.experiments;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Nested Intervals Value Provider</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider#getMinValue
 * <em>Min Value</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider#getMaxValue
 * <em>Max Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getNestedIntervalsValueProvider()
 * @model
 * @generated
 */
public interface NestedIntervalsValueProvider extends ValueProvider {
    /**
     * Returns the value of the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Min Value</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Min Value</em>' attribute.
     * @see #setMinValue(long)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getNestedIntervalsValueProvider_MinValue()
     * @model required="true"
     * @generated
     */
    long getMinValue();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider#getMinValue
     * <em>Min Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Min Value</em>' attribute.
     * @see #getMinValue()
     * @generated
     */
    void setMinValue(long value);

    /**
     * Returns the value of the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Value</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Max Value</em>' attribute.
     * @see #setMaxValue(long)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getNestedIntervalsValueProvider_MaxValue()
     * @model required="true"
     * @generated
     */
    long getMaxValue();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider#getMaxValue
     * <em>Max Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Max Value</em>' attribute.
     * @see #getMaxValue()
     * @generated
     */
    void setMaxValue(long value);

} // NestedIntervalsValueProvider
