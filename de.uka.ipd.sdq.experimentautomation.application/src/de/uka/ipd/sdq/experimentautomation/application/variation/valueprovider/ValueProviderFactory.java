package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider;
import de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider;

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
