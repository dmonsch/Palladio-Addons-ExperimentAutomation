/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reconfiguration Rules Folder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.ReconfigurationRulesFolderImpl#getFolderUri
 * <em>Folder Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReconfigurationRulesFolderImpl extends EObjectImpl implements ReconfigurationRulesFolder {
    /**
     * The default value of the '{@link #getFolderUri() <em>Folder Uri</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFolderUri()
     * @generated
     * @ordered
     */
    protected static final String FOLDER_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFolderUri() <em>Folder Uri</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFolderUri()
     * @generated
     * @ordered
     */
    protected String folderUri = FOLDER_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ReconfigurationRulesFolderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.RECONFIGURATION_RULES_FOLDER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getFolderUri() {
        return this.folderUri;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFolderUri(final String newFolderUri) {
        final String oldFolderUri = this.folderUri;
        this.folderUri = newFolderUri;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI, oldFolderUri, this.folderUri));
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            return this.getFolderUri();
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            this.setFolderUri((String) newValue);
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            this.setFolderUri(FOLDER_URI_EDEFAULT);
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            return FOLDER_URI_EDEFAULT == null ? this.folderUri != null : !FOLDER_URI_EDEFAULT.equals(this.folderUri);
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
        result.append(" (folderUri: ");
        result.append(this.folderUri);
        result.append(')');
        return result.toString();
    }

} // ReconfigurationRulesFolderImpl
