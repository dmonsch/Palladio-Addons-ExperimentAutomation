package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.edp2;

import java.io.File;

import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.Repository.RepositoryFactory;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource;

public class EDP2Factory {

    public static Repository createOrOpenDatasource(final Datasource datasource) {
        Repository repository = null;
        if (AbstractsimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            // create MemoryDatasource
            repository = RepositoryFactory.eINSTANCE.createLocalMemoryRepository();
        } else if (AbstractsimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            // create or open FileDatasource
            final FileDatasource fileDatasource = (FileDatasource) datasource;
            final File file = new File(fileDatasource.getLocation());
            repository = RepositoryManager.initializeLocalDirectoryRepository(file);
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }
        RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), repository);

        return repository;
    }

}
