/**
 */
package de.uka.ipd.sdq.experimentautomation.abstractsimulation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage
 * @generated
 */
public class AbstractsimulationAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static AbstractsimulationPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractsimulationAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AbstractsimulationPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected AbstractsimulationSwitch<Adapter> modelSwitch = new AbstractsimulationSwitch<Adapter>() {
        @Override
        public Adapter caseAbstractSimulationConfiguration(final AbstractSimulationConfiguration object) {
            return AbstractsimulationAdapterFactory.this.createAbstractSimulationConfigurationAdapter();
        }

        @Override
        public Adapter casePersistenceFramework(final PersistenceFramework object) {
            return AbstractsimulationAdapterFactory.this.createPersistenceFrameworkAdapter();
        }

        @Override
        public Adapter caseRandomNumberGeneratorSeed(final RandomNumberGeneratorSeed object) {
            return AbstractsimulationAdapterFactory.this.createRandomNumberGeneratorSeedAdapter();
        }

        @Override
        public Adapter caseProbeSpecConfiguration(final ProbeSpecConfiguration object) {
            return AbstractsimulationAdapterFactory.this.createProbeSpecConfigurationAdapter();
        }

        @Override
        public Adapter caseSensorFramework(final SensorFramework object) {
            return AbstractsimulationAdapterFactory.this.createSensorFrameworkAdapter();
        }

        @Override
        public Adapter caseSensorFrameworkDatasource(final SensorFrameworkDatasource object) {
            return AbstractsimulationAdapterFactory.this.createSensorFrameworkDatasourceAdapter();
        }

        @Override
        public Adapter caseMemoryDatasource(final MemoryDatasource object) {
            return AbstractsimulationAdapterFactory.this.createMemoryDatasourceAdapter();
        }

        @Override
        public Adapter caseFileDatasource(final FileDatasource object) {
            return AbstractsimulationAdapterFactory.this.createFileDatasourceAdapter();
        }

        @Override
        public Adapter caseMeasurementCountStopCondition(final MeasurementCountStopCondition object) {
            return AbstractsimulationAdapterFactory.this.createMeasurementCountStopConditionAdapter();
        }

        @Override
        public Adapter caseSimTimeStopCondition(final SimTimeStopCondition object) {
            return AbstractsimulationAdapterFactory.this.createSimTimeStopConditionAdapter();
        }

        @Override
        public Adapter caseStopCondition(final StopCondition object) {
            return AbstractsimulationAdapterFactory.this.createStopConditionAdapter();
        }

        @Override
        public Adapter caseEDP2(final EDP2 object) {
            return AbstractsimulationAdapterFactory.this.createEDP2Adapter();
        }

        @Override
        public Adapter caseToolConfiguration(final ToolConfiguration object) {
            return AbstractsimulationAdapterFactory.this.createToolConfigurationAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return AbstractsimulationAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration
     * <em>Abstract Simulation Configuration</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractSimulationConfiguration
     * @generated
     */
    public Adapter createAbstractSimulationConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework
     * <em>Persistence Framework</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework
     * @generated
     */
    public Adapter createPersistenceFrameworkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed
     * <em>Random Number Generator Seed</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.RandomNumberGeneratorSeed
     * @generated
     */
    public Adapter createRandomNumberGeneratorSeedAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.ProbeSpecConfiguration
     * <em>Probe Spec Configuration</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.ProbeSpecConfiguration
     * @generated
     */
    public Adapter createProbeSpecConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework
     * <em>Sensor Framework</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework
     * @generated
     */
    public Adapter createSensorFrameworkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFrameworkDatasource
     * <em>Sensor Framework Datasource</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFrameworkDatasource
     * @generated
     */
    public Adapter createSensorFrameworkDatasourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.MemoryDatasource
     * <em>Memory Datasource</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.MemoryDatasource
     * @generated
     */
    public Adapter createMemoryDatasourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.FileDatasource
     * <em>File Datasource</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.FileDatasource
     * @generated
     */
    public Adapter createFileDatasourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.MeasurementCountStopCondition
     * <em>Measurement Count Stop Condition</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.MeasurementCountStopCondition
     * @generated
     */
    public Adapter createMeasurementCountStopConditionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.SimTimeStopCondition
     * <em>Sim Time Stop Condition</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.SimTimeStopCondition
     * @generated
     */
    public Adapter createSimTimeStopConditionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition
     * <em>Stop Condition</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition
     * @generated
     */
    public Adapter createStopConditionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2 <em>EDP2</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.abstractsimulation.EDP2
     * @generated
     */
    public Adapter createEDP2Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration
     * <em>Tool Configuration</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration
     * @generated
     */
    public Adapter createToolConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // AbstractsimulationAdapterFactory
