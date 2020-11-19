/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByIdCONTRATO", query = "SELECT c FROM Contrato c WHERE c.idCONTRATO = :idCONTRATO")
    , @NamedQuery(name = "Contrato.findByCargo", query = "SELECT c FROM Contrato c WHERE c.cargo = :cargo")
    , @NamedQuery(name = "Contrato.findByTipoContrato", query = "SELECT c FROM Contrato c WHERE c.tipoContrato = :tipoContrato")
    , @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Contrato.findByFechaFinal", query = "SELECT c FROM Contrato c WHERE c.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Contrato.findByTIPOSCONTRATOidTIPOSCONTRATO", query = "SELECT c FROM Contrato c WHERE c.tIPOSCONTRATOidTIPOSCONTRATO = :tIPOSCONTRATOidTIPOSCONTRATO")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCONTRATO")
    private int idCONTRATO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "TIPO_CONTRATO")
    private String tipoContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOS_CONTRATO_idTIPOS_CONTRATO")
    private int tIPOSCONTRATOidTIPOSCONTRATO;
    @JoinColumn(name = "EMPLEADO_idEMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado eMPLEADOidEMPLEADO;

    public Contrato() {
    }

    public Contrato(int idCONTRATO) {
        this.idCONTRATO = idCONTRATO;
    }

    public Contrato(int idCONTRATO, String cargo, String tipoContrato, Date fechaInicio, int tIPOSCONTRATOidTIPOSCONTRATO) {
        this.idCONTRATO = idCONTRATO;
        this.cargo = cargo;
        this.tipoContrato = tipoContrato;
        this.fechaInicio = fechaInicio;
        this.tIPOSCONTRATOidTIPOSCONTRATO = tIPOSCONTRATOidTIPOSCONTRATO;
    }

    public int getIdCONTRATO() {
        return idCONTRATO;
    }

    public void setIdCONTRATO(int idCONTRATO) {
        this.idCONTRATO = idCONTRATO;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getTIPOSCONTRATOidTIPOSCONTRATO() {
        return tIPOSCONTRATOidTIPOSCONTRATO;
    }

    public void setTIPOSCONTRATOidTIPOSCONTRATO(int tIPOSCONTRATOidTIPOSCONTRATO) {
        this.tIPOSCONTRATOidTIPOSCONTRATO = tIPOSCONTRATOidTIPOSCONTRATO;
    }

    public Empleado getEMPLEADOidEMPLEADO() {
        return eMPLEADOidEMPLEADO;
    }

    public void setEMPLEADOidEMPLEADO(Empleado eMPLEADOidEMPLEADO) {
        this.eMPLEADOidEMPLEADO = eMPLEADOidEMPLEADO;
    }
    @Override
    public String toString() {
        return "com.sena.terra.entity.Contrato[ idCONTRATO=" + idCONTRATO + " ]";
    }
    
}
