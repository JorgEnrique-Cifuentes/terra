/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estado_pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPruebas.findAll", query = "SELECT e FROM EstadoPruebas e")
    , @NamedQuery(name = "EstadoPruebas.findByIdESTADOPRUEBAS", query = "SELECT e FROM EstadoPruebas e WHERE e.idESTADOPRUEBAS = :idESTADOPRUEBAS")
    , @NamedQuery(name = "EstadoPruebas.findByEstado", query = "SELECT e FROM EstadoPruebas e WHERE e.estado = :estado")
    , @NamedQuery(name = "EstadoPruebas.findByModoCalificacion", query = "SELECT e FROM EstadoPruebas e WHERE e.modoCalificacion = :modoCalificacion")})
public class EstadoPruebas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idESTADO_PRUEBAS")
    private int idESTADOPRUEBAS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "MODO_CALIFICACION")
    private String modoCalificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPruebas")
    private List<PruebasPsicotecnicas> pruebasPsicotecnicasList;

    public EstadoPruebas() {
    }

    public EstadoPruebas(int idESTADOPRUEBAS) {
        this.idESTADOPRUEBAS = idESTADOPRUEBAS;
    }

    public EstadoPruebas(int idESTADOPRUEBAS, String estado, String modoCalificacion) {
        this.idESTADOPRUEBAS = idESTADOPRUEBAS;
        this.estado = estado;
        this.modoCalificacion = modoCalificacion;
    }

    public int getIdESTADOPRUEBAS() {
        return idESTADOPRUEBAS;
    }

    public void setIdESTADOPRUEBAS(int idESTADOPRUEBAS) {
        this.idESTADOPRUEBAS = idESTADOPRUEBAS;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModoCalificacion() {
        return modoCalificacion;
    }

    public void setModoCalificacion(String modoCalificacion) {
        this.modoCalificacion = modoCalificacion;
    }

    @XmlTransient
    public List<PruebasPsicotecnicas> getPruebasPsicotecnicasList() {
        return pruebasPsicotecnicasList;
    }

    public void setPruebasPsicotecnicasList(List<PruebasPsicotecnicas> pruebasPsicotecnicasList) {
        this.pruebasPsicotecnicasList = pruebasPsicotecnicasList;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.EstadoPruebas[ idESTADOPRUEBAS=" + idESTADOPRUEBAS + " ]";
    }
    
}
