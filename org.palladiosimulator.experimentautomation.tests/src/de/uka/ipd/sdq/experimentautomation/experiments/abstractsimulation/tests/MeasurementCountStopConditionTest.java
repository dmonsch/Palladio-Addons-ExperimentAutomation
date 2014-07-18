/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Measurement Count Stop Condition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasurementCountStopConditionTest extends StopConditionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MeasurementCountStopConditionTest.class);
	}

	/**
	 * Constructs a new Measurement Count Stop Condition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementCountStopConditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Measurement Count Stop Condition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MeasurementCountStopCondition getFixture() {
		return (MeasurementCountStopCondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AbstractSimulationFactory.eINSTANCE.createMeasurementCountStopCondition());
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

} //MeasurementCountStopConditionTest
