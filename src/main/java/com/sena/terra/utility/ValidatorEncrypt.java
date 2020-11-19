/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Usuario
 */
public class ValidatorEncrypt {

    /**
     * 
     * @param contrasena
     * @param hashedContrasena
     * @return 
     */
    public static boolean checkPass(final String contrasena, final String hashedContrasena) {
        return BCrypt.checkpw(contrasena,
                hashedContrasena);
    }

    /**
     * 
     * @param password
     * @return 
     */
    public static String hashPassword(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
