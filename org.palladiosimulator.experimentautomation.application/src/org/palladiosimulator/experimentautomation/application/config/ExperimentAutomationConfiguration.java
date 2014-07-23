package org.palladiosimulator.experimentautomation.application.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ExperimentRepository;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.variation.VariationPackage;
import org.palladiosimulator.experimentautomation.variation.VariationRepository;

public class ExperimentAutomationConfiguration {

    private static final Logger LOGGER = Logger.getLogger(ExperimentAutomationConfiguration.class);

    private final ResourceSet resourceSet;
    private final ExperimentRepository experimentRepository;
    private final VariationRepository variations;
    private final List<String> filteredExperimentIDs;

    public ExperimentAutomationConfiguration(final Bundle bundle, final IPath experimentsLocation, final IPath variationsLocation,
            final List<String> filteredExperimentIDs) {
        this.resourceSet = new ResourceSetImpl();
        this.experimentRepository = (ExperimentRepository) loadResourceFromBundle(resourceSet, bundle,
                experimentsLocation, ExperimentsPackage.eINSTANCE.getExperimentRepository());
        this.variations = (VariationRepository) loadResourceFromBundle(resourceSet, bundle, variationsLocation,
                VariationPackage.eINSTANCE.getVariationRepository());
        this.filteredExperimentIDs = filteredExperimentIDs;
    }

    public ExperimentRepository getExperiments() {
        return this.experimentRepository;
    }

    public VariationRepository getVariations() {
        return this.variations;
    }
    
    public ResourceSet getResourceSet() {
        return this.resourceSet;
    }

    private static <T extends EClass> EObject loadResourceFromBundle(final ResourceSet resourceSet,
            final Bundle bundle, final IPath modelLocation, final T expectedType) {
        LOGGER.debug("Loading resource " + modelLocation.toString() + " from bundle");
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
    
    public List<Experiment> getFilteredExperiments() {
        final List<Experiment> experiments;
        if (filteredExperimentIDs.isEmpty()) {
            // experiments as in config
            experiments = this.experimentRepository.getExperiments();
        } else {
            // filter experiment list
            experiments = new ArrayList<Experiment>();
            for (final Experiment e : this.experimentRepository.getExperiments()) {
                for (final String id : filteredExperimentIDs) {
                    if (e.getId().equalsIgnoreCase(id)) {
                        experiments.add(e);
                        break;
                    }
                }
            }
        }
        return experiments;
    }
}
