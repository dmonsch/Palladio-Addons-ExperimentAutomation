/**
 */
package org.palladiosimulator.simucom.simucomtooladapter.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.palladiosimulator.simucom.simucomtooladapter.SimucomtooladapterPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimucomtooladapterXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimucomtooladapterXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        SimucomtooladapterPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the SimucomtooladapterResourceFactoryImpl factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new SimucomtooladapterResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new SimucomtooladapterResourceFactoryImpl());
        }
        return registrations;
    }

} // SimucomtooladapterXMLProcessor
