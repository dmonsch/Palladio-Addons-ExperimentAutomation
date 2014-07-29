package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.application.tooladapter.IToolAdapter;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.NestedIntervalsValueProviderStrategy;
import org.palladiosimulator.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class AddDynamicVariationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final IToolAdapter toolAdapter;
    private final Experiment experiment;
    private final ToolConfiguration toolConfig;
    private final List<VariationFactorTuple> variationFactorTuples;
    private final int repetition;

    private final Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> tuples2nestedIntervals;

    public AddDynamicVariationJob(IToolAdapter toolAdapter, final Experiment experiment,
            final ToolConfiguration toolConfig, final List<VariationFactorTuple> variationFactorTuples,
            final int repetition) {
        super(true);

        this.toolAdapter = toolAdapter;
        this.experiment = experiment;
        this.toolConfig = toolConfig;
        this.variationFactorTuples = variationFactorTuples;
        this.repetition = repetition;

        this.tuples2nestedIntervals = computeNestedIntervalsValueProviders();
    }

    private Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> computeNestedIntervalsValueProviders() {
        final Map<VariationFactorTuple, NestedIntervalsValueProviderStrategy> result;
        result = new HashMap<VariationFactorTuple, NestedIntervalsValueProviderStrategy>();

        for (final VariationFactorTuple variationFactorTuple : this.variationFactorTuples) {
            final IValueProviderStrategy valueProvider = ValueProviderFactory.createValueProvider(variationFactorTuple
                    .getVariation().getValueProvider());

            if (valueProvider instanceof NestedIntervalsValueProviderStrategy) {
                result.put(variationFactorTuple, (NestedIntervalsValueProviderStrategy) valueProvider);
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final boolean successWithLastRun = true; // FIXME Repeat based on previous analysis result

        if (this.tuples2nestedIntervals.size() > 0) {
            for (final VariationFactorTuple variationFactorTuple : this.tuples2nestedIntervals.keySet()) {
                final NestedIntervalsValueProviderStrategy nestedInterval = this.tuples2nestedIntervals
                        .get(variationFactorTuple);
                if (successWithLastRun) {
                    nestedInterval.setMin(nestedInterval.valueAtPosition(0));
                } else {
                    nestedInterval.setMax(nestedInterval.valueAtPosition(0));
                }

                if (nestedInterval.isConverged()) {
                    this.tuples2nestedIntervals.remove(variationFactorTuple);
                } else {
                    variationFactorTuple.setFactor(nestedInterval.valueAtPosition(0));
                }
            }

            if (this.tuples2nestedIntervals.size() > 0) {
                final IBlackboardInteractingJob<MDSDBlackboard> varyJob = new VaryJob(this.variationFactorTuples);
                varyJob.setBlackboard(this.getBlackboard());
                varyJob.execute(monitor);

                final IBlackboardInteractingJob<MDSDBlackboard> runAnalysisJob = this.toolAdapter.createRunAnalysisJob(
                        this.experiment, this.toolConfig, this.variationFactorTuples, this.repetition);
                runAnalysisJob.setBlackboard(this.getBlackboard());
                runAnalysisJob.execute(monitor);

                this.execute(monitor);
            }
        }
    }
}
