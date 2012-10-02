/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimFactory
 * @model kind="package"
 * @generated
 */
public interface EventSimPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eventsim";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/EventSim/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ExperimentAutomation.Experiments.EventSim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventSimPackage eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimConfigurationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimPackageImpl#getEventSimConfiguration()
	 * @generated
	 */
	int EVENT_SIM_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__NAME = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Persistence Framework</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__PERSISTENCE_FRAMEWORK = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK;

	/**
	 * The feature id for the '<em><b>Stop Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__STOP_CONDITIONS = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Random Number Generator Seed</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED;

	/**
	 * The feature id for the '<em><b>Simulate Linking Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__SIMULATE_LINKING_RESOURCES = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES;

	/**
	 * The feature id for the '<em><b>Simulate Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__SIMULATE_FAILURES = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES;

	/**
	 * The feature id for the '<em><b>Probe Spec Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION__PROBE_SPEC_CONFIGURATION = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SIM_CONFIGURATION_FEATURE_COUNT = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration
	 * @generated
	 */
	EClass getEventSimConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventSimFactory getEventSimFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimConfigurationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventSimPackageImpl#getEventSimConfiguration()
		 * @generated
		 */
		EClass EVENT_SIM_CONFIGURATION = eINSTANCE.getEventSimConfiguration();

	}

} //EventSimPackage
