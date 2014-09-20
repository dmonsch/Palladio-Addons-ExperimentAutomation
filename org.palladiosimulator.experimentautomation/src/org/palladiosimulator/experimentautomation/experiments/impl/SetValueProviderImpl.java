/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.SetValueProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Set Value Provider</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.SetValueProviderImpl#getValues
 * <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetValueProviderImpl extends ValueProviderImpl implements SetValueProvider {
    /**
     * The default value of the '{@link #getValues() <em>Values</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected static final String VALUES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected String values = VALUES_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SetValueProviderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.SET_VALUE_PROVIDER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getValues() {
        return this.values;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setValues(final String newValues) {
        final String oldValues = this.values;
        this.values = newValues;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.SET_VALUE_PROVIDER__VALUES,
                    oldValues, this.values));
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
        case ExperimentsPackage.SET_VALUE_PROVIDER__VALUES:
            return this.getValues();
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
        case ExperimentsPackage.SET_VALUE_PROVIDER__VALUES:
            this.setValues((String) newValue);
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
        case ExperimentsPackage.SET_VALUE_PROVIDER__VALUES:
            this.setValues(VALUES_EDEFAULT);
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
        case ExperimentsPackage.SET_VALUE_PROVIDER__VALUES:
            return VALUES_EDEFAULT == null ? this.values != null : !VALUES_EDEFAULT.equals(this.values);
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
        result.append(" (values: ");
        result.append(this.values);
        result.append(')');
        return result.toString();
    }

} // SetValueProviderImpl
