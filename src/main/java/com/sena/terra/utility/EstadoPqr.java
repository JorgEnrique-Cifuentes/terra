/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

/**
 *
 * @author Usuario
 */
public enum EstadoPqr {

    ABIERTO("Abierto"),
    CERRADO("Cerrado");

    private final String descripcion;

    private EstadoPqr(final String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

}
