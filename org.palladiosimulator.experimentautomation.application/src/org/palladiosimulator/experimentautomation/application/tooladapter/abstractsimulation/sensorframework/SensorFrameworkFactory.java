package org.palladiosimulator.experimentautomation.application.tooladapter.abstractsimulation.sensorframework;

import org.eclipse.core.runtime.Path;
import org.palladiosimulator.experimentautomation.abstractsimulation.AbstractsimulationPackage;
import org.palladiosimulator.experimentautomation.abstractsimulation.Datasource;
import org.palladiosimulator.experimentautomation.abstractsimulation.FileDatasource;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class SensorFrameworkFactory {

    public static IDAOFactory createOrOpenDatasource(final Datasource datasource) {
        IDAOFactory daoFactory = null;
        if (AbstractsimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            // create MemoryDatasource
            daoFactory = SensorFrameworkFactory.createMemoryDatasource();
        } else if (AbstractsimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            // create or open FileDatasource
            final FileDatasource fileDatasource = (FileDatasource) datasource;
            final Path directory = new Path(fileDatasource.getLocation());
            daoFactory = SensorFrameworkFactory.createOrOpenFileDatasource(directory);
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }
        SensorFrameworkDataset.singleton().addDataSource(daoFactory);

        return daoFactory;
    }

    public static void closeDatasource(final Datasource datasource) {
        IDAOFactory daoFactory = null;
        if (AbstractsimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            // create MemoryDatasource
            daoFactory = SensorFrameworkFactory.createMemoryDatasource();
        } else if (AbstractsimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            // create or open FileDatasource
            final FileDatasource fileDatasource = (FileDatasource) datasource;
            final Path directory = new Path(fileDatasource.getLocation());
            daoFactory = SensorFrameworkFactory.createOrOpenFileDatasource(directory);
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }
        SensorFrameworkDataset.singleton().removeDataSource(daoFactory);
    }

    private static IDAOFactory createOrOpenFileDatasource(final Path directory) {
        final IDAOFactory fileFactory = new FileDAOFactory(directory.toOSString());

        return fileFactory;
    }

    private static IDAOFactory createMemoryDatasource() {
        return new MemoryDAOFactory("");
    }

}
