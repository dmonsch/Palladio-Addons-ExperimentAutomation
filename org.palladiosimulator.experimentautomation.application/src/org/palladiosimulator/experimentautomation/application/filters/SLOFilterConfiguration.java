package org.palladiosimulator.experimentautomation.application.filters;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.edp2.datastream.configurable.reflective.ConfigurationProperty;
import org.palladiosimulator.edp2.datastream.configurable.reflective.ReflectivePropertyConfigurable;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;
import org.palladiosimulator.servicelevelobjective.ServicelevelObjectiveFactory;

public class SLOFilterConfiguration extends ReflectivePropertyConfigurable {

    public static final String SLO_KEY = "serviceLevelObjective";
    public static final ServiceLevelObjective EMPTY_SLO = ServicelevelObjectiveFactory.eINSTANCE.createServiceLevelObjective();

    @ConfigurationProperty(description = "Service Level Objective (SLO)")
    private ServiceLevelObjective serviceLevelObjective;

    public ServiceLevelObjective getServiceLevelObjective() {
        return this.serviceLevelObjective;
    }

    @Override
    public Map<String, Object> getDefaultConfiguration() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put(SLO_KEY, EMPTY_SLO);
        return result;
    }
}
