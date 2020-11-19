/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.PqrConversor;
import com.sena.terra.dto.PqrDto;
import com.sena.terra.entity.Empleado;
import com.sena.terra.entity.Pqr;
import com.sena.terra.facade.EmpleadoFacade;
import com.sena.terra.facade.PqrFacade;
import com.sena.terra.interfaces.IPqrDao;
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
@Local(IPqrDao.class)
public class PqrDao implements IPqrDao {

    @Inject
    private PqrFacade pqrFacade;

    @Inject
    private EmpleadoFacade empleadoFacade;

    @Override
    public List<PqrDto> listByEmpleado(final int empleadoId) {
        final List<Pqr> listaEntity = pqrFacade.listAll(empleadoId);
        return PqrConversor.listaPqrFromEntity(listaEntity);
    }

    @Override
    public List<PqrDto> listAll() {
        final List<Pqr> listaPqr = pqrFacade.findAll();
        return PqrConversor.listaPqrFromEntity(listaPqr);
    }

    @Override
    public void delete(final int pqrId) {
        final Pqr pqr = pqrFacade.find(pqrId);
        pqrFacade.remove(pqr);
    }

    @Override
    public void guardar(final PqrDto pqrDto, final int EmpleadoId) {
        final Pqr pqr = PqrConversor.pqrFromDto(pqrDto);
        final Empleado empleado = empleadoFacade.find(EmpleadoId);
        pqr.setIdEmpleado(empleado);
        if (pqr.getIdPQR() == Constant.ZERO) {
            pqrFacade.create(pqr);
            final String numeroRadicado = JsfUtility
                    .createNumeroRadicacion(pqr.getIdPQR());
            pqr.setNumeroRadicado(numeroRadicado);
            pqrFacade.edit(pqr);
        } else {
            pqrFacade.edit(pqr);
        }
    }
}
