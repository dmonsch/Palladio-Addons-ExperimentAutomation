package org.palladiosimulator.experimentautomation.application;

import org.palladiosimulator.experimentautomation.experiments.Variation;

public class VariationFactorTuple<FACTOR_TYPE> {

    private final Variation variation;
    private FACTOR_TYPE factor;

    public VariationFactorTuple(final Variation variation, final FACTOR_TYPE factor) {
        this.variation = variation;
        this.factor = factor;
    }

    public FACTOR_TYPE getFactor() {
        return this.factor;
    }

    public void setFactor(FACTOR_TYPE factor) {
        this.factor = factor;
    }

    public Variation getVariation() {
        return this.variation;
    }

    @Override
    public String toString() {
        return "" + factor;
    }

}
