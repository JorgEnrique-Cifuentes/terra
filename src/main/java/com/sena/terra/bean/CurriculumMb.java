package com.sena.terra.bean;

import com.sena.terra.dto.CurriculumDto;
import com.sena.terra.dto.EstudiosRealizadosDto;
import com.sena.terra.dto.ExperienciaLaboralDto;
import com.sena.terra.dto.FileCertificationDto;
import com.sena.terra.interfaces.ICurriculumDao;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.MessageUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Usuario
 */
@Named(value = "curriculumMb")
@ViewScoped
public class CurriculumMb implements Serializable {

    @Inject
    private ICurriculumDao curriculumDao;

    private CurriculumDto curriculumDto;
    private ExperienciaLaboralDto experienciaLaboralDto;
    private EstudiosRealizadosDto estudiosRealizadosDto;

    private List<CurriculumDto> listaCurriculums;
    private List<CurriculumDto> listaCurriculumsFilter;
    private List<CurriculumDto> filter;
    private List<CurriculumDto> curriculumSeleccionados;
    private CurriculumDto curriculumSeleccionado;
    private List<CurriculumDto> curriculumSeleccionados2; 
    

    @PostConstruct
    public void init() {
        setListaCurriculums(curriculumDao.listAll());
        curriculumSeleccionados = new ArrayList<>();
        curriculumSeleccionados2 = new ArrayList<>();
        filter = this.listaCurriculums;
        
    }
    
    public void cargar(){
        CurriculumDto dos;
        List<CurriculumDto> listaCurri = new ArrayList<>();
        for(int i = 0;i <=listaCurriculums.size()-1;i++){
            dos = listaCurriculums.get(i);
            System.out.println(dos.getEstado());
            if(dos.getEstado().equals("EN PROCESO")){
                listaCurri.add(dos);
                System.out.println("000000000000000000000000000000000000000000");
            }
        }
        setListaCurriculumsFilter(listaCurri);
    }

    public void guardarExperienciaLaboral() {
        final int validateDate = this.experienciaLaboralDto.getFechaFinal()
                .compareTo(this.experienciaLaboralDto.getFechaInicial());
        if (validateDate == Constant.ZERO) {
            MessageUtil.addMessageError("Error de validación", "Las fechas no pueden ser iguales");
        } else if (validateDate == -1) {
            MessageUtil.addMessageError("Error de validación", "La fecha final no debe ser mayor a la inicial");
        } else {
            this.curriculumDto.getListaExperienciaLaboral().add(this.experienciaLaboralDto);
            this.experienciaLaboralDto = new ExperienciaLaboralDto();
            MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
            JsfUtility.hideDialog("dialogExperienciaLaboral");
        }

    }

