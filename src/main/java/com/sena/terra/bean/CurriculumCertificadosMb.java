/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.bean;

import com.sena.terra.dto.FileCertificationDto;
import com.sena.terra.utility.FileUtil;
import com.sena.terra.utility.MessageUtil;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author USER
 */
@Named
@SessionScoped
public class CurriculumCertificadosMb implements Serializable {

    private List<FileCertificationDto> listaArchivos;
    private String identificacion;

    @PostConstruct
    public void init() {
        listaArchivos = new ArrayList<>();
    }

    public void uploadFile(final FileUploadEvent certificado) {
        final FileCertificationDto dto = constructor(certificado.getFile());
        final String pathServer = FileUtil.getPathCertificaciones();
        final String pathUser = pathServer.concat(this.identificacion);
        final File fileUser = new File(pathUser);
        try {
            if (!fileUser.exists()) {
                FileUtils.forceMkdir(fileUser);
            }
            final File saveFile = new File(pathUser.concat("/")
                    .concat(dto.getFileName()));
            FileUtils.copyInputStreamToFile(dto.getInputStream(), saveFile);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }

        listaArchivos.add(dto);
        MessageUtil.addMessageInfo("Exitoso", "Se ha subido la "
                + "certificación correctamente");
    }

    public void loadCertificaciones(final String identificacion) {
        this.identificacion = identificacion;
        listaArchivos.clear();
        final List<FileCertificationDto> listFiles = new ArrayList<>();
        final String pathServer = FileUtil.getPathCertificaciones();
        final String pathUser = pathServer.concat(identificacion);
        final File fileUser = new File(pathUser);
        if (fileUser.exists()) {
            if (fileUser.listFiles() != null
                    && fileUser.listFiles().length > 0) {
                for (final File file : fileUser.listFiles()) {
                    listFiles.add(constructorArchivos(file));
                }
                listaArchivos.addAll(listFiles);
            }
        }
    }

    public void eliminar(final FileCertificationDto fcd, final int index) {
        final String pathServer = FileUtil.getPathCertificaciones();
        final String pathUser = pathServer.concat(this.identificacion);
        final File fileUser = new File(pathUser.concat("/").concat(fcd.getFileName()));
        try {
            FileUtils.forceDelete(fileUser);
            MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente");
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }

    }

    private FileCertificationDto constructorArchivos(final File file) {
        final FileCertificationDto certificationDto = new FileCertificationDto();
        certificationDto.setFileName(file.getName());
        final String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        certificationDto.setContentType(mimeType);
        certificationDto.setSize(FileUtils.sizeOf(file));
        try {
            certificationDto.setInputStream(FileUtils.openInputStream(file));
            certificationDto.setContents(FileUtils.readFileToByteArray(file));
            certificationDto.setContentType(file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return certificationDto;
    }

    private FileCertificationDto constructor(final UploadedFile uploadedFile) {
        final Random rand = new Random();
        final FileCertificationDto certificationDto = new FileCertificationDto();
        certificationDto.setFileName("Certificado" + rand.nextInt(500000) + ".pdf");
        certificationDto.setContentType(uploadedFile.getContentType());
        certificationDto.setContents(uploadedFile.getContent());
        try {
            certificationDto.setInputStream(uploadedFile.getInputStream());
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        certificationDto.setSize(uploadedFile.getSize());
        return certificationDto;
    }

    /**
     * @return the listaArchivos
     */
    public List<FileCertificationDto> getListaArchivos() {
        return listaArchivos;
    }

    /**
     * @param listaArchivos the listaArchivos to set
     */
    public void setListaArchivos(List<FileCertificationDto> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

}
