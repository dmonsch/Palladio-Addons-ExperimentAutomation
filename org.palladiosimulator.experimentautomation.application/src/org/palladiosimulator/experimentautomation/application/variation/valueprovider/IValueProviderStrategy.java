package org.palladiosimulator.experimentautomation.application.variation.valueprovider;

public interface IValueProviderStrategy<RETURN_TYPE> {

    public RETURN_TYPE valueAtPosition(final int position);

}
