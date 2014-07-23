package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.application.variation.IVariationStrategy;
import org.palladiosimulator.experimentautomation.application.variation.VariationStrategyFactory;
import org.palladiosimulator.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

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
    public VaryJob(final List<Variation> variations, final List<Long> factorLevels) {
        super(false);

        this.variations = variations;
        this.factorLevels = factorLevels;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        // modify the copied PCM model according to the variation descriptions; one by one
        for (int i = 0; i < this.variations.size(); i++) {
            final Variation variation = this.variations.get(i);
            final Long currentValue = this.factorLevels.get(i);

            this.executeVariation(variation, currentValue);
        }
    }

    private void executeVariation(final Variation variation, Long currentValue) {
        ResourceSetPartition pcmPartition = this.getBlackboard().getPartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        final EObject variedObject = EcoreHelper.findModelElementById(pcmPartition.getResourceSet(),
                variation.getVariedObjectId());
        
        if (variedObject == null) {
            throw new RuntimeException("Unable to find model element with ID " + variation.getVariedObjectId()
                    + " in resource set");
        }

        final IVariationStrategy variationStrategy = VariationStrategyFactory.createStrategy(variation.getType());
        variationStrategy.setVariedObject(variedObject);
        variationStrategy.vary(currentValue);
    }
}
