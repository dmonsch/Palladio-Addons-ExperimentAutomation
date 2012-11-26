package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class SimulationDurationSimulationListener implements IResponseMeasurement {

    private final ExperimentBookkeeping bookkeeping;

    private final List<Long> variationValues;

    private long startTime;

    public SimulationDurationSimulationListener(final ExperimentBookkeeping bookkeeping,
            final List<Long> variationValues, final URI variationFolderUri) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
    }

    @Override
    public void simulationStart() {
        System.gc();
        this.startTime = System.nanoTime();
    }

    @Override
    public void simulationStop() {
        // trigger garbage collection
        System.gc();

        final long stopTime = System.nanoTime();
        final long duration = stopTime - this.startTime;

        final String[] factorLevels = new String[this.variationValues.size()];
        for (int i = 0; i < this.variationValues.size(); i++) {
            factorLevels[i] = this.variationValues.get(i).toString();
        }
        this.bookkeeping.addResult(new String[] { new Long(duration).toString() }, factorLevels);
    }

    @Override
    public void prepareBookkeeping(final ExperimentBookkeeping bookeeping, final String[] factorNames) {
        this.bookkeeping.prepareResultFile(new String[] { "RuntimeNano" }, factorNames);
    }

}
