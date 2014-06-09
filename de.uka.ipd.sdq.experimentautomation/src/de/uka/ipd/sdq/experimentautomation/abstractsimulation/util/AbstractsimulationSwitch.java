/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2;
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
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage
 * @generated
 */
public class AbstractsimulationSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static AbstractsimulationPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractsimulationSwitch() {
        if (modelPackage == null) {
            modelPackage = AbstractsimulationPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case AbstractsimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION: {
            final AbstractSimulationConfiguration abstractSimulationConfiguration = (AbstractSimulationConfiguration) theEObject;
            T result = this.caseAbstractSimulationConfiguration(abstractSimulationConfiguration);
            if (result == null) {
                result = this.caseToolConfiguration(abstractSimulationConfiguration);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.PERSISTENCE_FRAMEWORK: {
            final PersistenceFramework persistenceFramework = (PersistenceFramework) theEObject;
            T result = this.casePersistenceFramework(persistenceFramework);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.RANDOM_NUMBER_GENERATOR_SEED: {
            final RandomNumberGeneratorSeed randomNumberGeneratorSeed = (RandomNumberGeneratorSeed) theEObject;
            T result = this.caseRandomNumberGeneratorSeed(randomNumberGeneratorSeed);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.PROBE_SPEC_CONFIGURATION: {
            final ProbeSpecConfiguration probeSpecConfiguration = (ProbeSpecConfiguration) theEObject;
            T result = this.caseProbeSpecConfiguration(probeSpecConfiguration);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.SENSOR_FRAMEWORK: {
            final SensorFramework sensorFramework = (SensorFramework) theEObject;
            T result = this.caseSensorFramework(sensorFramework);
            if (result == null) {
                result = this.casePersistenceFramework(sensorFramework);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.SENSOR_FRAMEWORK_DATASOURCE: {
            final SensorFrameworkDatasource sensorFrameworkDatasource = (SensorFrameworkDatasource) theEObject;
            T result = this.caseSensorFrameworkDatasource(sensorFrameworkDatasource);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.MEMORY_DATASOURCE: {
            final MemoryDatasource memoryDatasource = (MemoryDatasource) theEObject;
            T result = this.caseMemoryDatasource(memoryDatasource);
            if (result == null) {
                result = this.caseSensorFrameworkDatasource(memoryDatasource);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.FILE_DATASOURCE: {
            final FileDatasource fileDatasource = (FileDatasource) theEObject;
            T result = this.caseFileDatasource(fileDatasource);
            if (result == null) {
                result = this.caseSensorFrameworkDatasource(fileDatasource);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION: {
            final MeasurementCountStopCondition measurementCountStopCondition = (MeasurementCountStopCondition) theEObject;
            T result = this.caseMeasurementCountStopCondition(measurementCountStopCondition);
            if (result == null) {
                result = this.caseStopCondition(measurementCountStopCondition);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.SIM_TIME_STOP_CONDITION: {
            final SimTimeStopCondition simTimeStopCondition = (SimTimeStopCondition) theEObject;
            T result = this.caseSimTimeStopCondition(simTimeStopCondition);
            if (result == null) {
                result = this.caseStopCondition(simTimeStopCondition);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.STOP_CONDITION: {
            final StopCondition stopCondition = (StopCondition) theEObject;
            T result = this.caseStopCondition(stopCondition);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractsimulationPackage.EDP2: {
            final EDP2 edp2 = (EDP2) theEObject;
            T result = this.caseEDP2(edp2);
            if (result == null) {
                result = this.casePersistenceFramework(edp2);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Simulation Configuration</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Simulation Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractSimulationConfiguration(final AbstractSimulationConfiguration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Persistence Framework</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Persistence Framework</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePersistenceFramework(final PersistenceFramework object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Random Number Generator Seed</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Random Number Generator Seed</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRandomNumberGeneratorSeed(final RandomNumberGeneratorSeed object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Probe Spec Configuration</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Probe Spec Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProbeSpecConfiguration(final ProbeSpecConfiguration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sensor Framework</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sensor Framework</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSensorFramework(final SensorFramework object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Sensor Framework Datasource</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Sensor Framework Datasource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSensorFrameworkDatasource(final SensorFrameworkDatasource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Memory Datasource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Memory Datasource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMemoryDatasource(final MemoryDatasource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Datasource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Datasource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileDatasource(final FileDatasource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Measurement Count Stop Condition</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Measurement Count Stop Condition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMeasurementCountStopCondition(final MeasurementCountStopCondition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Sim Time Stop Condition</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Sim Time Stop Condition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimTimeStopCondition(final SimTimeStopCondition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Stop Condition</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Stop Condition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStopCondition(final StopCondition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EDP2</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EDP2</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEDP2(final EDP2 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tool Configuration</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tool Configuration</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseToolConfiguration(final ToolConfiguration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // AbstractsimulationSwitch
