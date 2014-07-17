package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.simucom.simucomtooladapter.SimuComConfiguration;

import de.uka.ipd.sdq.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class CleanUpRecorderJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    final SimuComConfiguration simuComConfiguration;

    public CleanUpRecorderJob(final SimuComConfiguration simuComConfiguration) {
        this.simuComConfiguration = simuComConfiguration;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final PersistenceFramework persistenceFramework = this.simuComConfiguration.getPersistenceFramework();

        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            final SensorFramework sensorFramework = (SensorFramework) persistenceFramework;
            final SensorFrameworkDatasource datasource = sensorFramework.getDatasource();

            SensorFrameworkFactory.closeDatasource(datasource);
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            // For EDP2, nothing to do!
        } else {
            throw new IllegalArgumentException("Tried to clean up unknown persistency framework");
        }

        super.execute(monitor);
    }
}
