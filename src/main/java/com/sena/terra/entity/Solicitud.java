/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSOLICITUD", query = "SELECT s FROM Solicitud s WHERE s.idSOLICITUD = :idSOLICITUD")
    , @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")
    , @NamedQuery(name = "Solicitud.findByDescripcion", query = "SELECT s FROM Solicitud s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Solicitud.findByCantidadVacantes", query = "SELECT s FROM Solicitud s WHERE s.cantidadVacantes = :cantidadVacantes")
    , @NamedQuery(name = "Solicitud.findByNumeroRadicado", query = "SELECT s FROM Solicitud s WHERE s.numeroRadicado = :numeroRadicado")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSOLICITUD")
    private int idSOLICITUD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLugarTrabajo")
    private int idLugarTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_VACANTES")
    private int cantidadVacantes;
    @Size(max = 45)
    @Column(name = "NUMERO_RADICADO")
    private String numeroRadicado;
    @JoinColumn(name = "idCARGO", referencedColumnName = "idCARGO")
    @ManyToOne
    private Cargo idCARGO;

    public Solicitud() {
    }

    public Solicitud(int idSOLICITUD) {
        this.idSOLICITUD = idSOLICITUD;
    }

    public Solicitud(int idSOLICITUD, String estado, String descripcion, int idLugarTrabajo, int cantidadVacantes) {
        this.idSOLICITUD = idSOLICITUD;
        this.estado = estado;
        this.descripcion = descripcion;
        this.idLugarTrabajo = idLugarTrabajo;
        this.cantidadVacantes = cantidadVacantes;
    }

    public int getIdSOLICITUD() {
        return idSOLICITUD;
    }

    public void setIdSOLICITUD(int idSOLICITUD) {
        this.idSOLICITUD = idSOLICITUD;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdLugarTrabajo() {
        return idLugarTrabajo;
    }

    public void setIdLugarTrabajo(int idLugarTrabajo) {
        this.idLugarTrabajo = idLugarTrabajo;
    }

    public int getCantidadVacantes() {
        return cantidadVacantes;
    }

    public void setCantidadVacantes(int cantidadVacantes) {
        this.cantidadVacantes = cantidadVacantes;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public Cargo getIdCARGO() {
        return idCARGO;
    }

    public void setIdCARGO(Cargo idCARGO) {
        this.idCARGO = idCARGO;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Solicitud[ idSOLICITUD=" + idSOLICITUD + " ]";
    }
    
}
