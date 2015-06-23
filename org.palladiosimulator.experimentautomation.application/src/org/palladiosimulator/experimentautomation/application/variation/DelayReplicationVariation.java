package org.palladiosimulator.experimentautomation.application.variation;

//package org.palladiosimulator.experimentautomation.application.variation;
//
//import org.palladiosimulator.pcm.core.CoreFactory;
//import org.palladiosimulator.pcm.core.PCMRandomVariable;
//import org.palladiosimulator.pcm.usagemodel.Delay;
//import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
//
//public class DelayReplicationVariation extends AbstractUserActionReplicationVariation<Delay> {
//
//    @Override
//    public Delay replicate(Delay action) {
//        Delay replica = UsagemodelFactory.eINSTANCE.createDelay();
//        replica.setEntityName(action.getEntityName());
//        replica.setScenarioBehaviour_AbstractUserAction(action.getScenarioBehaviour_AbstractUserAction());
//        replica.setTimeSpecification_Delay(replicate(action.getTimeSpecification_Delay()));
//        return replica;
//    }
//    
//    public PCMRandomVariable replicate(PCMRandomVariable variable) {
//        PCMRandomVariable replica = CoreFactory.eINSTANCE.createPCMRandomVariable();
//        replica.setSpecification(variable.getSpecification());
//        return replica;
//    }
//
// }
