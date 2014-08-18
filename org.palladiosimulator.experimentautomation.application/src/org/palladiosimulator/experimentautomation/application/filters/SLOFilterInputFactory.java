package org.palladiosimulator.experimentautomation.application.filters;

import org.eclipse.ui.IMemento;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;
import org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurableElementFactory;

public class SLOFilterInputFactory extends PropertyConfigurableElementFactory {

    public static final String FACTORY_ID = SLOFilterInputFactory.class.getCanonicalName();

    @Override
    protected IPropertyConfigurable createElementInternal(IMemento memento) {
        return new SLOFilterConfiguration();
    }

}
