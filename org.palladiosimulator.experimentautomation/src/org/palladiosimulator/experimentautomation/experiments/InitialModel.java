/**
 */
package org.palladiosimulator.experimentautomation.experiments;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;
import org.palladiosimulator.simulizar.pms.PMSModel;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Initial Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getUsageModel <em>
 * Usage Model</em>}</li>
 * <li>{@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getAllocation <em>
 * Allocation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getMiddlewareRepository
 * <em>Middleware Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getEventMiddleWareRepository
 * <em>Event Middle Ware Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getReconfigurationRules
 * <em>Reconfiguration Rules</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getPlatformMonitoringSpecification
 * <em>Platform Monitoring Specification</em>}</li>
 * <li>
 * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getServiceLevelObjectives
 * <em>Service Level Objectives</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel()
 * @model
 * @generated
 */
public interface InitialModel extends EObject {
    /**
     * Returns the value of the '<em><b>Usage Model</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usage Model</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Usage Model</em>' reference.
     * @see #setUsageModel(UsageModel)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_UsageModel()
     * @model required="true"
     * @generated
     */
    UsageModel getUsageModel();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getUsageModel
     * <em>Usage Model</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Usage Model</em>' reference.
     * @see #getUsageModel()
     * @generated
     */
    void setUsageModel(UsageModel value);

    /**
     * Returns the value of the '<em><b>Allocation</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allocation</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Allocation</em>' reference.
     * @see #setAllocation(Allocation)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_Allocation()
     * @model required="true"
     * @generated
     */
    Allocation getAllocation();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getAllocation
     * <em>Allocation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Allocation</em>' reference.
     * @see #getAllocation()
     * @generated
     */
    void setAllocation(Allocation value);

    /**
     * Returns the value of the '<em><b>Middleware Repository</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Middleware Repository</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Middleware Repository</em>' reference.
     * @see #setMiddlewareRepository(Repository)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_MiddlewareRepository()
     * @model required="true"
     * @generated
     */
    Repository getMiddlewareRepository();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getMiddlewareRepository
     * <em>Middleware Repository</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Middleware Repository</em>' reference.
     * @see #getMiddlewareRepository()
     * @generated
     */
    void setMiddlewareRepository(Repository value);

    /**
     * Returns the value of the '<em><b>Event Middle Ware Repository</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Middle Ware Repository</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Event Middle Ware Repository</em>' reference.
     * @see #setEventMiddleWareRepository(Repository)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_EventMiddleWareRepository()
     * @model required="true"
     * @generated
     */
    Repository getEventMiddleWareRepository();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getEventMiddleWareRepository
     * <em>Event Middle Ware Repository</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Event Middle Ware Repository</em>' reference.
     * @see #getEventMiddleWareRepository()
     * @generated
     */
    void setEventMiddleWareRepository(Repository value);

    /**
     * Returns the value of the '<em><b>Reconfiguration Rules</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reconfiguration Rules</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Reconfiguration Rules</em>' reference.
     * @see #setReconfigurationRules(ReconfigurationRulesFolder)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_ReconfigurationRules()
     * @model
     * @generated
     */
    ReconfigurationRulesFolder getReconfigurationRules();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getReconfigurationRules
     * <em>Reconfiguration Rules</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Reconfiguration Rules</em>' reference.
     * @see #getReconfigurationRules()
     * @generated
     */
    void setReconfigurationRules(ReconfigurationRulesFolder value);

    /**
     * Returns the value of the '<em><b>Platform Monitoring Specification</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Platform Monitoring Specification</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Platform Monitoring Specification</em>' reference.
     * @see #setPlatformMonitoringSpecification(PMSModel)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_PlatformMonitoringSpecification()
     * @model
     * @generated
     */
    PMSModel getPlatformMonitoringSpecification();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getPlatformMonitoringSpecification
     * <em>Platform Monitoring Specification</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Platform Monitoring Specification</em>' reference.
     * @see #getPlatformMonitoringSpecification()
     * @generated
     */
    void setPlatformMonitoringSpecification(PMSModel value);

    /**
     * Returns the value of the '<em><b>Service Level Objectives</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Level Objectives</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Service Level Objectives</em>' reference.
     * @see #setServiceLevelObjectives(ServiceLevelObjectiveRepository)
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#getInitialModel_ServiceLevelObjectives()
     * @model
     * @generated
     */
    ServiceLevelObjectiveRepository getServiceLevelObjectives();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.experimentautomation.experiments.InitialModel#getServiceLevelObjectives
     * <em>Service Level Objectives</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Service Level Objectives</em>' reference.
     * @see #getServiceLevelObjectives()
     * @generated
     */
    void setServiceLevelObjectives(ServiceLevelObjectiveRepository value);

} // InitialModel
