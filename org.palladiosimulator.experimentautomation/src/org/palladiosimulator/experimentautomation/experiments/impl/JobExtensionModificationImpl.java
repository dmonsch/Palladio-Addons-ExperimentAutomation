/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.JobExtensionModification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Job Extension Modification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.JobExtensionModificationImpl#getExtensionID
 * <em>Extension ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobExtensionModificationImpl extends ModificationImpl implements JobExtensionModification {
    /**
     * The default value of the '{@link #getExtensionID() <em>Extension ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExtensionID()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_ID_EDEFAULT = "org.palladiosimulator.quality.scalability";

    /**
     * The cached value of the '{@link #getExtensionID() <em>Extension ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExtensionID()
     * @generated
     * @ordered
     */
    protected String extensionID = EXTENSION_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected JobExtensionModificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.JOB_EXTENSION_MODIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getExtensionID() {
        return this.extensionID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExtensionID(final String newExtensionID) {
        final String oldExtensionID = this.extensionID;
        this.extensionID = newExtensionID;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.JOB_EXTENSION_MODIFICATION__EXTENSION_ID, oldExtensionID, this.extensionID));
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
        case ExperimentsPackage.JOB_EXTENSION_MODIFICATION__EXTENSION_ID:
            return this.getExtensionID();
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
        case ExperimentsPackage.JOB_EXTENSION_MODIFICATION__EXTENSION_ID:
            this.setExtensionID((String) newValue);
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
        case ExperimentsPackage.JOB_EXTENSION_MODIFICATION__EXTENSION_ID:
            this.setExtensionID(EXTENSION_ID_EDEFAULT);
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
        case ExperimentsPackage.JOB_EXTENSION_MODIFICATION__EXTENSION_ID:
            return EXTENSION_ID_EDEFAULT == null ? this.extensionID != null : !EXTENSION_ID_EDEFAULT
                    .equals(this.extensionID);
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
        result.append(" (extensionID: ");
        result.append(this.extensionID);
        result.append(')');
        return result.toString();
    }

} // JobExtensionModificationImpl
