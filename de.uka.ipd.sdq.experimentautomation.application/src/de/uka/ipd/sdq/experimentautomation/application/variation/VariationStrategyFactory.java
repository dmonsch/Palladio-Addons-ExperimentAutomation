package de.uka.ipd.sdq.experimentautomation.application.variation;

import de.uka.ipd.sdq.experimentautomation.variation.VariationType;

public class VariationStrategyFactory {

    public static IVariationStrategy createStrategy(final VariationType type) {
        assert type != null : "The variation type may not be null";
        final String className = type.getStrategyClass();

        Object o = null;
        try {
            o = Class.forName(className).newInstance();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!IVariationStrategy.class.isInstance(o)) {
            throw new RuntimeException("Expected a class implementing " + IVariationStrategy.class.getName());
        }

        return (IVariationStrategy) o;
    }

}
