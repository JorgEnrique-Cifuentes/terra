package com.sena.terra.bean;

import com.sena.terra.dto.CargoDto;
import com.sena.terra.dto.ContratacionDto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import com.sena.terra.interfaces.IContratacionDao;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.MessageUtil;

/**
 *
 * @author Usuario
 */
@Named(value = "contratacionMb")
@ViewScoped
public class ContratacionMb implements Serializable {

    @Inject
    private IContratacionDao contratacion;

    private ContratacionDto contratacionDto;
    private List<CargoDto> listaCargos;
    private List<ContratacionDto> listaSolicitudes;
    private List<ContratacionDto> filter;

    private boolean isForm;

    /**
     * Creates a new instance of ContratacionMb
     */
    public ContratacionMb() {
        super();
    }

    public void guardar() {
        this.contratacionDto.setEstado(Constant.NUEVA);
        contratacion.guardar(this.contratacionDto);
        listaSolicitudes = contratacion.listaContratacion();
        filter = listaSolicitudes;
        isForm = Boolean.FALSE;
        MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
    }

    public void clean() {
        if (this.getContratacionDto().getIdCONTRATACION() == Constant.ZERO) {
            this.setContratacionDto(new ContratacionDto());
            this.getContratacionDto().setCargoDto(new CargoDto());
        } else {
            this.getContratacionDto().setCantidadVacantes(Constant.ZERO);
            this.getContratacionDto().setCargoDto(new CargoDto());
            this.getContratacionDto().setDescripcion(null);
            this.getContratacionDto().setLugarTrabajo(null);
        }
        this.isForm = Boolean.FALSE;
    }

    public void cleanNew() {
        this.setContratacionDto(new ContratacionDto());
        this.getContratacionDto().setCargoDto(new CargoDto());
        this.isForm = Boolean.TRUE;
    }

    public void preEditar(final ContratacionDto contratacionDto) {
        this.contratacionDto = contratacionDto;
        this.isForm = Boolean.TRUE;
    }

    public void delete(final ContratacionDto contratacionDto) {
        this.contratacion.delete(contratacionDto);
        this.listaSolicitudes = contratacion.listaContratacion();
        filter = listaSolicitudes;
        MessageUtil.addMessageInfo("Exitoso", "Se ha eliminado correctamente");
    }

    /**
     * @return the solicitudDto
     */
    public ContratacionDto getContratacionDto() {
        return contratacionDto;
    }

    /**
     * @param contratacionDto the contratacionDto to set
     */
    public void setContratacionDto(ContratacionDto contratacionDto) {
        this.contratacionDto = contratacionDto;
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
     * @return the listaContratatcion
     */
    public List<ContratacionDto> getListaContratacion() {
        return listaSolicitudes;
    }

    /**
     * @param listaContratacion the listaContratacion to set
     */
    public void setListaContratacion(List<ContratacionDto> listaContratacion) {
        this.listaSolicitudes = listaContratacion;
    }

    /**
     * @return the isForm
     */
    public boolean isIsForm() {
        return isForm;
    }

    /**
     * @param isForm the isForm to set
     */
    public void setIsForm(boolean isForm) {
        this.isForm = isForm;
    }

    /**
     * @return the filter
     */
    public List<ContratacionDto> getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(List<ContratacionDto> filter) {
        this.filter = filter;
    }

}