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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "desprendible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desprendible.findAll", query = "SELECT d FROM Desprendible d")
    , @NamedQuery(name = "Desprendible.findByIdDESPRENDIBLE", query = "SELECT d FROM Desprendible d WHERE d.idDESPRENDIBLE = :idDESPRENDIBLE")
    , @NamedQuery(name = "Desprendible.findByDiasLaborados", query = "SELECT d FROM Desprendible d WHERE d.diasLaborados = :diasLaborados")
    , @NamedQuery(name = "Desprendible.findByHorasExtras", query = "SELECT d FROM Desprendible d WHERE d.horasExtras = :horasExtras")
    , @NamedQuery(name = "Desprendible.findByAuxilioTransporte", query = "SELECT d FROM Desprendible d WHERE d.auxilioTransporte = :auxilioTransporte")
    , @NamedQuery(name = "Desprendible.findByRecargoNocturno", query = "SELECT d FROM Desprendible d WHERE d.recargoNocturno = :recargoNocturno")})
public class Desprendible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDESPRENDIBLE")
    private int idDESPRENDIBLE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAS_LABORADOS")
    private int diasLaborados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_EXTRAS")
    private int horasExtras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUXILIO_TRANSPORTE")
    private double auxilioTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECARGO_NOCTURNO")
    private double recargoNocturno;
    @JoinColumn(name = "EMPLEADO_idEMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado eMPLEADOidEMPLEADO;

    public Desprendible() {
    }

    public Desprendible(int idDESPRENDIBLE) {
        this.idDESPRENDIBLE = idDESPRENDIBLE;
    }

    public Desprendible(int idDESPRENDIBLE, int diasLaborados, int horasExtras, double auxilioTransporte, double recargoNocturno) {
        this.idDESPRENDIBLE = idDESPRENDIBLE;
        this.diasLaborados = diasLaborados;
        this.horasExtras = horasExtras;
        this.auxilioTransporte = auxilioTransporte;
        this.recargoNocturno = recargoNocturno;
    }

    public int getIdDESPRENDIBLE() {
        return idDESPRENDIBLE;
    }

    public void setIdDESPRENDIBLE(int idDESPRENDIBLE) {
        this.idDESPRENDIBLE = idDESPRENDIBLE;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public double getRecargoNocturno() {
        return recargoNocturno;
    }

    public void setRecargoNocturno(double recargoNocturno) {
        this.recargoNocturno = recargoNocturno;
    }

    public Empleado getEMPLEADOidEMPLEADO() {
        return eMPLEADOidEMPLEADO;
    }

    public void setEMPLEADOidEMPLEADO(Empleado eMPLEADOidEMPLEADO) {
        this.eMPLEADOidEMPLEADO = eMPLEADOidEMPLEADO;
    }


    @Override
    public String toString() {
        return "com.sena.terra.entity.Desprendible[ idDESPRENDIBLE=" + idDESPRENDIBLE + " ]";
    }
    
}
