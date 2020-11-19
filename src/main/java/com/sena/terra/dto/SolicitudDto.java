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
public class SolicitudDto {

    private int idSOLICITUD;
    private String estado;
    private String descripcion;
    private int idLugarTrabajo;
    private int cantidadVacantes;
    private String numeroRadicado;
    private CargoDto cargoDto;

    /**
     * @return the idSOLICITUD
     */
    public int getIdSOLICITUD() {
        return idSOLICITUD;
    }

    /**
     * @param idSOLICITUD the idSOLICITUD to set
     */
    public void setIdSOLICITUD(int idSOLICITUD) {
        this.idSOLICITUD = idSOLICITUD;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidadVacantes
     */
    public int getCantidadVacantes() {
        return cantidadVacantes;
    }

    /**
     * @param cantidadVacantes the cantidadVacantes to set
     */
    public void setCantidadVacantes(int cantidadVacantes) {
        this.cantidadVacantes = cantidadVacantes;
    }

    /**
     * @return the numeroRadicado
     */
    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    /**
     * @param numeroRadicado the numeroRadicado to set
     */
    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    /**
     * @return the cargoDto
     */
    public CargoDto getCargoDto() {
        return cargoDto;
    }

    /**
     * @param cargoDto the cargoDto to set
     */
    public void setCargoDto(CargoDto cargoDto) {
        this.cargoDto = cargoDto;
    }
    
      /**
     * @return the idLugarTrabajo
     */
    public int getIdLugarTrabajo() {
        return idLugarTrabajo;
    }

    /**
     * @param idLugarTrabajo the idLugarTrabajo to set
     */
    public void setIdLugarTrabajo(int idLugarTrabajo) {
        this.idLugarTrabajo = idLugarTrabajo;
    }

}
