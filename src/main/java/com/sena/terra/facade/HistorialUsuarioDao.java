/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.conversor.HistorialUsuarioConversor;
import com.sena.terra.dto.HistorialUsuarioDto;
import com.sena.terra.entity.HistorialUsuario;
import com.sena.terra.interfaces.IHistorialUsuarioDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(IHistorialUsuarioDao.class)
public class HistorialUsuarioDao implements IHistorialUsuarioDao {

    @Inject
    private HistorialUsuarioFacade historialUsuarioFacade;

    @Override
    public List<HistorialUsuarioDto> listAll() {
        final List<HistorialUsuario> listaEntity = historialUsuarioFacade.findAll();
        return HistorialUsuarioConversor.listaHistorialFromEntity(listaEntity);
    }

}
