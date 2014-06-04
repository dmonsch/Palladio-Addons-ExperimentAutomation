package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import java.util.List;

import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;

public interface IToolAdapter {

    public void runExperiment(String experimentName, PCMModelFiles model, ToolConfiguration configuration,
            List<StopCondition> stopConditions) throws Exception;

}
