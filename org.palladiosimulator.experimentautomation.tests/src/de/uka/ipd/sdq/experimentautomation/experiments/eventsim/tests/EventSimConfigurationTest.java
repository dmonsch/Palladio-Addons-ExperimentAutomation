/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests.AbstractSimulationConfigurationTest;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventSimConfigurationTest extends AbstractSimulationConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EventSimConfigurationTest.class);
	}

	/**
	 * Constructs a new Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSimConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EventSimConfiguration getFixture() {
		return (EventSimConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EventSimFactory.eINSTANCE.createEventSimConfiguration());
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

} //EventSimConfigurationTest
