package org.palladiosimulator.experimentautomation.application.variation;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.experimentautomation.application.utils.PCMModelHelper;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

public class ClosedWorkloadVariation implements IVariationStrategy {

    private static final Logger LOGGER = Logger.getLogger(ClosedWorkloadVariation.class);

    private ClosedWorkload workload;

    @Override
    public void setVariedObject(final EObject o) {
        if (!UsageScenario.class.isInstance(o)) {
            throw new RuntimeException("Expected a UsageScenario, but encountered a " + o.getClass().getName());
        }
        final UsageScenario s = (UsageScenario) o;

        if (!ClosedWorkload.class.isInstance(s.getWorkload_UsageScenario())) {
            throw new RuntimeException("Expected a UsageScenario containing a ClosedWorkload, but encountered a "
                    + s.getWorkload_UsageScenario().getClass().getName());
        }
        this.workload = (ClosedWorkload) s.getWorkload_UsageScenario();
    }

    @Override
    public String vary(final long value) {
        final int intValue;
        if (value > Integer.MAX_VALUE) {
            LOGGER.warn("Warning: Converted long to int, but the value was larger than MAXINT.");
            intValue = Integer.MAX_VALUE;
        } else {
            intValue = new Long(value).intValue();
        }
        this.workload.setPopulation(intValue);

        return "Closed workload population = " + value + ": " + this.workload.eClass().getName() + " of "
                + PCMModelHelper.toString(this.workload.getUsageScenario_Workload());
    }

}
