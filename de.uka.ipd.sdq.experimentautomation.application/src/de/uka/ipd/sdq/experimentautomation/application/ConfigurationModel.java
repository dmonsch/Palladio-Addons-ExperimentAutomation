package de.uka.ipd.sdq.experimentautomation.application;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationRepository;

public class ConfigurationModel {

    private static final Logger logger = Logger.getLogger(ConfigurationModel.class);

    private final ExperimentRepository experimentRepository;
    private final VariationRepository variations;

    private ConfigurationModel(final ExperimentRepository experiments, final VariationRepository variations) {
        this.experimentRepository = experiments;
        this.variations = variations;
    }

    public ExperimentRepository getExperiments() {
        return this.experimentRepository;
    }

    public VariationRepository getVariations() {
        return this.variations;
    }

    public static ConfigurationModel loadFromBundle(final Bundle bundle, final IPath experimentsLocation,
            final IPath variationsLocation) {
        final ResourceSet resourceSet = new ResourceSetImpl();
        final ExperimentRepository experiments = (ExperimentRepository) loadResourceFromBundle(resourceSet, bundle,
                experimentsLocation, ExperimentsPackage.eINSTANCE.getExperimentRepository());
        final VariationRepository variations = (VariationRepository) loadResourceFromBundle(resourceSet, bundle,
                variationsLocation, VariationPackage.eINSTANCE.getVariationRepository());

        return new ConfigurationModel(experiments, variations);
    }

    private static <T extends EClass> EObject loadResourceFromBundle(final ResourceSet resourceSet,
            final Bundle bundle, final IPath modelLocation, final T expectedType) {
        logger.debug("Loading resource " + modelLocation.toString() + " from bundle");
        final URI modelUri = URI.createFileURI(modelLocation.toOSString());// absolutePathToBundleURI(bundle,
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
