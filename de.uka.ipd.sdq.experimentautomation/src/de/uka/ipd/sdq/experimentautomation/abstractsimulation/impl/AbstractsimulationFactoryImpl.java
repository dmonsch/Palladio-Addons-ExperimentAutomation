/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationFactory;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.BlackboardType;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.FileDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.MeasurementCountStopCondition;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.MemoryDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.ProbeSpecConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SimTimeStopCondition;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractsimulationFactoryImpl extends EFactoryImpl implements AbstractsimulationFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static AbstractsimulationFactory init() {
        try {
            final AbstractsimulationFactory theAbstractsimulationFactory = (AbstractsimulationFactory) EPackage.Registry.INSTANCE
                    .getEFactory(AbstractsimulationPackage.eNS_URI);
            if (theAbstractsimulationFactory != null) {
                return theAbstractsimulationFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AbstractsimulationFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractsimulationFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED:
            return this.createRandomNumberGeneratorSeed();
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION:
            return this.createProbeSpecConfiguration();
        case AbstractsimulationPackage.SENSOR_FRAMEWORK:
            return this.createSensorFramework();
        case AbstractsimulationPackage.MEMORY_DATASOURCE:
            return this.createMemoryDatasource();
        case AbstractsimulationPackage.FILE_DATASOURCE:
            return this.createFileDatasource();
        case AbstractsimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION:
            return this.createMeasurementCountStopCondition();
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION:
            return this.createSimTimeStopCondition();
        case AbstractsimulationPackage.EDP2:
            return this.createEDP2();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(final EDataType eDataType, final String initialValue) {
        switch (eDataType.getClassifierID()) {
        case AbstractsimulationPackage.BLACKBOARD_TYPE:
            return this.createBlackboardTypeFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(final EDataType eDataType, final Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case AbstractsimulationPackage.BLACKBOARD_TYPE:
            return this.convertBlackboardTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RandomNumberGeneratorSeed createRandomNumberGeneratorSeed() {
        final RandomNumberGeneratorSeedImpl randomNumberGeneratorSeed = new RandomNumberGeneratorSeedImpl();
        return randomNumberGeneratorSeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProbeSpecConfiguration createProbeSpecConfiguration() {
        final ProbeSpecConfigurationImpl probeSpecConfiguration = new ProbeSpecConfigurationImpl();
        return probeSpecConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SensorFramework createSensorFramework() {
        final SensorFrameworkImpl sensorFramework = new SensorFrameworkImpl();
        return sensorFramework;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MemoryDatasource createMemoryDatasource() {
        final MemoryDatasourceImpl memoryDatasource = new MemoryDatasourceImpl();
        return memoryDatasource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileDatasource createFileDatasource() {
        final FileDatasourceImpl fileDatasource = new FileDatasourceImpl();
        return fileDatasource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MeasurementCountStopCondition createMeasurementCountStopCondition() {
        final MeasurementCountStopConditionImpl measurementCountStopCondition = new MeasurementCountStopConditionImpl();
        return measurementCountStopCondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SimTimeStopCondition createSimTimeStopCondition() {
        final SimTimeStopConditionImpl simTimeStopCondition = new SimTimeStopConditionImpl();
        return simTimeStopCondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDP2 createEDP2() {
        final EDP2Impl edp2 = new EDP2Impl();
        return edp2;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BlackboardType createBlackboardTypeFromString(final EDataType eDataType, final String initialValue) {
        final BlackboardType result = BlackboardType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertBlackboardTypeToString(final EDataType eDataType, final Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractsimulationPackage getAbstractsimulationPackage() {
        return (AbstractsimulationPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static AbstractsimulationPackage getPackage() {
        return AbstractsimulationPackage.eINSTANCE;
    }

} // AbstractsimulationFactoryImpl
