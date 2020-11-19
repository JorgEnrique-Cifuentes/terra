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
@Table(name = "parametrizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrizacion.findAll", query = "SELECT p FROM Parametrizacion p")
    , @NamedQuery(name = "Parametrizacion.findById", query = "SELECT p FROM Parametrizacion p WHERE p.id = :id")
    , @NamedQuery(name = "Parametrizacion.findByValor", query = "SELECT p FROM Parametrizacion p WHERE p.valor = :valor")
    , @NamedQuery(name = "Parametrizacion.findByParamAbrev", query = "SELECT p FROM Parametrizacion p WHERE p.paramAbrev = :paramAbrev")})
public class Parametrizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Size(max = 45)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 5)
    @Column(name = "PARAM_ABREV")
    private String paramAbrev;

    public Parametrizacion() {
    }

    public Parametrizacion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getParamAbrev() {
        return paramAbrev;
    }

    public void setParamAbrev(String paramAbrev) {
        this.paramAbrev = paramAbrev;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.Parametrizacion[ id=" + id + " ]";
    }
    
}
