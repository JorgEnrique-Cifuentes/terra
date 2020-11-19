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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "certificacion_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CertificacionLaboral.findAll", query = "SELECT c FROM CertificacionLaboral c")
    , @NamedQuery(name = "CertificacionLaboral.findByIdCERTIFICACIONLABORAL", query = "SELECT c FROM CertificacionLaboral c WHERE c.idCERTIFICACIONLABORAL = :idCERTIFICACIONLABORAL")
    , @NamedQuery(name = "CertificacionLaboral.findByFechaExpedicion", query = "SELECT c FROM CertificacionLaboral c WHERE c.fechaExpedicion = :fechaExpedicion")})
public class CertificacionLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCERTIFICACION_LABORAL")
    private int idCERTIFICACIONLABORAL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EXPEDICION")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @JoinColumn(name = "EMPLEADO_idEMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado eMPLEADOidEMPLEADO;

    public CertificacionLaboral() {
    }

    public CertificacionLaboral(int idCERTIFICACIONLABORAL) {
        this.idCERTIFICACIONLABORAL = idCERTIFICACIONLABORAL;
    }

    public CertificacionLaboral(int idCERTIFICACIONLABORAL, Date fechaExpedicion) {
        this.idCERTIFICACIONLABORAL = idCERTIFICACIONLABORAL;
        this.fechaExpedicion = fechaExpedicion;
    }

    public int getIdCERTIFICACIONLABORAL() {
        return idCERTIFICACIONLABORAL;
    }

    public void setIdCERTIFICACIONLABORAL(int idCERTIFICACIONLABORAL) {
        this.idCERTIFICACIONLABORAL = idCERTIFICACIONLABORAL;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Empleado getEMPLEADOidEMPLEADO() {
        return eMPLEADOidEMPLEADO;
    }

    public void setEMPLEADOidEMPLEADO(Empleado eMPLEADOidEMPLEADO) {
        this.eMPLEADOidEMPLEADO = eMPLEADOidEMPLEADO;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.CertificacionLaboral[ idCERTIFICACIONLABORAL=" + idCERTIFICACIONLABORAL + " ]";
    }
    
}
