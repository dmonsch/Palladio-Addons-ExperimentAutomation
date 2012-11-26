package de.uka.ipd.sdq.experimentautomation.application.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Utils {

    /**
     * Creates a zip-archive containing the specified <code>sourceFolder</code>.
     * 
     * (Source: http://www.lalitmehta.com/home/wp-content/uploads/2007/09/zipfile.txt)
     * 
     */
    public static void zipFolder(final File sourceFolder, final File destinationFile) {
        try {

            // create ZipOutputStream object
            final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destinationFile));

            // get path prefix so that the zip file does not contain the whole path
            // eg. if folder to be zipped is /home/lalit/test
            // the zip file when opened will have test folder and not home/lalit/test folder
            final int len = sourceFolder.getAbsolutePath().lastIndexOf(File.separator);
            final String baseName = sourceFolder.getAbsolutePath().substring(0, len + 1);

            addFolderToZip(sourceFolder, out, baseName);

            out.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uploads the specified <code>sourceFile</code> file via FTP.
     */
    public static void ftpUpload(final String hostName, final String user, final String password,
            final File sourceFile, final String destinationFileName) {
        final FTPClient ftp = new FTPClient();
        InputStream in = null;
        try {
            ftp.connect(hostName);
            ftp.login(user, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory("/httpdocs");

            final int reply = ftp.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {
                System.out.println("FTP connection established");
                in = new FileInputStream(sourceFile);

                ftp.storeFile(destinationFileName, in);
            }

            ftp.logout();
        } catch (final SocketException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Source: http://www.lalitmehta.com/home/wp-content/uploads/2007/09/zipfile.txt
     */
    private static void addFolderToZip(final File folder, final ZipOutputStream zip, final String baseName)
            throws IOException {
        final File[] files = folder.listFiles();
        for (final File file : files) {
            if (file.isDirectory()) {
                addFolderToZip(file, zip, baseName);
            } else {
                final String name = file.getAbsolutePath().substring(baseName.length());
                final ZipEntry zipEntry = new ZipEntry(name);
                zip.putNextEntry(zipEntry);
                IOUtils.copy(new FileInputStream(file), zip);
                zip.closeEntry();
            }
        }
    }

}
