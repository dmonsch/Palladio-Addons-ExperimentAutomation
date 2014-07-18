/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.BlackboardType;
import org.palladiosimulator.experimentautomation.abstractsimulation.ProbeSpecConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Probe Spec Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.abstractsimulation.impl.ProbeSpecConfigurationImpl#getBlackboardType
 * <em>Blackboard Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbeSpecConfigurationImpl extends EObjectImpl implements ProbeSpecConfiguration {
    /**
     * The default value of the '{@link #getBlackboardType() <em>Blackboard Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBlackboardType()
     * @generated
     * @ordered
     */
    protected static final BlackboardType BLACKBOARD_TYPE_EDEFAULT = BlackboardType.SIMPLE;

    /**
     * The cached value of the '{@link #getBlackboardType() <em>Blackboard Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBlackboardType()
     * @generated
     * @ordered
     */
    protected BlackboardType blackboardType = BLACKBOARD_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProbeSpecConfigurationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.PROBE_SPEC_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BlackboardType getBlackboardType() {
        return blackboardType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBlackboardType(BlackboardType newBlackboardType) {
        BlackboardType oldBlackboardType = blackboardType;
        blackboardType = newBlackboardType == null ? BLACKBOARD_TYPE_EDEFAULT : newBlackboardType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE, oldBlackboardType,
                    blackboardType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE:
            return getBlackboardType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE:
            setBlackboardType((BlackboardType) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE:
            setBlackboardType(BLACKBOARD_TYPE_EDEFAULT);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE:
            return blackboardType != BLACKBOARD_TYPE_EDEFAULT;
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
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (blackboardType: ");
        result.append(blackboardType);
        result.append(')');
        return result.toString();
    }

} // ProbeSpecConfigurationImpl
