package com.sena.terra.bean;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.dto.CargoDto;
import com.sena.terra.dto.ParametrizacionDto;
import com.sena.terra.dto.SolicitudDto;
import com.sena.terra.interfaces.ICargoDao;
import com.sena.terra.interfaces.IParametrizacionDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import com.sena.terra.interfaces.ISolicitudDao;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.MessageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Usuario
 */
@Named(value = "solicitudMb")
@ViewScoped
public class SolicitudMb implements Serializable {

    @Inject
    private ICargoDao cargoDao;

    @Inject
    private ISolicitudDao solicitud;

    @Inject
    private IParametrizacionDao iParametrizacionDao;

    private SolicitudDto solicitudDto;
    private List<CargoDto> listaCargos;
    private List<SolicitudDto> listaSolicitudes;
    private List<SolicitudDto> filter;

    /**
     * Creates a new instance of SolicitudMb
     */
    public SolicitudMb() {
        super();
    }

    @PostConstruct
    public void init() {
        solicitudDto = new SolicitudDto();
        solicitudDto.setCargoDto(new CargoDto());
        listaCargos = cargoDao.listaCargos();
        listaSolicitudes = solicitud.listaSolicitudes();
        filter = listaSolicitudes;
    }

    public void guardar() {
        this.solicitudDto.setEstado(Constant.NUEVA);
        solicitud.guardar(this.solicitudDto);
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
        JsfUtility.reloadPage();

    }

    public void clean() {
        if (this.getSolicitudDto().getIdSOLICITUD() == Constant.ZERO) {
            this.setSolicitudDto(new SolicitudDto());
            this.getSolicitudDto().setCargoDto(new CargoDto());
        } else {
            this.getSolicitudDto().setCantidadVacantes(Constant.ZERO);
            this.getSolicitudDto().setCargoDto(new CargoDto());
            this.getSolicitudDto().setDescripcion(null);
            this.getSolicitudDto().setIdLugarTrabajo(0);
        }
    }

