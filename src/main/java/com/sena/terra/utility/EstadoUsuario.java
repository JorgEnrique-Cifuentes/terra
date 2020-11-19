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
public enum EstadoUsuario {

    CAMBIO_CONTRASENA("Cambio de contraseña"),
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private final String descripcion;

    private EstadoUsuario(final String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

}
