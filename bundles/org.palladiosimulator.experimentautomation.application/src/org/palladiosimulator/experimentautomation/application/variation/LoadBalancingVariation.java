package org.palladiosimulator.experimentautomation.application.variation;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

public class LoadBalancingVariation implements IVariationStrategy<Long> {

    private BasicComponent loadBalancer;
    private static final Logger LOGGER = Logger.getLogger(LoadBalancingVariation.class);

    @Override
    public void setVariedObject(EObject o) {
        if (!BasicComponent.class.isInstance(o)) {
            throw new RuntimeException("Expected a BasicComponent, but encountered a " + o.getClass().getName());
        }
        loadBalancer = (BasicComponent) o;
    }

    @Override
    public String vary(Long value) {
        String semaphoreResult = adjustSemaphore(value);
        String branchProbresult = adjustBranchProbabilities(value);
        return semaphoreResult + "\n" + branchProbresult;
    }

    private String adjustSemaphore(long value) {
        PassiveResource semaphore = getFirstPassiveResource(loadBalancer);
        semaphore.getCapacity_PassiveResource().setSpecification(Double.toString(value));

        return "Parameter value of " + semaphore.eClass().getName() + "'" + semaphore.getEntityName() + "' = " + value
                + ": ";
    }

    private PassiveResource getFirstPassiveResource(BasicComponent loadBalancer) {
        return loadBalancer.getPassiveResource_BasicComponent().get(0);

    }

    private String adjustBranchProbabilities(long value) {
        double branchProbability = 1.0 / value;

        List<ServiceEffectSpecification> seffs = loadBalancer.getServiceEffectSpecifications__BasicComponent();
        for (ServiceEffectSpecification serviceEffectSpecification : seffs) {

            BranchAction branch = getBranchAction(serviceEffectSpecification);
            LOGGER.debug("Number of branches: " + branch.getBranches_Branch().size() + ", new BranchProbability: "
                    + branchProbability);

            for (int i = 0; i < branch.getBranches_Branch().size(); i++) {

                AbstractBranchTransition t = branch.getBranches_Branch().get(i);
                if (!(t instanceof ProbabilisticBranchTransition)) {
                    throw new RuntimeException("ProbabilisticBranchTransition expected. Found "
                            + t.getClass().getName());
                }

                ProbabilisticBranchTransition pTrans = (ProbabilisticBranchTransition) t;
                if (i < value) {
                    pTrans.setBranchProbability(branchProbability);
                } else {
                    pTrans.setBranchProbability(0.0);
                }
            }
        }

        return "Branch probabilities of BranchActions within SEFFs" + seffs.toString() + " adjusted.";
    }

    private BranchAction getBranchAction(ServiceEffectSpecification seff) {
        ResourceDemandingSEFF rdSeff = (ResourceDemandingSEFF) seff;
        List<AbstractAction> setps = rdSeff.getSteps_Behaviour();
        for (AbstractAction abstractAction : setps) {
            if (abstractAction instanceof BranchAction) {
                return (BranchAction) abstractAction;
            }
        }
        return null;
    }

}
