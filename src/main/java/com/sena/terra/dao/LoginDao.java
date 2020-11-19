/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.LoginConversor;
import com.sena.terra.dto.LoginDto;
import com.sena.terra.entity.Login;
import com.sena.terra.facade.LoginFacade;
import com.sena.terra.interfaces.ILoginDao;
import com.sena.terra.utility.EstadoUsuario;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(ILoginDao.class)
public class LoginDao implements ILoginDao {

    @Inject
    private LoginFacade loginFacade;

    @Override
    public LoginDto obtenerLogin(final String nombre) {
        final Login login = loginFacade.obtenerLogin(nombre);
        return LoginConversor.loginFromDto(login);
    }

    @Override
    public LoginDto obtenerLoginPorId(final int id) {
        final Login login = loginFacade.find(id);
        return LoginConversor.loginFromDto(login);
    }

    @Override
    public void guardarPassword(final int idLogin, final String contrasena, final EstadoUsuario estadoUsuario) {
        loginFacade.guardarContrasena(idLogin, contrasena, estadoUsuario);
    }

    @Override
    public void insertarHistorialUsuario(final int logId) {
        loginFacade.insertarHistorialUsuario(logId);
    }

}
