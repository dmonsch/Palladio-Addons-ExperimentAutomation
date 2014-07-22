package org.palladiosimulator.experimentautomation.application.tooladapter.simucom.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class LogExperimentInformationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(LogExperimentInformationJob.class);
    
    final private SimuComConfig simuComConfig;

    public LogExperimentInformationJob(final SimuComConfig simuComConfig) {
        this.simuComConfig = simuComConfig;
    }

    /**
     * TODO How to enable logging? [Lehrig]
     */
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        //if(LOGGER.isInfoEnabled()) {
            final StringBuilder stringBuilder = new StringBuilder(); 
            
            stringBuilder.append("Conducting Experiment: \"");
            stringBuilder.append(this.simuComConfig.getNameBase()); // Experiment name
            stringBuilder.append("\" [");
            stringBuilder.append(this.simuComConfig.getSimulatorId());
            stringBuilder.append("; ");
            stringBuilder.append(this.simuComConfig.getRecorderName());
            stringBuilder.append("]");
            
            System.out.println(stringBuilder.toString());
            
            //LOGGER.info(stringBuilder.toString());
        //}

        super.execute(monitor);
    }
}