    public void guardarEstudiosRealizados() {
        this.curriculumDto.getListaEstudiosRealizados().add(this.estudiosRealizadosDto);
        this.estudiosRealizadosDto = new EstudiosRealizadosDto();
        MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
        JsfUtility.hideDialog("dialogEstudiosRealizados");

    }

//    public void uploadFileExperiencia(final FileUploadEvent certificado) {
//        this.experienciaLaboralDto.setPathFile(constructor(certificado.getFile(), "laboral"));
//        MessageUtil.addMessageInfo("Exitoso", "Se ha subido la "
//                + "certificación correctamente");
//    }
//    public void uploadFileEstudios(final FileUploadEvent certificado) {
//        this.estudiosRealizadosDto.setPathFile(constructor(certificado.getFile(), "estudio"));
//        MessageUtil.addMessageInfo("Exitoso", "Se ha subido la "
//                + "certificación correctamente");
//    }
    private FileCertificationDto constructor(final UploadedFile uploadedFile,
            final String name) {
        final Random rand = new Random(); //instance of random class
        final FileCertificationDto certificationDto = new FileCertificationDto();
        certificationDto.setFileName(name + rand.nextInt(500000) + ".pdf");
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

//    public void deleteExperienciaLaboralFile() {
//        this.experienciaLaboralDto.setPathFile(new FileCertificationDto());
//        MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente la certificación");
//    }
//    public void deleteEstudiosFile() {
//        this.estudiosRealizadosDto.setPathFile(new FileCertificationDto());
//        MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente la certificación");
//    }
    public void clean() {
        curriculumDto = new CurriculumDto();
        curriculumDto.setListaEstudiosRealizados(new ArrayList<>());
        curriculumDto.setListaExperienciaLaboral(new ArrayList<>());
        this.experienciaLaboralDto = new ExperienciaLaboralDto();
        this.estudiosRealizadosDto = new EstudiosRealizadosDto();
    }

    public void guardar() {
        this.curriculumDao.guardar(this.curriculumDto);
        setListaCurriculums(curriculumDao.listAll());
        filter = this.listaCurriculums;
        JsfUtility.hideDialog("dialogCurriculum");
        MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
        JsfUtility.reloadPage();
    }
    
     public void guardar2() {
          
          if(curriculumSeleccionados.size()>=1){
              int i = 0;
              while(i<= curriculumSeleccionados.size()-1){
                final CurriculumDto uno;
                uno = curriculumSeleccionados.get(i);
                uno.setEstado("EN PROCESO");
                this.curriculumDto = uno; 
                System.out.println("el curriculum"+this.curriculumDto);
                this.curriculumDao.guardar(this.curriculumDto);  
                i++;
              }
              JsfUtility.reloadPageCurriculum();
          }else{
              MessageUtil.addMessageError("Error de validación", "Seleccione al menos un candidato");
          }
          
    }

    public void preEditar(final CurriculumDto curriculumDtoEdit) {
        this.curriculumDto = curriculumDtoEdit;
        this.experienciaLaboralDto = new ExperienciaLaboralDto();
        this.estudiosRealizadosDto = new EstudiosRealizadosDto();

    }

    public void delete(final CurriculumDto curriculumDto) {
        try {
            this.curriculumDto = curriculumDto;
            this.curriculumDao.delete(curriculumDto);
            this.listaCurriculums = this.curriculumDao.listAll();
            filter = listaCurriculums;
            MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente");
            JsfUtility.reloadPage();
        } catch (Exception e) {
            MessageUtil.addMessageError("¡oops!", "Error de eliminación" + e.getMessage());
        }

    }

    /**
     * Creates a new instance of CurriculumMb
     */
    public CurriculumMb() {
        super();
    }

    /**
     * @return the listaCurriculums
     */
    public List<CurriculumDto> getListaCurriculums() {
        return listaCurriculums;
    }

    /**
     * @param listaCurriculums the listaCurriculums to set
     */
    public void setListaCurriculums(List<CurriculumDto> listaCurriculums) {
        this.listaCurriculums = listaCurriculums;
    }
    
     /**
     * @return the listaCurriculums
     */
    public List<CurriculumDto> getListaCurriculumsFilter() {
        return listaCurriculumsFilter;
    }

    /**
     * @param listaCurriculums the listaCurriculums to set
     */
    public void setListaCurriculumsFilter(List<CurriculumDto> listaCurriculumsFilter) {
        this.listaCurriculumsFilter = listaCurriculumsFilter;
    }
    /**
     * @return the curriculumDto
     */
    public CurriculumDto getCurriculumDto() {
        return curriculumDto;
    }

    /**
     * @param curriculumDto the curriculumDto to set
     */
    public void setCurriculumDto(CurriculumDto curriculumDto) {
        this.curriculumDto = curriculumDto;
    }

    /**
     * @return the experienciaLaboralDto
     */
    public ExperienciaLaboralDto getExperienciaLaboralDto() {
        return experienciaLaboralDto;
    }

    /**
     * @param experienciaLaboralDto the experienciaLaboralDto to set
     */
    public void setExperienciaLaboralDto(ExperienciaLaboralDto experienciaLaboralDto) {
        this.experienciaLaboralDto = experienciaLaboralDto;
    }

    /**
     * @return the estudiosRealizadosDto
     */
    public EstudiosRealizadosDto getEstudiosRealizadosDto() {
        return estudiosRealizadosDto;
    }

    /**
     * @param estudiosRealizadosDto the estudiosRealizadosDto to set
     */
    public void setEstudiosRealizadosDto(EstudiosRealizadosDto estudiosRealizadosDto) {
        this.estudiosRealizadosDto = estudiosRealizadosDto;
    }

    /**
     * @return the filter
     */
    public List<CurriculumDto> getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(List<CurriculumDto> filter) {
        this.filter = filter;
    }

    public List<CurriculumDto> getCurriculumSeleccionados() {
        return curriculumSeleccionados;
    }

    public void setCurriculumSeleccionados(List<CurriculumDto> curriculumSeleccionados) {
        this.curriculumSeleccionados = curriculumSeleccionados;
    }

    public CurriculumDto getCurriculumSeleccionado() {
        return curriculumSeleccionado;
    }

    public void setCurriculumSeleccionado(CurriculumDto curriculumSeleccionado) {
        this.curriculumSeleccionado = curriculumSeleccionado;
    }

    public List<CurriculumDto> getCurriculumSeleccionados2() {
        return curriculumSeleccionados2;
    }

    public void setCurriculumSeleccionados2(List<CurriculumDto> curriculumSeleccionados2) {
        this.curriculumSeleccionados2 = curriculumSeleccionados2;
    }

   

}
