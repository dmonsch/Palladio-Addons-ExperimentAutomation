/**
 */
package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimuLizarConfiguration;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimulizartooladapterFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimulizartooladapterPackage;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.variation.VariationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimulizartooladapterPackageImpl extends EPackageImpl implements SimulizartooladapterPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simuLizarConfigurationEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimulizartooladapterPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SimulizartooladapterPackageImpl() {
        super(eNS_URI, SimulizartooladapterFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link SimulizartooladapterPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SimulizartooladapterPackage init() {
        if (isInited) {
            return (SimulizartooladapterPackage) EPackage.Registry.INSTANCE
                    .getEPackage(SimulizartooladapterPackage.eNS_URI);
        }

        // Obtain or create and register package
        final SimulizartooladapterPackageImpl theSimulizartooladapterPackage = (SimulizartooladapterPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof SimulizartooladapterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new SimulizartooladapterPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        VariationPackage.eINSTANCE.eClass();
        ExperimentsPackage.eINSTANCE.eClass();
        AbstractsimulationPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theSimulizartooladapterPackage.createPackageContents();

        // Initialize created meta-data
        theSimulizartooladapterPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSimulizartooladapterPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SimulizartooladapterPackage.eNS_URI, theSimulizartooladapterPackage);
        return theSimulizartooladapterPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimuLizarConfiguration() {
        return this.simuLizarConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SimulizartooladapterFactory getSimulizartooladapterFactory() {
        return (SimulizartooladapterFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.simuLizarConfigurationEClass = this.createEClass(SIMU_LIZAR_CONFIGURATION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final AbstractsimulationPackage theAbstractsimulationPackage = (AbstractsimulationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AbstractsimulationPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.simuLizarConfigurationEClass.getESuperTypes().add(
                theAbstractsimulationPackage.getAbstractSimulationConfiguration());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.simuLizarConfigurationEClass, SimuLizarConfiguration.class, "SimuLizarConfiguration",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        this.createResource(eNS_URI);
    }

} // SimulizartooladapterPackageImpl
