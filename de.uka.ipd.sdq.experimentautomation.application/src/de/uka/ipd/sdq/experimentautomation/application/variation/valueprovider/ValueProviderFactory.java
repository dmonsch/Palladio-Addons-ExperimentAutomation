package org.palladiosimulator.experimentautomation.application.variation.valueprovider;

import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.ExponentialValueProvider;
import org.palladiosimulator.experimentautomation.experiments.LinearValueProvider;
import org.palladiosimulator.experimentautomation.experiments.PolynomialValueProvider;
import org.palladiosimulator.experimentautomation.experiments.SetValueProvider;
import org.palladiosimulator.experimentautomation.experiments.ValueProvider;

public class ValueProviderFactory {

    public static IValueProviderStrategy createValueProvider(final ValueProvider specification) {
        if (ExperimentsPackage.eINSTANCE.getPolynomialValueProvider().isInstance(specification)) {
            final PolynomialValueProvider p = (PolynomialValueProvider) specification;
            return new PolynomialValueProviderStrategy(p);
        } else if (ExperimentsPackage.eINSTANCE.getExponentialValueProvider().isInstance(specification)) {
            final ExponentialValueProvider p = (ExponentialValueProvider) specification;
            return new ExponentialValueProviderStrategy(p);
        } else if (ExperimentsPackage.eINSTANCE.getSetValueProvider().isInstance(specification)) {
            final SetValueProvider p = (SetValueProvider) specification;
            return new SetValueProviderStrategy(p);
        } else if (ExperimentsPackage.eINSTANCE.getLinearValueProvider().isInstance(specification)) {
            final LinearValueProvider p = (LinearValueProvider) specification;
            return new LinearValueProviderStrategy(p);
        }
        throw new RuntimeException("Could not find a value provider strategy for " + specification.eClass().getName());
    }

}
