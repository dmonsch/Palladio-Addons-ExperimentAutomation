/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Nested Intervals Value Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.NestedIntervalsValueProviderImpl#getMinValue
 * <em>Min Value</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.NestedIntervalsValueProviderImpl#getMaxValue
 * <em>Max Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NestedIntervalsValueProviderImpl extends ValueProviderImpl implements NestedIntervalsValueProvider {
    /**
     * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMinValue()
     * @generated
     * @ordered
     */
    protected static final double MIN_VALUE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMinValue()
     * @generated
     * @ordered
     */
    protected double minValue = MIN_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMaxValue()
     * @generated
     * @ordered
     */
    protected static final double MAX_VALUE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMaxValue()
     * @generated
     * @ordered
     */
    protected double maxValue = MAX_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected NestedIntervalsValueProviderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.NESTED_INTERVALS_VALUE_PROVIDER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getMinValue() {
        return this.minValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMinValue(final double newMinValue) {
        final double oldMinValue = this.minValue;
        this.minValue = newMinValue;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE, oldMinValue, this.minValue));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getMaxValue() {
        return this.maxValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMaxValue(final double newMaxValue) {
        final double oldMaxValue = this.maxValue;
        this.maxValue = newMaxValue;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE, oldMaxValue, this.maxValue));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE:
            return this.getMinValue();
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE:
            return this.getMaxValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE:
            this.setMinValue((Double) newValue);
            return;
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE:
            this.setMaxValue((Double) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE:
            this.setMinValue(MIN_VALUE_EDEFAULT);
            return;
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE:
            this.setMaxValue(MAX_VALUE_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE:
            return this.minValue != MIN_VALUE_EDEFAULT;
        case ExperimentsPackage.NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE:
            return this.maxValue != MAX_VALUE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (minValue: ");
        result.append(this.minValue);
        result.append(", maxValue: ");
        result.append(this.maxValue);
        result.append(')');
        return result.toString();
    }

} // NestedIntervalsValueProviderImpl
