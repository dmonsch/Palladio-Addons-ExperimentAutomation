package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider;

public class ExponentialValueProviderStrategy implements IValueProviderStrategy {

    private final ExponentialValueProvider specification;

    public ExponentialValueProviderStrategy(final ExponentialValueProvider specification) {
        this.specification = specification;
    }

    @Override
    public long valueAtPosition(final int position) {
        final double base = this.specification.getBase();
        final double result = Math.pow(base, position);
        return new Double(result).longValue();
    }

}
