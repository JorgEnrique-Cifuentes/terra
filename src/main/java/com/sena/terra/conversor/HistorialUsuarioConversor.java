/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.HistorialUsuarioDto;
import com.sena.terra.entity.HistorialUsuario;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HistorialUsuarioConversor {

    public static List<HistorialUsuarioDto> listaHistorialFromEntity(final List<HistorialUsuario> listaHistorialUsuario) {
        final List<HistorialUsuarioDto> listaHistorialUsuarioDto = new ArrayList<>();
        if (Validator.isListNull(listaHistorialUsuario)) {
            return null;
        } else {
            listaHistorialUsuario.stream().forEach(historialUsuario -> {
                listaHistorialUsuarioDto.add(curriculumFromEntity(historialUsuario));
            });
        }
        return listaHistorialUsuarioDto;
    }

    private static HistorialUsuarioDto curriculumFromEntity(HistorialUsuario historialUsuario) {
        HistorialUsuarioDto historialUsuarioDto = new HistorialUsuarioDto();
        historialUsuarioDto.setId(historialUsuario.getId());
        historialUsuarioDto.setUsuario(historialUsuario.getUsuario());
        historialUsuarioDto.setIdentificacion(historialUsuario.getIdentificacion());
        historialUsuarioDto.setRol(historialUsuario.getRol());
        historialUsuarioDto.setIpUsuario(historialUsuario.getIpUsuario());
        historialUsuarioDto.setFechaIngreso(historialUsuario.getFechaIngreso());
        return historialUsuarioDto;
    }
}
