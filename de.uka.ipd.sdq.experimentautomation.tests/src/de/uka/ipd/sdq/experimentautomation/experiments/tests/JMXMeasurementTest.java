/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>JMX Measurement</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JMXMeasurementTest extends ResponseMeasurementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(JMXMeasurementTest.class);
	}

	/**
	 * Constructs a new JMX Measurement test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMXMeasurementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this JMX Measurement test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected JMXMeasurement getFixture() {
		return (JMXMeasurement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExperimentsFactory.eINSTANCE.createJMXMeasurement());
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

} //JMXMeasurementTest
