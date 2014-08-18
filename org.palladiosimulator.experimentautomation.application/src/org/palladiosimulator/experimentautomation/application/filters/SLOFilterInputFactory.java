package org.palladiosimulator.experimentautomation.application.filters;

import org.eclipse.ui.IMemento;
import org.palladiosimulator.edp2.datastream.configurable.DataSinkElementFactory;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;

public class SLOFilterInputFactory extends DataSinkElementFactory {

    public static final String FACTORY_ID = SLOFilterInputFactory.class.getCanonicalName();

    @Override
    protected IPropertyConfigurable createElementInternal(final IMemento memento) {
        return new SLOFilter();
    }

}
