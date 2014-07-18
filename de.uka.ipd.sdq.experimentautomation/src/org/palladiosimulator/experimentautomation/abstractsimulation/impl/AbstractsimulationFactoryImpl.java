/**
 */
package org.palladiosimulator.experimentautomation.abstractsimulation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationFactory;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.BlackboardType;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2;
import org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.MeasurementCountStopCondition;
import org.palladiosimulator.experimentautomation.abstractsimulation.MemoryDatasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.ProbeSpecConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed;
import org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.SimTimeStopCondition;

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
            AbstractsimulationFactory theAbstractsimulationFactory = (AbstractsimulationFactory) EPackage.Registry.INSTANCE
                    .getEFactory(AbstractsimulationPackage.eNS_URI);
            if (theAbstractsimulationFactory != null) {
                return theAbstractsimulationFactory;
            }
        } catch (Exception exception) {
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
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED:
            return createRandomNumberGeneratorSeed();
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION:
            return createProbeSpecConfiguration();
        case AbstractsimulationPackage.SENSOR_FRAMEWORK:
            return createSensorFramework();
        case AbstractsimulationPackage.MEMORY_DATASOURCE:
            return createMemoryDatasource();
        case AbstractsimulationPackage.FILE_DATASOURCE:
            return createFileDatasource();
        case AbstractsimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION:
            return createMeasurementCountStopCondition();
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION:
            return createSimTimeStopCondition();
        case AbstractsimulationPackage.EDP2:
            return createEDP2();
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
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case AbstractsimulationPackage.BLACKBOARD_TYPE:
            return createBlackboardTypeFromString(eDataType, initialValue);
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
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case AbstractsimulationPackage.BLACKBOARD_TYPE:
            return convertBlackboardTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RandomNumberGeneratorSeed createRandomNumberGeneratorSeed() {
        RandomNumberGeneratorSeedImpl randomNumberGeneratorSeed = new RandomNumberGeneratorSeedImpl();
        return randomNumberGeneratorSeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProbeSpecConfiguration createProbeSpecConfiguration() {
        ProbeSpecConfigurationImpl probeSpecConfiguration = new ProbeSpecConfigurationImpl();
        return probeSpecConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SensorFramework createSensorFramework() {
        SensorFrameworkImpl sensorFramework = new SensorFrameworkImpl();
        return sensorFramework;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MemoryDatasource createMemoryDatasource() {
        MemoryDatasourceImpl memoryDatasource = new MemoryDatasourceImpl();
        return memoryDatasource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FileDatasource createFileDatasource() {
        FileDatasourceImpl fileDatasource = new FileDatasourceImpl();
        return fileDatasource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MeasurementCountStopCondition createMeasurementCountStopCondition() {
        MeasurementCountStopConditionImpl measurementCountStopCondition = new MeasurementCountStopConditionImpl();
        return measurementCountStopCondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimTimeStopCondition createSimTimeStopCondition() {
        SimTimeStopConditionImpl simTimeStopCondition = new SimTimeStopConditionImpl();
        return simTimeStopCondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EDP2 createEDP2() {
        EDP2Impl edp2 = new EDP2Impl();
        return edp2;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BlackboardType createBlackboardTypeFromString(EDataType eDataType, String initialValue) {
        BlackboardType result = BlackboardType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertBlackboardTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractsimulationPackage getAbstractsimulationPackage() {
        return (AbstractsimulationPackage) getEPackage();
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
