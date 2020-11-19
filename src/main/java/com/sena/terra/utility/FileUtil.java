/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.dto.FileCertificationDto;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author USER
 */
public class FileUtil {

    public static FileCertificationDto getFileFromPath(final String path) {
        final File file = new File(path);
        final FileCertificationDto certificationDto = new FileCertificationDto();
        if (file.exists()) {
            final File fileCreate = new File(file.getAbsolutePath());
            certificationDto.setFileName(fileCreate.getName());
            final String mimeType = URLConnection.guessContentTypeFromName(fileCreate.getName());
            certificationDto.setContentType(mimeType);
            certificationDto.setSize(FileUtils.sizeOf(fileCreate));
            try {
                certificationDto.setInputStream(FileUtils.openInputStream(fileCreate));
                certificationDto.setContents(FileUtils.readFileToByteArray(fileCreate));
                certificationDto.setContentType(file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error " + e.getMessage());
            }
        }
        return certificationDto;
    }

    /**
     * Compare two input stream
     *
     * @param input1 the first stream
     * @param input2 the second stream
     * @return true if the streams contain the same content, or false otherwise
     * @throws IOException
     * @throws IllegalArgumentException if the stream is null
     */
    public static boolean isSame(InputStream input1,
            InputStream input2) {
        boolean error = false;
        try {
            byte[] buffer1 = new byte[1024];
            byte[] buffer2 = new byte[1024];
            try {
                int numRead1 = 0;
                int numRead2 = 0;
                while (true) {
                    numRead1 = input1.read(buffer1);
                    numRead2 = input2.read(buffer2);
                    if (numRead1 > -1) {
                        if (numRead2 != numRead1) {
                            return false;
                        }
                        // Otherwise same number of bytes read
                        if (!Arrays.equals(buffer1, buffer2)) {
                            return false;
                        }
                        // Otherwise same bytes read, so continue ...
                    } else {
                        // Nothing more in stream 1 ...
                        return numRead2 < 0;
                    }
                }
            } finally {
                input1.close();
            }
        } catch (IOException e) {
            error = true; // this error should be thrown, even if there is an error closing stream 2
        } catch (RuntimeException e) {
            error = true; // this error should be thrown, even if there is an error closing stream 2
            throw e;
        } finally {
            try {
                input2.close();
            } catch (IOException e) {
                if (!error);
            }
        }
        return false;
    }

    public static String getPathCertificaciones() {
        return LoadTerraConfig.getInstance()
                .findProperty("path",
                        "path.file.certificaciones");

    }

    public static boolean deleteDirectory(final String directory) {
        final File file = new File(directory);
        if (file.exists()) {
            try {
                for (final File fileDelete : file.listFiles()) {
                    FileDeleteStrategy.FORCE.delete(fileDelete);
                }
                return true;
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }
        return false;
    }

}
