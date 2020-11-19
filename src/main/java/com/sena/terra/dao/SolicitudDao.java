/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.SolicitudConversor;
import com.sena.terra.dto.SolicitudDto;
import com.sena.terra.entity.Solicitud;
import com.sena.terra.facade.SolicitudFacade;
import com.sena.terra.interfaces.ISolicitudDao;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.JsfUtility;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(ISolicitudDao.class)
public class SolicitudDao implements ISolicitudDao {
    
    @Inject
    private SolicitudFacade solicitudFacade;
    
    @Override
    public void guardar(final SolicitudDto solicitudDto) {
        final Solicitud solicitud
                = SolicitudConversor.solicitudFromDto(solicitudDto);
        if (solicitud.getIdSOLICITUD() == Constant.ZERO) {
            solicitudFacade.create(solicitud);
            final String numeroRadicado = JsfUtility
                    .createNumeroRadicacion(solicitud.getIdSOLICITUD());
            solicitud.setNumeroRadicado(numeroRadicado);
            solicitudFacade.edit(solicitud);
        } else {
            solicitudFacade.edit(solicitud);
        }
        
    }
    
    @Override
    public void delete(final SolicitudDto solicitudDto) {
        final Solicitud solicitud = SolicitudConversor.solicitudFromDto(solicitudDto);
        this.solicitudFacade.remove(solicitud);
    }
    
    @Override
    public List<SolicitudDto> listaSolicitudes() {
        final List<Solicitud> listaSolicitu = solicitudFacade.findAll();
        return SolicitudConversor.listaSolicitudFromEntity(listaSolicitu);
    }
}
