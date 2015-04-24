/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.SimTimeStopCondition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sim Time Stop Condition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.SimTimeStopConditionImpl#getSimulationTime
 * <em>Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimTimeStopConditionImpl extends StopConditionImpl implements SimTimeStopCondition {
    /**
     * The default value of the '{@link #getSimulationTime() <em>Simulation Time</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSimulationTime()
     * @generated
     * @ordered
     */
    protected static final int SIMULATION_TIME_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSimulationTime() <em>Simulation Time</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSimulationTime()
     * @generated
     * @ordered
     */
    protected int simulationTime = SIMULATION_TIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SimTimeStopConditionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.SIM_TIME_STOP_CONDITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getSimulationTime() {
        return this.simulationTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSimulationTime(final int newSimulationTime) {
        final int oldSimulationTime = this.simulationTime;
        this.simulationTime = newSimulationTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.SIM_TIME_STOP_CONDITION__SIMULATION_TIME, oldSimulationTime,
                    this.simulationTime));
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
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION__SIMULATION_TIME:
            return this.getSimulationTime();
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
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION__SIMULATION_TIME:
            this.setSimulationTime((Integer) newValue);
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
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION__SIMULATION_TIME:
            this.setSimulationTime(SIMULATION_TIME_EDEFAULT);
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
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION__SIMULATION_TIME:
            return this.simulationTime != SIMULATION_TIME_EDEFAULT;
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
        result.append(" (simulationTime: ");
        result.append(this.simulationTime);
        result.append(')');
        return result.toString();
    }

} // SimTimeStopConditionImpl
