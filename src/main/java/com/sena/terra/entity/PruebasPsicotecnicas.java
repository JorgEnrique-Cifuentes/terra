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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pruebas_psicotecnicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PruebasPsicotecnicas.findAll", query = "SELECT p FROM PruebasPsicotecnicas p")
    , @NamedQuery(name = "PruebasPsicotecnicas.findById", query = "SELECT p FROM PruebasPsicotecnicas p WHERE p.id = :id")
    , @NamedQuery(name = "PruebasPsicotecnicas.findByResultado", query = "SELECT p FROM PruebasPsicotecnicas p WHERE p.resultado = :resultado")})
public class PruebasPsicotecnicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RESULTADO")
    private String resultado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPruebasPsicotecnicas")
    private List<HojasDeVida> hojasDeVidaList;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "ID_ESTADO_PRUEBAS", referencedColumnName = "idESTADO_PRUEBAS")
    @ManyToOne(optional = false)
    private EstadoPruebas idEstadoPruebas;

    public PruebasPsicotecnicas() {
    }

    public PruebasPsicotecnicas(int id) {
        this.id = id;
    }

    public PruebasPsicotecnicas(int id, String resultado) {
        this.id = id;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @XmlTransient
    public List<HojasDeVida> getHojasDeVidaList() {
        return hojasDeVidaList;
    }

    public void setHojasDeVidaList(List<HojasDeVida> hojasDeVidaList) {
        this.hojasDeVidaList = hojasDeVidaList;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public EstadoPruebas getIdEstadoPruebas() {
        return idEstadoPruebas;
    }

    public void setIdEstadoPruebas(EstadoPruebas idEstadoPruebas) {
        this.idEstadoPruebas = idEstadoPruebas;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.PruebasPsicotecnicas[ id=" + id + " ]";
    }
    
}
