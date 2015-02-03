package org.palladiosimulator.experimentautomation.application.variation.valueprovider;

import org.palladiosimulator.experimentautomation.experiments.ExponentialValueProvider;

public class ExponentialValueProviderStrategy implements IValueProviderStrategy {

    private final ExponentialValueProvider specification;

    public ExponentialValueProviderStrategy(final ExponentialValueProvider specification) {
        this.specification = specification;
    }

    @Override
    public Double valueAtPosition(final int position) {
        final double base = this.specification.getBase();
        final double result = Math.pow(base, position);
        return result;
    }

}
