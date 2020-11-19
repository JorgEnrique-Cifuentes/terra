/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.EmpleadoConversor;
import com.sena.terra.dto.EmpleadoDto;
import com.sena.terra.entity.Empleado;
import com.sena.terra.facade.EmpleadoFacade;
import com.sena.terra.interfaces.IEmpleadoDao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(IEmpleadoDao.class)
public class EmpleadoDao implements IEmpleadoDao {

    @Inject
    private EmpleadoFacade empleadoFacade;

    @Override
    public EmpleadoDto obtenerEmpleadoPorLogin(final int idLogin) {
        final Empleado empleado = empleadoFacade
                .obtenerEmpleadoPorLogin(idLogin);
        return EmpleadoConversor.empleadoFromEntity(empleado);
    }

    @Override
    public EmpleadoDto obtenerEmpleadoPorIdentificacion(final String identificacion) {
        final Empleado empleado = empleadoFacade
                .obtenerEmpleadoPorIdentificacion(identificacion);
        return EmpleadoConversor.empleadoFromEntity(empleado);
    }

}
