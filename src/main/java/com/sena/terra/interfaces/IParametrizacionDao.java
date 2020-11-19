/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.ParametrizacionDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IParametrizacionDao {
    
    public List<ParametrizacionDto> Lista(final String paramAbrev);
    
    public String obtenerLugarTrabajo(final int id);
    
    public ParametrizacionDto obtenerCiudad(final String valor);
    
}
