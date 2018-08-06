package org.palladiosimulator.experimentautomation.application.utils;

import org.palladiosimulator.pcm.core.entity.Entity;

public class PCMModelHelper {

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
