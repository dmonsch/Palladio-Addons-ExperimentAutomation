/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.ProbeSpecConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Simulation Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getPersistenceFramework
 * <em>Persistence Framework</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getStopConditions
 * <em>Stop Conditions</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getRandomNumberGeneratorSeed
 * <em>Random Number Generator Seed</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#isSimulateLinkingResources
 * <em>Simulate Linking Resources</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#isSimulateFailures
 * <em>Simulate Failures</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getProbeSpecConfiguration
 * <em>Probe Spec Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractSimulationConfigurationImpl extends ToolConfigurationImpl implements
        AbstractSimulationConfiguration {
    /**
     * The cached value of the '{@link #getPersistenceFramework() <em>Persistence Framework</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPersistenceFramework()
     * @generated
     * @ordered
     */
    protected PersistenceFramework persistenceFramework;

    /**
     * The cached value of the '{@link #getStopConditions() <em>Stop Conditions</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStopConditions()
     * @generated
     * @ordered
     */
    protected EList<StopCondition> stopConditions;

    /**
     * The cached value of the '{@link #getRandomNumberGeneratorSeed()
     * <em>Random Number Generator Seed</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRandomNumberGeneratorSeed()
     * @generated
     * @ordered
     */
    protected RandomNumberGeneratorSeed randomNumberGeneratorSeed;

    /**
     * The default value of the '{@link #isSimulateLinkingResources()
     * <em>Simulate Linking Resources</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSimulateLinkingResources()
     * @generated
     * @ordered
     */
    protected static final boolean SIMULATE_LINKING_RESOURCES_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSimulateLinkingResources()
     * <em>Simulate Linking Resources</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSimulateLinkingResources()
     * @generated
     * @ordered
     */
    protected boolean simulateLinkingResources = SIMULATE_LINKING_RESOURCES_EDEFAULT;

    /**
     * The default value of the '{@link #isSimulateFailures() <em>Simulate Failures</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSimulateFailures()
     * @generated
     * @ordered
     */
    protected static final boolean SIMULATE_FAILURES_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSimulateFailures() <em>Simulate Failures</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSimulateFailures()
     * @generated
     * @ordered
     */
    protected boolean simulateFailures = SIMULATE_FAILURES_EDEFAULT;

    /**
     * The cached value of the '{@link #getProbeSpecConfiguration()
     * <em>Probe Spec Configuration</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProbeSpecConfiguration()
     * @generated
     * @ordered
     */
    protected ProbeSpecConfiguration probeSpecConfiguration;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractSimulationConfigurationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractsimulationPackage.Literals.ABSTRACT_SIMULATION_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PersistenceFramework getPersistenceFramework() {
        return this.persistenceFramework;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPersistenceFramework(final PersistenceFramework newPersistenceFramework,
            NotificationChain msgs) {
        final PersistenceFramework oldPersistenceFramework = this.persistenceFramework;
        this.persistenceFramework = newPersistenceFramework;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK,
                    oldPersistenceFramework, newPersistenceFramework);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPersistenceFramework(final PersistenceFramework newPersistenceFramework) {
        if (newPersistenceFramework != this.persistenceFramework) {
            NotificationChain msgs = null;
            if (this.persistenceFramework != null) {
                msgs = ((InternalEObject) this.persistenceFramework).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, null,
                        msgs);
            }
            if (newPersistenceFramework != null) {
                msgs = ((InternalEObject) newPersistenceFramework).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, null,
                        msgs);
            }
            msgs = this.basicSetPersistenceFramework(newPersistenceFramework, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK,
                    newPersistenceFramework, newPersistenceFramework));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<StopCondition> getStopConditions() {
        if (this.stopConditions == null) {
            this.stopConditions = new EObjectContainmentEList<StopCondition>(StopCondition.class, this,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS);
        }
        return this.stopConditions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RandomNumberGeneratorSeed getRandomNumberGeneratorSeed() {
        return this.randomNumberGeneratorSeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRandomNumberGeneratorSeed(
            final RandomNumberGeneratorSeed newRandomNumberGeneratorSeed, NotificationChain msgs) {
        final RandomNumberGeneratorSeed oldRandomNumberGeneratorSeed = this.randomNumberGeneratorSeed;
        this.randomNumberGeneratorSeed = newRandomNumberGeneratorSeed;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED,
                    oldRandomNumberGeneratorSeed, newRandomNumberGeneratorSeed);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRandomNumberGeneratorSeed(final RandomNumberGeneratorSeed newRandomNumberGeneratorSeed) {
        if (newRandomNumberGeneratorSeed != this.randomNumberGeneratorSeed) {
            NotificationChain msgs = null;
            if (this.randomNumberGeneratorSeed != null) {
                msgs = ((InternalEObject) this.randomNumberGeneratorSeed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED,
                        null, msgs);
            }
            if (newRandomNumberGeneratorSeed != null) {
                msgs = ((InternalEObject) newRandomNumberGeneratorSeed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED,
                        null, msgs);
            }
            msgs = this.basicSetRandomNumberGeneratorSeed(newRandomNumberGeneratorSeed, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED,
                    newRandomNumberGeneratorSeed, newRandomNumberGeneratorSeed));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSimulateLinkingResources() {
        return this.simulateLinkingResources;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSimulateLinkingResources(final boolean newSimulateLinkingResources) {
        final boolean oldSimulateLinkingResources = this.simulateLinkingResources;
        this.simulateLinkingResources = newSimulateLinkingResources;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES,
                    oldSimulateLinkingResources, this.simulateLinkingResources));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSimulateFailures() {
        return this.simulateFailures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSimulateFailures(final boolean newSimulateFailures) {
        final boolean oldSimulateFailures = this.simulateFailures;
        this.simulateFailures = newSimulateFailures;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES,
                    oldSimulateFailures, this.simulateFailures));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProbeSpecConfiguration getProbeSpecConfiguration() {
        return this.probeSpecConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProbeSpecConfiguration(final ProbeSpecConfiguration newProbeSpecConfiguration,
            NotificationChain msgs) {
        final ProbeSpecConfiguration oldProbeSpecConfiguration = this.probeSpecConfiguration;
        this.probeSpecConfiguration = newProbeSpecConfiguration;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION,
                    oldProbeSpecConfiguration, newProbeSpecConfiguration);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setProbeSpecConfiguration(final ProbeSpecConfiguration newProbeSpecConfiguration) {
        if (newProbeSpecConfiguration != this.probeSpecConfiguration) {
            NotificationChain msgs = null;
            if (this.probeSpecConfiguration != null) {
                msgs = ((InternalEObject) this.probeSpecConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, null,
                        msgs);
            }
            if (newProbeSpecConfiguration != null) {
                msgs = ((InternalEObject) newProbeSpecConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, null,
                        msgs);
            }
            msgs = this.basicSetProbeSpecConfiguration(newProbeSpecConfiguration, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION,
                    newProbeSpecConfiguration, newProbeSpecConfiguration));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
            return this.basicSetPersistenceFramework(null, msgs);
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
            return ((InternalEList<?>) this.getStopConditions()).basicRemove(otherEnd, msgs);
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
            return this.basicSetRandomNumberGeneratorSeed(null, msgs);
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
            return this.basicSetProbeSpecConfiguration(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
            return this.getPersistenceFramework();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
            return this.getStopConditions();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
            return this.getRandomNumberGeneratorSeed();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
            return this.isSimulateLinkingResources();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
            return this.isSimulateFailures();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
            return this.getProbeSpecConfiguration();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
            this.setPersistenceFramework((PersistenceFramework) newValue);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
            this.getStopConditions().clear();
            this.getStopConditions().addAll((Collection<? extends StopCondition>) newValue);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
            this.setRandomNumberGeneratorSeed((RandomNumberGeneratorSeed) newValue);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
            this.setSimulateLinkingResources((Boolean) newValue);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
            this.setSimulateFailures((Boolean) newValue);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
            this.setProbeSpecConfiguration((ProbeSpecConfiguration) newValue);
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
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
            this.setPersistenceFramework((PersistenceFramework) null);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
            this.getStopConditions().clear();
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
            this.setRandomNumberGeneratorSeed((RandomNumberGeneratorSeed) null);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
            this.setSimulateLinkingResources(SIMULATE_LINKING_RESOURCES_EDEFAULT);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
            this.setSimulateFailures(SIMULATE_FAILURES_EDEFAULT);
            return;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
            this.setProbeSpecConfiguration((ProbeSpecConfiguration) null);
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
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
            return this.persistenceFramework != null;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
            return this.stopConditions != null && !this.stopConditions.isEmpty();
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
            return this.randomNumberGeneratorSeed != null;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
            return this.simulateLinkingResources != SIMULATE_LINKING_RESOURCES_EDEFAULT;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
            return this.simulateFailures != SIMULATE_FAILURES_EDEFAULT;
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
            return this.probeSpecConfiguration != null;
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
        result.append(" (simulateLinkingResources: ");
        result.append(this.simulateLinkingResources);
        result.append(", simulateFailures: ");
        result.append(this.simulateFailures);
        result.append(')');
        return result.toString();
    }

} // AbstractSimulationConfigurationImpl
