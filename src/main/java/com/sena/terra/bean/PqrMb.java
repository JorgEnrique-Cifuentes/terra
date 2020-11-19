/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.bean;

import com.sena.terra.dto.PqrDto;
import com.sena.terra.interfaces.IPqrDao;
import com.sena.terra.utility.EstadoPqr;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.MessageUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "pqrMb")
@ViewScoped
public class PqrMb implements Serializable {

    private PqrDto pqrDto;

    @Inject
    private IPqrDao iPqrDao;

    @Inject
    private LoginMb loginMb;

     /**
     * Creates a new instance of PqrMb
     */
    public PqrMb() {
        super();
    }

    @PostConstruct
    public void init() {
        pqrDto = new PqrDto();
    }

//    public void preEditar(final PqrDto pqrDto) {
//        this.pqrDto = pqrDto;
//        this.isForm = Boolean.TRUE;
//    }
//
//    public void delete(final PqrDto pqrDto) {
//        this.iPqrDao.delete(pqrDto.getId());
//        validarPermisoPqr();
//        MessageControl.addMessageInfo("Exitoso", "Se ha eliminado correctamente");
//    }
    public void guardar() {
        this.pqrDto.setEstado(EstadoPqr.ABIERTO);
        iPqrDao.guardar(this.pqrDto,
                loginMb.getLoginDto().getEmpleadoDto().getIdEMPLEADO());
        JsfUtility.hideDialog("dialogPqr");
        MessageUtil.addMessageInfo("Exitoso", "Se ha guardado correctamente");
        this.pqrDto = new PqrDto();
    }

    /**
     * @return the pqrDto
     */
    public PqrDto getPqrDto() {
        return pqrDto;
    }

    /**
     * @param pqrDto the pqrDto to set
     */
    public void setPqrDto(PqrDto pqrDto) {
        this.pqrDto = pqrDto;
    }

}
