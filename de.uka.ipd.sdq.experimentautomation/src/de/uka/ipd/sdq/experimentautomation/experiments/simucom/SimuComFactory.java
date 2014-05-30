/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComPackage
 * @generated
 */
public interface SimuComFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    SimuComFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Configuration</em>'.
     * @generated
     */
    SimuComConfiguration createSimuComConfiguration();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    SimuComPackage getSimuComPackage();

} // SimuComFactory
