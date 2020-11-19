/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.bean;

import com.sena.terra.dto.EmpleadoDto;
import com.sena.terra.dto.PqrDto;
import com.sena.terra.facade.SendMailService;
import com.sena.terra.interfaces.IEmpleadoDao;
import com.sena.terra.interfaces.IPqrDao;
import com.sena.terra.utility.EstadoPqr;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.MessageUtil;
import com.sena.terra.utility.PermisoApp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "seguimientoPqrMb")
@ViewScoped
public class SeguimientoPqrMb implements Serializable {

    private List<PqrDto> listaPqrDto;
    private boolean isForm;
    private List<PqrDto> filter;

    @Inject
    private IPqrDao iPqrDao;

    @Inject
    private LoginMb loginMb;

    @Inject
    private IEmpleadoDao empleadoDao;

    @EJB
    private SendMailService mailService;

    private long count;
    private String observacion;
    private PqrDto pqrDto;

    /**
     * Creates a new instance of PqrMb
     */
    public SeguimientoPqrMb() {
        super();
    }

    @PostConstruct
    public void init() {
        validarPermisoPqr();
    }

    private void validarPermisoPqr() {
        if (loginMb.validarPermiso(PermisoApp.CONSULTAR_PQR_TODAS)) {
            listaPqrDto = iPqrDao.listAll();
            this.filter = this.listaPqrDto;
        } else {
            listaPqrDto = iPqrDao.listByEmpleado(this.loginMb
                    .getLoginDto().getEmpleadoDto().getIdEMPLEADO());
            filter = listaPqrDto;
        }
        count = listaPqrDto.parallelStream()
                .filter(soli -> soli.getEstado()
                .equals(EstadoPqr.ABIERTO)).count();
    }

    public void cerrarPqr() {
        this.pqrDto.setEstado(EstadoPqr.CERRADO);
        final EmpleadoDto empleadoDto = empleadoDao
                .obtenerEmpleadoPorIdentificacion(pqrDto.getCedula());
        iPqrDao.guardar(pqrDto, empleadoDto.getIdEMPLEADO());
        mailService.mailPqr(this.pqrDto, empleadoDto, this.observacion);
        validarPermisoPqr();
        pqrDto = null;
        JsfUtility.hideDialog("dialogPqrObs");
        MessageUtil.addMessageInfo("Exito", "Se ha cerrado la Pqr correctamente");
    }

    public void preClose(final PqrDto pqrDto) {
        this.pqrDto = pqrDto;
    }

    /**
     * @return the listaPqrDto
     */
    public List<PqrDto> getListaPqrDto() {
        return listaPqrDto;
    }

    /**
     * @param listaPqrDto the listaPqrDto to set
     */
    public void setListaPqrDto(List<PqrDto> listaPqrDto) {
        this.listaPqrDto = listaPqrDto;
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
    public List<PqrDto> getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(List<PqrDto> filter) {
        this.filter = filter;
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
