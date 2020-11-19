/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.CargoDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICargoDao {
    
    public List<CargoDto> listaCargos();
    
    public CargoDto obtenerCargo(final String valor);
    
}
