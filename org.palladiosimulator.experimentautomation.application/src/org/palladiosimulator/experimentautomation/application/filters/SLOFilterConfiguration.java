package org.palladiosimulator.experimentautomation.application.filters;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.edp2.datastream.configurable.reflective.ConfigurationProperty;
import org.palladiosimulator.edp2.datastream.configurable.reflective.ReflectivePropertyConfigurable;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

public class SLOFilterConfiguration extends ReflectivePropertyConfigurable {

    public static final String SLO_KEY = "serviceLevelObjective";

    @ConfigurationProperty(description = "Service Level Objective (SLO)", isUnsetable = true)
    private ServiceLevelObjective serviceLevelObjective;

    public ServiceLevelObjective getServiceLevelObjective() {
        if (isPropertyNotSet(SLO_KEY)) {
            throw new IllegalStateException("Tried to get an unset SLO");
        }
        return this.serviceLevelObjective;
    }

    @Override
    public Map<String, Object> getDefaultConfiguration() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put(SLO_KEY, getNotSetConstant());
        return result;
    }
}
