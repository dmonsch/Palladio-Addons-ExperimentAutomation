package org.palladiosimulator.experimentautomation.application.jobs;

import java.util.List;

import javax.measure.unit.Unit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.edp2.dao.exception.DataNotAccessibleException;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractSimulationConfiguration;
import org.palladiosimulator.experimentautomation.abstractsimulation.EDP2Datasource;
import org.palladiosimulator.experimentautomation.application.VariationFactorTuple;
import org.palladiosimulator.experimentautomation.experiments.Experiment;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.utils.MultipleRunsConfidenceStopCondition;

import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.IConfidenceEstimator;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Repeats the given experiment for a given tool and a given set of variations.
 * 
 * @author Sebastian Lehrig
 */
public class RepeatExperimentJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

	private static final Logger LOGGER = Logger.getLogger(RepeatExperimentJob.class);

	private EDP2Datasource datasoruce;

	/** mean of the observations and the corresponding confidence interval */
	private ConfidenceInterval confidence;

	private boolean confidenceReached = false;

	private IBatchAlgorithm batchAlgorithm;

	private IConfidenceEstimator estimator;

	private double confidenceLevel;

	private double halfWidth;

	private int minBatches;
	
	private Experiment experiment;
	private AbstractSimulationConfiguration simulationConfiguration;
	private List<VariationFactorTuple> variationFactorTuples;

	/**
	 * Default Constructor.
	 * 
	 * @param experiment
	 *            the experiment to be conducted.
	 * @param simulationConfiguration
	 *            the given analysis tool, e.g., SimuCom.
	 * @param variationFactorTuples
	 *            the variations and according value factors.
	 */
	public RepeatExperimentJob(final Experiment experiment,
			final AbstractSimulationConfiguration simulationConfiguration,
			final List<VariationFactorTuple> variationFactorTuples) {
		super(false);

		datasoruce = simulationConfiguration.getDatasource();
		this.batchAlgorithm = new PhiMixingBatchAlgorithm();
		this.estimator = new SampleMeanEstimator();
		// TODO: Decide about real values here.
		this.confidenceLevel = 0.5;
		this.halfWidth = 0.5;
		this.minBatches = 0;
		this.experiment = experiment;
		this.simulationConfiguration = simulationConfiguration;
		this.variationFactorTuples = variationFactorTuples; 
		this.add(new RunExperimentJob(experiment, simulationConfiguration, variationFactorTuples, 1));

	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		do {
			super.execute(monitor);
			analyzeLastExperimentsReconfigurationTimes();
			this.add(new RunExperimentJob(experiment, simulationConfiguration, variationFactorTuples, 1));
		} while (!confidenceReached);
	}

	private void analyzeLastExperimentsReconfigurationTimes() {
		final Repository repository = getEDP2Repository(datasoruce.getId());
		final ExperimentGroup experimentGroup = getExperimentGroup(repository, "SimuLizar Load Balancer []");
		ExperimentSetting experimentSetting = getExperimentSetting(experimentGroup,
				"Variation [] [EDP2 SimuLizar Configuration]");
		final int lastExperiment = experimentSetting.getExperimentRuns().size() - 1;
		final ExperimentRun experimentRun = experimentSetting.getExperimentRuns().get(lastExperiment);
		for (Measurement measurement : experimentRun.getMeasurement()) {
			if (measurement.getMeasuringType().getMetric()
					.equals(MetricDescriptionConstants.RECONFIGURATION_TIME_METRIC_TUPLE)) {
				for (MeasurementRange measurementRange : measurement.getMeasurementRanges()) {
					Long startTime = (Long) measurementRange.getStartTime().getValue();
					Long endTime = (Long) measurementRange.getEndTime().getValue();
					Long reconfigurationTime = endTime - startTime;
					computeConfidenceInterval(reconfigurationTime);
				}
			}
		}
	}

	private void computeConfidenceInterval(double sample) {
		batchAlgorithm.offerSample(sample);
		if (batchAlgorithm.hasValidBatches() && batchAlgorithm.getBatchMeans().size() >= minBatches) {
			// estimate actual confidence interval
			final ConfidenceInterval ci = estimator.estimateConfidence(batchAlgorithm.getBatchMeans(), confidenceLevel);

			if (ci != null) {
				// construct target confidence interval
				final ConfidenceInterval targetCI = new ConfidenceInterval(ci.getMean(), halfWidth, confidenceLevel);

				if (targetCI.contains(ci)) {
					if (LOGGER.isEnabledFor(Level.INFO)) {
						LOGGER.info("Requested confidence reached.");
					}
					confidenceReached = true;
					this.confidence = ci;

					// request another batch in order to proceed with improving
					// confidence interval's half-width until the simulation
					// actually stops.
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				} else {
					if (LOGGER.isEnabledFor(Level.INFO)) {
						LOGGER.info("Requested confidence not yet reached.");
					}

					// request another batch in order to reduce the confidence
					// interval's half-width
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				}
				if (LOGGER.isEnabledFor(Level.INFO)) {
					LOGGER.info("Current confidence interval: Mean " + ci.getMean() + ", " + confidenceLevel * 100
							+ "% Confidence Interval " + "[" + ci.getLowerBound() + "," + ci.getUpperBound() + "]");
				}
			}
		}
	}

	/**
	 * Returns the EDP2 repository containing measurements from the last
	 * analysis run.
	 * 
	 * @param edp2datasourceID
	 *            the EDP2 datasource ID to get measurements from.
	 * @return the EDP2 repository.
	 */
	private Repository getEDP2Repository(final String edp2datasourceID) {
		final Repository repository = RepositoryManager.getRepositoryFromUUID(edp2datasourceID);

		if (repository == null) {
			throw new RuntimeException("Could not determine datasource type. This should not have happened.");
		}

		try {
			MeasurementsUtility.ensureOpenRepository(repository);
		} catch (DataNotAccessibleException e) {
			throw new RuntimeException("Could not open EDP2 repository");
		}

		return repository;
	}

	/**
	 * Returns an experiment group object from the given repository, based on
	 * the experiment group purpose member variable.
	 * 
	 * @param repository
	 *            the repository containing the experiment group.
	 * @param purpose
	 *            the unique name of an experiment run; used to identify the
	 *            experiment group of the last analysis run.
	 * @return the experiment group of interest.
	 */
	private ExperimentGroup getExperimentGroup(final Repository repository, final String purpose) {
		for (final ExperimentGroup experimentGroup : repository.getExperimentGroups()) {
			if (experimentGroup.getPurpose().equals(purpose)) {
				return experimentGroup;
			}
		}

		throw new IllegalArgumentException("Could not find experiment group with purpose \"" + purpose + "\"");
	}

	/**
	 * Returns the experiment setting from the given experiment group that is
	 * identified by the unique experiment setting description string.
	 * 
	 * @param experimentGroup
	 *            the experiment group to be investigated.
	 * @param experimentSettingDescription
	 *            the unique experiment setting description identifier.
	 * @return the experiment setting whose description matches the given
	 *         identifier string.
	 */
	private ExperimentSetting getExperimentSetting(final ExperimentGroup experimentGroup,
			final String experimentSettingDescription) {
		for (final ExperimentSetting expSetting : experimentGroup.getExperimentSettings()) {
			if (expSetting.getDescription().equals(experimentSettingDescription)) {
				return expSetting;
			}
		}

		throw new IllegalArgumentException("Could not find experiment setting for variation \""
				+ experimentSettingDescription + "\"");
	}

}
