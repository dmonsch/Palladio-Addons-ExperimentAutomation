/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sensor Framework</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SensorFrameworkTest extends PersistenceFrameworkTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SensorFrameworkTest.class);
	}

	/**
	 * Constructs a new Sensor Framework test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sensor Framework test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SensorFramework getFixture() {
		return (SensorFramework)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AbstractSimulationFactory.eINSTANCE.createSensorFramework());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SensorFrameworkTest
