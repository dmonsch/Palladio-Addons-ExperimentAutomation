/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComPackageImpl;

import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;

import de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventSimPackageImpl extends EPackageImpl implements EventSimPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventSimConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventSimPackageImpl() {
		super(eNS_URI, EventSimFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EventSimPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventSimPackage init() {
		if (isInited) return (EventSimPackage)EPackage.Registry.INSTANCE.getEPackage(EventSimPackage.eNS_URI);

		// Obtain or create and register package
		EventSimPackageImpl theEventSimPackage = (EventSimPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventSimPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventSimPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		VariationPackageImpl theVariationPackage = (VariationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VariationPackage.eNS_URI) instanceof VariationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VariationPackage.eNS_URI) : VariationPackage.eINSTANCE);
		ExperimentsPackageImpl theExperimentsPackage = (ExperimentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI) instanceof ExperimentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI) : ExperimentsPackage.eINSTANCE);
		AbstractSimulationPackageImpl theAbstractSimulationPackage = (AbstractSimulationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbstractSimulationPackage.eNS_URI) instanceof AbstractSimulationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbstractSimulationPackage.eNS_URI) : AbstractSimulationPackage.eINSTANCE);
		SimuComPackageImpl theSimuComPackage = (SimuComPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimuComPackage.eNS_URI) instanceof SimuComPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimuComPackage.eNS_URI) : SimuComPackage.eINSTANCE);

		// Create package meta-data objects
		theEventSimPackage.createPackageContents();
		theVariationPackage.createPackageContents();
		theExperimentsPackage.createPackageContents();
		theAbstractSimulationPackage.createPackageContents();
		theSimuComPackage.createPackageContents();

		// Initialize created meta-data
		theEventSimPackage.initializePackageContents();
		theVariationPackage.initializePackageContents();
		theExperimentsPackage.initializePackageContents();
		theAbstractSimulationPackage.initializePackageContents();
		theSimuComPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventSimPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventSimPackage.eNS_URI, theEventSimPackage);
		return theEventSimPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventSimConfiguration() {
		return eventSimConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSimFactory getEventSimFactory() {
		return (EventSimFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eventSimConfigurationEClass = createEClass(EVENT_SIM_CONFIGURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AbstractSimulationPackage theAbstractSimulationPackage = (AbstractSimulationPackage)EPackage.Registry.INSTANCE.getEPackage(AbstractSimulationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eventSimConfigurationEClass.getESuperTypes().add(theAbstractSimulationPackage.getAbstractSimulationConfiguration());

		// Initialize classes and features; add operations and parameters
		initEClass(eventSimConfigurationEClass, EventSimConfiguration.class, "EventSimConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //EventSimPackageImpl
