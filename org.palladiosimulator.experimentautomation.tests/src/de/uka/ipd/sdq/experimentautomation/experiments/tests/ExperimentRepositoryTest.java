/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Experiment Repository</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentRepositoryTest extends TestCase {

	/**
	 * The fixture for this Experiment Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentRepository fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExperimentRepositoryTest.class);
	}

	/**
	 * Constructs a new Experiment Repository test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRepositoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Experiment Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExperimentRepository fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Experiment Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentRepository getFixture() {
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
		setFixture(ExperimentsFactory.eINSTANCE.createExperimentRepository());
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

} //ExperimentRepositoryTest
