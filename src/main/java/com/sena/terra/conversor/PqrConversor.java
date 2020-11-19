/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.PqrDto;
import com.sena.terra.entity.Pqr;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PqrConversor {
    
    public static PqrDto pqrFromEntity(final Pqr pqr) {
        if (pqr == null) {
            return null;
        } else {
            final PqrDto pqrDto = new PqrDto();
            pqrDto.setIdPQR(pqr.getIdPQR());
            pqrDto.setDescripcion(pqr.getDescripcion());
            pqrDto.setTipoPqr(pqr.getTipoPqr());
            pqrDto.setNumeroRadicado(pqr.getNumeroRadicado());
            pqrDto.setNombreCompleto(pqr.getIdEmpleado().nombreCompleto());
            pqrDto.setCedula(pqr.getIdEmpleado().getNumeroDocumento());
            pqrDto.setEstado(pqr.getEstado());
            return pqrDto;
        }
    }
    
    public static Pqr pqrFromDto(final PqrDto pqrDto) {
        if (pqrDto == null) {
            return null;
        } else {
            final Pqr pqr = new Pqr();
            pqr.setIdPQR(pqrDto.getIdPQR());
            pqr.setDescripcion(pqrDto.getDescripcion());
            pqr.setTipoPqr(pqrDto.getTipoPqr());
            pqr.setNumeroRadicado(pqrDto.getNumeroRadicado());
            pqr.setEstado(pqrDto.getEstado());
            return pqr;
        }
    }
    
    public static List<PqrDto> listaPqrFromEntity(final List<Pqr> listaEntity) {
        final List<PqrDto> listaDto = new ArrayList<>();
        if (Validator.isListNull(listaEntity)) {
            return new ArrayList<>();
        } else {
            listaEntity.stream().forEach(entity -> {
                listaDto.add(pqrFromEntity(entity));
            });
        }
        return listaDto;
    }
    
}
