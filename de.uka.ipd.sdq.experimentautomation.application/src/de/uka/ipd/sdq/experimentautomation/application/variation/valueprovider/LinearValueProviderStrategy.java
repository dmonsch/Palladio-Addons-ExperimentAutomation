package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;

public class LinearValueProviderStrategy implements IValueProviderStrategy {

    private final LinearValueProvider specification;

    public LinearValueProviderStrategy(final LinearValueProvider specification) {
        this.specification = specification;
    }

    @Override
    public long valueAtPosition(final int position) {
        return (long) (this.specification.getFactor() * position + this.specification.getSummand());
    }
}
