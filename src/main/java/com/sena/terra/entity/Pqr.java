/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import com.sena.terra.utility.EstadoPqr;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqr.findAll", query = "SELECT p FROM Pqr p"),
    @NamedQuery(name = "Pqr.findByIdPQR", query = "SELECT p FROM Pqr p WHERE p.idPQR = :idPQR"),
    @NamedQuery(name = "Pqr.findByTipoPqr", query = "SELECT p FROM Pqr p WHERE p.tipoPqr = :tipoPqr"),
    @NamedQuery(name = "Pqr.findByDescripcion", query = "SELECT p FROM Pqr p WHERE p.descripcion = :descripcion")})
public class Pqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPQR")
    private int idPQR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TIPO_PQR")
    private String tipoPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "NUMERO_RADICADO")
    private String numeroRadicado;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ESTADO")
    private EstadoPqr estado;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    public Pqr() {
    }

    public Pqr(int idPQR) {
        this.idPQR = idPQR;
    }

    public Pqr(int idPQR, String tipoPqr, String descripcion) {
        this.idPQR = idPQR;
        this.tipoPqr = tipoPqr;
        this.descripcion = descripcion;
    }

    public int getIdPQR() {
        return idPQR;
    }

    public void setIdPQR(int idPQR) {
        this.idPQR = idPQR;
    }

    public String getTipoPqr() {
        return tipoPqr;
    }

    public void setTipoPqr(String tipoPqr) {
        this.tipoPqr = tipoPqr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @Override
    public String toString() {
        return "com.sena.terra.entity.Pqr[ idPQR=" + idPQR + " ]";
    }

}
