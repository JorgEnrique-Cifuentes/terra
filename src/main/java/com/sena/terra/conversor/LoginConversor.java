package com.sena.terra.conversor;


import com.sena.terra.dto.LoginDto;
import com.sena.terra.entity.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class LoginConversor {

    public static LoginDto loginFromDto(final Login login) {
        if (null == login) {
            return null;
        } else {
            final LoginDto loginDto = new LoginDto();
            loginDto.setIdUSUARIO(login.getIdUSUARIO());
            loginDto.setContrasena(login.getContrasena());
            loginDto.setEstado(login.getEstado());
            return loginDto;
        }

    }

    public static Login loginFromEntity(final LoginDto loginDto) {
        if (null == loginDto) {
            return null;
        } else {
            final Login login = new Login();
            login.setIdUSUARIO(login.getIdUSUARIO());
            login.setContrasena(login.getContrasena());
            login.setEstado(login.getEstado());
            return login;
        }
    }

}
