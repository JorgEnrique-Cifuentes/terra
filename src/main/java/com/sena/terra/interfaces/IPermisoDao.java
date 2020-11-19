/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.PermisoDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPermisoDao {
    
    public List<PermisoDto> obtenerPermisos(int rolId);
    
}
