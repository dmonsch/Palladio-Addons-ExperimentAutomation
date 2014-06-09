package de.uka.ipd.sdq.experimentautomation.application.utils;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.application.ConfigurationModel;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.pcm.core.entity.Entity;

public class PCMModelHelper {

    public static EObject findModelElementById(final ResourceSet resourceSet, final String id) {
        for (Resource resource : resourceSet.getResources()) {
            EObject eObject = resource.getEObject(id);
            if(eObject != null) {
                return eObject;
            }
        }
        return null;
    }

    /**
     * Creates a copy of the files referenced by the given model.
     * 
     * @param model
     * @return the locations of the copied files
     */
    private static PCMModelFiles createTemporaryCopy(final PCMModelFiles model, final URI destDirUri) {
        // create the temporary directory
        // URI tmpDirUri = createTemporaryDirectory("expaut" + System.currentTimeMillis());

        // copy model files to the temporary directory
        final String[] modelPaths = { model.getAllocationFile(), model.getRepositoryFile(),
                model.getResourceenvironmentFile(), model.getSystemFile(), model.getUsagemodelFile() };
        // PCMModel result = ExperimentsFactory.eINSTANCE.createPCMModel();
        final PCMModelFiles result = EcoreUtil.copy(model);
        for (final String path : modelPaths) {
            final File modelFile = new File(path);
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
            }
            final String fileName = modelFile.getName();
            final URI fileUri = URI.createURI(fileName);
            final URI absoluteFileUri = fileUri.resolve(destDirUri);

            // copy file
            final File inputFile = modelFile;
            final File outputFile = new File(absoluteFileUri.toFileString());
            FileHelper.copyFile(inputFile, outputFile);

            setFileLocation(result, outputFile);
        }
        return result;
    }

    public static PCMModelFiles createTemporaryCopy(final PCMModelFiles model, final Bundle bundle,
            final Path experimentsLocation, final Path variationsLocation) {
        // create the temporary directory
        final URI tmpDirUri = createTemporaryDirectory("expaut" + System.currentTimeMillis());

        // copy experiment model files to temporary directory
        final Path[] modelPaths = { experimentsLocation, variationsLocation };
        final Path[] outputPaths = new Path[2];
        for (int i = 0; i < modelPaths.length; i++) {
            final Path p = modelPaths[i];
            final File modelFile = new File(p.toOSString());
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
            }

            final String fileName = modelFile.getName();
            final URI fileUri = URI.createURI(fileName);
            final URI absoluteFileUri = fileUri.resolve(tmpDirUri);

            // copy file
            final File inputFile = modelFile;
            final File outputFile = new File(absoluteFileUri.toFileString());
            FileHelper.copyFile(inputFile, outputFile);

            outputPaths[i] = new Path(outputFile.getPath());
        }

        // copy PCM model files to temporary directory
        final ConfigurationModel config = ConfigurationModel.loadFromBundle(bundle, experimentsLocation,
                variationsLocation);
        final PCMModelFiles modelCopy = createTemporaryCopy(model, tmpDirUri);

        final ConfigurationModel result = ConfigurationModel.loadFromBundle(bundle, outputPaths[0], outputPaths[1]);
        // result.getExperiments().setInitialModel(pcmmodel);

        return modelCopy;
    }

    public static PCMModelFiles copyToExperimentFolder(final PCMModelFiles model, final Path experimentsLocation,
            final Path variationsLocation, final URI experimentFolderUri) {
        final PCMModelFiles modelCopy = copyToExperimentFolder(model, experimentFolderUri);

        // copy experiment model files to temporary directory
        final Path[] modelPaths = { experimentsLocation, variationsLocation };
        final Path[] outputPaths = new Path[2];
        for (int i = 0; i < modelPaths.length; i++) {
            final Path p = modelPaths[i];
            final File modelFile = new File(p.toOSString());
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
            }

            final String fileName = modelFile.getName();
            final URI fileUri = URI.createURI(fileName);
            final URI absoluteFileUri = fileUri.resolve(experimentFolderUri);

            // copy file
            final File inputFile = modelFile;
            final File outputFile = new File(absoluteFileUri.toFileString());
            FileHelper.copyFile(inputFile, outputFile);

            outputPaths[i] = new Path(outputFile.getPath());
        }

        return modelCopy;
    }

    public static PCMModelFiles copyToExperimentFolder(final PCMModelFiles model, final URI experimentFolderUri) {
        // create experiment folder if it does not exit yet
        final File f = new File(experimentFolderUri.toFileString());
        if (!f.exists()) {
            f.mkdir();
        }

        // copy PCM model files to temporary directory
        // ConfigurationModel config = ConfigurationModel.loadFromBundle(bundle,
        // experimentsLocation, variationsLocation);
        final PCMModelFiles modelCopy = createTemporaryCopy(model, experimentFolderUri);

        // ConfigurationModel result = ConfigurationModel.loadFromBundle(bundle, outputPaths[0],
        // outputPaths[1]);
        // result.getExperiments().setInitialModel(pcmmodel);

        return modelCopy;
    }

    private static URI createTemporaryDirectory(final String folderName) {
        final String tmpDir = System.getProperty("java.io.tmpdir");
        final File tmpDirFile = new File(tmpDir + File.separator + folderName);
        tmpDirFile.mkdir();
        final URI tmpDirUri = URI.createFileURI(tmpDirFile.getPath() + "/");
        return tmpDirUri;
    }

    private static void setFileLocation(final PCMModelFiles model, final File temporaryFile) {
        final String[] fileSegments = temporaryFile.getName().split("\\.");
        final String fileExtension = fileSegments[fileSegments.length - 1];

        if (fileExtension.equalsIgnoreCase("allocation")) {
            model.setAllocationFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("repository")) {
            model.setRepositoryFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("resourceenvironment")) {
            model.setResourceenvironmentFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("system")) {
            model.setSystemFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("usagemodel")) {
            model.setUsagemodelFile(temporaryFile.getPath());
        } else {
            throw new RuntimeException("Unexpected file extension: " + fileExtension);
        }
    }

    public static String toString(final Entity entity) {
        if (entity == null) {
            return "null";
        }
        final StringBuilder builder = new StringBuilder();
        builder.append(entity.getEntityName());
        builder.append(" <");
        builder.append(entity.eClass().getName());
        builder.append("> ");
        builder.append(" [ID: ");
        builder.append(entity.getId());
        builder.append("]");
        return builder.toString();
    }
}
