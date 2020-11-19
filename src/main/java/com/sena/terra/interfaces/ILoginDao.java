/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.LoginDto;
import com.sena.terra.utility.EstadoUsuario;

/**
 *
 * @author Usuario
 */
public interface ILoginDao {

    /**
     * Obtiene el login por nombre
     * @param nombre de usuario
     * @return 
     */
    public LoginDto obtenerLogin(final String nombre);
    
    /**
     * Obtiene el login por id
     * @param id del usuario
     * @return 
     */
    public LoginDto obtenerLoginPorId(final int id);
    
    
    /**
     * guardar contraseñà
     * @param idLogin
     * @param contrasena 
     * @param estadoUsuario 
     */
    public void guardarPassword(final int idLogin, final String contrasena,final EstadoUsuario estadoUsuario);
    
    /**
     * 
     * @param logId
     */
    public void insertarHistorialUsuario(final int logId);
}
