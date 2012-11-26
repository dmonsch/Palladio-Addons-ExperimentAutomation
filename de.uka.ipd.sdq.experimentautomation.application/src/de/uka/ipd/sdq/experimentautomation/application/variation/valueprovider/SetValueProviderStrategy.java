package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider;

public class SetValueProviderStrategy implements IValueProviderStrategy {

    private final SetValueProvider specification;
    private final List<Double> values;

    public SetValueProviderStrategy(final SetValueProvider specification) {
        this.specification = specification;
        this.values = parseValueString(this.specification.getValues());
    }

    @Override
    public long valueAtPosition(final int position) {
        if (position > this.values.size() - 1) {
            return -1;
            // throw new RuntimeException("Requested the value at position " + (position + 1)
            // + ", but the set contains only " + values.size() + " values.");
        }
        return this.values.get(position).longValue();
    }

    private static List<Double> parseValueString(final String values) {
        final List<Double> result = new ArrayList<Double>();
        final StringTokenizer tokens = new StringTokenizer(values, ",");
        while (tokens.hasMoreElements()) {
            final String value = tokens.nextToken();
            final Double d = new Double(value);
            result.add(d);
        }
        return result;
    }

}
