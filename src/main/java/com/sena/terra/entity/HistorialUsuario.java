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
@Table(name = "historial_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialUsuario.findAll", query = "SELECT h FROM HistorialUsuario h")
    , @NamedQuery(name = "HistorialUsuario.findById", query = "SELECT h FROM HistorialUsuario h WHERE h.id = :id")
    , @NamedQuery(name = "HistorialUsuario.findByUsuario", query = "SELECT h FROM HistorialUsuario h WHERE h.usuario = :usuario")
    , @NamedQuery(name = "HistorialUsuario.findByIdentificacion", query = "SELECT h FROM HistorialUsuario h WHERE h.identificacion = :identificacion")
    , @NamedQuery(name = "HistorialUsuario.findByRol", query = "SELECT h FROM HistorialUsuario h WHERE h.rol = :rol")
    , @NamedQuery(name = "HistorialUsuario.findByFechaIngreso", query = "SELECT h FROM HistorialUsuario h WHERE h.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "HistorialUsuario.findByIpUsuario", query = "SELECT h FROM HistorialUsuario h WHERE h.ipUsuario = :ipUsuario")})
public class HistorialUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUARIO", nullable = false, length = 45)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IDENTIFICACION", nullable = false, length = 45)
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ROL", nullable = false, length = 45)
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "IP_USUARIO", nullable = false, length = 40)
    private String ipUsuario;

    public HistorialUsuario() {
    }

    public HistorialUsuario(int id) {
        this.id = id;
    }

    public HistorialUsuario(int id, String usuario, String identificacion, String rol, Date fechaIngreso, String ipUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.identificacion = identificacion;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.ipUsuario = ipUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.HistorialUsuario[ id=" + id + " ]";
    }
    
}
