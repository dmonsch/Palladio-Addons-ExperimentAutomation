/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.simulizar.pms.PmsPackage;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl.AbstractsimulationPackageImpl;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.FractionalFactorialDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.FullFactorialDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.InitialModel;
import de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.Modification;
import de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime;
import de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ReconfigurationRulesFolder;
import de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExperimentsPackageImpl extends EPackageImpl implements ExperimentsPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass experimentRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass experimentEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass valueProviderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass toolConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass experimentDesignEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass responseMeasurementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass polynomialValueProviderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass exponentialValueProviderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass setValueProviderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass placketBurmanDesignEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fullFactorialDesignEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fractionalFactorialDesignEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass oneFactorAtATimeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simulationDurationMeasurementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass profilingMeasurementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jmxMeasurementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass linearValueProviderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass initialModelEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass reconfigurationRulesFolderEClass = null;

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
     * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ExperimentsPackageImpl() {
        super(eNS_URI, ExperimentsFactory.eINSTANCE);
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
     * This method is used to initialize {@link ExperimentsPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ExperimentsPackage init() {
        if (isInited)
            return (ExperimentsPackage) EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI);

        // Obtain or create and register package
        ExperimentsPackageImpl theExperimentsPackage = (ExperimentsPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ExperimentsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ExperimentsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PmsPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        VariationPackageImpl theVariationPackage = (VariationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) instanceof VariationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) : VariationPackage.eINSTANCE);
        AbstractsimulationPackageImpl theAbstractsimulationPackage = (AbstractsimulationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(AbstractsimulationPackage.eNS_URI) instanceof AbstractsimulationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(AbstractsimulationPackage.eNS_URI) : AbstractsimulationPackage.eINSTANCE);

        // Create package meta-data objects
        theExperimentsPackage.createPackageContents();
        theVariationPackage.createPackageContents();
        theAbstractsimulationPackage.createPackageContents();

        // Initialize created meta-data
        theExperimentsPackage.initializePackageContents();
        theVariationPackage.initializePackageContents();
        theAbstractsimulationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theExperimentsPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ExperimentsPackage.eNS_URI, theExperimentsPackage);
        return theExperimentsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExperimentRepository() {
        return experimentRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperimentRepository_Experiments() {
        return (EReference) experimentRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperimentRepository_ToolConfiguration() {
        return (EReference) experimentRepositoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperimentRepository_Repetitions() {
        return (EAttribute) experimentRepositoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExperiment() {
        return experimentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_Variations() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_Modifications() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Id() {
        return (EAttribute) experimentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Name() {
        return (EAttribute) experimentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_InitialModel() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ToolConfiguration() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_StopConditions() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Description() {
        return (EAttribute) experimentEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ExperimentDesign() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ResponseMeasurement() {
        return (EReference) experimentEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getVariation() {
        return variationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariation_Type() {
        return (EReference) variationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariation_ValueProvider() {
        return (EReference) variationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MinValue() {
        return (EAttribute) variationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MaxValue() {
        return (EAttribute) variationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MaxVariations() {
        return (EAttribute) variationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_VariedObjectId() {
        return (EAttribute) variationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_Name() {
        return (EAttribute) variationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueProvider() {
        return valueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getToolConfiguration() {
        return toolConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getToolConfiguration_Name() {
        return (EAttribute) toolConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExperimentDesign() {
        return experimentDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResponseMeasurement() {
        return responseMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPolynomialValueProvider() {
        return polynomialValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPolynomialValueProvider_Exponent() {
        return (EAttribute) polynomialValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPolynomialValueProvider_Factor() {
        return (EAttribute) polynomialValueProviderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExponentialValueProvider() {
        return exponentialValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExponentialValueProvider_Base() {
        return (EAttribute) exponentialValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSetValueProvider() {
        return setValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSetValueProvider_Values() {
        return (EAttribute) setValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPlacketBurmanDesign() {
        return placketBurmanDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFullFactorialDesign() {
        return fullFactorialDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFractionalFactorialDesign() {
        return fractionalFactorialDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOneFactorAtATime() {
        return oneFactorAtATimeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimulationDurationMeasurement() {
        return simulationDurationMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProfilingMeasurement() {
        return profilingMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJMXMeasurement() {
        return jmxMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXMeasurement_PollingPeriod() {
        return (EAttribute) jmxMeasurementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLinearValueProvider() {
        return linearValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLinearValueProvider_Summand() {
        return (EAttribute) linearValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLinearValueProvider_Factor() {
        return (EAttribute) linearValueProviderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModification() {
        return modificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModification_Type() {
        return (EReference) modificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_Name() {
        return (EAttribute) modificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_VariedObjectId() {
        return (EAttribute) modificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_Value() {
        return (EAttribute) modificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInitialModel() {
        return initialModelEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_UsageModel() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_Allocation() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_MiddlewareRepository() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_EventMiddleWareRepository() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_ReconfigurationRules() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInitialModel_PlatformMonitoringSpecification() {
        return (EReference) initialModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getReconfigurationRulesFolder() {
        return reconfigurationRulesFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getReconfigurationRulesFolder_FolderUri() {
        return (EAttribute) reconfigurationRulesFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExperimentsFactory getExperimentsFactory() {
        return (ExperimentsFactory) getEFactoryInstance();
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
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        experimentRepositoryEClass = createEClass(EXPERIMENT_REPOSITORY);
        createEReference(experimentRepositoryEClass, EXPERIMENT_REPOSITORY__EXPERIMENTS);
        createEReference(experimentRepositoryEClass, EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION);
        createEAttribute(experimentRepositoryEClass, EXPERIMENT_REPOSITORY__REPETITIONS);

        experimentEClass = createEClass(EXPERIMENT);
        createEReference(experimentEClass, EXPERIMENT__VARIATIONS);
        createEReference(experimentEClass, EXPERIMENT__MODIFICATIONS);
        createEAttribute(experimentEClass, EXPERIMENT__ID);
        createEAttribute(experimentEClass, EXPERIMENT__NAME);
        createEReference(experimentEClass, EXPERIMENT__TOOL_CONFIGURATION);
        createEReference(experimentEClass, EXPERIMENT__STOP_CONDITIONS);
        createEAttribute(experimentEClass, EXPERIMENT__DESCRIPTION);
        createEReference(experimentEClass, EXPERIMENT__EXPERIMENT_DESIGN);
        createEReference(experimentEClass, EXPERIMENT__RESPONSE_MEASUREMENT);
        createEReference(experimentEClass, EXPERIMENT__INITIAL_MODEL);

        variationEClass = createEClass(VARIATION);
        createEReference(variationEClass, VARIATION__TYPE);
        createEReference(variationEClass, VARIATION__VALUE_PROVIDER);
        createEAttribute(variationEClass, VARIATION__MIN_VALUE);
        createEAttribute(variationEClass, VARIATION__MAX_VALUE);
        createEAttribute(variationEClass, VARIATION__MAX_VARIATIONS);
        createEAttribute(variationEClass, VARIATION__VARIED_OBJECT_ID);
        createEAttribute(variationEClass, VARIATION__NAME);

        valueProviderEClass = createEClass(VALUE_PROVIDER);

        toolConfigurationEClass = createEClass(TOOL_CONFIGURATION);
        createEAttribute(toolConfigurationEClass, TOOL_CONFIGURATION__NAME);

        experimentDesignEClass = createEClass(EXPERIMENT_DESIGN);

        responseMeasurementEClass = createEClass(RESPONSE_MEASUREMENT);

        polynomialValueProviderEClass = createEClass(POLYNOMIAL_VALUE_PROVIDER);
        createEAttribute(polynomialValueProviderEClass, POLYNOMIAL_VALUE_PROVIDER__EXPONENT);
        createEAttribute(polynomialValueProviderEClass, POLYNOMIAL_VALUE_PROVIDER__FACTOR);

        exponentialValueProviderEClass = createEClass(EXPONENTIAL_VALUE_PROVIDER);
        createEAttribute(exponentialValueProviderEClass, EXPONENTIAL_VALUE_PROVIDER__BASE);

        setValueProviderEClass = createEClass(SET_VALUE_PROVIDER);
        createEAttribute(setValueProviderEClass, SET_VALUE_PROVIDER__VALUES);

        placketBurmanDesignEClass = createEClass(PLACKET_BURMAN_DESIGN);

        fullFactorialDesignEClass = createEClass(FULL_FACTORIAL_DESIGN);

        fractionalFactorialDesignEClass = createEClass(FRACTIONAL_FACTORIAL_DESIGN);

        oneFactorAtATimeEClass = createEClass(ONE_FACTOR_AT_ATIME);

        simulationDurationMeasurementEClass = createEClass(SIMULATION_DURATION_MEASUREMENT);

        profilingMeasurementEClass = createEClass(PROFILING_MEASUREMENT);

        jmxMeasurementEClass = createEClass(JMX_MEASUREMENT);
        createEAttribute(jmxMeasurementEClass, JMX_MEASUREMENT__POLLING_PERIOD);

        linearValueProviderEClass = createEClass(LINEAR_VALUE_PROVIDER);
        createEAttribute(linearValueProviderEClass, LINEAR_VALUE_PROVIDER__SUMMAND);
        createEAttribute(linearValueProviderEClass, LINEAR_VALUE_PROVIDER__FACTOR);

        modificationEClass = createEClass(MODIFICATION);
        createEReference(modificationEClass, MODIFICATION__TYPE);
        createEAttribute(modificationEClass, MODIFICATION__NAME);
        createEAttribute(modificationEClass, MODIFICATION__VARIED_OBJECT_ID);
        createEAttribute(modificationEClass, MODIFICATION__VALUE);

        initialModelEClass = createEClass(INITIAL_MODEL);
        createEReference(initialModelEClass, INITIAL_MODEL__USAGE_MODEL);
        createEReference(initialModelEClass, INITIAL_MODEL__ALLOCATION);
        createEReference(initialModelEClass, INITIAL_MODEL__MIDDLEWARE_REPOSITORY);
        createEReference(initialModelEClass, INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY);
        createEReference(initialModelEClass, INITIAL_MODEL__RECONFIGURATION_RULES);
        createEReference(initialModelEClass, INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION);

        reconfigurationRulesFolderEClass = createEClass(RECONFIGURATION_RULES_FOLDER);
        createEAttribute(reconfigurationRulesFolderEClass, RECONFIGURATION_RULES_FOLDER__FOLDER_URI);
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
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        AbstractsimulationPackage theAbstractsimulationPackage = (AbstractsimulationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AbstractsimulationPackage.eNS_URI);
        VariationPackage theVariationPackage = (VariationPackage) EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI);
        UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI);
        AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI);
        RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        PmsPackage thePmsPackage = (PmsPackage) EPackage.Registry.INSTANCE.getEPackage(PmsPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        polynomialValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        exponentialValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        setValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        fullFactorialDesignEClass.getESuperTypes().add(this.getExperimentDesign());
        oneFactorAtATimeEClass.getESuperTypes().add(this.getExperimentDesign());
        simulationDurationMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        profilingMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        jmxMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        linearValueProviderEClass.getESuperTypes().add(this.getValueProvider());

        // Initialize classes and features; add operations and parameters
        initEClass(experimentRepositoryEClass, ExperimentRepository.class, "ExperimentRepository", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExperimentRepository_Experiments(), this.getExperiment(), null, "experiments", null, 0, -1,
                ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentRepository_ToolConfiguration(), this.getToolConfiguration(), null,
                "toolConfiguration", null, 0, -1, ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperimentRepository_Repetitions(), ecorePackage.getEInt(), "repetitions", null, 1, 1,
                ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(experimentEClass, Experiment.class, "Experiment", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExperiment_Variations(), this.getVariation(), null, "variations", null, 0, -1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_Modifications(), this.getModification(), null, "modifications", null, 0, -1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExperiment_Id(), ecorePackage.getEString(), "id", null, 1, 1, Experiment.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperiment_Name(), ecorePackage.getEString(), "name", null, 1, 1, Experiment.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_ToolConfiguration(), this.getToolConfiguration(), null, "toolConfiguration", null,
                1, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_StopConditions(), theAbstractsimulationPackage.getStopCondition(), null,
                "stopConditions", null, 0, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperiment_Description(), ecorePackage.getEString(), "description", null, 1, 1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_ExperimentDesign(), this.getExperimentDesign(), null, "experimentDesign", null, 1,
                1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_ResponseMeasurement(), this.getResponseMeasurement(), null, "responseMeasurement",
                null, 1, 1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperiment_InitialModel(), this.getInitialModel(), null, "initialModel", null, 1, 1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(variationEClass, Variation.class, "Variation", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getVariation_Type(), theVariationPackage.getVariationType(), null, "type", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getVariation_ValueProvider(), this.getValueProvider(), null, "valueProvider", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getVariation_MinValue(), ecorePackage.getELong(), "minValue", null, 1, 1, Variation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getVariation_MaxValue(), ecorePackage.getELong(), "maxValue", null, 1, 1, Variation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getVariation_MaxVariations(), ecorePackage.getELong(), "maxVariations", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getVariation_VariedObjectId(), ecorePackage.getEString(), "variedObjectId", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getVariation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(valueProviderEClass, ValueProvider.class, "ValueProvider", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(toolConfigurationEClass, ToolConfiguration.class, "ToolConfiguration", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getToolConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1,
                ToolConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        initEClass(experimentDesignEClass, ExperimentDesign.class, "ExperimentDesign", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(responseMeasurementEClass, ResponseMeasurement.class, "ResponseMeasurement", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(polynomialValueProviderEClass, PolynomialValueProvider.class, "PolynomialValueProvider",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPolynomialValueProvider_Exponent(), ecorePackage.getEDouble(), "exponent", null, 1, 1,
                PolynomialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPolynomialValueProvider_Factor(), ecorePackage.getEDouble(), "factor", null, 1, 1,
                PolynomialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(exponentialValueProviderEClass, ExponentialValueProvider.class, "ExponentialValueProvider",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExponentialValueProvider_Base(), ecorePackage.getEDouble(), "base", null, 1, 1,
                ExponentialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(setValueProviderEClass, SetValueProvider.class, "SetValueProvider", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSetValueProvider_Values(), ecorePackage.getEString(), "values", null, 1, 1,
                SetValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        initEClass(placketBurmanDesignEClass, PlacketBurmanDesign.class, "PlacketBurmanDesign", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(fullFactorialDesignEClass, FullFactorialDesign.class, "FullFactorialDesign", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(fractionalFactorialDesignEClass, FractionalFactorialDesign.class, "FractionalFactorialDesign",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(oneFactorAtATimeEClass, OneFactorAtATime.class, "OneFactorAtATime", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(simulationDurationMeasurementEClass, SimulationDurationMeasurement.class,
                "SimulationDurationMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(profilingMeasurementEClass, ProfilingMeasurement.class, "ProfilingMeasurement", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(jmxMeasurementEClass, JMXMeasurement.class, "JMXMeasurement", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getJMXMeasurement_PollingPeriod(), ecorePackage.getEIntegerObject(), "pollingPeriod", null, 1,
                1, JMXMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        initEClass(linearValueProviderEClass, LinearValueProvider.class, "LinearValueProvider", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLinearValueProvider_Summand(), ecorePackage.getEDouble(), "summand", null, 1, 1,
                LinearValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getLinearValueProvider_Factor(), ecorePackage.getEDouble(), "factor", null, 1, 1,
                LinearValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(modificationEClass, Modification.class, "Modification", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getModification_Type(), theVariationPackage.getVariationType(), null, "type", null, 0, 1,
                Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModification_Name(), ecorePackage.getEString(), "name", null, 1, 1, Modification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getModification_VariedObjectId(), ecorePackage.getEString(), "variedObjectId", null, 1, 1,
                Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getModification_Value(), ecorePackage.getELong(), "value", null, 1, 1, Modification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(initialModelEClass, InitialModel.class, "InitialModel", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInitialModel_UsageModel(), theUsagemodelPackage.getUsageModel(), null, "usageModel", null, 1,
                1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInitialModel_Allocation(), theAllocationPackage.getAllocation(), null, "allocation", null, 1,
                1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInitialModel_MiddlewareRepository(), theRepositoryPackage.getRepository(), null,
                "middlewareRepository", null, 1, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInitialModel_EventMiddleWareRepository(), theRepositoryPackage.getRepository(), null,
                "eventMiddleWareRepository", null, 1, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInitialModel_ReconfigurationRules(), this.getReconfigurationRulesFolder(), null,
                "reconfigurationRules", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInitialModel_PlatformMonitoringSpecification(), thePmsPackage.getPMSModel(), null,
                "platformMonitoringSpecification", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(reconfigurationRulesFolderEClass, ReconfigurationRulesFolder.class, "ReconfigurationRulesFolder",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReconfigurationRulesFolder_FolderUri(), ecorePackage.getEString(), "folderUri", null, 1, 1,
                ReconfigurationRulesFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // ExperimentsPackageImpl
