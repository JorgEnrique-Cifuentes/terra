/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.dto.EstudiosRealizadosDto;
import com.sena.terra.entity.EstudiosRealizados;
import com.sena.terra.utility.FileUtil;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EstudiosRealizadosConversor {

    public static EstudiosRealizadosDto estudiosRealizadosFromEntity(final EstudiosRealizados estudiosRealizados, 
            final String identificacion) {
        if (null == estudiosRealizados) {
            return null;
        } else {
            final EstudiosRealizadosDto estudiosRealizadosDto = new EstudiosRealizadosDto();
            estudiosRealizadosDto.setAnoGraduacion(estudiosRealizados.getAnoGraduacion());
            estudiosRealizadosDto.setId(estudiosRealizados.getId());
            estudiosRealizadosDto.setInstitucion(estudiosRealizados.getInstitucion());
            estudiosRealizadosDto.setTitulo(estudiosRealizados.getTitulo());
            return estudiosRealizadosDto;
        }
    }

    public static EstudiosRealizados estudiosRealizadosFromDto(final EstudiosRealizadosDto estudiosRealizadosDto) {
        if (null == estudiosRealizadosDto) {
            return null;
        } else {
            final EstudiosRealizados estudiosRealizados = new EstudiosRealizados();
            estudiosRealizados.setAnoGraduacion(estudiosRealizadosDto.getAnoGraduacion());
            estudiosRealizados.setId(estudiosRealizadosDto.getId());
            estudiosRealizados.setInstitucion(estudiosRealizadosDto.getInstitucion());
            estudiosRealizados.setTitulo(estudiosRealizadosDto.getTitulo());
            return estudiosRealizados;
        }
    }

    public static List<EstudiosRealizadosDto> listaEstudiosReaFromEntity(final List<EstudiosRealizados> listaEstudiosRealizados,
            final String identificacion) {
        final List<EstudiosRealizadosDto> listaEstudiosRealizadosDto = new ArrayList<>();
        if (Validator.isListNull(listaEstudiosRealizados)) {
            return new ArrayList<>();
        } else {
            listaEstudiosRealizados.stream().forEach(estudio -> {
                listaEstudiosRealizadosDto.add(estudiosRealizadosFromEntity(estudio, identificacion));
            });
        }
        return listaEstudiosRealizadosDto;
    }

    public static List<EstudiosRealizados> listaEstudiosReaFromDto(final List<EstudiosRealizadosDto> listaEstudiosRealizadosDto) {
        final List<EstudiosRealizados> listaEstudiosRealizados = new ArrayList<>();
        if (Validator.isListNull(listaEstudiosRealizadosDto)) {
            return new ArrayList<>();
        } else {
            listaEstudiosRealizadosDto.stream().forEach(estudio -> {
                listaEstudiosRealizados.add(estudiosRealizadosFromDto(estudio));
            });
        }
        return listaEstudiosRealizados;
    }

}
