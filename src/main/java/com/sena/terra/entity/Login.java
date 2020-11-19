/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import com.sena.terra.utility.EstadoUsuario;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdUSUARIO", query = "SELECT l FROM Login l WHERE l.idUSUARIO = :idUSUARIO")
    , @NamedQuery(name = "Login.findByEstado", query = "SELECT l FROM Login l WHERE l.estado = :estado")
    , @NamedQuery(name = "Login.findByContrasena", query = "SELECT l FROM Login l WHERE l.contrasena = :contrasena")})

@NamedStoredProcedureQuery(
        name="insertarHistorialUsuario",
        procedureName="insertarHistorialUsuario",
        parameters={
            @StoredProcedureParameter(name="LOGIN_PROCE", type=int.class, mode=ParameterMode.IN),
            @StoredProcedureParameter(name="IP_USUARIO_PROCE", type=String.class, mode=ParameterMode.IN)
        }
)
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUSUARIO")
    private int idUSUARIO;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ESTADO")
    private EstadoUsuario estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "CONTRASENA")
    private String contrasena;

    public Login() {
    }

    public Login(int idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public Login(int idUSUARIO, EstadoUsuario estado, String contrasena) {
        this.idUSUARIO = idUSUARIO;
        this.estado = estado;
        this.contrasena = contrasena;
    }

    public int getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(int idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Login[ idUSUARIO=" + idUSUARIO + " ]";
    }
    
}
