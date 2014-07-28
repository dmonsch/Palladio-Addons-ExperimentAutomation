package org.palladiosimulator.experimentautomation.application.utils;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.identifier.Identifier;

public class EcoreHelper {

    private static final Logger LOGGER = Logger.getLogger(EcoreHelper.class);

    /**
     * Creates a deep copy of the source object and creates a new UUID for each {@link Identifier}
     * instance contained in the containment hierarchy of the copied object.
     * 
     * @param source
     *            the object that is to be copied
     * @return Copy of the source object
     */
    public static <T extends EObject> T copy(final T source) {
        final T copy = EcoreUtil.copy(source);
        createNewIds(copy);
        return copy;
    }

    private static <T extends EObject> void createNewIds(final T source) {
        // create and set new UUID
        if (Identifier.class.isInstance(source)) {
            ((Identifier) source).setId(EcoreUtil.generateUUID());
        }

        // recursively create new UUIDs for contained objects
        final EList<EObject> contents = source.eContents();
        for (final EObject o : contents) {
            createNewIds(o);
        }
    }

    public static EObject findModelElementById(final ResourceSet resourceSet, final String id) {
        for (Resource resource : resourceSet.getResources()) {
            EObject eObject = resource.getEObject(id);
            if (eObject != null) {
                return eObject;
            }
        }
        return null;
    }

    public static <T extends EClass> EObject loadResourceFromBundle(final ResourceSet resourceSet, final Bundle bundle,
            final IPath modelLocation, final T expectedType) {
        LOGGER.info("Loading resource " + modelLocation.toString() + " from bundle");
        final URI modelUri = URI.createFileURI(modelLocation.toOSString()); // absolutePathToBundleURI(bundle,
                                                                            // modelLocation);
        final Resource r = resourceSet.getResource(modelUri, true);

        final EObject o = r.getContents().get(0);
        if (expectedType.isInstance(o)) {
            return o;
        } else {
            throw new RuntimeException("The root element of the loaded resource is not of the expected type "
                    + expectedType.getName());
        }
    }
}
