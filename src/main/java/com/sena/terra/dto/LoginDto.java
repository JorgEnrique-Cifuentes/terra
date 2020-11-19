/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

import com.sena.terra.utility.Constant;
import com.sena.terra.utility.EstadoUsuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idUSUARIO;
    private String identificacion;
    private String identificacionRestablecer;
    private EstadoUsuario estado;
    private String contrasena;
    private EmpleadoDto empleadoDto;
    private List<PermisoDto> listaPermisos;

    public LoginDto() {
    }

    public LoginDto(int idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public int getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(int idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the empleadoDto
     */
    public EmpleadoDto getEmpleadoDto() {
        return empleadoDto;
    }

    /**
     * @param empleadoDto the empleadoDto to set
     */
    public void setEmpleadoDto(EmpleadoDto empleadoDto) {
        this.empleadoDto = empleadoDto;
    }

    /**
     * @return the listaPermisos
     */
    public List<PermisoDto> getListaPermisos() {
        return listaPermisos;
    }

    /**
     * @param listaPermisos the listaPermisos to set
     */
    public void setListaPermisos(List<PermisoDto> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }
    
    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
     /**
     * @return the identificacionRestablecer
     */
    public String getIdentificacionRestablecer() {
        return identificacionRestablecer;
    }

    /**
     * @param identificacionRestablecer the identificacionRestablecer to set
     */
    public void setIdentificacionRestablecer(String identificacionRestablecer) {
        this.identificacionRestablecer = identificacionRestablecer;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Login[ idUSUARIO=" + idUSUARIO + " ]";
    }

}
