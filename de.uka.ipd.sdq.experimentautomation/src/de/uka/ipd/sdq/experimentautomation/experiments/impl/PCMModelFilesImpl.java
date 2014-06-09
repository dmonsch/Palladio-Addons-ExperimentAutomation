/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PCM Model Files</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getAllocationFile
 * <em>Allocation File</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getUsagemodelFile
 * <em>Usagemodel File</em>}</li>
 * <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getSystemFile
 * <em>System File</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getRepositoryFile
 * <em>Repository File</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getResourceenvironmentFile
 * <em>Resourceenvironment File</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getMiddlewareRepositoryFile
 * <em>Middleware Repository File</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getEventMiddlewareRepositoryFile
 * <em>Event Middleware Repository File</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PCMModelFilesImpl extends EObjectImpl implements PCMModelFiles {
    /**
     * The default value of the '{@link #getAllocationFile() <em>Allocation File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAllocationFile()
     * @generated
     * @ordered
     */
    protected static final String ALLOCATION_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAllocationFile() <em>Allocation File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAllocationFile()
     * @generated
     * @ordered
     */
    protected String allocationFile = ALLOCATION_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getUsagemodelFile() <em>Usagemodel File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUsagemodelFile()
     * @generated
     * @ordered
     */
    protected static final String USAGEMODEL_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsagemodelFile() <em>Usagemodel File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUsagemodelFile()
     * @generated
     * @ordered
     */
    protected String usagemodelFile = USAGEMODEL_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getSystemFile() <em>System File</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSystemFile()
     * @generated
     * @ordered
     */
    protected static final String SYSTEM_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSystemFile() <em>System File</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSystemFile()
     * @generated
     * @ordered
     */
    protected String systemFile = SYSTEM_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getRepositoryFile() <em>Repository File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRepositoryFile()
     * @generated
     * @ordered
     */
    protected static final String REPOSITORY_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRepositoryFile() <em>Repository File</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRepositoryFile()
     * @generated
     * @ordered
     */
    protected String repositoryFile = REPOSITORY_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getResourceenvironmentFile()
     * <em>Resourceenvironment File</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceenvironmentFile()
     * @generated
     * @ordered
     */
    protected static final String RESOURCEENVIRONMENT_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getResourceenvironmentFile()
     * <em>Resourceenvironment File</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceenvironmentFile()
     * @generated
     * @ordered
     */
    protected String resourceenvironmentFile = RESOURCEENVIRONMENT_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getMiddlewareRepositoryFile()
     * <em>Middleware Repository File</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMiddlewareRepositoryFile()
     * @generated
     * @ordered
     */
    protected static final String MIDDLEWARE_REPOSITORY_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMiddlewareRepositoryFile()
     * <em>Middleware Repository File</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMiddlewareRepositoryFile()
     * @generated
     * @ordered
     */
    protected String middlewareRepositoryFile = MIDDLEWARE_REPOSITORY_FILE_EDEFAULT;

    /**
     * The default value of the '{@link #getEventMiddlewareRepositoryFile()
     * <em>Event Middleware Repository File</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEventMiddlewareRepositoryFile()
     * @generated
     * @ordered
     */
    protected static final String EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEventMiddlewareRepositoryFile()
     * <em>Event Middleware Repository File</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEventMiddlewareRepositoryFile()
     * @generated
     * @ordered
     */
    protected String eventMiddlewareRepositoryFile = EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMModelFilesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.PCM_MODEL_FILES;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getAllocationFile() {
        return this.allocationFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAllocationFile(final String newAllocationFile) {
        final String oldAllocationFile = this.allocationFile;
        this.allocationFile = newAllocationFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE, oldAllocationFile, this.allocationFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getUsagemodelFile() {
        return this.usagemodelFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsagemodelFile(final String newUsagemodelFile) {
        final String oldUsagemodelFile = this.usagemodelFile;
        this.usagemodelFile = newUsagemodelFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE, oldUsagemodelFile, this.usagemodelFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSystemFile() {
        return this.systemFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSystemFile(final String newSystemFile) {
        final String oldSystemFile = this.systemFile;
        this.systemFile = newSystemFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE,
                    oldSystemFile, this.systemFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getRepositoryFile() {
        return this.repositoryFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRepositoryFile(final String newRepositoryFile) {
        final String oldRepositoryFile = this.repositoryFile;
        this.repositoryFile = newRepositoryFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE, oldRepositoryFile, this.repositoryFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getResourceenvironmentFile() {
        return this.resourceenvironmentFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceenvironmentFile(final String newResourceenvironmentFile) {
        final String oldResourceenvironmentFile = this.resourceenvironmentFile;
        this.resourceenvironmentFile = newResourceenvironmentFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE, oldResourceenvironmentFile,
                    this.resourceenvironmentFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMiddlewareRepositoryFile() {
        return this.middlewareRepositoryFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMiddlewareRepositoryFile(final String newMiddlewareRepositoryFile) {
        final String oldMiddlewareRepositoryFile = this.middlewareRepositoryFile;
        this.middlewareRepositoryFile = newMiddlewareRepositoryFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE, oldMiddlewareRepositoryFile,
                    this.middlewareRepositoryFile));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getEventMiddlewareRepositoryFile() {
        return this.eventMiddlewareRepositoryFile;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventMiddlewareRepositoryFile(final String newEventMiddlewareRepositoryFile) {
        final String oldEventMiddlewareRepositoryFile = this.eventMiddlewareRepositoryFile;
        this.eventMiddlewareRepositoryFile = newEventMiddlewareRepositoryFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE,
                    oldEventMiddlewareRepositoryFile, this.eventMiddlewareRepositoryFile));
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
        case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
            return this.getAllocationFile();
        case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
            return this.getUsagemodelFile();
        case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
            return this.getSystemFile();
        case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
            return this.getRepositoryFile();
        case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
            return this.getResourceenvironmentFile();
        case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
            return this.getMiddlewareRepositoryFile();
        case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
            return this.getEventMiddlewareRepositoryFile();
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
        case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
            this.setAllocationFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
            this.setUsagemodelFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
            this.setSystemFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
            this.setRepositoryFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
            this.setResourceenvironmentFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
            this.setMiddlewareRepositoryFile((String) newValue);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
            this.setEventMiddlewareRepositoryFile((String) newValue);
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
        case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
            this.setAllocationFile(ALLOCATION_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
            this.setUsagemodelFile(USAGEMODEL_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
            this.setSystemFile(SYSTEM_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
            this.setRepositoryFile(REPOSITORY_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
            this.setResourceenvironmentFile(RESOURCEENVIRONMENT_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
            this.setMiddlewareRepositoryFile(MIDDLEWARE_REPOSITORY_FILE_EDEFAULT);
            return;
        case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
            this.setEventMiddlewareRepositoryFile(EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT);
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
        case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
            return ALLOCATION_FILE_EDEFAULT == null ? this.allocationFile != null : !ALLOCATION_FILE_EDEFAULT
                    .equals(this.allocationFile);
        case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
            return USAGEMODEL_FILE_EDEFAULT == null ? this.usagemodelFile != null : !USAGEMODEL_FILE_EDEFAULT
                    .equals(this.usagemodelFile);
        case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
            return SYSTEM_FILE_EDEFAULT == null ? this.systemFile != null : !SYSTEM_FILE_EDEFAULT
                    .equals(this.systemFile);
        case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
            return REPOSITORY_FILE_EDEFAULT == null ? this.repositoryFile != null : !REPOSITORY_FILE_EDEFAULT
                    .equals(this.repositoryFile);
        case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
            return RESOURCEENVIRONMENT_FILE_EDEFAULT == null ? this.resourceenvironmentFile != null
                    : !RESOURCEENVIRONMENT_FILE_EDEFAULT.equals(this.resourceenvironmentFile);
        case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
            return MIDDLEWARE_REPOSITORY_FILE_EDEFAULT == null ? this.middlewareRepositoryFile != null
                    : !MIDDLEWARE_REPOSITORY_FILE_EDEFAULT.equals(this.middlewareRepositoryFile);
        case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
            return EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT == null ? this.eventMiddlewareRepositoryFile != null
                    : !EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT.equals(this.eventMiddlewareRepositoryFile);
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
        result.append(" (allocationFile: ");
        result.append(this.allocationFile);
        result.append(", usagemodelFile: ");
        result.append(this.usagemodelFile);
        result.append(", systemFile: ");
        result.append(this.systemFile);
        result.append(", repositoryFile: ");
        result.append(this.repositoryFile);
        result.append(", resourceenvironmentFile: ");
        result.append(this.resourceenvironmentFile);
        result.append(", middlewareRepositoryFile: ");
        result.append(this.middlewareRepositoryFile);
        result.append(", eventMiddlewareRepositoryFile: ");
        result.append(this.eventMiddlewareRepositoryFile);
        result.append(')');
        return result.toString();
    }

} // PCMModelFilesImpl
