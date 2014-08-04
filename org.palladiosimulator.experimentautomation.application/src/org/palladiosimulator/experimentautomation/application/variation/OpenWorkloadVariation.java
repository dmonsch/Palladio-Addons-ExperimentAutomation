package org.palladiosimulator.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.experimentautomation.application.utils.PCMModelHelper;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

public class OpenWorkloadVariation implements IVariationStrategy {

    private OpenWorkload workload;

    @Override
    public void setVariedObject(final EObject o) {
        if (!UsageScenario.class.isInstance(o)) {
            throw new RuntimeException("Expected a UsageScenario, but encountered a " + o.getClass().getName());
        }
        final UsageScenario s = (UsageScenario) o;

        if (!OpenWorkload.class.isInstance(s.getWorkload_UsageScenario())) {
            throw new RuntimeException("Expected a UsageScenario containing an OpenWorkload, but encountered a "
                    + s.getWorkload_UsageScenario().getClass().getName());
        }
        this.workload = (OpenWorkload) s.getWorkload_UsageScenario();
    }

    @Override
    public String vary(final long value) {
        // int intValue;
        // if (value > Integer.MAX_VALUE) {
        // LOGGER.warn("Warning: Converted long to int, but the value was larger than MAXINT.");
        // intValue = Integer.MAX_VALUE;
        // } else {
        // intValue = new Long(value).intValue();
        // }
        final PCMRandomVariable var = CoreFactory.eINSTANCE.createPCMRandomVariable();
        // var.setOpenWorkload_PCMRandomVariable(workload);
        var.setSpecification(new Long(value).toString());
        this.workload.setInterArrivalTime_OpenWorkload(var);

        return "Open workload interarrival time = " + value + ": " + this.workload.eClass().getName() + " of "
                + PCMModelHelper.toString(this.workload.getUsageScenario_Workload());
    }

}
