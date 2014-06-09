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
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

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
import de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.Modification;
import de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl;

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
    private EClass pcmModelFilesEClass = null;

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
        if (isInited) {
            return (ExperimentsPackage) EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI);
        }

        // Obtain or create and register package
        final ExperimentsPackageImpl theExperimentsPackage = (ExperimentsPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ExperimentsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ExperimentsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final VariationPackageImpl theVariationPackage = (VariationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) instanceof VariationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI) : VariationPackage.eINSTANCE);
        final AbstractsimulationPackageImpl theAbstractsimulationPackage = (AbstractsimulationPackageImpl) (EPackage.Registry.INSTANCE
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
        return this.experimentRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperimentRepository_Experiments() {
        return (EReference) this.experimentRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperimentRepository_ToolConfiguration() {
        return (EReference) this.experimentRepositoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperimentRepository_Repetitions() {
        return (EAttribute) this.experimentRepositoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExperiment() {
        return this.experimentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_Variations() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_Modifications() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Id() {
        return (EAttribute) this.experimentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Name() {
        return (EAttribute) this.experimentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_InitialModel() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ToolConfiguration() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_StopConditions() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExperiment_Description() {
        return (EAttribute) this.experimentEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ExperimentDesign() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExperiment_ResponseMeasurement() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getVariation() {
        return this.variationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariation_Type() {
        return (EReference) this.variationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariation_ValueProvider() {
        return (EReference) this.variationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MinValue() {
        return (EAttribute) this.variationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MaxValue() {
        return (EAttribute) this.variationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_MaxVariations() {
        return (EAttribute) this.variationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_VariedObjectId() {
        return (EAttribute) this.variationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariation_Name() {
        return (EAttribute) this.variationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueProvider() {
        return this.valueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPCMModelFiles() {
        return this.pcmModelFilesEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_AllocationFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_UsagemodelFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_SystemFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_RepositoryFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_ResourceenvironmentFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_MiddlewareRepositoryFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPCMModelFiles_EventMiddlewareRepositoryFile() {
        return (EAttribute) this.pcmModelFilesEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getToolConfiguration() {
        return this.toolConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getToolConfiguration_Name() {
        return (EAttribute) this.toolConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExperimentDesign() {
        return this.experimentDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResponseMeasurement() {
        return this.responseMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPolynomialValueProvider() {
        return this.polynomialValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPolynomialValueProvider_Exponent() {
        return (EAttribute) this.polynomialValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPolynomialValueProvider_Factor() {
        return (EAttribute) this.polynomialValueProviderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExponentialValueProvider() {
        return this.exponentialValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExponentialValueProvider_Base() {
        return (EAttribute) this.exponentialValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSetValueProvider() {
        return this.setValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSetValueProvider_Values() {
        return (EAttribute) this.setValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPlacketBurmanDesign() {
        return this.placketBurmanDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFullFactorialDesign() {
        return this.fullFactorialDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFractionalFactorialDesign() {
        return this.fractionalFactorialDesignEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOneFactorAtATime() {
        return this.oneFactorAtATimeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimulationDurationMeasurement() {
        return this.simulationDurationMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProfilingMeasurement() {
        return this.profilingMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJMXMeasurement() {
        return this.jmxMeasurementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXMeasurement_PollingPeriod() {
        return (EAttribute) this.jmxMeasurementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLinearValueProvider() {
        return this.linearValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLinearValueProvider_Summand() {
        return (EAttribute) this.linearValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLinearValueProvider_Factor() {
        return (EAttribute) this.linearValueProviderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModification() {
        return this.modificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModification_Type() {
        return (EReference) this.modificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_Name() {
        return (EAttribute) this.modificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_VariedObjectId() {
        return (EAttribute) this.modificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModification_Value() {
        return (EAttribute) this.modificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExperimentsFactory getExperimentsFactory() {
        return (ExperimentsFactory) this.getEFactoryInstance();
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
        this.experimentRepositoryEClass = this.createEClass(EXPERIMENT_REPOSITORY);
        this.createEReference(this.experimentRepositoryEClass, EXPERIMENT_REPOSITORY__EXPERIMENTS);
        this.createEReference(this.experimentRepositoryEClass, EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION);
        this.createEAttribute(this.experimentRepositoryEClass, EXPERIMENT_REPOSITORY__REPETITIONS);

        this.experimentEClass = this.createEClass(EXPERIMENT);
        this.createEReference(this.experimentEClass, EXPERIMENT__VARIATIONS);
        this.createEReference(this.experimentEClass, EXPERIMENT__MODIFICATIONS);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__ID);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__NAME);
        this.createEReference(this.experimentEClass, EXPERIMENT__INITIAL_MODEL);
        this.createEReference(this.experimentEClass, EXPERIMENT__TOOL_CONFIGURATION);
        this.createEReference(this.experimentEClass, EXPERIMENT__STOP_CONDITIONS);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__DESCRIPTION);
        this.createEReference(this.experimentEClass, EXPERIMENT__EXPERIMENT_DESIGN);
        this.createEReference(this.experimentEClass, EXPERIMENT__RESPONSE_MEASUREMENT);

        this.variationEClass = this.createEClass(VARIATION);
        this.createEReference(this.variationEClass, VARIATION__TYPE);
        this.createEReference(this.variationEClass, VARIATION__VALUE_PROVIDER);
        this.createEAttribute(this.variationEClass, VARIATION__MIN_VALUE);
        this.createEAttribute(this.variationEClass, VARIATION__MAX_VALUE);
        this.createEAttribute(this.variationEClass, VARIATION__MAX_VARIATIONS);
        this.createEAttribute(this.variationEClass, VARIATION__VARIED_OBJECT_ID);
        this.createEAttribute(this.variationEClass, VARIATION__NAME);

        this.valueProviderEClass = this.createEClass(VALUE_PROVIDER);

        this.pcmModelFilesEClass = this.createEClass(PCM_MODEL_FILES);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__ALLOCATION_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__USAGEMODEL_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__SYSTEM_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__REPOSITORY_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE);
        this.createEAttribute(this.pcmModelFilesEClass, PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE);

        this.toolConfigurationEClass = this.createEClass(TOOL_CONFIGURATION);
        this.createEAttribute(this.toolConfigurationEClass, TOOL_CONFIGURATION__NAME);

        this.experimentDesignEClass = this.createEClass(EXPERIMENT_DESIGN);

        this.responseMeasurementEClass = this.createEClass(RESPONSE_MEASUREMENT);

        this.polynomialValueProviderEClass = this.createEClass(POLYNOMIAL_VALUE_PROVIDER);
        this.createEAttribute(this.polynomialValueProviderEClass, POLYNOMIAL_VALUE_PROVIDER__EXPONENT);
        this.createEAttribute(this.polynomialValueProviderEClass, POLYNOMIAL_VALUE_PROVIDER__FACTOR);

        this.exponentialValueProviderEClass = this.createEClass(EXPONENTIAL_VALUE_PROVIDER);
        this.createEAttribute(this.exponentialValueProviderEClass, EXPONENTIAL_VALUE_PROVIDER__BASE);

        this.setValueProviderEClass = this.createEClass(SET_VALUE_PROVIDER);
        this.createEAttribute(this.setValueProviderEClass, SET_VALUE_PROVIDER__VALUES);

        this.placketBurmanDesignEClass = this.createEClass(PLACKET_BURMAN_DESIGN);

        this.fullFactorialDesignEClass = this.createEClass(FULL_FACTORIAL_DESIGN);

        this.fractionalFactorialDesignEClass = this.createEClass(FRACTIONAL_FACTORIAL_DESIGN);

        this.oneFactorAtATimeEClass = this.createEClass(ONE_FACTOR_AT_ATIME);

        this.simulationDurationMeasurementEClass = this.createEClass(SIMULATION_DURATION_MEASUREMENT);

        this.profilingMeasurementEClass = this.createEClass(PROFILING_MEASUREMENT);

        this.jmxMeasurementEClass = this.createEClass(JMX_MEASUREMENT);
        this.createEAttribute(this.jmxMeasurementEClass, JMX_MEASUREMENT__POLLING_PERIOD);

        this.linearValueProviderEClass = this.createEClass(LINEAR_VALUE_PROVIDER);
        this.createEAttribute(this.linearValueProviderEClass, LINEAR_VALUE_PROVIDER__SUMMAND);
        this.createEAttribute(this.linearValueProviderEClass, LINEAR_VALUE_PROVIDER__FACTOR);

        this.modificationEClass = this.createEClass(MODIFICATION);
        this.createEReference(this.modificationEClass, MODIFICATION__TYPE);
        this.createEAttribute(this.modificationEClass, MODIFICATION__NAME);
        this.createEAttribute(this.modificationEClass, MODIFICATION__VARIED_OBJECT_ID);
        this.createEAttribute(this.modificationEClass, MODIFICATION__VALUE);
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
        final VariationPackage theVariationPackage = (VariationPackage) EPackage.Registry.INSTANCE
                .getEPackage(VariationPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.polynomialValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        this.exponentialValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        this.setValueProviderEClass.getESuperTypes().add(this.getValueProvider());
        this.fullFactorialDesignEClass.getESuperTypes().add(this.getExperimentDesign());
        this.oneFactorAtATimeEClass.getESuperTypes().add(this.getExperimentDesign());
        this.simulationDurationMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        this.profilingMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        this.jmxMeasurementEClass.getESuperTypes().add(this.getResponseMeasurement());
        this.linearValueProviderEClass.getESuperTypes().add(this.getValueProvider());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.experimentRepositoryEClass, ExperimentRepository.class, "ExperimentRepository",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getExperimentRepository_Experiments(), this.getExperiment(), null, "experiments",
                null, 0, -1, ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperimentRepository_ToolConfiguration(), this.getToolConfiguration(), null,
                "toolConfiguration", null, 0, -1, ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getExperimentRepository_Repetitions(), this.ecorePackage.getEInt(), "repetitions",
                null, 1, 1, ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.experimentEClass, Experiment.class, "Experiment", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getExperiment_Variations(), this.getVariation(), null, "variations", null, 0, -1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_Modifications(), this.getModification(), null, "modifications", null, 0,
                -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getExperiment_Id(), this.ecorePackage.getEString(), "id", null, 1, 1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getExperiment_Name(), this.ecorePackage.getEString(), "name", null, 1, 1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_InitialModel(), this.getPCMModelFiles(), null, "initialModel", null, 1,
                1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_ToolConfiguration(), this.getToolConfiguration(), null,
                "toolConfiguration", null, 1, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_StopConditions(), theAbstractsimulationPackage.getStopCondition(), null,
                "stopConditions", null, 0, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getExperiment_Description(), this.ecorePackage.getEString(), "description", null, 1,
                1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_ExperimentDesign(), this.getExperimentDesign(), null,
                "experimentDesign", null, 1, 1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getExperiment_ResponseMeasurement(), this.getResponseMeasurement(), null,
                "responseMeasurement", null, 1, 1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.variationEClass, Variation.class, "Variation", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getVariation_Type(), theVariationPackage.getVariationType(), null, "type", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getVariation_ValueProvider(), this.getValueProvider(), null, "valueProvider", null, 1,
                1, Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getVariation_MinValue(), this.ecorePackage.getELong(), "minValue", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getVariation_MaxValue(), this.ecorePackage.getELong(), "maxValue", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getVariation_MaxVariations(), this.ecorePackage.getELong(), "maxVariations", null, 1,
                1, Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getVariation_VariedObjectId(), this.ecorePackage.getEString(), "variedObjectId", null,
                1, 1, Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getVariation_Name(), this.ecorePackage.getEString(), "name", null, 1, 1,
                Variation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.valueProviderEClass, ValueProvider.class, "ValueProvider", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.pcmModelFilesEClass, PCMModelFiles.class, "PCMModelFiles", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPCMModelFiles_AllocationFile(), this.ecorePackage.getEString(), "allocationFile",
                null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_UsagemodelFile(), this.ecorePackage.getEString(), "usagemodelFile",
                null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_SystemFile(), this.ecorePackage.getEString(), "systemFile", null, 1,
                1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_RepositoryFile(), this.ecorePackage.getEString(), "repositoryFile",
                null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_ResourceenvironmentFile(), this.ecorePackage.getEString(),
                "resourceenvironmentFile", null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_MiddlewareRepositoryFile(), this.ecorePackage.getEString(),
                "middlewareRepositoryFile", null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPCMModelFiles_EventMiddlewareRepositoryFile(), this.ecorePackage.getEString(),
                "eventMiddlewareRepositoryFile", null, 1, 1, PCMModelFiles.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.toolConfigurationEClass, ToolConfiguration.class, "ToolConfiguration", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getToolConfiguration_Name(), this.ecorePackage.getEString(), "name", null, 1, 1,
                ToolConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.experimentDesignEClass, ExperimentDesign.class, "ExperimentDesign", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.responseMeasurementEClass, ResponseMeasurement.class, "ResponseMeasurement", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.polynomialValueProviderEClass, PolynomialValueProvider.class, "PolynomialValueProvider",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPolynomialValueProvider_Exponent(), this.ecorePackage.getEDouble(), "exponent",
                null, 1, 1, PolynomialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPolynomialValueProvider_Factor(), this.ecorePackage.getEDouble(), "factor", null,
                1, 1, PolynomialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.exponentialValueProviderEClass, ExponentialValueProvider.class,
                "ExponentialValueProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getExponentialValueProvider_Base(), this.ecorePackage.getEDouble(), "base", null, 1,
                1, ExponentialValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.setValueProviderEClass, SetValueProvider.class, "SetValueProvider", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getSetValueProvider_Values(), this.ecorePackage.getEString(), "values", null, 1, 1,
                SetValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.placketBurmanDesignEClass, PlacketBurmanDesign.class, "PlacketBurmanDesign", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.fullFactorialDesignEClass, FullFactorialDesign.class, "FullFactorialDesign", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.fractionalFactorialDesignEClass, FractionalFactorialDesign.class,
                "FractionalFactorialDesign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.oneFactorAtATimeEClass, OneFactorAtATime.class, "OneFactorAtATime", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.simulationDurationMeasurementEClass, SimulationDurationMeasurement.class,
                "SimulationDurationMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.profilingMeasurementEClass, ProfilingMeasurement.class, "ProfilingMeasurement",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.jmxMeasurementEClass, JMXMeasurement.class, "JMXMeasurement", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getJMXMeasurement_PollingPeriod(), this.ecorePackage.getEIntegerObject(),
                "pollingPeriod", null, 1, 1, JMXMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.linearValueProviderEClass, LinearValueProvider.class, "LinearValueProvider", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getLinearValueProvider_Summand(), this.ecorePackage.getEDouble(), "summand", null, 1,
                1, LinearValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getLinearValueProvider_Factor(), this.ecorePackage.getEDouble(), "factor", null, 1, 1,
                LinearValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.modificationEClass, Modification.class, "Modification", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getModification_Type(), theVariationPackage.getVariationType(), null, "type", null, 0,
                1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getModification_Name(), this.ecorePackage.getEString(), "name", null, 1, 1,
                Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getModification_VariedObjectId(), this.ecorePackage.getEString(), "variedObjectId",
                null, 1, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getModification_Value(), this.ecorePackage.getELong(), "value", null, 1, 1,
                Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // ExperimentsPackageImpl
