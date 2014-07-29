package org.palladiosimulator.experimentautomation.application;

import org.palladiosimulator.experimentautomation.experiments.Variation;

public class VariationFactorTuple {

    private final Variation variation;
    private long factor;

    public VariationFactorTuple(final Variation variation, final long factor) {
        this.variation = variation;
        this.factor = factor;
    }

    public long getFactor() {
        return this.factor;
    }

    public void setFactor(long factor) {
        this.factor = factor;
    }

    public Variation getVariation() {
        return this.variation;
    }

    @Override
    public String toString() {
        return ""+factor;
    }
    
 

}
