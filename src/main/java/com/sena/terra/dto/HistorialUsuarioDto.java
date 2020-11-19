/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class HistorialUsuarioDto {

    private int id;
    private String usuario;
    private String identificacion;
    private String rol;
    private Date fechaIngreso;
    private String ipUsuario;

    public HistorialUsuarioDto() {
    }

    public HistorialUsuarioDto(int id) {
        this.id = id;
    }

    public HistorialUsuarioDto(int id, String usuario, String identificacion,
            String rol, Date fechaIngreso, String ipUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.identificacion = identificacion;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.ipUsuario = ipUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

}
