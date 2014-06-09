package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import java.util.List;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

public interface IToolAdapter {

    public void runExperiment(final String experimentName, final PCMModelFiles model,
            final ToolConfiguration configuration, final List<StopCondition> stopConditions) throws Exception;

    public boolean hasSupportFor(final ToolConfiguration configuration);
}
