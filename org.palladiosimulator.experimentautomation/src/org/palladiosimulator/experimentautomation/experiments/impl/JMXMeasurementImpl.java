/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.JMXMeasurement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMX Measurement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.JMXMeasurementImpl#getPollingPeriod
 * <em>Polling Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JMXMeasurementImpl extends ResponseMeasurementImpl implements JMXMeasurement {
    /**
     * The default value of the '{@link #getPollingPeriod() <em>Polling Period</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPollingPeriod()
     * @generated
     * @ordered
     */
    protected static final Integer POLLING_PERIOD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPollingPeriod() <em>Polling Period</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPollingPeriod()
     * @generated
     * @ordered
     */
    protected Integer pollingPeriod = POLLING_PERIOD_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected JMXMeasurementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.JMX_MEASUREMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getPollingPeriod() {
        return this.pollingPeriod;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPollingPeriod(final Integer newPollingPeriod) {
        final Integer oldPollingPeriod = this.pollingPeriod;
        this.pollingPeriod = newPollingPeriod;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.JMX_MEASUREMENT__POLLING_PERIOD,
                    oldPollingPeriod, this.pollingPeriod));
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
        case ExperimentsPackage.JMX_MEASUREMENT__POLLING_PERIOD:
            return this.getPollingPeriod();
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
        case ExperimentsPackage.JMX_MEASUREMENT__POLLING_PERIOD:
            this.setPollingPeriod((Integer) newValue);
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
        case ExperimentsPackage.JMX_MEASUREMENT__POLLING_PERIOD:
            this.setPollingPeriod(POLLING_PERIOD_EDEFAULT);
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
        case ExperimentsPackage.JMX_MEASUREMENT__POLLING_PERIOD:
            return POLLING_PERIOD_EDEFAULT == null ? this.pollingPeriod != null : !POLLING_PERIOD_EDEFAULT
            .equals(this.pollingPeriod);
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
        result.append(" (pollingPeriod: ");
        result.append(this.pollingPeriod);
        result.append(')');
        return result.toString();
    }

} // JMXMeasurementImpl
