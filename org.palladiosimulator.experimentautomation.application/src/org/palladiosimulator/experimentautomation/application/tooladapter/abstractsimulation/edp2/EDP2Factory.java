package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.edp2;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.Repository.RepositoryFactory;
import org.palladiosimulator.edp2.models.Repository.impl.LocalDirectoryRepositoryImpl;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource;

public class EDP2Factory {

    private static Repository repository = null;

    /**
     * Loads an EDP2 repository based on the given data source.
     * 
     * FIXME The singleton repository used here is generally unsuitable. Situations when experiments
     * have different memory/file data sources cannot be realized. The current version is hacked and
     * works only in special situations. These issues should be discussed and fixed. [Lehrig]
     * 
     * @param datasource
     *            The data source to be used for loading, e.g., a memory or a file data source.
     * @return The repository corresponding to the given data source.
     */
    public static Repository createOrOpenDatasource(final Datasource datasource) {
        if (repository == null) {
            if (AbstractsimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
                // create MemoryDatasource
                repository = RepositoryFactory.eINSTANCE.createLocalMemoryRepository();
            } else if (AbstractsimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
                final LocalDirectoryRepositoryImpl ldRepository = (LocalDirectoryRepositoryImpl) RepositoryManager
                        .getRepositoryFromUUID("org.palladiosimulator.edp2.dao.localfile.dao");
                final FileDatasource fileDatasource = (FileDatasource) datasource;
                final File file = new File(fileDatasource.getLocation());
                final URI fileURI = URI.createFileURI(file.getAbsoluteFile().toString());

                if (ldRepository == null || !ldRepository.getUri().equals(fileURI.toString())) {
                    repository = RepositoryManager.initializeLocalDirectoryRepository(file);
                } else {
                    repository = ldRepository;
                }
            } else {
                throw new RuntimeException("Could not determine datasource type. This should not have happened.");
            }
            RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), repository);
        }

        return repository;
    }

}
