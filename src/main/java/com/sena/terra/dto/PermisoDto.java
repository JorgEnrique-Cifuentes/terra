/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

import com.sena.terra.utility.PermisoApp;

/**
 *
 * @author Usuario
 */
public class PermisoDto {

    private int idPERMISO;
    private PermisoApp nombrePermiso;
    private String descripcionPermiso;

    /**
     * @return the idPERMISO
     */
    public int getIdPERMISO() {
        return idPERMISO;
    }

    /**
     * @param idPERMISO the idPERMISO to set
     */
    public void setIdPERMISO(int idPERMISO) {
        this.idPERMISO = idPERMISO;
    }

    /**
     * @return the nombrePermiso
     */
    public PermisoApp getNombrePermiso() {
        return nombrePermiso;
    }

    /**
     * @param nombrePermiso the nombrePermiso to set
     */
    public void setNombrePermiso(PermisoApp nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    /**
     * @return the descripcionPermiso
     */
    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    /**
     * @param descripcionPermiso the descripcionPermiso to set
     */
    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

}
