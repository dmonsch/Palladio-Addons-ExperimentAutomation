package org.palladiosimulator.experimentautomation.application.variation.valueprovider;

import org.palladiosimulator.experimentautomation.experiments.NestedIntervalsValueProvider;

public class NestedIntervalsValueProviderStrategy implements IValueProviderStrategy {

    private long min;
    private long middle;
    private long max;
    private boolean converged;

    public NestedIntervalsValueProviderStrategy(final NestedIntervalsValueProvider specification) {
        this.min = specification.getMinValue();
        this.max = specification.getMaxValue();
        this.converged = false;

        this.middle = this.min;
    }

    @Override
    public long valueAtPosition(final int position) {
        if (position != 0) {
            return -1; // Only position 0 is supported
        }

        return this.middle;
    }

    public void setMin(final long min) {
        if (min < this.min) {
            throw new IllegalArgumentException("New interval has to be nested in original interval");
        }
        
        if (this.min == this.middle && this.middle != this.max) {
            this.middle = this.max;
            this.min = min;
        } else {
            this.min = min;
            calculateMiddle();
        }

        if (this.min == this.max) {
            this.converged = true;
        } else if (this.min == this.middle) {
            this.middle++;
        }
    }

    public void setMax(final long max) {
        if (max > this.max) {
            throw new IllegalArgumentException("New interval has to be nested in original interval");
        }

        this.max = max;
        calculateMiddle();

        if (this.min == this.max) {
            this.converged = true;
        }
    }    

    public boolean isConverged() {
        return this.converged;
    }

    private void calculateMiddle() {
        this.middle = (this.min + this.max) / 2L;
    }
    
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Capacity Interval: [");
        stringBuilder.append(this.min);
        stringBuilder.append(", ");
        stringBuilder.append(this.max);
        stringBuilder.append("]");
        
        return stringBuilder.toString();
    }

}