    public void uploadFile(final FileUploadEvent fileUploadEvent) throws IOException {
        final File tempFile = File.createTempFile("plantilla_solicitud", ".xlsx");
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(fileUploadEvent.getFile().getInputStream(), out);
        }
        final FileInputStream fileInputStream = new FileInputStream(tempFile);
        final XSSFWorkbook fWorkbook = new XSSFWorkbook(fileInputStream);
        final XSSFSheet sheet = fWorkbook.getSheetAt(Constant.ZERO);
        SolicitudDto solicitudDto = null;
        final StringBuilder builder = new StringBuilder();
        for (final Row row : sheet) {
            solicitudDto = new SolicitudDto();
            if (row.getRowNum() != Constant.ZERO) {
                if (row.getCell(Constant.ZERO).getStringCellValue() != null
                        && !row.getCell(Constant.ZERO).getStringCellValue().isEmpty()) {
                    solicitudDto.setDescripcion(row.getCell(Constant.ZERO).getStringCellValue());
                } else {
                    builder.append("La descripción es obligatoria fila (")
                            .append(row.getRowNum() + 1).append(")")
                            .append(" columna ")
                            .append(row.getCell(Constant.ZERO).getColumnIndex() + 1);
                }
                if (row.getCell(Constant.ONE).getStringCellValue() != null
                        && !row.getCell(Constant.ONE).getStringCellValue().isEmpty()) {
                    final CargoDto cargoDto = cargoDao.obtenerCargo(row.getCell(Constant.ONE).getStringCellValue());
                    if (cargoDto != null) {
                        solicitudDto.setCargoDto(cargoDto);
                    } else {
                        builder.append("El cargo no existe fila (")
                                .append(row.getRowNum() + 1).append(")")
                                .append(" columna ")
                                .append(row.getCell(Constant.ONE).getColumnIndex() + 1);
                    }
                } else {
                    builder.append("El cargo es obligatorio fila (")
                            .append(row.getRowNum() + 1).append(")")
                            .append(" columna ")
                            .append(row.getCell(Constant.ONE).getColumnIndex() + 1);
                }
                if (row.getCell(Constant.TWO).getStringCellValue() != null
                        && !row.getCell(Constant.TWO).getStringCellValue().isEmpty()) {
                    final ParametrizacionDto parametrizacionDto = iParametrizacionDao
                            .obtenerCiudad(row.getCell(Constant.TWO).getStringCellValue());
                    if (parametrizacionDto != null) {
                        solicitudDto.setIdLugarTrabajo(parametrizacionDto.getId());
                    } else {
                        builder.append("La ciudad no existe fila (")
                                .append(row.getRowNum() + 1).append(")")
                                .append(" columna ")
                                .append(row.getCell(Constant.TWO).getColumnIndex() + 1);
                    }
                } else {
                    builder.append("La ciudad es obligatorio fila (")
                            .append(row.getRowNum() + 1).append(")")
                            .append(" columna ")
                            .append(row.getCell(Constant.TWO).getColumnIndex() + 1);
                }
                if (row.getCell(Constant.THREE).getNumericCellValue() > 0) {
                    final Double vacantes = row.getCell(Constant.THREE).getNumericCellValue();
                    solicitudDto.setCantidadVacantes(vacantes.intValue());
                } else {
                    builder.append("El número de vacantes no puede ser 0 fila (")
                            .append(row.getRowNum() + 1).append(")")
                            .append(" columna ")
                            .append(row.getCell(Constant.THREE).getColumnIndex() + 1);
                }
                solicitudDto.setEstado("NUEVA");
                solicitud.guardar(solicitudDto);
            }
        }
        MessageUtil.addMessageInfo(
                "Exitoso", "Se ha guardado correctamente");
        listaSolicitudes = solicitud.listaSolicitudes();
        filter = listaSolicitudes;
        JsfUtility.reloadPage();

    }

    public String obtenerLugarTrabajo(final int idLugarTrabajo) {
        return iParametrizacionDao.obtenerLugarTrabajo(idLugarTrabajo);
    }

    public void cleanNew() {
        this.setSolicitudDto(new SolicitudDto());
        this.getSolicitudDto().setCargoDto(new CargoDto());
    }

    public void preEditar(final SolicitudDto solicitudDto) {
        this.solicitudDto = solicitudDto;
    }

    public void delete(final SolicitudDto solicitudDto) {
        this.solicitud.delete(solicitudDto);
        MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente");
        JsfUtility.reloadPage();

    }

    public void descargar() throws FileNotFoundException, IOException {
        final String patServer = LoadTerraConfig.getInstance().findProperty("path", "path.file.plantillas");
        final String pathPlantilla = patServer.concat("plantilla_solicitud.xlsx");
        final File file = new File(pathPlantilla);
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final HttpServletResponse response
                = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.reset();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=plantilla_solicitud.xlsx");
        final OutputStream responseOutputStream = response.getOutputStream();
        InputStream fileInputStream = new FileInputStream(file);
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
        responseOutputStream.flush();
        fileInputStream.close();
        responseOutputStream.close();
        facesContext.responseComplete();
    }

    /**
     * @return the solicitudDto
     */
    public SolicitudDto getSolicitudDto() {
        return solicitudDto;
    }

    /**
     * @param solicitudDto the solicitudDto to set
     */
    public void setSolicitudDto(SolicitudDto solicitudDto) {
        this.solicitudDto = solicitudDto;
    }

    /**
     * @return the listaCargos
     */
    public List<CargoDto> getListaCargos() {
        return listaCargos;
    }

    /**
     * @param listaCargos the listaCargos to set
     */
    public void setListaCargos(List<CargoDto> listaCargos) {
        this.listaCargos = listaCargos;
    }

    /**
     * @return the listaSolicitudes
     */
    public List<SolicitudDto> getListaSolicitudes() {
        return listaSolicitudes;
    }

    /**
     * @param listaSolicitudes the listaSolicitudes to set
     */
    public void setListaSolicitudes(List<SolicitudDto> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    /**
     * @return the filter
     */
    public List<SolicitudDto> getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(List<SolicitudDto> filter) {
        this.filter = filter;
    }

}
