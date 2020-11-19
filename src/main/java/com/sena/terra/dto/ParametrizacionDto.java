/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dto;

/**
 *
 * @author Usuario
 */
public class ParametrizacionDto {

    private int id;
    private String valor;
    private String paramAbrev;

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

}
