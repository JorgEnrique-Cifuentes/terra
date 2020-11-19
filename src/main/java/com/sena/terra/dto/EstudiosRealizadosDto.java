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
public class EstudiosRealizadosDto {

    private int id;
    private String titulo;
    private String institucion;
    private Date anoGraduacion;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the institucion
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    /**
     * @return the anoGraduacion
     */
    public Date getAnoGraduacion() {
        return anoGraduacion;
    }

    /**
     * @param anoGraduacion the anoGraduacion to set
     */
    public void setAnoGraduacion(Date anoGraduacion) {
        this.anoGraduacion = anoGraduacion;
    }
    
}
