/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.Modification;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModificationTest extends TestCase {

	/**
	 * The fixture for this Modification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Modification fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModificationTest.class);
	}

	/**
	 * Constructs a new Modification test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModificationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Modification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Modification fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Modification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Modification getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExperimentsFactory.eINSTANCE.createModification());
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

} //ModificationTest
