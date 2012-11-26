package de.uka.ipd.sdq.experimentautomation.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;

public class ExperimentBookkeeping {

    private static final Logger logger = Logger.getLogger(ExperimentApplication.class);
    private static final String METADATA_FILE = "metadata.txt";
    private static final String ERROR_LOG_FILE = "errorlog.txt";
    private static final String RESULTS_FILE = "results.csv";
    private static final String CSV_COLUMN_DELIMITER = ";";

    private final File experimentFolder;
    private PrintWriter resultWriter;
    private int columnsCount;

    /**
     * Default constructor.
     * 
     * @param folder
     *            the folder in which experiment results and metadata will be stored
     */
    public ExperimentBookkeeping(final File folder) {
        assert folder != null : "The folder may not be null";
        if (folder.exists()) {
            throw new RuntimeException("There is already a file or folder named " + folder);
        }
        this.experimentFolder = folder;

        // create folder
        logger.debug("Creating folder " + folder.getPath());
        final boolean created = folder.mkdir();
        if (!created) {
            throw new RuntimeException("Could not create folder " + folder);
        }
    }

    public void prepareResultFile(final String[] responseVariableNames, final String[] columnNames) {
        final String[] headerNames = new String[responseVariableNames.length + columnNames.length];
        for (int i = 0; i < responseVariableNames.length; i++) {
            headerNames[i] = responseVariableNames[i];
        }
        for (int i = 0; i < columnNames.length; i++) {
            headerNames[responseVariableNames.length + i] = columnNames[i];
        }

        this.columnsCount = headerNames.length;
        final URI resultFileUri = this.createExperimentFolderUri(RESULTS_FILE);
        final File resultFile = new File(resultFileUri.toFileString());
        this.resultWriter = this.createAndOpenFile(resultFile);
        for (int i = 0; i < headerNames.length; i++) {
            this.resultWriter.print(headerNames[i]);
            if (i + 1 < headerNames.length) {
                this.resultWriter.print(CSV_COLUMN_DELIMITER);
            }
        }
        this.resultWriter.println();
        this.resultWriter.flush();
    }

    public void addResult(final String responses[], final String[] factorLevels) {
        final String[] cols = new String[responses.length + factorLevels.length];
        for (int i = 0; i < responses.length; i++) {
            cols[i] = responses[i];
        }
        for (int i = 0; i < factorLevels.length; i++) {
            cols[responses.length + i] = factorLevels[i];
        }

        if (this.resultWriter == null) {
            throw new IllegalStateException("The result file needs to be initialised first");
        }
        // assert (this.columnsCount == columns.length) :
        // "The result file has been initialised with " + columnsCount
        // + " columns, but tried to write " + columns.length + " columns.";
        for (int i = 0; i < cols.length; i++) {
            this.resultWriter.print(cols[i]);
            if (i + 1 < cols.length) {
                this.resultWriter.print(CSV_COLUMN_DELIMITER);
            }
        }
        this.resultWriter.println();
        this.resultWriter.flush();
    }

    public void finishResultFile() {
        if (this.resultWriter != null) {
            this.resultWriter.close();
        }
    }

    /**
     * Copies the files referenced by the specified model to the experiment folder.
     * 
     * @param model
     *            the model whose files are to be copied
     */
    public void copyModelFilesToExperimentFolder(final PCMModelFiles model) {

    }

    /**
     * Writes the metadata to a new file in the experiment folder.
     * 
     * @param metadata
     *            the metadata which is to be stored in a newly created file
     */
    public void writeMetadata(final ExperimentMetadata metadata) {
        final URI absoluteMetadataUri = this.createExperimentFolderUri(METADATA_FILE);
        final File metadataFile = new File(absoluteMetadataUri.toFileString());
        final PrintWriter writer = this.createAndOpenFile(metadataFile);
        writer.print(metadata);
        writer.close();
    }

    public void logException(final Exception ex) {
        final URI absoluteErrorLogUri = this.createExperimentFolderUri("errorlog_" + System.currentTimeMillis()
                + ".txt");
        final File logFile = new File(absoluteErrorLogUri.toFileString());
        final PrintWriter writer = this.createAndOpenFile(logFile);
        ex.printStackTrace(writer);
        writer.close();
    }

    private URI createExperimentFolderUri(final String fileName) {
        final URI experimentFolderUri = URI.createFileURI(this.experimentFolder.getPath() + File.separator);
        final URI relativeMetadataUri = URI.createURI(fileName);
        final URI absoluteMetadataUri = relativeMetadataUri.resolve(experimentFolderUri);
        return absoluteMetadataUri;
    }

    private PrintWriter createAndOpenFile(final File file) {
        try {
            if (file.exists()) {
                throw new RuntimeException("The file " + file + " does already exists.");
            } else {
                final boolean created = file.createNewFile();
                if (!created) {
                    throw new RuntimeException("Could not create file " + file);
                }
            }
            return new PrintWriter(file);
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getExperimentFolder() {
        return this.experimentFolder;
    }

}
