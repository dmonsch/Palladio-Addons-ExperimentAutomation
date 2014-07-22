package org.palladiosimulator.experimentautomation.application.tooladapter.simucom.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import org.palladiosimulator.experimentautomation.application.tooladapter.simucom.model.SimuComConfiguration;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class CleanUpRecorderJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    final private SimuComConfiguration simuComConfiguration;

    public CleanUpRecorderJob(final SimuComConfiguration simuComConfiguration) {
        this.simuComConfiguration = simuComConfiguration;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final PersistenceFramework persistenceFramework = this.simuComConfiguration.getPersistenceFramework();

        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(persistenceFramework)) {
            final SensorFramework sensorFramework = (SensorFramework) persistenceFramework;
            final Datasource datasource = sensorFramework.getDatasource();

            SensorFrameworkFactory.closeDatasource(datasource);
        } else if (AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(persistenceFramework)) {
            // For EDP2, nothing to do!
        } else {
            throw new IllegalArgumentException("Tried to clean up unknown persistency framework");
        }

        super.execute(monitor);
    }
}
