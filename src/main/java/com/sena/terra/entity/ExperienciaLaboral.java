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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findById", query = "SELECT e FROM ExperienciaLaboral e WHERE e.id = :id")
    , @NamedQuery(name = "ExperienciaLaboral.findByEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.empresa = :empresa")
    , @NamedQuery(name = "ExperienciaLaboral.findByCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.cargo = :cargo")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaInicial", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaFinal", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaFinal = :fechaFinal")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @JoinColumn(name = "id_hojas_de_vida", referencedColumnName = "ID_ASPIRANTE")
    @ManyToOne(optional = false)
    private HojasDeVida idHojasDeVida;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(int id) {
        this.id = id;
    }

    public ExperienciaLaboral(int id, String empresa, String cargo, Date fechaInicial) {
        this.id = id;
        this.empresa = empresa;
        this.cargo = cargo;
        this.fechaInicial = fechaInicial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public HojasDeVida getIdHojasDeVida() {
        return idHojasDeVida;
    }

    public void setIdHojasDeVida(HojasDeVida idHojasDeVida) {
        this.idHojasDeVida = idHojasDeVida;
    }
    
    @Override
    public String toString() {
        return "com.sena.terra.entity.ExperienciaLaboral[ id=" + id + " ]";
    }
    
}
