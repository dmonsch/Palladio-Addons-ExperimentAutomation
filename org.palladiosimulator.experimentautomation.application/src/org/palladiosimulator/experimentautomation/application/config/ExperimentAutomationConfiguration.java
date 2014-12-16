package org.palladiosimulator.experimentautomation.application.config;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.experimentautomation.experiments.Experiment;

import de.uka.ipd.sdq.workflow.extension.ExtendableJobConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

public class ExperimentAutomationConfiguration extends AbstractWorkflowBasedRunConfiguration implements
        ExtendableJobConfiguration {

    private List<Experiment> experiments;

    /** The configuration of the current launch to work with. */
    private Map<String, Object> attributes;

    public void setExperiments(final List<Experiment> experiments) {
        this.experiments = experiments;
    }

    public List<Experiment> getExperiments() {
        return this.experiments;
    }

    @Override
    public String getErrorMessage() {
        // must be null; otherwise a non-empty error message will result in
        // a workflow config being considered invalid
        return null;
    }

    @Override
    public void setDefaults() {
        throw new RuntimeException("Not implemented. No defaults defined.");
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

}
