/**
 */
package org.palladiosimulator.simucom.simucomtooladapter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.simucom.simucomtooladapter.SimuComConfiguration;
import org.palladiosimulator.simucom.simucomtooladapter.SimucomtooladapterFactory;
import org.palladiosimulator.simucom.simucomtooladapter.SimucomtooladapterPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimucomtooladapterFactoryImpl extends EFactoryImpl implements SimucomtooladapterFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static SimucomtooladapterFactory init() {
        try {
            SimucomtooladapterFactory theSimucomtooladapterFactory = (SimucomtooladapterFactory) EPackage.Registry.INSTANCE
                    .getEFactory(SimucomtooladapterPackage.eNS_URI);
            if (theSimucomtooladapterFactory != null) {
                return theSimucomtooladapterFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SimucomtooladapterFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimucomtooladapterFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SimucomtooladapterPackage.SIMU_COM_CONFIGURATION:
            return createSimuComConfiguration();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimuComConfiguration createSimuComConfiguration() {
        SimuComConfigurationImpl simuComConfiguration = new SimuComConfigurationImpl();
        return simuComConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimucomtooladapterPackage getSimucomtooladapterPackage() {
        return (SimucomtooladapterPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SimucomtooladapterPackage getPackage() {
        return SimucomtooladapterPackage.eINSTANCE;
    }

} // SimucomtooladapterFactoryImpl
