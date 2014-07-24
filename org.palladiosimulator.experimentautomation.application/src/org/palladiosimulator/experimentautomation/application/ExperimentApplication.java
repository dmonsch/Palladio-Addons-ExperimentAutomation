package org.palladiosimulator.experimentautomation.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.palladiosimulator.experimentautomation.application.config.ExperimentAutomationConfiguration;
import org.palladiosimulator.experimentautomation.application.jobs.RunExperimentAutomationJob;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Main entry point to the experiment automation application. By implementing the
 * {@link IApplication} interface, this class can serve as a stand-alone application.
 * 
 * In the field "Program arguments", provide two additional arguments as shown in the example:
 * <code>-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl}
 * -consoleLog D:\models\my.experiments D:\models\pcm.variation</code>
 * 
 * The first argument is the path to your configuration model (.experiments extension). The second
 * argument is the path to the predefined pcm.variation file.
 * 
 * An optional third argument allows to list experiment IDs (separated by ";"). This list serves as
 * a filter; only listed experiments are conducted (instead of all experiments of the experiment
 * repository).
 * 
 * @author Merkle, Sebastian Lehrig
 */
public class ExperimentApplication implements IApplication {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object start(final IApplicationContext context) throws Exception {
        // obtain command line arguments
        final String[] args = (String[]) context.getArguments().get("application.args");

        // check arguments
        if (args.length < 2) {
            System.out.println("The mandatory parameters have not been specified.");
            return IApplication.EXIT_OK;
        }

        // prepare experiment list, if parameter has been specified
        final List<String> experimentIds = new ArrayList<String>();
        if (args.length >= 3) {
            final String[] ids = args[2].split(";");
            for (final String id : ids) {
                experimentIds.add(id);
            }
        }

        // load configuration
        final Bundle bundle = Activator.getDefault().getBundle();
        final Path experimentsLocation = new Path(args[0]);
        final Path variationsLocation = new Path(args[1]);
        final ExperimentAutomationConfiguration config = new ExperimentAutomationConfiguration(bundle,
                experimentsLocation, variationsLocation, experimentIds);

        // run experiments via blackboard-based workflow
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(
                new RunExperimentAutomationJob(config.getFilteredExperiments()), blackboard);
        workflow.run();

        return IApplication.EXIT_OK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        // nothing to do
    }

}
