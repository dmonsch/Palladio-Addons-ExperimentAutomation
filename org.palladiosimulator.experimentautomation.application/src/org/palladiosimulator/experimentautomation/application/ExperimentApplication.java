package org.palladiosimulator.experimentautomation.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.palladiosimulator.experimentautomation.application.jobs.RunExperimentAutomationJob;
import org.palladiosimulator.experimentautomation.application.utils.EcoreHelper;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.experimentautomation.experiments.ExperimentRepository;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Main entry point to the experiment automation application. By implementing the
 * {@link IApplication} interface, this class can serve as a stand-alone application.
 * 
 * In the field "Program arguments", provide an additional argument as shown in this example:
 * <code>-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl}
 * -consoleLog D:\models\my.experiments</code>
 * 
 * This argument is the path to your configuration model (.experiments extension).
 * 
 * An optional second argument allows to list experiment IDs (separated by ";"). This list serves as
 * a filter; only listed experiments are conducted (instead of all experiments of the experiment
 * repository).
 * 
 * Once the experiments are finished, you will find all data in the EDP2 recorder.
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
        if (args.length < 1) {
            System.out.println("The mandatory parameters have not been specified.");
            return IApplication.EXIT_OK;
        }

        // get location of experiments file
        final Path experimentsLocation = new Path(args[0]);

        // prepare filtered experiment list, if parameter has been specified
        final List<String> filteredExperimentIDs = new ArrayList<String>();
        if (args.length >= 2) {
            final String[] ids = args[1].split(";");
            for (final String id : ids) {
                filteredExperimentIDs.add(id);
            }
        }

        // load experiments
        final List<Experiment> experiments = getExperiments(experimentsLocation, filteredExperimentIDs);

        // run experiments via blackboard-based workflow
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(
                new RunExperimentAutomationJob(experiments), blackboard);
        workflow.run();

        return IApplication.EXIT_OK;
    }

    private static List<Experiment> getExperiments(final IPath experimentsLocation,
            final List<String> filteredExperimentIDs) {
        final Bundle bundle = Activator.getDefault().getBundle();
        final ResourceSet resourceSet = new ResourceSetImpl();
        final EClass expectedType = ExperimentsPackage.eINSTANCE.getExperimentRepository();
        final ExperimentRepository experimentRepository = (ExperimentRepository) EcoreHelper.loadResourceFromBundle(
                resourceSet, bundle, experimentsLocation, expectedType);

        final List<Experiment> experiments;
        if (filteredExperimentIDs == null || filteredExperimentIDs.isEmpty()) {
            // experiments as in config
            experiments = experimentRepository.getExperiments();
        } else {
            // filter experiment list
            experiments = new ArrayList<Experiment>();
            for (final Experiment e : experimentRepository.getExperiments()) {
                for (final String id : filteredExperimentIDs) {
                    if (e.getId().equalsIgnoreCase(id)) {
                        experiments.add(e);
                        break;
                    }
                }
            }
        }

        return experiments;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        // nothing to do
    }

}
