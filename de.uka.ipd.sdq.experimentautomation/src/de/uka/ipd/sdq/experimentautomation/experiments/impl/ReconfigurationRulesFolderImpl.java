/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ReconfigurationRulesFolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reconfiguration Rules Folder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ReconfigurationRulesFolderImpl#getFolderUri
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
    public String getFolderUri() {
        return folderUri;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFolderUri(String newFolderUri) {
        String oldFolderUri = folderUri;
        folderUri = newFolderUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI, oldFolderUri, folderUri));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            return getFolderUri();
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            setFolderUri((String) newValue);
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            setFolderUri(FOLDER_URI_EDEFAULT);
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
        case ExperimentsPackage.RECONFIGURATION_RULES_FOLDER__FOLDER_URI:
            return FOLDER_URI_EDEFAULT == null ? folderUri != null : !FOLDER_URI_EDEFAULT.equals(folderUri);
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
        result.append(" (folderUri: ");
        result.append(folderUri);
        result.append(')');
        return result.toString();
    }

} // ReconfigurationRulesFolderImpl
