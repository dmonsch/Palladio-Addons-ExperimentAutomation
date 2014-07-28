package org.palladiosimulator.experimentautomation.application.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.PersistenceFramework;
import org.palladiosimulator.experimentautomation.abstractsimulation.SensorFramework;
import org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class CleanUpRecorderJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private final PersistenceFramework persistenceFramework;

    public CleanUpRecorderJob(final PersistenceFramework persistenceFramework) {
        this.persistenceFramework = persistenceFramework;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        if (AbstractsimulationPackage.eINSTANCE.getSensorFramework().isInstance(this.persistenceFramework)) {
            final SensorFramework sensorFramework = (SensorFramework) this.persistenceFramework;
            final Datasource datasource = sensorFramework.getDatasource();

            SensorFrameworkFactory.closeDatasource(datasource);
        } else if (!AbstractsimulationPackage.eINSTANCE.getEDP2().isInstance(this.persistenceFramework)) {
            // For EDP2, nothing to do!
            throw new IllegalArgumentException("Tried to clean up unknown persistency framework");
        }

        super.execute(monitor);
    }
}
