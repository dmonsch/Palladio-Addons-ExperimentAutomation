/**
 */
package org.palladiosimulator.experimentautomation.experiments.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.impl.AbstractsimulationPackageImpl;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ExperimentDesign;
import org.palladiosimulator.experimentautomation.experiments.ExperimentRepository;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsFactory;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.ExponentialValueProvider;
import org.palladiosimulator.experimentautomation.experiments.FractionalFactorialDesign;
import org.palladiosimulator.experimentautomation.experiments.FullFactorialDesign;
import org.palladiosimulator.experimentautomation.experiments.InitialModel;
import org.palladiosimulator.experimentautomation.experiments.JMXMeasurement;
import org.palladiosimulator.experimentautomation.experiments.LinearValueProvider;
import org.palladiosimulator.experimentautomation.experiments.Modification;
import org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider;
import org.palladiosimulator.experimentautomation.experiments.OneFactorAtATime;
import org.palladiosimulator.experimentautomation.experiments.PlacketBurmanDesign;
import org.palladiosimulator.experimentautomation.experiments.PolynomialValueProvider;
import org.palladiosimulator.experimentautomation.experiments.ProfilingMeasurement;
import org.palladiosimulator.experimentautomation.experiments.ReconfigurationRulesFolder;
import org.palladiosimulator.experimentautomation.experiments.ResponseMeasurement;
import org.palladiosimulator.experimentautomation.experiments.SetValueProvider;
import org.palladiosimulator.experimentautomation.experiments.SimulationDurationMeasurement;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;
import org.palladiosimulator.experimentautomation.experiments.ValueProvider;
import org.palladiosimulator.experimentautomation.experiments.Variation;
import org.palladiosimulator.experimentautomation.variation.VariationPackage;
import org.palladiosimulator.experimentautomation.variation.impl.VariationPackageImpl;
import org.palladiosimulator.servicelevelobjective.ServicelevelObjectivePackage;
import org.palladiosimulator.simulizar.pms.PmsPackage;
import org.scaledl.usageevolution.UsageevolutionPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass nestedIntervalsValueProviderEClass = null;

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
     * @see org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage#eNS_URI
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
        PmsPackage.eINSTANCE.eClass();
        ServicelevelObjectivePackage.eINSTANCE.eClass();
        UsageevolutionPackage.eINSTANCE.eClass();

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
    public EReference getExperiment_ToolConfiguration() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExperiment_StopConditions() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getExperiment_Description() {
        return (EAttribute) this.experimentEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExperiment_ExperimentDesign() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExperiment_ResponseMeasurement() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExperiment_InitialModel() {
        return (EReference) this.experimentEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getExperiment_Repetitions() {
        return (EAttribute) this.experimentEClass.getEStructuralFeatures().get(10);
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
    public EClass getInitialModel() {
        return this.initialModelEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_UsageModel() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_Allocation() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_MiddlewareRepository() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_EventMiddleWareRepository() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_ReconfigurationRules() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_PlatformMonitoringSpecification() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_ServiceLevelObjectives() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_Repository() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_System() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_ResourceEnvironment() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInitialModel_UsageEvolution() {
        return (EReference) this.initialModelEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getReconfigurationRulesFolder() {
        return this.reconfigurationRulesFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getReconfigurationRulesFolder_FolderUri() {
        return (EAttribute) this.reconfigurationRulesFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getNestedIntervalsValueProvider() {
        return this.nestedIntervalsValueProviderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getNestedIntervalsValueProvider_MinValue() {
        return (EAttribute) this.nestedIntervalsValueProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getNestedIntervalsValueProvider_MaxValue() {
        return (EAttribute) this.nestedIntervalsValueProviderEClass.getEStructuralFeatures().get(1);
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

        this.experimentEClass = this.createEClass(EXPERIMENT);
        this.createEReference(this.experimentEClass, EXPERIMENT__VARIATIONS);
        this.createEReference(this.experimentEClass, EXPERIMENT__MODIFICATIONS);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__ID);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__NAME);
        this.createEReference(this.experimentEClass, EXPERIMENT__TOOL_CONFIGURATION);
        this.createEReference(this.experimentEClass, EXPERIMENT__STOP_CONDITIONS);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__DESCRIPTION);
        this.createEReference(this.experimentEClass, EXPERIMENT__EXPERIMENT_DESIGN);
        this.createEReference(this.experimentEClass, EXPERIMENT__RESPONSE_MEASUREMENT);
        this.createEReference(this.experimentEClass, EXPERIMENT__INITIAL_MODEL);
        this.createEAttribute(this.experimentEClass, EXPERIMENT__REPETITIONS);

        this.variationEClass = this.createEClass(VARIATION);
        this.createEReference(this.variationEClass, VARIATION__TYPE);
        this.createEReference(this.variationEClass, VARIATION__VALUE_PROVIDER);
        this.createEAttribute(this.variationEClass, VARIATION__MIN_VALUE);
        this.createEAttribute(this.variationEClass, VARIATION__MAX_VALUE);
        this.createEAttribute(this.variationEClass, VARIATION__MAX_VARIATIONS);
        this.createEAttribute(this.variationEClass, VARIATION__VARIED_OBJECT_ID);
        this.createEAttribute(this.variationEClass, VARIATION__NAME);

        this.valueProviderEClass = this.createEClass(VALUE_PROVIDER);

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

        this.initialModelEClass = this.createEClass(INITIAL_MODEL);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__USAGE_MODEL);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__ALLOCATION);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__MIDDLEWARE_REPOSITORY);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__EVENT_MIDDLE_WARE_REPOSITORY);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__RECONFIGURATION_RULES);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__PLATFORM_MONITORING_SPECIFICATION);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__SERVICE_LEVEL_OBJECTIVES);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__REPOSITORY);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__SYSTEM);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__RESOURCE_ENVIRONMENT);
        this.createEReference(this.initialModelEClass, INITIAL_MODEL__USAGE_EVOLUTION);

        this.reconfigurationRulesFolderEClass = this.createEClass(RECONFIGURATION_RULES_FOLDER);
        this.createEAttribute(this.reconfigurationRulesFolderEClass, RECONFIGURATION_RULES_FOLDER__FOLDER_URI);

        this.nestedIntervalsValueProviderEClass = this.createEClass(NESTED_INTERVALS_VALUE_PROVIDER);
        this.createEAttribute(this.nestedIntervalsValueProviderEClass, NESTED_INTERVALS_VALUE_PROVIDER__MIN_VALUE);
        this.createEAttribute(this.nestedIntervalsValueProviderEClass, NESTED_INTERVALS_VALUE_PROVIDER__MAX_VALUE);
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
        final UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI);
        final AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        final PmsPackage thePmsPackage = (PmsPackage) EPackage.Registry.INSTANCE.getEPackage(PmsPackage.eNS_URI);
        final ServicelevelObjectivePackage theServicelevelObjectivePackage = (ServicelevelObjectivePackage) EPackage.Registry.INSTANCE
                .getEPackage(ServicelevelObjectivePackage.eNS_URI);
        final SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI);
        final ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourceenvironmentPackage.eNS_URI);
        final UsageevolutionPackage theUsageevolutionPackage = (UsageevolutionPackage) EPackage.Registry.INSTANCE
                .getEPackage(UsageevolutionPackage.eNS_URI);

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
        this.nestedIntervalsValueProviderEClass.getESuperTypes().add(this.getValueProvider());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.experimentRepositoryEClass, ExperimentRepository.class, "ExperimentRepository",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getExperimentRepository_Experiments(), this.getExperiment(), null, "experiments",
                null, 0, -1, ExperimentRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
        this.initEReference(this.getExperiment_ToolConfiguration(), this.getToolConfiguration(), null,
                "toolConfiguration", null, 1, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
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
        this.initEReference(this.getExperiment_InitialModel(), this.getInitialModel(), null, "initialModel", null, 1,
                1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getExperiment_Repetitions(), this.ecorePackage.getEInt(), "repetitions", null, 1, 1,
                Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

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

        this.initEClass(this.initialModelEClass, InitialModel.class, "InitialModel", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getInitialModel_UsageModel(), theUsagemodelPackage.getUsageModel(), null,
                "usageModel", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_Allocation(), theAllocationPackage.getAllocation(), null,
                "allocation", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_MiddlewareRepository(), theRepositoryPackage.getRepository(), null,
                "middlewareRepository", null, 1, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_EventMiddleWareRepository(), theRepositoryPackage.getRepository(),
                null, "eventMiddleWareRepository", null, 1, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_ReconfigurationRules(), this.getReconfigurationRulesFolder(), null,
                "reconfigurationRules", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_PlatformMonitoringSpecification(), thePmsPackage.getPMSModel(), null,
                "platformMonitoringSpecification", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_ServiceLevelObjectives(),
                theServicelevelObjectivePackage.getServiceLevelObjectiveRepository(), null, "serviceLevelObjectives",
                null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_Repository(), theRepositoryPackage.getRepository(), null,
                "repository", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_System(), theSystemPackage.getSystem(), null, "system", null, 0, 1,
                InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_ResourceEnvironment(),
                theResourceenvironmentPackage.getResourceEnvironment(), null, "resourceEnvironment", null, 0, 1,
                InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInitialModel_UsageEvolution(), theUsageevolutionPackage.getUsageEvolution(), null,
                "usageEvolution", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.reconfigurationRulesFolderEClass, ReconfigurationRulesFolder.class,
                "ReconfigurationRulesFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getReconfigurationRulesFolder_FolderUri(), this.ecorePackage.getEString(),
                "folderUri", null, 1, 1, ReconfigurationRulesFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.nestedIntervalsValueProviderEClass, NestedIntervalsValueProvider.class,
                "NestedIntervalsValueProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getNestedIntervalsValueProvider_MinValue(), this.ecorePackage.getELong(), "minValue",
                null, 1, 1, NestedIntervalsValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getNestedIntervalsValueProvider_MaxValue(), this.ecorePackage.getELong(), "maxValue",
                null, 1, 1, NestedIntervalsValueProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // ExperimentsPackageImpl
