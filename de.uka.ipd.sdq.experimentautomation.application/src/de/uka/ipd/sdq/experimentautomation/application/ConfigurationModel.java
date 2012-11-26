package de.uka.ipd.sdq.experimentautomation.application;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationRepository;

public class ConfigurationModel {

    private static final Logger logger = Logger.getLogger(ConfigurationModel.class);

    private ExperimentRepository experimentRepository;
    private final VariationRepository variations;

    private final Bundle bundle;
    private final IPath experimentsLocation;

    private ConfigurationModel(final ExperimentRepository experiments, final VariationRepository variations,
            final Bundle bundle, final IPath experimentsLocation) {
        this.experimentRepository = experiments;
        this.variations = variations;
        this.bundle = bundle;
        this.experimentsLocation = experimentsLocation;
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

        return new ConfigurationModel(experiments, variations, bundle, experimentsLocation);
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

    private static URI absolutePathToBundleURI(final Bundle bundle, final IPath modelLocation) {
        // create URI pointing to the model file contained in the bundle
        final URL bundleUrl = FileLocator.find(bundle, modelLocation, null);
        final URI bundleUri = URI.createURI(bundleUrl.toExternalForm());
        return bundleUri;
    }

    public void setPCMModel(final PCMModelFiles pcm) {
        final ResourceSet resourceSet = new ResourceSetImpl();
        final ExperimentRepository experimentRepository = (ExperimentRepository) loadResourceFromBundle(resourceSet,
                this.bundle, this.experimentsLocation, ExperimentsPackage.eINSTANCE.getExperimentRepository());

        // tell Ecore where to find the PCM partial models by overwriting the relative path with
        // the absolute path to the temporary folder.
        final String[] modelFilePaths = { pcm.getAllocationFile(), pcm.getRepositoryFile(),
                pcm.getResourceenvironmentFile(), pcm.getSystemFile(), pcm.getUsagemodelFile() };
        for (final String path : modelFilePaths) {
            final File modelFile = new File(path);
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString()
                        + ". Check your configuration model.");
            }
            final String fileName = modelFile.getName();
            final URI absoluteFileUri = URI.createFileURI(modelFile.getPath());

            final URL bundleBaseUrl = this.bundle.getEntry("/");
            final URI bundleRelativeFileUri = URI.createURI(bundleBaseUrl.toExternalForm() + "config/" + fileName);
            resourceSet.getURIConverter().getURIMap().put(bundleRelativeFileUri, absoluteFileUri);
        }

        // resolve all references...
        EcoreUtil.resolveAll(resourceSet);

        // ...and check, whether there are unresolved references
        final Map<EObject, Collection<Setting>> map = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
        for (final EObject o : map.keySet()) {
            logger.warn("There are unresolved references: " + o);
        }

        // EcoreUtil.replace(this.experimentRepository, experimentRepository);

        this.experimentRepository = experimentRepository;
    }

}
