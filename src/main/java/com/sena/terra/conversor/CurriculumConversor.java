/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.CurriculumDto;
import com.sena.terra.entity.HojasDeVida;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CurriculumConversor {
    
    public static CurriculumDto curriculumFromEntity(final HojasDeVida hojasDeVida) {
        final CurriculumDto curriculumDto = new CurriculumDto();
        if (null == hojasDeVida) {
            return null;
        } else {
            curriculumDto.setCorreoElectronico(hojasDeVida.getCorreoElectronico());
            curriculumDto.setDireccion(hojasDeVida.getDireccion());
            curriculumDto.setIdAspirante(hojasDeVida.getIdAspirante());
            curriculumDto.setNumeroDocumento(hojasDeVida.getNumeroDocumento());
            curriculumDto.setPrimerApellido(hojasDeVida.getPrimerApellido());
            curriculumDto.setPrimerNombre(hojasDeVida.getPrimerNombre());
            curriculumDto.setProfesion(hojasDeVida.getProfesion());
            curriculumDto.setSegundoApellido(hojasDeVida.getSegundoApellido());
            curriculumDto.setSegundoNombre(hojasDeVida.getSegundoNombre());
            curriculumDto.setTelefono(hojasDeVida.getTelefono());
            curriculumDto.setTipoDocumento(hojasDeVida.getTipoDocumento());
            curriculumDto.setPuntaje(hojasDeVida.getPuntaje());
            curriculumDto.setIdCiudad(hojasDeVida.getIdCiudad());
            curriculumDto.setListaEstudiosRealizados(EstudiosRealizadosConversor
                    .listaEstudiosReaFromEntity(hojasDeVida.getEstudiosRealizadosList(), hojasDeVida.getNumeroDocumento()));
            curriculumDto.setListaExperienciaLaboral(ExperienciaLaboralConversor
                    .listaExperienciaLaboralFromEntity(hojasDeVida.getExperienciaLaboralList(), hojasDeVida.getNumeroDocumento()));
            return curriculumDto;
        }
    }
    
    public static HojasDeVida curriculumFromDto(final CurriculumDto curriculumDto) {
        final HojasDeVida hojasDeVida = new HojasDeVida();
        if (null == curriculumDto) {
            return null;
        } else {
            hojasDeVida.setCorreoElectronico(curriculumDto.getCorreoElectronico());
            hojasDeVida.setDireccion(curriculumDto.getDireccion());
            hojasDeVida.setIdAspirante(curriculumDto.getIdAspirante());
            hojasDeVida.setNumeroDocumento(curriculumDto.getNumeroDocumento());
            hojasDeVida.setPrimerApellido(curriculumDto.getPrimerApellido());
            hojasDeVida.setPrimerNombre(curriculumDto.getPrimerNombre());
            hojasDeVida.setProfesion(curriculumDto.getProfesion());
            hojasDeVida.setSegundoApellido(curriculumDto.getSegundoApellido());
            hojasDeVida.setSegundoNombre(curriculumDto.getSegundoNombre());
            hojasDeVida.setTelefono(curriculumDto.getTelefono());
            hojasDeVida.setTipoDocumento(curriculumDto.getTipoDocumento());
            hojasDeVida.setPuntaje(curriculumDto.getPuntaje());
            hojasDeVida.setIdCiudad(curriculumDto.getIdCiudad());
            hojasDeVida.setEstudiosRealizadosList(EstudiosRealizadosConversor
                    .listaEstudiosReaFromDto(curriculumDto.getListaEstudiosRealizados()));
            hojasDeVida.setExperienciaLaboralList(ExperienciaLaboralConversor
                    .listaExperienciaLaboralFromDto(curriculumDto.getListaExperienciaLaboral()));
            return hojasDeVida;
        }
    }
    
    public static List<CurriculumDto> listaCurriculumFromEntity(final List<HojasDeVida> listaHojasDeVida) {
        final List<CurriculumDto> listaCurriculumDto = new ArrayList<>();
        if (Validator.isListNull(listaHojasDeVida)) {
            return null;
        } else {
            listaHojasDeVida.stream().forEach(hojaDeVida -> {
                listaCurriculumDto.add(curriculumFromEntity(hojaDeVida));
            });
        }
        return listaCurriculumDto;
    }
    
}
