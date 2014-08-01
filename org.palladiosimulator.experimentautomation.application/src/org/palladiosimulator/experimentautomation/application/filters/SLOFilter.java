package org.palladiosimulator.experimentautomation.application.filters;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.measurementframework.Measurement;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

/**
 * Filter for SLO violations over time. Additionally counts the SLO violations so far detected.
 * 
 * @author Sebastian Lehrig
 */
public class SLOFilter extends AbstractFilter {

    private final ServiceLevelObjective serviceLevelObjective;

    private long sloViolations;

    /**
     * Default constructor.
     * 
     * @param datasource
     *            the data source as needed by the parent class.
     * @param serviceLevelObjective
     *            the SLO to check for.
     */
    public SLOFilter(final IDataSource datasource, final ServiceLevelObjective serviceLevelObjective) {
        super(datasource, serviceLevelObjective.getMetricDescription());

        this.serviceLevelObjective = serviceLevelObjective;
        this.sloViolations = 0;
    }

    /**
     * Computes SLO violations over time for the given SLO member variable and of the given
     * measurement. For instance, a response time tuple (10s, 5s) would be an SLO violation if the
     * SLO specifies a threshold of 3s.
     * 
     * TODO This method assumes that (1) measurement tuples come in and (2) SLOs are checked against
     * the second tuple element (see example above). The SLO metamodel needs extensions to get rid
     * of such assumptions, by making explicit whether a tuple element should be used for SLO
     * checking. [Lehrig]
     * 
     * TODO Matthias should enrich this method by fuzzy thresholds. [Lehrig]
     * 
     * {@inheritDoc}
     */
    @SuppressWarnings({
            "rawtypes", "unchecked"
    })
    @Override
    protected Measurement computeOutputFromInput(Measurement measurement) {
        final List<Measure<?, ?>> newMeasures = new ArrayList<Measure<?, ?>>(2);

        List<Measure<?, ?>> measures = measurement.asList();
        newMeasures.add(measures.get(0));

        if (serviceLevelObjective.getLowerThreshold() != null) {
            final Measure lowerThreshold = serviceLevelObjective.getLowerThreshold().getThresholdLimit();
            if (measures.get(1).compareTo(lowerThreshold) < 0) {
                this.sloViolations++;
            }
        }

        if (serviceLevelObjective.getUpperThreshold() != null) {
            final Measure upperThreshold = serviceLevelObjective.getUpperThreshold().getThresholdLimit();
            if (measures.get(1).compareTo(upperThreshold) > 0) {
                this.sloViolations++;
            }
        }

        newMeasures.add(Measure.valueOf(this.sloViolations, Dimensionless.UNIT));

        return new TupleMeasurement(MetricDescriptionConstants.NUMBER_OF_SLO_VIOLATIONS_OVER_TIME, newMeasures);
    }

    /**
     * Returns the number of SLO violations so far detected. For detecting SLO violations, this
     * filter should be applied on a data stream first.
     * 
     * @return the number of SLO violations detected so far by this filter.
     */
    public long getSloViolations() {
        return this.sloViolations;
    }

}
