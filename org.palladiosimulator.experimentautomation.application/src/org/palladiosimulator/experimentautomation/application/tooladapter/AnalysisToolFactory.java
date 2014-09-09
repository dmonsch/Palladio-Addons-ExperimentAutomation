package org.palladiosimulator.experimentautomation.application.tooladapter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.palladiosimulator.experimentautomation.experiments.ToolConfiguration;

/**
 * Creates an analysis tool adapter object by getting it from an extension point.
 * 
 * TODO ExtensionHelper should optimally be used. However, ExtensionHelper seems to miss some
 * advanced filtering options as used here. Java 1.8 Lambda expressions could help. [Lehrig]
 * 
 * @author Sebastian Lehrig
 */
public class AnalysisToolFactory {

    /**
     * Creates a tool adapter by creating an executable extension based from an extension.
     * 
     * @param configuration
     *            the tool configuration stating which tool shall be created.
     * @return the created tool adapter.
     */
    public static IToolAdapter createToolAdapater(final ToolConfiguration configuration) {
        assert configuration != null : "The configuration may not be null";

        if (Platform.getExtensionRegistry() != null) {
            try {
                final IConfigurationElement[] adapterExtensions = Platform.getExtensionRegistry()
                        .getConfigurationElementsFor(
                                "org.palladiosimulator.experimentautomation.application.tooladapter");
                for (final IConfigurationElement e : adapterExtensions) {
                    try {
                        final IToolAdapter toolAdapter = (IToolAdapter) e.createExecutableExtension("class");
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
