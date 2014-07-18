/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exponential Value Provider</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExponentialValueProviderTest extends ValueProviderTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExponentialValueProviderTest.class);
	}

	/**
	 * Constructs a new Exponential Value Provider test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExponentialValueProviderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Exponential Value Provider test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ExponentialValueProvider getFixture() {
		return (ExponentialValueProvider)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExperimentsFactory.eINSTANCE.createExponentialValueProvider());
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

} //ExponentialValueProviderTest
