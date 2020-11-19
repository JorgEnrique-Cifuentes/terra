/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.dto.ExperienciaLaboralDto;
import com.sena.terra.entity.ExperienciaLaboral;
import com.sena.terra.utility.FileUtil;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ExperienciaLaboralConversor {

    public static ExperienciaLaboralDto experienciaLaboralFromEntity(final ExperienciaLaboral experienciaLaboral, 
            final String identificacion) {
        if (null == experienciaLaboral) {
            return null;
        } else {
            final ExperienciaLaboralDto experienciaLaboralDto = new ExperienciaLaboralDto();
            experienciaLaboralDto.setCargo(experienciaLaboral.getCargo());
            experienciaLaboralDto.setEmpresa(experienciaLaboral.getEmpresa());
            experienciaLaboralDto.setFechaFinal(experienciaLaboral.getFechaFinal());
            experienciaLaboralDto.setFechaInicial(experienciaLaboral.getFechaInicial());
            experienciaLaboralDto.setId(experienciaLaboral.getId());
            return experienciaLaboralDto;
        }
    }
    
    public static ExperienciaLaboral experienciaLaboralFromDto(final ExperienciaLaboralDto experienciaLaboralDto) {
        if (null == experienciaLaboralDto) {
            return null;
        } else {
            final ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(); 
            experienciaLaboral.setCargo(experienciaLaboralDto.getCargo());
            experienciaLaboral.setEmpresa(experienciaLaboralDto.getEmpresa());
            experienciaLaboral.setFechaFinal(experienciaLaboralDto.getFechaFinal());
            experienciaLaboral.setFechaInicial(experienciaLaboralDto.getFechaInicial());
            experienciaLaboral.setId(experienciaLaboralDto.getId());
            return experienciaLaboral;
        }
    }

    public static List<ExperienciaLaboralDto> listaExperienciaLaboralFromEntity(final List<ExperienciaLaboral> listaExperienciaLaboral, 
            final String identificacion) {
        final List<ExperienciaLaboralDto> listaExperienciaLaboralDto = new ArrayList<>();
        if (Validator.isListNull(listaExperienciaLaboral)) {
            return new ArrayList<>();
        } else {
            listaExperienciaLaboral.stream().forEach(experiencia -> {
                listaExperienciaLaboralDto.add(experienciaLaboralFromEntity(experiencia, identificacion));
            });
        }
        return listaExperienciaLaboralDto;
    }
    
     public static List<ExperienciaLaboral> listaExperienciaLaboralFromDto(final List<ExperienciaLaboralDto> listaExperienciaLaboralDto) {
        final List<ExperienciaLaboral> listaExperienciaLaboral = new ArrayList<>();
        if (Validator.isListNull(listaExperienciaLaboralDto)) {
            return new ArrayList<>();
        } else {
            listaExperienciaLaboralDto.stream().forEach(experiencia -> {
                listaExperienciaLaboral.add(experienciaLaboralFromDto(experiencia));
            });
        }
        return listaExperienciaLaboral;
    }

}
