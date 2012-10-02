/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimuComFactoryImpl extends EFactoryImpl implements SimuComFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimuComFactory init() {
		try {
			SimuComFactory theSimuComFactory = (SimuComFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/SimuCom/1.0"); 
			if (theSimuComFactory != null) {
				return theSimuComFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimuComFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimuComPackage.SIMU_COM_CONFIGURATION: return createSimuComConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComConfiguration createSimuComConfiguration() {
		SimuComConfigurationImpl simuComConfiguration = new SimuComConfigurationImpl();
		return simuComConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComPackage getSimuComPackage() {
		return (SimuComPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimuComPackage getPackage() {
		return SimuComPackage.eINSTANCE;
	}

} //SimuComFactoryImpl
