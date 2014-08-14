package org.palladiosimulator.experimentautomation.application.filters;

import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.datastream.AbstractDataSource;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.edp2.visualization.wizards.IFilterWizard;
import org.palladiosimulator.edp2.visualization.wizards.SelectFilterPage;

public class SLOFilterWizard extends Wizard implements IFilterWizard {

    private final AbstractFilter filter = null;
    private AbstractDataSource abstractDataSource;

    @Override
    public AbstractFilter getFilter() {
        if (this.filter == null) {
            throw new RuntimeException("SLO filter was not initialized");
        }
        
        return this.filter;
    }

    @Override
    public void setSourceFromCaller(AbstractDataSource source, SelectFilterPage selectFilterPage) {
        this.abstractDataSource = source;
    }

    @Override
    public boolean performFinish() {
        return true;
    }
    
    

}
