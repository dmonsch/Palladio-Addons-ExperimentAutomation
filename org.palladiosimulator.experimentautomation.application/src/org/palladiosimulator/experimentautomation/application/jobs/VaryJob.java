package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.application.variation.IVariationStrategy;
import org.palladiosimulator.experimentautomation.application.variation.VariationStrategyFactory;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * This job conducts a given experiment for a given analysis tool. The job assumes that involved
 * models are already loaded to the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class VaryJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final List<Variation> variations;
    private final List<Long> factorLevels;
    
    /**
     * Default Constructor.
     * 
     * @param variations
     *            Variations considered for the experiment.
     * @param factorLevels
     *            Factor levels considered for the experiment.
     */
    public VaryJob(final List<Variation> variations,
            final List<Long> factorLevels) {
        super(false);

        this.variations = variations;
        this.factorLevels = factorLevels;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // FIXME Crucial fixme!
        // copy initial PCM model
        //ExperimentAutomationConfiguration clonedConfiguration = configuration.clone();

        // modify the copied PCM model according to the variation descriptions
        for (int i = 0; i < this.variations.size(); i++) {
            final Variation variation = this.variations.get(i);
            final Long currentValue = this.factorLevels.get(i);
//            final IVariationStrategy variationStrategy = this.initialiseVariations(variation,
//                    clonedConfiguration.getResourceSet()); // FIXME Modify in blackboard?
//
//            variationStrategy.vary(currentValue);
        }
    }

    private IVariationStrategy initialiseVariations(final Variation variation, final ResourceSet resourceSet) {
        final EObject variedObject = EcoreHelper.findModelElementById(resourceSet, variation.getVariedObjectId());
        if (variedObject == null) {
            throw new RuntimeException("Unable to find model element with ID " + variation.getVariedObjectId()
                    + " in resource set");
        }
        final IVariationStrategy variationStrategy = VariationStrategyFactory.createStrategy(variation.getType());
        variationStrategy.setVariedObject(variedObject);
        return variationStrategy;
    }
}
