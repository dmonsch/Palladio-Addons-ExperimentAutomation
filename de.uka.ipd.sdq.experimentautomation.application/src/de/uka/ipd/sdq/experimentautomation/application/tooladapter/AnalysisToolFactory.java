package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.eventsim.EventSimToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom.SimuComToolAdapter;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComPackage;

public class AnalysisToolFactory {

    public static IToolAdapter createToolAdapater(ToolConfiguration configuration) {
        assert configuration != null : "The configuration may not be null";
        if (SimuComPackage.eINSTANCE.getSimuComConfiguration().isInstance(configuration)) {
            return new SimuComToolAdapter();
        } else if (EventSimPackage.eINSTANCE.getEventSimConfiguration().isInstance(configuration)) {
            return new EventSimToolAdapter();
        }
        throw new RuntimeException("Unknown tool configuration type: " + configuration.eClass().getName());
    }

}