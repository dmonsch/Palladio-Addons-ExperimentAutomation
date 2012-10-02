/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.tests;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MemoryDatasource;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Memory Datasource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryDatasourceTest extends SensorFrameworkDatasourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MemoryDatasourceTest.class);
	}

	/**
	 * Constructs a new Memory Datasource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryDatasourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Memory Datasource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MemoryDatasource getFixture() {
		return (MemoryDatasource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AbstractSimulationFactory.eINSTANCE.createMemoryDatasource());
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

} //MemoryDatasourceTest
