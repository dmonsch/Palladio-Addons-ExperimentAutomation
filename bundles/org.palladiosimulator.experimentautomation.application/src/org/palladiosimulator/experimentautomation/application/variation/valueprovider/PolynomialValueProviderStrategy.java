package org.palladiosimulator.experimentautomation.application.variation.valueprovider;

import org.palladiosimulator.experimentautomation.experiments.PolynomialValueProvider;

public class PolynomialValueProviderStrategy implements IValueProviderStrategy<Double> {

    private final PolynomialValueProvider specification;

    public PolynomialValueProviderStrategy(final PolynomialValueProvider specification) {
        this.specification = specification;
    }

    @Override
    public Double valueAtPosition(final int position) {
        return Math.pow(position, this.specification.getExponent()) * this.specification.getFactor();
    }

}
