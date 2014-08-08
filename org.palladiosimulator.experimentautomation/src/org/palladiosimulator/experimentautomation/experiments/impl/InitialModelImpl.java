/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;
import org.palladiosimulator.simulizar.pms.PMSModel;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Initial Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getUsageModel
 * <em>Usage Model</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getAllocation
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
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.impl.InitialModelImpl#getServiceLevelObjectives
 * <em>Service Level Objectives</em>}</li>
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
     * The cached value of the '{@link #getServiceLevelObjectives()
     * <em>Service Level Objectives</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getServiceLevelObjectives()
     * @generated
     * @ordered
     */
    protected ServiceLevelObjectiveRepository serviceLevelObjectives;

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
    @Override
    public UsageModel getUsageModel() {
        if (this.usageModel != null && ((EObject) this.usageModel).eIsProxy()) {
            final InternalEObject oldUsageModel = (InternalEObject) this.usageModel;
            this.usageModel = (UsageModel) this.eResolveProxy(oldUsageModel);
            if (this.usageModel != oldUsageModel) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL, oldUsageModel, this.usageModel));
                }
            }
        }
        return this.usageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UsageModel basicGetUsageModel() {
        return this.usageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsageModel(final UsageModel newUsageModel) {
        final UsageModel oldUsageModel = this.usageModel;
        this.usageModel = newUsageModel;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL,
                    oldUsageModel, this.usageModel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Allocation getAllocation() {
        if (this.allocation != null && ((EObject) this.allocation).eIsProxy()) {
            final InternalEObject oldAllocation = (InternalEObject) this.allocation;
            this.allocation = (Allocation) this.eResolveProxy(oldAllocation);
            if (this.allocation != oldAllocation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__ALLOCATION, oldAllocation, this.allocation));
                }
            }
        }
        return this.allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Allocation basicGetAllocation() {
        return this.allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAllocation(final Allocation newAllocation) {
        final Allocation oldAllocation = this.allocation;
        this.allocation = newAllocation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.INITIAL_MODEL__ALLOCATION,
                    oldAllocation, this.allocation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository getMiddlewareRepository() {
        if (this.middlewareRepository != null && ((EObject) this.middlewareRepository).eIsProxy()) {
            final InternalEObject oldMiddlewareRepository = (InternalEObject) this.middlewareRepository;
            this.middlewareRepository = (Repository) this.eResolveProxy(oldMiddlewareRepository);
            if (this.middlewareRepository != oldMiddlewareRepository) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY, oldMiddlewareRepository,
                            this.middlewareRepository));
                }
            }
        }
        return this.middlewareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetMiddlewareRepository() {
        return this.middlewareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMiddlewareRepository(final Repository newMiddlewareRepository) {
        final Repository oldMiddlewareRepository = this.middlewareRepository;
        this.middlewareRepository = newMiddlewareRepository;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY, oldMiddlewareRepository,
                    this.middlewareRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository getEventMiddleWareRepository() {
        if (this.eventMiddleWareRepository != null && ((EObject) this.eventMiddleWareRepository).eIsProxy()) {
            final InternalEObject oldEventMiddleWareRepository = (InternalEObject) this.eventMiddleWareRepository;
            this.eventMiddleWareRepository = (Repository) this.eResolveProxy(oldEventMiddleWareRepository);
            if (this.eventMiddleWareRepository != oldEventMiddleWareRepository) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY,
                            oldEventMiddleWareRepository, this.eventMiddleWareRepository));
                }
            }
        }
        return this.eventMiddleWareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository basicGetEventMiddleWareRepository() {
        return this.eventMiddleWareRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventMiddleWareRepository(final Repository newEventMiddleWareRepository) {
        final Repository oldEventMiddleWareRepository = this.eventMiddleWareRepository;
        this.eventMiddleWareRepository = newEventMiddleWareRepository;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY, oldEventMiddleWareRepository,
                    this.eventMiddleWareRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ReconfigurationRulesFolder getReconfigurationRules() {
        if (this.reconfigurationRules != null && this.reconfigurationRules.eIsProxy()) {
            final InternalEObject oldReconfigurationRules = (InternalEObject) this.reconfigurationRules;
            this.reconfigurationRules = (ReconfigurationRulesFolder) this.eResolveProxy(oldReconfigurationRules);
            if (this.reconfigurationRules != oldReconfigurationRules) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES, oldReconfigurationRules,
                            this.reconfigurationRules));
                }
            }
        }
        return this.reconfigurationRules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ReconfigurationRulesFolder basicGetReconfigurationRules() {
        return this.reconfigurationRules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setReconfigurationRules(final ReconfigurationRulesFolder newReconfigurationRules) {
        final ReconfigurationRulesFolder oldReconfigurationRules = this.reconfigurationRules;
        this.reconfigurationRules = newReconfigurationRules;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES, oldReconfigurationRules,
                    this.reconfigurationRules));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PMSModel getPlatformMonitoringSpecification() {
        if (this.platformMonitoringSpecification != null && this.platformMonitoringSpecification.eIsProxy()) {
            final InternalEObject oldPlatformMonitoringSpecification = (InternalEObject) this.platformMonitoringSpecification;
            this.platformMonitoringSpecification = (PMSModel) this.eResolveProxy(oldPlatformMonitoringSpecification);
            if (this.platformMonitoringSpecification != oldPlatformMonitoringSpecification) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION,
                            oldPlatformMonitoringSpecification, this.platformMonitoringSpecification));
                }
            }
        }
        return this.platformMonitoringSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PMSModel basicGetPlatformMonitoringSpecification() {
        return this.platformMonitoringSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPlatformMonitoringSpecification(final PMSModel newPlatformMonitoringSpecification) {
        final PMSModel oldPlatformMonitoringSpecification = this.platformMonitoringSpecification;
        this.platformMonitoringSpecification = newPlatformMonitoringSpecification;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION,
                    oldPlatformMonitoringSpecification, this.platformMonitoringSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ServiceLevelObjectiveRepository getServiceLevelObjectives() {
        if (this.serviceLevelObjectives != null && this.serviceLevelObjectives.eIsProxy()) {
            final InternalEObject oldServiceLevelObjectives = (InternalEObject) this.serviceLevelObjectives;
            this.serviceLevelObjectives = (ServiceLevelObjectiveRepository) this
                    .eResolveProxy(oldServiceLevelObjectives);
            if (this.serviceLevelObjectives != oldServiceLevelObjectives) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES, oldServiceLevelObjectives,
                            this.serviceLevelObjectives));
                }
            }
        }
        return this.serviceLevelObjectives;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ServiceLevelObjectiveRepository basicGetServiceLevelObjectives() {
        return this.serviceLevelObjectives;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setServiceLevelObjectives(final ServiceLevelObjectiveRepository newServiceLevelObjectives) {
        final ServiceLevelObjectiveRepository oldServiceLevelObjectives = this.serviceLevelObjectives;
        this.serviceLevelObjectives = newServiceLevelObjectives;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES, oldServiceLevelObjectives,
                    this.serviceLevelObjectives));
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            if (resolve) {
                return this.getUsageModel();
            }
            return this.basicGetUsageModel();
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            if (resolve) {
                return this.getAllocation();
            }
            return this.basicGetAllocation();
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            if (resolve) {
                return this.getMiddlewareRepository();
            }
            return this.basicGetMiddlewareRepository();
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            if (resolve) {
                return this.getEventMiddleWareRepository();
            }
            return this.basicGetEventMiddleWareRepository();
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            if (resolve) {
                return this.getReconfigurationRules();
            }
            return this.basicGetReconfigurationRules();
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            if (resolve) {
                return this.getPlatformMonitoringSpecification();
            }
            return this.basicGetPlatformMonitoringSpecification();
        case ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES:
            if (resolve) {
                return this.getServiceLevelObjectives();
            }
            return this.basicGetServiceLevelObjectives();
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            this.setUsageModel((UsageModel) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            this.setAllocation((Allocation) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            this.setMiddlewareRepository((Repository) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            this.setEventMiddleWareRepository((Repository) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            this.setReconfigurationRules((ReconfigurationRulesFolder) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            this.setPlatformMonitoringSpecification((PMSModel) newValue);
            return;
        case ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES:
            this.setServiceLevelObjectives((ServiceLevelObjectiveRepository) newValue);
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            this.setUsageModel((UsageModel) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            this.setAllocation((Allocation) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            this.setMiddlewareRepository((Repository) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            this.setEventMiddleWareRepository((Repository) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            this.setReconfigurationRules((ReconfigurationRulesFolder) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            this.setPlatformMonitoringSpecification((PMSModel) null);
            return;
        case ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES:
            this.setServiceLevelObjectives((ServiceLevelObjectiveRepository) null);
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
        case ExperimentsPackage.INITIAL_MODEL__USAGE_MODEL:
            return this.usageModel != null;
        case ExperimentsPackage.INITIAL_MODEL__ALLOCATION:
            return this.allocation != null;
        case ExperimentsPackage.INITIAL_MODEL__MIDDLEWARE_REPOSITORY:
            return this.middlewareRepository != null;
        case ExperimentsPackage.INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY:
            return this.eventMiddleWareRepository != null;
        case ExperimentsPackage.INITIAL_MODEL__RECONFIGURATION_RULES:
            return this.reconfigurationRules != null;
        case ExperimentsPackage.INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION:
            return this.platformMonitoringSpecification != null;
        case ExperimentsPackage.INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES:
            return this.serviceLevelObjectives != null;
        }
        return super.eIsSet(featureID);
    }

} // InitialModelImpl
