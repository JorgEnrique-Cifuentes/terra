/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.PermisoConversor;
import com.sena.terra.dto.PermisoDto;
import com.sena.terra.entity.Permiso;
import com.sena.terra.facade.PermisoFacade;
import com.sena.terra.interfaces.IPermisoDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(IPermisoDao.class)
public class PermisoDao implements IPermisoDao {

    @Inject
    private PermisoFacade permisoFacade;

    @Override
    public List<PermisoDto> obtenerPermisos(int rolId) {
        final List<Permiso> listaPermiso = permisoFacade.obtenerPermisos(rolId);
        return PermisoConversor.listPermisoFromEntity(listaPermiso);
    }

}
