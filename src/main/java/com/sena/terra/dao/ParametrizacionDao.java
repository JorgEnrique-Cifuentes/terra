/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.ParametrizacionConversor;
import com.sena.terra.dto.ParametrizacionDto;
import com.sena.terra.entity.Parametrizacion;
import com.sena.terra.facade.ParametrizacionFacade;
import com.sena.terra.interfaces.IParametrizacionDao;
import com.sena.terra.utility.Validator;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(IParametrizacionDao.class)
public class ParametrizacionDao implements IParametrizacionDao {

    @Inject
    private ParametrizacionFacade parametrizacionFacade;

    @Override
    public List<ParametrizacionDto> Lista(final String paramAbrev) {
        final List<Parametrizacion> listaParametrizacion
                = parametrizacionFacade.listaParametrizacion(paramAbrev);
        return ParametrizacionConversor.listaFromEntity(listaParametrizacion);
    }

    @Override
    public String obtenerLugarTrabajo(final int id) {
        final Parametrizacion parametrizacion = parametrizacionFacade.find(id);
        return parametrizacion == null
                || Validator.isNull(parametrizacion.getValor())
                ? "" : parametrizacion.getValor();
    }

    @Override
    public ParametrizacionDto obtenerCiudad(final String valor) {
        final Parametrizacion parametrizacion = parametrizacionFacade.obtenerCiudad(valor);
        return parametrizacion != null ? ParametrizacionConversor
                .paramFromEntity(parametrizacion) : null;
    }

}
