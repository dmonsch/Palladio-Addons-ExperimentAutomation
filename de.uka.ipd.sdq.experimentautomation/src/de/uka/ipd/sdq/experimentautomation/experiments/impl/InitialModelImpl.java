/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.simulizar.pms.PMSModel;

import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Initial Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getUsageModel
 * <em>Usage Model</em>}</li>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getAllocation
 * <em>Allocation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getMiddlewareRepository
 * <em>Middleware Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getEventMiddleWareRepository
 * <em>Event Middle Ware Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getReconfigurationRules
 * <em>Reconfiguration Rules</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getPlatformMonitoringSpecification
 * <em>Platform Monitoring Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitialModelImpl extends EObjectImpl implements InitialModel {
    /**
     * The cached value of the '{@link #getUsageModel() <em>Usage Model</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUsageModel()
     * @generated
     * @ordered
     */
    protected UsageModel usageModel;

    /**
     * The cached value of the '{@link #getAllocation() <em>Allocation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAllocation()
     * @generated
     * @ordered
     */
    protected Allocation allocation;

    /**
     * The cached value of the '{@link #getMiddlewareRepository() <em>Middleware Repository</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMiddlewareRepository()
     * @generated
     * @ordered
     */
    protected Repository middlewareRepository;

    /**
     * The cached value of the '{@link #getEventMiddleWareRepository()
     * <em>Event Middle Ware Repository</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getEventMiddleWareRepository()
     * @generated
     * @ordered
     */
    protected Repository eventMiddleWareRepository;

    /**
     * The cached value of the '{@link #getReconfigurationRules() <em>Reconfiguration Rules</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReconfigurationRules()
     * @generated
     * @ordered
     */
    protected ReconfigurationRulesFolder reconfigurationRules;

    /**
     * The cached value of the '{@link #getPlatformMonitoringSpecification()
     * <em>Platform Monitoring Specification</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPlatformMonitoringSpecification()
     * @generated
     * @ordered
     */
    protected PMSModel platformMonitoringSpecification;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InitialModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExperimentsPackage.Literals.INITIAL_MODEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UsageModel getUsageModel() {
        if (usageModel != null && ((EObject) usageModel).eIsProxy()) {
            InternalEObject oldUsageModel = (InternalEObject) usageModel;
            usageModel = (UsageModel) eResolveProxy(oldUsageModel);
            if (usageModel != oldUsageModel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL, oldUsageModel, usageModel));
            }
        }
        return usageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UsageModel basicGetUsageModel() {
        return usageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUsageModel(UsageModel newUsageModel) {
        UsageModel oldUsageModel = usageModel;
        usageModel = newUsageModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL,
                    oldUsageModel, usageModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Allocation getAllocation() {
        if (allocation != null && ((EObject) allocation).eIsProxy()) {
            InternalEObject oldAllocation = (InternalEObject) allocation;
            allocation = (Allocation) eResolveProxy(oldAllocation);
            if (allocation != oldAllocation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__ALLOCATION, oldAllocation, allocation));
            }
        }
        return allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Allocation basicGetAllocation() {
        return allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAllocation(Allocation newAllocation) {
        Allocation oldAllocation = allocation;
        allocation = newAllocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.INITIAL_MODEL__ALLOCATION,
                    oldAllocation, allocation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository getMiddlewareRepository() {
        if (middlewareRepository != null && ((EObject) middlewareRepository).eIsProxy()) {
            InternalEObject oldMiddlewareRepository = (InternalEObject) middlewareRepository;
            middlewareRepository = (Repository) eResolveProxy(oldMiddlewareRepository);
            if (middlewareRepository != oldMiddlewareRepository) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY, oldMiddlewareRepository,
                            middlewareRepository));
            }
        }
        return middlewareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetMiddlewareRepository() {
        return middlewareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMiddlewareRepository(Repository newMiddlewareRepository) {
        Repository oldMiddlewareRepository = middlewareRepository;
        middlewareRepository = newMiddlewareRepository;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY, oldMiddlewareRepository,
                    middlewareRepository));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository getEventMiddleWareRepository() {
        if (eventMiddleWareRepository != null && ((EObject) eventMiddleWareRepository).eIsProxy()) {
            InternalEObject oldEventMiddleWareRepository = (InternalEObject) eventMiddleWareRepository;
            eventMiddleWareRepository = (Repository) eResolveProxy(oldEventMiddleWareRepository);
            if (eventMiddleWareRepository != oldEventMiddleWareRepository) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY,
                            oldEventMiddleWareRepository, eventMiddleWareRepository));
            }
        }
        return eventMiddleWareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetEventMiddleWareRepository() {
        return eventMiddleWareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setEventMiddleWareRepository(Repository newEventMiddleWareRepository) {
        Repository oldEventMiddleWareRepository = eventMiddleWareRepository;
        eventMiddleWareRepository = newEventMiddleWareRepository;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY, oldEventMiddleWareRepository,
                    eventMiddleWareRepository));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ReconfigurationRulesFolder getReconfigurationRules() {
        if (reconfigurationRules != null && reconfigurationRules.eIsProxy()) {
            InternalEObject oldReconfigurationRules = (InternalEObject) reconfigurationRules;
            reconfigurationRules = (ReconfigurationRulesFolder) eResolveProxy(oldReconfigurationRules);
            if (reconfigurationRules != oldReconfigurationRules) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES, oldReconfigurationRules,
                            reconfigurationRules));
            }
        }
        return reconfigurationRules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ReconfigurationRulesFolder basicGetReconfigurationRules() {
        return reconfigurationRules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReconfigurationRules(ReconfigurationRulesFolder newReconfigurationRules) {
        ReconfigurationRulesFolder oldReconfigurationRules = reconfigurationRules;
        reconfigurationRules = newReconfigurationRules;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES, oldReconfigurationRules,
                    reconfigurationRules));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PMSModel getPlatformMonitoringSpecification() {
        if (platformMonitoringSpecification != null && platformMonitoringSpecification.eIsProxy()) {
            InternalEObject oldPlatformMonitoringSpecification = (InternalEObject) platformMonitoringSpecification;
            platformMonitoringSpecification = (PMSModel) eResolveProxy(oldPlatformMonitoringSpecification);
            if (platformMonitoringSpecification != oldPlatformMonitoringSpecification) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION,
                            oldPlatformMonitoringSpecification, platformMonitoringSpecification));
            }
        }
        return platformMonitoringSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PMSModel basicGetPlatformMonitoringSpecification() {
        return platformMonitoringSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPlatformMonitoringSpecification(PMSModel newPlatformMonitoringSpecification) {
        PMSModel oldPlatformMonitoringSpecification = platformMonitoringSpecification;
        platformMonitoringSpecification = newPlatformMonitoringSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION,
                    oldPlatformMonitoringSpecification, platformMonitoringSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            if (resolve)
                return getUsageModel();
            return basicGetUsageModel();
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            if (resolve)
                return getAllocation();
            return basicGetAllocation();
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            if (resolve)
                return getMiddlewareRepository();
            return basicGetMiddlewareRepository();
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            if (resolve)
                return getEventMiddleWareRepository();
            return basicGetEventMiddleWareRepository();
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            if (resolve)
                return getReconfigurationRules();
            return basicGetReconfigurationRules();
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            if (resolve)
                return getPlatformMonitoringSpecification();
            return basicGetPlatformMonitoringSpecification();
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            setUsageModel((UsageModel) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            setAllocation((Allocation) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            setMiddlewareRepository((Repository) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            setEventMiddleWareRepository((Repository) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            setReconfigurationRules((ReconfigurationRulesFolder) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            setPlatformMonitoringSpecification((PMSModel) newValue);
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            setUsageModel((UsageModel) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            setAllocation((Allocation) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            setMiddlewareRepository((Repository) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            setEventMiddleWareRepository((Repository) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            setReconfigurationRules((ReconfigurationRulesFolder) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            setPlatformMonitoringSpecification((PMSModel) null);
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            return usageModel != null;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            return allocation != null;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            return middlewareRepository != null;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            return eventMiddleWareRepository != null;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            return reconfigurationRules != null;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            return platformMonitoringSpecification != null;
        }
        return super.eIsSet(featureID);
    }

} // InitialModelImpl
