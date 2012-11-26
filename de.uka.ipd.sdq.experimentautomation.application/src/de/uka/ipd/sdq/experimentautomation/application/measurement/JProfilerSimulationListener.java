package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.jprofiler.api.agent.Controller;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class JProfilerSimulationListener implements IResponseMeasurement {

    private final ExperimentBookkeeping bookkeeping;
    private final List<Long> variationValues;
    private final URI variationFolderUri;
    private long id;
    private File beforeFile;

    public JProfilerSimulationListener(final ExperimentBookkeeping bookkeeping, final List<Long> variationValues,
            final URI variationFolderUri) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
        this.variationFolderUri = variationFolderUri;
        Controller.stopAllocRecording();
        Controller.stopCallTracer();
        Controller.stopCPURecording();
        Controller.stopMethodStatsRecording();
        Controller.stopMonitorRecording();
        Controller.stopThreadProfiling();
        Controller.stopVMTelemetryRecording();
    }

    @Override
    public void simulationStart() {
        this.id = System.currentTimeMillis();
        final File resultFile = new File(this.variationFolderUri.toFileString() + this.id + "_before.jps");
        this.beforeFile = resultFile;
        System.gc();
        Controller.startVMTelemetryRecording();
        // Controller.saveSnapshot(resultFile);
    }

    @Override
    public void simulationStop() {
        final File resultFile = new File(this.variationFolderUri.toFileString() + this.id + "_after.jps");
        Controller.saveSnapshot(resultFile);
        Controller.stopVMTelemetryRecording();

        final String csvFile = this.exportSnapshotToCSV(resultFile, this.bookkeeping);
        this.save(this.extractMeasurementsFromCSV(csvFile), this.bookkeeping);
        // Connection conn = null;
        // try {
        // // conn = ConnectionFactory.getLocalConnection()
        // conn = ConnectionFactory.createSnapshotConnection(beforeFile, new
        // File("C:/Users/pmerkle/.jprofiler6/config.xml"));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        //
        // if (conn != null) {
        // Collection<ThreadInfo> threadInfo = conn.getThreadInfos();
        // for(ThreadInfo i : threadInfo) {
        // System.out.println(i.getThreadName());
        // }
        // }
    }

    private String exportSnapshotToCSV(final File snapshotFile, final ExperimentBookkeeping bookeeping) {
        // Execute JProfiler export command-line utility
        final String inputFilePath = snapshotFile.toString();
        final String outputFilePath = snapshotFile.toString().substring(0, snapshotFile.toString().length() - 4)
                + ".csv";

        String arguments = "";
        arguments = "\"" + inputFilePath + "\"" + " TelemetryThreads " + "-format=csv " + "\"" + outputFilePath + "\"";

        try {
            final String exec = "\"C:/Program Files/jprofiler6/bin/jpexport.exe\" " + arguments;
            System.out.println("Executing " + exec + "...");
            final Process p = Runtime.getRuntime().exec(exec);
            final OutputStream stdin = p.getOutputStream();
            final InputStream stderr = p.getErrorStream();
            final InputStream stdout = p.getInputStream();

            new Thread(new StdoutRunnable(stdout)).start();
            new Thread(new StderrRunnable(stderr)).start();

            p.waitFor();

            stdout.close();
            stderr.close();
            stdin.close();
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        return outputFilePath;
    }

    private Map<String, List<Double>> extractMeasurementsFromCSV(final String csvFile) {
        final Map<String, List<Double>> result = new HashMap<String, List<Double>>();
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            final int lineNumber = 0;

            // read column headers
            line = reader.readLine();
            if (line == null) {
                throw new RuntimeException("Could not read the column headers from file " + csvFile);
            }
            final String[] columHeaders = line.split(";");
            for (final String h : columHeaders) {
                result.put(h, new ArrayList<Double>());
            }

            // read column line by line
            while ((line = reader.readLine()) != null) {
                final String[] cols = line.split(";");
                for (int i = 0; i < cols.length; i++) {
                    result.get(columHeaders[i]).add(new Double(cols[i]));
                }
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void save(final Map<String, List<Double>> measurements, final ExperimentBookkeeping bookkeeping) {
        final List<Double> m = measurements.get("\"Total number of threads\"");
        final Double mean = this.calculateMean(m);
        final Double max = this.calculateMax(m);
        final String[] factorLevels = new String[this.variationValues.size()];
        for (int i = 0; i < this.variationValues.size(); i++) {
            factorLevels[i] = this.variationValues.get(i).toString();
        }
        // variationValues.toArray(factorLevels);
        bookkeeping.addResult(new String[] { mean.toString(), max.toString() }, factorLevels);
    }

    private double calculateMax(final List<Double> doubles) {
        double max = 0;
        for (final Double d : doubles) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    private double calculateMean(final List<Double> doubles) {
        final double sum = this.calculateSum(doubles);
        final int count = doubles.size();
        return sum / count;
    }

    private double calculateSum(final List<Double> doubles) {
        double sum = 0;
        for (final Double d : doubles) {
            sum += d;
        }
        return sum;
    }

    @Override
    public void prepareBookkeeping(final ExperimentBookkeeping bookeeping, final String[] factorNames) {
        this.bookkeeping.prepareResultFile(new String[] { "Mean", "Max" }, factorNames);
    }

    private class StdoutRunnable implements Runnable {

        private final InputStream stdout;

        public StdoutRunnable(final InputStream stdout) {
            this.stdout = stdout;
        }

        @Override
        public void run() {
            // Write R output to the specified file
            try {
                final BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(this.stdout));
                int x;
                while ((x = stdoutReader.read()) != -1) {
                    System.out.print(x);
                }
                stdoutReader.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private class StderrRunnable implements Runnable {

        private final InputStream stderr;

        public StderrRunnable(final InputStream stderr) {
            this.stderr = stderr;
        }

        @Override
        public void run() {
            // Write R error output to the console
            try {
                final BufferedReader r2 = new BufferedReader(new InputStreamReader(this.stderr));
                String x2;
                while ((x2 = r2.readLine()) != null) {
                    System.err.println(x2);
                }
                r2.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}
