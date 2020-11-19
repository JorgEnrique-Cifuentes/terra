/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.PermisoDto;
import com.sena.terra.entity.Permiso;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PermisoConversor {

    public static List<PermisoDto> listPermisoFromEntity(final List<Permiso> listaPermiso) {
        if (Validator.isListNull(listaPermiso)) {
            return new ArrayList<>();
        } else {
            final List<PermisoDto> listaPermisoDto = new ArrayList<>();
            listaPermiso.stream().forEach(permiso -> {
                listaPermisoDto.add(permisoFromEntity(permiso));
            });
            return listaPermisoDto;
        }
    }

    public static PermisoDto permisoFromEntity(final Permiso permiso) {
        if (permiso == null) {
            return null;
        } else {
            final PermisoDto permisoDto = new PermisoDto();
            permisoDto.setIdPERMISO(permiso.getIdPERMISO());
            permisoDto.setNombrePermiso(permiso.getNombrePermiso());
            permisoDto.setDescripcionPermiso(permiso.getDescripcionPermiso());
            return permisoDto;
        }
    }

}
