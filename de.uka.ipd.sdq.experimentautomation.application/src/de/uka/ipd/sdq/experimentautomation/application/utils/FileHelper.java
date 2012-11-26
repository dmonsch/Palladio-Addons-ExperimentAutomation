package de.uka.ipd.sdq.experimentautomation.application.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Provides helper methods for file handling.
 * 
 * @author Philipp Merkle
 * 
 */
public class FileHelper {

    /**
     * Copies a file such that the target file is a duplicate of the source file.
     * 
     * @param source
     *            the source file
     * @param target
     *            the target file
     */
    public static void copyFile(final File source, final File target) {
        try {
            final FileReader in = new FileReader(source);
            final FileWriter out = new FileWriter(target);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

}
