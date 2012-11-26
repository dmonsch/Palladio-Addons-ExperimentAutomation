package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class JMXSimulationListener implements IResponseMeasurement {

    private final ExperimentBookkeeping bookkeeping;
    private final List<Long> variationValues;
    private final URI variationFolderUri;
    private final int pollingPeriod;

    private final Timer timer;
    private final ThreadMonitor threadMonitor;

    public JMXSimulationListener(final ExperimentBookkeeping bookkeeping, final List<Long> variationValues,
            final URI variationFolderUri, final int pollingPeriod) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
        this.variationFolderUri = variationFolderUri;
        this.pollingPeriod = pollingPeriod;

        this.timer = new Timer();
        this.threadMonitor = new ThreadMonitor();
    }

    @Override
    public void prepareBookkeeping(final ExperimentBookkeeping bookeeping, final String[] factorNames) {
        this.bookkeeping.prepareResultFile(new String[] { "InitialThreads", "MeanThreads", "MaxThreads",
                "InitialMemory", "MeanMemory", "MaxMemory", "SampleCount" }, factorNames);
    }

    @Override
    public void simulationStart() {
        System.gc();
        this.threadMonitor.resetStatistics();
        this.timer.scheduleAtFixedRate(this.threadMonitor, 50, this.pollingPeriod);
    }

    @Override
    public void simulationStop() {
        this.threadMonitor.cancel();

        final String initialThreads = Integer.toString(this.threadMonitor.getInitialThreadCount());
        final String maxThreads = Integer.toString(this.threadMonitor.getMaxThreadCount());
        final String meanThreads = Integer.toString(this.threadMonitor.getMeanThreadCount());

        final String initialMemory = Long.toString(this.threadMonitor.getInitialMemory());
        final String maxMemory = Long.toString(this.threadMonitor.getMaxMemory());
        final String meanMemory = Double.toString(this.threadMonitor.getMeanMemory());

        final String sampleCount = Integer.toString(this.threadMonitor.getSampleCount());

        final String[] factorLevels = new String[this.variationValues.size()];
        for (int i = 0; i < this.variationValues.size(); i++) {
            factorLevels[i] = this.variationValues.get(i).toString();
        }
        this.bookkeeping.addResult(new String[] { initialThreads, meanThreads, maxThreads, initialMemory, meanMemory,
                maxMemory, sampleCount }, factorLevels);
    }

    private class ThreadMonitor extends TimerTask {

        private final ThreadMXBean threadBean;
        private int initialThreads;
        private int maxThreads;
        private long sumThreads;
        private int countThreads;

        private final MemoryMXBean memoryBean;
        private long initialMemory;
        private long maxMemory;
        private final Mean meanMemory;

        public ThreadMonitor() {
            this.threadBean = ManagementFactory.getThreadMXBean();
            this.memoryBean = ManagementFactory.getMemoryMXBean();
            this.meanMemory = new Mean();
        }

        @Override
        public void run() {
            // Threads
            final int threads = this.threadBean.getThreadCount();
            if (threads > this.maxThreads) {
                this.maxThreads = threads;
            }
            this.sumThreads += threads;
            this.countThreads++;

            // Memory
            final long memory = this.memoryBean.getHeapMemoryUsage().getUsed();
            if (memory > this.maxMemory) {
                this.maxMemory = memory;
            }
            this.meanMemory.increment(memory);
        }

        public void resetStatistics() {
            this.maxThreads = 0;
            this.sumThreads = 0;
            this.countThreads = 0;
            this.initialThreads = this.threadBean.getThreadCount();

            this.maxMemory = 0;
            this.meanMemory.clear();
            this.initialMemory = this.memoryBean.getHeapMemoryUsage().getUsed();
        }

        public int getMeanThreadCount() {
            return (int) (this.sumThreads / this.countThreads);
        }

        public int getMaxThreadCount() {
            return this.maxThreads;
        }

        public int getInitialThreadCount() {
            return this.initialThreads;
        }

        public int getSampleCount() {
            return this.countThreads;
        }

        public long getInitialMemory() {
            return this.initialMemory;
        }

        public long getMaxMemory() {
            return this.maxMemory;
        }

        public double getMeanMemory() {
            return this.meanMemory.getResult();
        }

    }

}
