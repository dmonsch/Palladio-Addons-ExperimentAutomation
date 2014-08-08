package org.palladiosimulator.experimentautomation.application.filters;

import java.util.List;

import javax.measure.Measure;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.measurementframework.Measurement;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

/**
 * Filter for SLO violations.
 * 
 * @author Sebastian Lehrig
 */
public class SLOFilter extends AbstractFilter {

    private final ServiceLevelObjective serviceLevelObjective;

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
    }

    /**
     * Determines whether an SLO violations occurred for the given SLO member variable and for the
     * given measurement. For instance, a response time tuple (10s, 5s) would be an SLO violation if
     * the SLO specifies a threshold of 3s.
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
    @Override
    protected boolean shouldSkip(Measurement measurement) {
        final List<Measure<?, ?>> measures = measurement.asList();

        if (serviceLevelObjective.getLowerThreshold() != null) {
            final Measure lowerThreshold = serviceLevelObjective.getLowerThreshold().getThresholdLimit();
            if (measures.get(1).compareTo(lowerThreshold) < 0) {
                return false;
            }
        }

        if (serviceLevelObjective.getUpperThreshold() != null) {
            final Measure upperThreshold = serviceLevelObjective.getUpperThreshold().getThresholdLimit();
            if (measures.get(1).compareTo(upperThreshold) > 0) {
                return false;
            }
        }

        return true;
    }

}
