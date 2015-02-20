package org.palladiosimulator.experimentautomation.application.variation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class SystemCallActionParameterVariation implements IVariationStrategy<Double> {

    private static final Object SEARCH_STRING = "records";
    private VariableUsage variedParameter = null;

    @Override
    public void setVariedObject(EObject o) {
        if (!EntryLevelSystemCall.class.isInstance(o)) {
            throw new RuntimeException("Expected a EntryLevelSystemCall, but encountered a " + o.getClass().getName());
        }

        EntryLevelSystemCall call = (EntryLevelSystemCall) o;
        variedParameter = getRecordSizeVariable(call);
    }

    private VariableUsage getRecordSizeVariable(EntryLevelSystemCall call) {
        List<VariableUsage> parameterUsages = call.getInputParameterUsages_EntryLevelSystemCall();
        for (VariableUsage variableUsage : parameterUsages) {
            return variableUsage;
        }
        return null;
    }

    @Override
    public String vary(Double value) {

        PCMRandomVariable newValue = CoreFactory.eINSTANCE.createPCMRandomVariable();
        newValue.setSpecification(Double.toString(value));
        this.variedParameter.getVariableCharacterisation_VariableUsage().get(0)
                .setSpecification_VariableCharacterisation(newValue);

        return "Parameter value of '" + SEARCH_STRING + "' = " + value + ": " + this.variedParameter.eClass().getName();
    }

}
