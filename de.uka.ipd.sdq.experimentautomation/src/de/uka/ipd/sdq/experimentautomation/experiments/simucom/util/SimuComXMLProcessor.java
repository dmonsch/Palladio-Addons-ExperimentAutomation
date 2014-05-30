/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimuComXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimuComXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        SimuComPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the SimuComResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new SimuComResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new SimuComResourceFactoryImpl());
        }
        return registrations;
    }

} // SimuComXMLProcessor
