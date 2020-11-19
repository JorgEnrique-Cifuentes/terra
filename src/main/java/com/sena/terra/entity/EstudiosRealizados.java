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
@Table(name = "estudios_realizados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudiosRealizados.findAll", query = "SELECT e FROM EstudiosRealizados e")
    , @NamedQuery(name = "EstudiosRealizados.findById", query = "SELECT e FROM EstudiosRealizados e WHERE e.id = :id")
    , @NamedQuery(name = "EstudiosRealizados.findByTitulo", query = "SELECT e FROM EstudiosRealizados e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "EstudiosRealizados.findByInstitucion", query = "SELECT e FROM EstudiosRealizados e WHERE e.institucion = :institucion")
    , @NamedQuery(name = "EstudiosRealizados.findByAnoGraduacion", query = "SELECT e FROM EstudiosRealizados e WHERE e.anoGraduacion = :anoGraduacion")})
public class EstudiosRealizados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "institucion")
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_graduacion")
    @Temporal(TemporalType.DATE)
    private Date anoGraduacion;
    @JoinColumn(name = "id_hoja_de_vida", referencedColumnName = "ID_ASPIRANTE")
    @ManyToOne(optional = false)
    private HojasDeVida idHojaDeVida;

    public EstudiosRealizados() {
        super();
    }

    public EstudiosRealizados(int id) {
        this.id = id;
    }

    public EstudiosRealizados(int id, String titulo, String institucion, Date anoGraduacion) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.anoGraduacion = anoGraduacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getAnoGraduacion() {
        return anoGraduacion;
    }

    public void setAnoGraduacion(Date anoGraduacion) {
        this.anoGraduacion = anoGraduacion;
    }

    public HojasDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public void setIdHojaDeVida(HojasDeVida idHojaDeVida) {
        this.idHojaDeVida = idHojaDeVida;
    }
    

    @Override
    public String toString() {
        return "com.sena.terra.entity.EstudiosRealizados[ id=" + id + " ]";
    }
    
}
