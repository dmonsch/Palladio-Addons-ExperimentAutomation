/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Linear Value Provider</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinearValueProviderTest extends ValueProviderTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LinearValueProviderTest.class);
	}

	/**
	 * Constructs a new Linear Value Provider test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearValueProviderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Linear Value Provider test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LinearValueProvider getFixture() {
		return (LinearValueProvider)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExperimentsFactory.eINSTANCE.createLinearValueProvider());
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

} //LinearValueProviderTest
