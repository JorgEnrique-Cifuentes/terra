/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.SolicitudDto;
import com.sena.terra.entity.Solicitud;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SolicitudConversor {

    public static List<SolicitudDto> listaSolicitudFromEntity(final List<Solicitud> listaSolicitud) {
        final List<SolicitudDto> listaSolicitudDto = new ArrayList<>();
        if (Validator.isListNull(listaSolicitud)) {
            return new ArrayList<>();
        } else {
            listaSolicitud.stream().forEach(solicitud -> {
                listaSolicitudDto.add(solicitudFromEntity(solicitud));
            });
        }
        return listaSolicitudDto;
    }

    public static SolicitudDto solicitudFromEntity(final Solicitud solicitud) {
        if (null == solicitud) {
            return null;
        } else {
            final SolicitudDto solicitudDto = new SolicitudDto();
            solicitudDto.setCantidadVacantes(solicitud.getCantidadVacantes());
            solicitudDto.setDescripcion(solicitud.getDescripcion());
            solicitudDto.setEstado(solicitud.getEstado());
            solicitudDto.setIdSOLICITUD(solicitud.getIdSOLICITUD());
            solicitudDto.setIdLugarTrabajo(solicitud.getIdLugarTrabajo());
            solicitudDto.setNumeroRadicado(solicitud.getNumeroRadicado());
            solicitudDto.setCargoDto(CargoConversor
                    .cargoFromEntity(solicitud.getIdCARGO()));
            return solicitudDto;
        }
    }

    public static Solicitud solicitudFromDto(final SolicitudDto solicitudDto) {
        if (null == solicitudDto) {
            return null;
        } else {
            final Solicitud solicitud = new Solicitud();
            solicitud.setCantidadVacantes(solicitudDto.getCantidadVacantes());
            solicitud.setDescripcion(solicitudDto.getDescripcion());
            solicitud.setEstado(solicitudDto.getEstado());
            solicitud.setIdSOLICITUD(solicitudDto.getIdSOLICITUD());
            solicitud.setIdLugarTrabajo(solicitudDto.getIdLugarTrabajo());
            solicitud.setNumeroRadicado(solicitudDto.getNumeroRadicado());
            solicitud.setIdCARGO(CargoConversor.cargoFromEntity(solicitudDto.getCargoDto()));
            return solicitud;
        }
    }

}
