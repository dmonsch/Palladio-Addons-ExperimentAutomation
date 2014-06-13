package de.uka.ipd.sdq.experimentautomation.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.application.config.ExperimentAutomationConfiguration;
import de.uka.ipd.sdq.experimentautomation.application.controller.ExperimentController;

public class ExperimentApplication implements IApplication {
    
    @Override
    public Object start(final IApplicationContext context) throws Exception {
        // obtain command line arguments
        final String[] args = (String[]) context.getArguments().get("application.args");

        // check arguments
        if (args.length < 3) {
            System.out.println("The mandatory parameters have not been specified.");
            return IApplication.EXIT_OK;
        }

        // prepare experiment list, if parameter has been specified
        final List<String> experimentIds = new ArrayList<String>();
        if (args.length >= 4) {
            final String[] ids = args[3].split(";");
            for (final String id : ids) {
                experimentIds.add(id);
            }
        }

        // load configuration
        final Bundle bundle = Activator.getDefault().getBundle();
        final Path experimentsLocation = new Path(args[0]);
        final Path variationsLocation = new Path(args[1]);
        final ExperimentAutomationConfiguration config = new ExperimentAutomationConfiguration(bundle, experimentsLocation, variationsLocation, experimentIds);

        // run experiments
        final ExperimentController controller = new ExperimentController(config);
        controller.runExperiments();
        
        return IApplication.EXIT_OK;
    }

    @Override
    public void stop() {
        // nothing to do
    }

}
