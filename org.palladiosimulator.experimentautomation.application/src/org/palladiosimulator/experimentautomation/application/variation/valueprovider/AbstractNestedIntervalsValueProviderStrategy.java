package org.palladiosimulator.experimentautomation.application.variation.valueprovider;


abstract public class AbstractNestedIntervalsValueProviderStrategy<RETURN_TYPE> implements
        IValueProviderStrategy<RETURN_TYPE> {

    protected boolean converged;

    public AbstractNestedIntervalsValueProviderStrategy() {
        this.converged = false;
    }

    abstract public void setMin(final RETURN_TYPE min);

    abstract public void setMax(final RETURN_TYPE max);

    public boolean isConverged() {
        return this.converged;
    }

}
