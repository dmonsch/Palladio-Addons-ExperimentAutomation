package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

public class AnalysisToolFactory {

    public static IToolAdapter createToolAdapater(final ToolConfiguration configuration) {
        assert configuration != null : "The configuration may not be null";

        if (Platform.getExtensionRegistry() != null) {
            try {
                final IConfigurationElement[] adapterExtensions = Platform.getExtensionRegistry()
                        .getConfigurationElementsFor("de.uka.ipd.sdq.experimentautomation.application.tooladapter");
                for (final IConfigurationElement e : adapterExtensions) {
                    try {
                        IToolAdapter toolAdapter = (IToolAdapter) e.createExecutableExtension("class");
                        if (toolAdapter != null && toolAdapter.hasSupportFor(configuration)) {
                            return toolAdapter;
                        }
                    } catch (final CoreException e1) {
                        throw new RuntimeException();
                    }
                }
            } catch (final Exception e) {
                throw new RuntimeException("Could not load tool adapter from extension point: " + e);
            }
        }

        throw new IllegalArgumentException("Unknown tool configuration type: " + configuration.eClass().getName());
    }
}
