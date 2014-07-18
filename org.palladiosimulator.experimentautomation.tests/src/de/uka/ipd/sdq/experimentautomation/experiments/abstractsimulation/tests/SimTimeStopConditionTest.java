/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sim Time Stop Condition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimTimeStopConditionTest extends StopConditionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimTimeStopConditionTest.class);
	}

	/**
	 * Constructs a new Sim Time Stop Condition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimTimeStopConditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sim Time Stop Condition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimTimeStopCondition getFixture() {
		return (SimTimeStopCondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AbstractSimulationFactory.eINSTANCE.createSimTimeStopCondition());
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

} //SimTimeStopConditionTest
