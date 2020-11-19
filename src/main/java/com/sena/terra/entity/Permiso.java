/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import com.sena.terra.utility.PermisoApp;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPERMISO", query = "SELECT p FROM Permiso p WHERE p.idPERMISO = :idPERMISO"),
    @NamedQuery(name = "Permiso.findByNombrePermiso", query = "SELECT p FROM Permiso p WHERE p.nombrePermiso = :nombrePermiso"),
    @NamedQuery(name = "Permiso.findByDescripcionPermiso", query = "SELECT p FROM Permiso p WHERE p.descripcionPermiso = :descripcionPermiso"),
    @NamedQuery(name = "Permiso.findByIdRol", query = "SELECT p FROM Permiso p WHERE p.idRol = :idRol")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPERMISO")
    private int idPERMISO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE_PERMISO")
    @Enumerated(EnumType.STRING)
    private PermisoApp nombrePermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DESCRIPCION_PERMISO")
    private String descripcionPermiso;
    @Size(max = 80)
    @Column(name = "ID_ROL")
    private String idRol;

    public Permiso() {
    }

    public Permiso(int idPERMISO) {
        this.idPERMISO = idPERMISO;
    }

    public Permiso(int idPERMISO, PermisoApp nombrePermiso, String descripcionPermiso) {
        this.idPERMISO = idPERMISO;
        this.nombrePermiso = nombrePermiso;
        this.descripcionPermiso = descripcionPermiso;
    }

    public int getIdPERMISO() {
        return idPERMISO;
    }

    public void setIdPERMISO(int idPERMISO) {
        this.idPERMISO = idPERMISO;
    }

    public PermisoApp getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(PermisoApp nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Permiso[ idPERMISO=" + idPERMISO + " ]";
    }

}
