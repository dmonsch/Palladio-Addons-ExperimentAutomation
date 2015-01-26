/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.LinearValueProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Linear Value Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.LinearValueProviderImpl#getSummand
 * <em>Summand</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.LinearValueProviderImpl#getFactor
 * <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinearValueProviderImpl extends ValueProviderImpl implements LinearValueProvider {
    /**
     * The default value of the '{@link #getSummand() <em>Summand</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSummand()
     * @generated
     * @ordered
     */
    protected static final double SUMMAND_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getSummand() <em>Summand</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSummand()
     * @generated
     * @ordered
     */
    protected double summand = SUMMAND_EDEFAULT;

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
    protected LinearValueProviderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.LINEAR_VALUE_PROVIDER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getSummand() {
        return this.summand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSummand(final double newSummand) {
        final double oldSummand = this.summand;
        this.summand = newSummand;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.LINEAR_VALUE_PROVIDER__SUMMAND, oldSummand, this.summand));
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
                    ExperimentsPackage.LINEAR_VALUE_PROVIDER__FACTOR, oldFactor, this.factor));
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
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__SUMMAND:
            return this.getSummand();
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__FACTOR:
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
        switch (featureID) {
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__SUMMAND:
            this.setSummand((Double) newValue);
            return;
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__FACTOR:
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
        switch (featureID) {
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__SUMMAND:
            this.setSummand(SUMMAND_EDEFAULT);
            return;
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__FACTOR:
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
        switch (featureID) {
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__SUMMAND:
            return this.summand != SUMMAND_EDEFAULT;
        case ExperimentsPackage.LINEAR_VALUE_PROVIDER__FACTOR:
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
        result.append(" (summand: ");
        result.append(this.summand);
        result.append(", factor: ");
        result.append(this.factor);
        result.append(')');
        return result.toString();
    }

} // LinearValueProviderImpl
