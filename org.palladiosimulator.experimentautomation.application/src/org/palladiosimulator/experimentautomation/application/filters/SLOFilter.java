package org.palladiosimulator.experimentautomation.application.filters;

import javax.measure.Measure;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistable;
import org.eclipse.ui.IPersistableElement;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjective;

/**
 * Filter for SLO violations.
 *
 * @author Sebastian Lehrig
 */
public class SLOFilter extends AbstractFilter implements IPersistable, IPersistableElement {

    public SLOFilter() {
        super(MetricDescriptionConstants.RESPONSE_TIME_METRIC_TUPLE);
        // TODO Using RT is too specific. Can we do better? [Lehrig]
    }

    /**
     * Default constructor.
     *
     * @param datasource
     *            the data source as needed by the parent class.
     */
    public SLOFilter(final IDataSource datasource) {
        super(datasource, MetricDescriptionConstants.RESPONSE_TIME_METRIC_TUPLE);
        // TODO Using a tuple is actually not intended; we should just refer to metric the SLO
        // provides; e.g., RT [Lehrig]
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
     */
    @Override
    public void saveState(final IMemento memento) {
        SLOFilterInputFactory.saveState(memento, this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IPersistableElement#getFactoryId()
     */
    @Override
    public String getFactoryId() {
        return SLOFilterInputFactory.FACTORY_ID;
    }

    /**
     * Determines whether an SLO violations occurred for the given SLO member variable and for the
     * given measurement. For instance, a response time tuple (10s, 5s) would be an SLO violation if
     * the SLO specifies a threshold of 3s.
     *
     * TODO Matthias should enrich this method by fuzzy thresholds. [Lehrig]
     *
     * {@inheritDoc}
     */
    @SuppressWarnings({
            "rawtypes", "unchecked"
    })
    @Override
    protected boolean shouldSkip(final MeasuringValue measurement) {
        if (this.getConfiguration().isPropertyNotSet(SLOFilterConfiguration.SLO_KEY)) {
            return false;
        }

        final Object propertyObject = this.getConfiguration().getProperties().get(SLOFilterConfiguration.SLO_KEY);
        if (!(propertyObject instanceof ServiceLevelObjective)) {
            throw new RuntimeException("Expected a ServiceLevelObjective for the property "
                    + SLOFilterConfiguration.SLO_KEY);
        }

        final ServiceLevelObjective serviceLevelObjective = (ServiceLevelObjective) propertyObject;
        final Measure responseTime = measurement.getMeasureForMetric(serviceLevelObjective.getMetricDescription());

        if (serviceLevelObjective.getLowerThreshold() != null) {
            final Measure lowerThreshold = serviceLevelObjective.getLowerThreshold().getThresholdLimit();
            if (responseTime.compareTo(lowerThreshold) < 0) {
                return false;
            }
        }

        if (serviceLevelObjective.getUpperThreshold() != null) {
            final Measure upperThreshold = serviceLevelObjective.getUpperThreshold().getThresholdLimit();
            if (responseTime.compareTo(upperThreshold) > 0) {
                return false;
            }
        }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.palladiosimulator.edp2.datastream.filter.AbstractAdapter#createProperties()
     */
    @Override
    protected PropertyConfigurable createProperties() {
        return new SLOFilterConfiguration();
    }
}
