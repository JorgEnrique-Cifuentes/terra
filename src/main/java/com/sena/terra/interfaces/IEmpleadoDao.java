/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.EmpleadoDto;

/**
 *
 * @author Usuario
 */
public interface IEmpleadoDao {

    /**
     * Obtiene el empleado por Login
     * @param idLogin de usuario
     * @return 
     */
    public EmpleadoDto obtenerEmpleadoPorLogin(final int idLogin);
    
    
    /**
     * Obtiene el empleado por identificacion
     * @param identificacion del usuario
     * @return 
     */
    public EmpleadoDto obtenerEmpleadoPorIdentificacion(final String identificacion);
    
    
}
