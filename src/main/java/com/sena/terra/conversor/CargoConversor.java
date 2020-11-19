/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.CargoDto;
import com.sena.terra.entity.Cargo;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CargoConversor {

    public static List<CargoDto> listaCargoFromEntity(final List<Cargo> listaCargos) {
        final List<CargoDto> listaCargosDto = new ArrayList<>();
        if (Validator.isListNull(listaCargos)) {
            return null;
        } else {
            listaCargos.stream().forEach(cargo -> {
                listaCargosDto.add(cargoFromEntity(cargo));
            });
        }
        return listaCargosDto;
    }

    public static CargoDto cargoFromEntity(final Cargo cargo) {
        final CargoDto cargoDto = new CargoDto();
        cargoDto.setIdCARGO(cargo.getIdCARGO());
        cargoDto.setNombre(cargo.getNombre());
        return cargoDto;
    }

    public static Cargo cargoFromEntity(final CargoDto cargoDto) {
        final Cargo cargo = new Cargo();
        cargo.setIdCARGO(cargoDto.getIdCARGO());
        cargo.setNombre(cargoDto.getNombre());
        return cargo;
    }

}
