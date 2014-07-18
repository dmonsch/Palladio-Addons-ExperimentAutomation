/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Number Generator Seed</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomNumberGeneratorSeedTest extends TestCase {

	/**
	 * The fixture for this Random Number Generator Seed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomNumberGeneratorSeed fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomNumberGeneratorSeedTest.class);
	}

	/**
	 * Constructs a new Random Number Generator Seed test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomNumberGeneratorSeedTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Random Number Generator Seed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RandomNumberGeneratorSeed fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Random Number Generator Seed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomNumberGeneratorSeed getFixture() {
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
		setFixture(AbstractSimulationFactory.eINSTANCE.createRandomNumberGeneratorSeed());
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

} //RandomNumberGeneratorSeedTest
