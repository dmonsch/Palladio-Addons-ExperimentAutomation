package org.palladiosimulator.experimentautomation.application;

import org.palladiosimulator.experimentautomation.experiments.Variation;

public class VariationFactorTuple {

    private final Variation variation;
    private Double factor;

    public VariationFactorTuple(final Variation variation, final Double factor) {
        this.variation = variation;
        this.factor = factor;
    }

    public Double getFactor() {
        return this.factor;
    }

    public void setFactor(Double factor) {
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
