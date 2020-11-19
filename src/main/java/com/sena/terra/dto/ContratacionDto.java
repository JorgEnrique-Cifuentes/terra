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
public class ContratacionDto {

    private int idCONTRATACION;
    private String estado;
    private String descripcion;
    private String lugarTrabajo;
    private int cantidadVacantes;
    private String numeroRadicado;
    private CargoDto cargoDto;

    /**
     * @return the idCONTRATTACION
     */
    public int getIdCONTRATACION() {
        return idCONTRATACION;
    }

    /**
     * @param idCONTRATACION the idCONTRATACION to set
     */
    public void setIdCONTRATACION(int idCONTRATACION) {
        this.idCONTRATACION = idCONTRATACION;
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
     * @return the lugarTrabajo
     */
    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    /**
     * @param lugarTrabajo the lugarTrabajo to set
     */
    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
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

}