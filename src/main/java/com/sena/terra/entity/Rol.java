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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdROL", query = "SELECT r FROM Rol r WHERE r.idROL = :idROL")
    , @NamedQuery(name = "Rol.findByTipoRol", query = "SELECT r FROM Rol r WHERE r.tipoRol = :tipoRol")})
public class Rol implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rOLidROL")
    private List<Empleado> empleadoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idROL")
    private int idROL;
    @Size(max = 200)
    @Column(name = "TIPO_ROL")
    private String tipoRol;

    public Rol() {
    }

    public Rol(int idROL) {
        this.idROL = idROL;
    }

    public int getIdROL() {
        return idROL;
    }

    public void setIdROL(int idROL) {
        this.idROL = idROL;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Rol[ idROL=" + idROL + " ]";
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }
    
}
