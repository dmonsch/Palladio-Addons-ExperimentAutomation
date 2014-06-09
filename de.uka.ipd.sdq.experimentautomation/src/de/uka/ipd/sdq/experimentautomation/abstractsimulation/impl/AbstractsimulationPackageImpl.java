/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationFactory;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.BlackboardType;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.FileDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.MeasurementCountStopCondition;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.MemoryDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.ProbeSpecConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SimTimeStopCondition;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractsimulationPackageImpl extends EPackageImpl implements AbstractsimulationPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractSimulationConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass persistenceFrameworkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass randomNumberGeneratorSeedEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass probeSpecConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sensorFrameworkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sensorFrameworkDatasourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass memoryDatasourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fileDatasourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass measurementCountStopConditionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simTimeStopConditionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stopConditionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass edp2EClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum blackboardTypeEEnum = null;

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
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AbstractsimulationPackageImpl() {
        super(eNS_URI, AbstractsimulationFactory.eINSTANCE);
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
     * This method is used to initialize {@link AbstractsimulationPackage#eINSTANCE} when that field
     * is accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AbstractsimulationPackage init() {
        if (isInited) {
            return (AbstractsimulationPackage) EPackage.Registry.INSTANCE
                    .getEPackage(AbstractsimulationPackage.eNS_URI);
        }

        // Obtain or create and register package
        final AbstractsimulationPackageImpl theAbstractsimulationPackage = (AbstractsimulationPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof AbstractsimulationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new AbstractsimulationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final VariationPackageImpl theVariationPackage = (VariationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) instanceof VariationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) : VariationPackage.eINSTANCE);
        final ExperimentsPackageImpl theExperimentsPackage = (ExperimentsPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ExperimentsPackage.eNS_URI) instanceof ExperimentsPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ExperimentsPackage.eNS_URI) : ExperimentsPackage.eINSTANCE);

        // Create package meta-data objects
        theAbstractsimulationPackage.createPackageContents();
        theVariationPackage.createPackageContents();
        theExperimentsPackage.createPackageContents();

        // Initialize created meta-data
        theAbstractsimulationPackage.initializePackageContents();
        theVariationPackage.initializePackageContents();
        theExperimentsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAbstractsimulationPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AbstractsimulationPackage.eNS_URI, theAbstractsimulationPackage);
        return theAbstractsimulationPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAbstractSimulationConfiguration() {
        return this.abstractSimulationConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractSimulationConfiguration_PersistenceFramework() {
        return (EReference) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractSimulationConfiguration_StopConditions() {
        return (EReference) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractSimulationConfiguration_RandomNumberGeneratorSeed() {
        return (EReference) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractSimulationConfiguration_SimulateLinkingResources() {
        return (EAttribute) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractSimulationConfiguration_SimulateFailures() {
        return (EAttribute) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractSimulationConfiguration_ProbeSpecConfiguration() {
        return (EReference) this.abstractSimulationConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPersistenceFramework() {
        return this.persistenceFrameworkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRandomNumberGeneratorSeed() {
        return this.randomNumberGeneratorSeedEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed0() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed1() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed2() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed3() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed4() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRandomNumberGeneratorSeed_Seed5() {
        return (EAttribute) this.randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProbeSpecConfiguration() {
        return this.probeSpecConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProbeSpecConfiguration_BlackboardType() {
        return (EAttribute) this.probeSpecConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSensorFramework() {
        return this.sensorFrameworkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSensorFramework_Datasource() {
        return (EReference) this.sensorFrameworkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSensorFrameworkDatasource() {
        return this.sensorFrameworkDatasourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMemoryDatasource() {
        return this.memoryDatasourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFileDatasource() {
        return this.fileDatasourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileDatasource_Location() {
        return (EAttribute) this.fileDatasourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMeasurementCountStopCondition() {
        return this.measurementCountStopConditionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMeasurementCountStopCondition_MeasurementCount() {
        return (EAttribute) this.measurementCountStopConditionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimTimeStopCondition() {
        return this.simTimeStopConditionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSimTimeStopCondition_SimulationTime() {
        return (EAttribute) this.simTimeStopConditionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStopCondition() {
        return this.stopConditionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEDP2() {
        return this.edp2EClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEDP2_Repository() {
        return (EReference) this.edp2EClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getBlackboardType() {
        return this.blackboardTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractsimulationFactory getAbstractsimulationFactory() {
        return (AbstractsimulationFactory) this.getEFactoryInstance();
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
        this.abstractSimulationConfigurationEClass = this.createEClass(ABSTRACT_SIMULATION_CONFIGURATION);
        this.createEReference(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK);
        this.createEReference(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS);
        this.createEReference(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED);
        this.createEAttribute(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES);
        this.createEAttribute(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES);
        this.createEReference(this.abstractSimulationConfigurationEClass,
                ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION);

        this.persistenceFrameworkEClass = this.createEClass(PERSISTENCE_FRAMEWORK);

        this.randomNumberGeneratorSeedEClass = this.createEClass(RANDOM_NUMBER_GENERATOR_SEED);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED0);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED1);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED2);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED3);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED4);
        this.createEAttribute(this.randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED5);

        this.probeSpecConfigurationEClass = this.createEClass(PROBE_SPEC_CONFIGURATION);
        this.createEAttribute(this.probeSpecConfigurationEClass, PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE);

        this.sensorFrameworkEClass = this.createEClass(SENSOR_FRAMEWORK);
        this.createEReference(this.sensorFrameworkEClass, SENSOR_FRAMEWORK__DATASOURCE);

        this.sensorFrameworkDatasourceEClass = this.createEClass(SENSOR_FRAMEWORK_DATASOURCE);

        this.memoryDatasourceEClass = this.createEClass(MEMORY_DATASOURCE);

        this.fileDatasourceEClass = this.createEClass(FILE_DATASOURCE);
        this.createEAttribute(this.fileDatasourceEClass, FILE_DATASOURCE__LOCATION);

        this.measurementCountStopConditionEClass = this.createEClass(MEASUREMENT_COUNT_STOP_CONDITION);
        this.createEAttribute(this.measurementCountStopConditionEClass,
                MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT);

        this.simTimeStopConditionEClass = this.createEClass(SIM_TIME_STOP_CONDITION);
        this.createEAttribute(this.simTimeStopConditionEClass, SIM_TIME_STOP_CONDITION__SIMULATION_TIME);

        this.stopConditionEClass = this.createEClass(STOP_CONDITION);

        this.edp2EClass = this.createEClass(EDP2);
        this.createEReference(this.edp2EClass, EDP2__REPOSITORY);

        // Create enums
        this.blackboardTypeEEnum = this.createEEnum(BLACKBOARD_TYPE);
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
        final ExperimentsPackage theExperimentsPackage = (ExperimentsPackage) EPackage.Registry.INSTANCE
                .getEPackage(ExperimentsPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.abstractSimulationConfigurationEClass.getESuperTypes().add(theExperimentsPackage.getToolConfiguration());
        this.sensorFrameworkEClass.getESuperTypes().add(this.getPersistenceFramework());
        this.memoryDatasourceEClass.getESuperTypes().add(this.getSensorFrameworkDatasource());
        this.fileDatasourceEClass.getESuperTypes().add(this.getSensorFrameworkDatasource());
        this.measurementCountStopConditionEClass.getESuperTypes().add(this.getStopCondition());
        this.simTimeStopConditionEClass.getESuperTypes().add(this.getStopCondition());
        this.edp2EClass.getESuperTypes().add(this.getPersistenceFramework());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.abstractSimulationConfigurationEClass, AbstractSimulationConfiguration.class,
                "AbstractSimulationConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAbstractSimulationConfiguration_PersistenceFramework(),
                this.getPersistenceFramework(), null, "persistenceFramework", null, 1, 1,
                AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getAbstractSimulationConfiguration_StopConditions(), this.getStopCondition(), null,
                "stopConditions", null, 1, -1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getAbstractSimulationConfiguration_RandomNumberGeneratorSeed(),
                this.getRandomNumberGeneratorSeed(), null, "randomNumberGeneratorSeed", null, 0, 1,
                AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getAbstractSimulationConfiguration_SimulateLinkingResources(),
                this.ecorePackage.getEBoolean(), "simulateLinkingResources", null, 1, 1,
                AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getAbstractSimulationConfiguration_SimulateFailures(),
                this.ecorePackage.getEBoolean(), "simulateFailures", null, 1, 1, AbstractSimulationConfiguration.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getAbstractSimulationConfiguration_ProbeSpecConfiguration(),
                this.getProbeSpecConfiguration(), null, "probeSpecConfiguration", null, 1, 1,
                AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.persistenceFrameworkEClass, PersistenceFramework.class, "PersistenceFramework",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.randomNumberGeneratorSeedEClass, RandomNumberGeneratorSeed.class,
                "RandomNumberGeneratorSeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed0(), this.ecorePackage.getEInt(), "seed0", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed1(), this.ecorePackage.getEInt(), "seed1", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed2(), this.ecorePackage.getEInt(), "seed2", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed3(), this.ecorePackage.getEInt(), "seed3", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed4(), this.ecorePackage.getEInt(), "seed4", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getRandomNumberGeneratorSeed_Seed5(), this.ecorePackage.getEInt(), "seed5", null, 1,
                1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.probeSpecConfigurationEClass, ProbeSpecConfiguration.class, "ProbeSpecConfiguration",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getProbeSpecConfiguration_BlackboardType(), this.getBlackboardType(),
                "blackboardType", null, 1, 1, ProbeSpecConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.sensorFrameworkEClass, SensorFramework.class, "SensorFramework", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSensorFramework_Datasource(), this.getSensorFrameworkDatasource(), null,
                "datasource", null, 1, 1, SensorFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.sensorFrameworkDatasourceEClass, SensorFrameworkDatasource.class,
                "SensorFrameworkDatasource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.memoryDatasourceEClass, MemoryDatasource.class, "MemoryDatasource", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.fileDatasourceEClass, FileDatasource.class, "FileDatasource", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getFileDatasource_Location(), this.ecorePackage.getEString(), "location", null, 1, 1,
                FileDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.measurementCountStopConditionEClass, MeasurementCountStopCondition.class,
                "MeasurementCountStopCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getMeasurementCountStopCondition_MeasurementCount(), this.ecorePackage.getEInt(),
                "measurementCount", null, 1, 1, MeasurementCountStopCondition.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.simTimeStopConditionEClass, SimTimeStopCondition.class, "SimTimeStopCondition",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getSimTimeStopCondition_SimulationTime(), this.ecorePackage.getEInt(),
                "simulationTime", null, 1, 1, SimTimeStopCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.stopConditionEClass, StopCondition.class, "StopCondition", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.edp2EClass, de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2.class, "EDP2",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getEDP2_Repository(), theRepositoryPackage.getRepository(), null, "repository", null,
                1, 1, de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        this.initEEnum(this.blackboardTypeEEnum, BlackboardType.class, "BlackboardType");
        this.addEEnumLiteral(this.blackboardTypeEEnum, BlackboardType.SIMPLE);
        this.addEEnumLiteral(this.blackboardTypeEEnum, BlackboardType.CONCURRENT);
        this.addEEnumLiteral(this.blackboardTypeEEnum, BlackboardType.NONE);

        // Create resource
        this.createResource(eNS_URI);
    }

} // AbstractsimulationPackageImpl
