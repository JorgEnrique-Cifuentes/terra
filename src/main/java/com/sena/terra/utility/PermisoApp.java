package com.sena.terra.utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public enum PermisoApp {

    VER_MODULO_SOLICITUD("Acceder al modulo de solicitud"),
    VER_MODULO_PQR("Acceder al modulo de pqr"),
    VER_MODULO_HV("Acceder al modulo de hoja de vida"),
    VER_MODULO_CONTRATACION("Acceder al modulo de contratación"),
    VER_MODULO_GENERAR_CERTIFICACION("Acceder al modulo de generar certificación"),
    VER_MODULO_DESPRENDIBLE("Acceder al modulo de desprendible"),
    CONSULTAR_PQR_TODAS("Consultar las todas las pqr"),
    VER_MODULO_HISTORIAL_USUARIO("Ver historial de usuario"),
    GUARDAR_MODULO_SOLICITUD("Guardar modulo solicitud"),
    VER_MODULO_PSICOTECNICAS("Acceder al modulo de pruebas psicotecnicas");

    PermisoApp(final String descripcion) {
        this.descripcion = descripcion;
    }

    private final String descripcion;

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

}
