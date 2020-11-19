/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.ParametrizacionDto;
import com.sena.terra.entity.Parametrizacion;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ParametrizacionConversor {

    public static ParametrizacionDto paramFromEntity(final Parametrizacion parametrizacion) {
        if (null == parametrizacion) {
            return null;
        } else {
            final ParametrizacionDto parametrizacionDto = new ParametrizacionDto();
            parametrizacionDto.setId(parametrizacion.getId());
            parametrizacionDto.setValor(parametrizacion.getValor());
            parametrizacionDto.setParamAbrev(parametrizacion.getParamAbrev());
            return parametrizacionDto;
        }
    }

    public static List<ParametrizacionDto> listaFromEntity(final List<Parametrizacion> listaParametrizacion) {
        final List<ParametrizacionDto> listaParametrizacionDto = new ArrayList<>();
        if (Validator.isListNull(listaParametrizacion)) {
            return new ArrayList<>();
        } else {
            listaParametrizacion.stream().forEach(param -> {
                listaParametrizacionDto.add(paramFromEntity(param));
            });
        }
        return listaParametrizacionDto;
    }

}
