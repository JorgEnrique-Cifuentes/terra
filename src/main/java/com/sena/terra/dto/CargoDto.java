/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

/**
 *
 * @author Usuario
 */
public class CargoDto {

    private int idCARGO;
    private String nombre;
    
    /**
     * @return the idCARGO
     */
    public int getIdCARGO() {
        return idCARGO;
    }

    /**
     * @param idCARGO the idCARGO to set
     */
    public void setIdCARGO(int idCARGO) {
        this.idCARGO = idCARGO;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
