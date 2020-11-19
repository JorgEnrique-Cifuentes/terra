/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.CargoConversor;
import com.sena.terra.dto.CargoDto;
import com.sena.terra.entity.Cargo;
import com.sena.terra.facade.CargoFacade;
import com.sena.terra.interfaces.ICargoDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(ICargoDao.class)
public class CargoDao implements ICargoDao {

    @Inject
    private CargoFacade cargoFacade;

    @Override
    public List<CargoDto> listaCargos() {
        final List<Cargo> listaCargos = cargoFacade.findAll();
        return CargoConversor.listaCargoFromEntity(listaCargos);
    }

    @Override
    public CargoDto obtenerCargo(final String valor) {
        final Cargo cargo = cargoFacade.obtenerCargo(valor);
        return cargo != null ? CargoConversor.cargoFromEntity(cargo) : null;
    }

}
