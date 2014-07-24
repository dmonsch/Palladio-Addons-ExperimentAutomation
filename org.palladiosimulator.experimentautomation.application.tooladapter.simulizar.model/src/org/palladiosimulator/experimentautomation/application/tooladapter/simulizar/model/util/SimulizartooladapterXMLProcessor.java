/**
 */
package org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.palladiosimulator.experimentautomation.application.tooladapter.simulizar.model.SimulizartooladapterPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimulizartooladapterXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimulizartooladapterXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        SimulizartooladapterPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the SimulizartooladapterResourceFactoryImpl
     * factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new SimulizartooladapterResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new SimulizartooladapterResourceFactoryImpl());
        }
        return this.registrations;
    }

} // SimulizartooladapterXMLProcessor
