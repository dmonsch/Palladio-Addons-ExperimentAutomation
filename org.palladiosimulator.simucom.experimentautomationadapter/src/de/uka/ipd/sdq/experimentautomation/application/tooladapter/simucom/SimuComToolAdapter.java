package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.palladiosimulator.simucom.simucomtooladapter.SimuComConfiguration;
import org.palladiosimulator.simucom.simucomtooladapter.SimucomtooladapterPackage;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class SimuComToolAdapter implements IToolAdapter {

    @Override
    public void runExperiment(final String experimentName, final PCMModelFiles model,
            final ToolConfiguration configuration, final List<StopCondition> stopConditions) throws CoreException {
        final SimuComConfiguration simuComConfiguration = (SimuComConfiguration) configuration;

        // create simulation configuration
        final SimuComConfig simuComConfig = SimuComConfigFactory.createConfig(simuComConfiguration, stopConditions,
                model, experimentName);

        // create workflow configuration
        final SimuComWorkflowConfiguration workflowConfig = SimuComWorkflowConfigurationFactory
                .createWorkflowConfiguration(simuComConfiguration, model, simuComConfig);

        // run simulation
        final SimuComJob run = new SimuComJob(workflowConfig, null);
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(run,
                blackboard);
        workflow.run();

        // clean up
        final PersistenceFramework persistenceFramework = simuComConfiguration.getPersistenceFramework();
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            final SensorFramework sensorFramework = (SensorFramework) persistenceFramework;
            final SensorFrameworkDatasource datasource = sensorFramework.getDatasource();

            SensorFrameworkFactory.closeDatasource(datasource);
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            // For EDP2, nothing to do!
            
            
//            final EDP2 edp2 = (EDP2) persistenceFramework;
//            final Repository repository = edp2.getRepository();
//
//            try {
//                MeasurementsUtility.ensureClosedRepository(repository);
//            } catch (DataNotAccessibleException e) {
//                throw new RuntimeException("Unable to write to EDP2 repository: " + e);
//            }
        } else {
            throw new IllegalArgumentException("Tried to clean up unknown persistency framework");
        }
    }

    @Override
    public boolean hasSupportFor(ToolConfiguration configuration) {
        return SimucomtooladapterPackage.eINSTANCE.getSimuComConfiguration().isInstance(configuration);
    }

}
