/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.PolynomialValueProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Polynomial Value Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.PolynomialValueProviderImpl#getExponent
 * <em>Exponent</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.PolynomialValueProviderImpl#getFactor
 * <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolynomialValueProviderImpl extends ValueProviderImpl implements PolynomialValueProvider {
    /**
     * The default value of the '{@link #getExponent() <em>Exponent</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExponent()
     * @generated
     * @ordered
     */
    protected static final double EXPONENT_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getExponent() <em>Exponent</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExponent()
     * @generated
     * @ordered
     */
    protected double exponent = EXPONENT_EDEFAULT;

    /**
     * The default value of the '{@link #getFactor() <em>Factor</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFactor()
     * @generated
     * @ordered
     */
    protected static final double FACTOR_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getFactor() <em>Factor</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getFactor()
     * @generated
     * @ordered
     */
    protected double factor = FACTOR_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PolynomialValueProviderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.POLYNOMIAL_VALUE_PROVIDER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getExponent() {
        return this.exponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExponent(final double newExponent) {
        final double oldExponent = this.exponent;
        this.exponent = newExponent;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__EXPONENT, oldExponent, this.exponent));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getFactor() {
        return this.factor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFactor(final double newFactor) {
        final double oldFactor = this.factor;
        this.factor = newFactor;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__FACTOR,
                    oldFactor, this.factor));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__EXPONENT:
            return this.getExponent();
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__FACTOR:
            return this.getFactor();
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
        switch (featureID)
        {
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__EXPONENT:
            this.setExponent((Double) newValue);
            return;
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__FACTOR:
            this.setFactor((Double) newValue);
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
        switch (featureID)
        {
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__EXPONENT:
            this.setExponent(EXPONENT_EDEFAULT);
            return;
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__FACTOR:
            this.setFactor(FACTOR_EDEFAULT);
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
        switch (featureID)
        {
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__EXPONENT:
            return this.exponent != EXPONENT_EDEFAULT;
        case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER__FACTOR:
            return this.factor != FACTOR_EDEFAULT;
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
        result.append(" (exponent: ");
        result.append(this.exponent);
        result.append(", factor: ");
        result.append(this.factor);
        result.append(')');
        return result.toString();
    }

} // PolynomialValueProviderImpl
