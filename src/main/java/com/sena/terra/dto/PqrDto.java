/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

import com.sena.terra.utility.EstadoPqr;

/**
 *
 * @author Usuario
 */
public class PqrDto {

    private int idPQR;
    private String tipoPqr;
    private String descripcion;
    private String numeroRadicado;
    private String cedula;
    private String nombreCompleto;
    private EstadoPqr estado;

    /**
     * @return the idPQR
     */
    public int getIdPQR() {
        return idPQR;
    }

    /**
     * @param idPQR the idPQR to set
     */
    public void setIdPQR(int idPQR) {
        this.idPQR = idPQR;
    }

    /**
     * @return the tipoPqr
     */
    public String getTipoPqr() {
        return tipoPqr;
    }

    /**
     * @param tipoPqr the tipoPqr to set
     */
    public void setTipoPqr(String tipoPqr) {
        this.tipoPqr = tipoPqr;
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
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the estado
     */
    public EstadoPqr getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoPqr estado) {
        this.estado = estado;
    }
}
