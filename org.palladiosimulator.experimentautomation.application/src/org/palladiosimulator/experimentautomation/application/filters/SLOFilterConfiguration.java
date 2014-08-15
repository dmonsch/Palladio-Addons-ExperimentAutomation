package org.palladiosimulator.experimentautomation.application.filters;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.edp2.datastream.configurable.reflective.ConfigurationProperty;
import org.palladiosimulator.edp2.datastream.configurable.reflective.ReflectivePropertyConfigurable;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

public class SLOFilterConfiguration extends ReflectivePropertyConfigurable {

    public static final String SLO_KEY = "SLO";

    @ConfigurationProperty(description = "Service Level Objective (SLO)")
    private ServiceLevelObjective serviceLevelObjective;

    public ServiceLevelObjective getServiceLevelObjective() {
        return this.serviceLevelObjective;
    }

    @Override
    public Map<String, Object> getDefaultConfiguration() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put(SLO_KEY, null);
        return result;
    }
}
