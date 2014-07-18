/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.variation.tests;

import de.uka.ipd.sdq.experimentautomation.variation.StructuralVariation;
import de.uka.ipd.sdq.experimentautomation.variation.VariationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Structural Variation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralVariationTest extends VariationTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StructuralVariationTest.class);
	}

	/**
	 * Constructs a new Structural Variation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralVariationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Structural Variation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StructuralVariation getFixture() {
		return (StructuralVariation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VariationFactory.eINSTANCE.createStructuralVariation());
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

} //StructuralVariationTest
