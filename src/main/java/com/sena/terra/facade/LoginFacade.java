/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.Login;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.EstadoUsuario;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.Validator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }

    public Login obtenerLogin(final String nombre) {
        final TypedQuery<Login> query
                = this.em.createNamedQuery("Login.findByUsuario", Login.class);
        query.setParameter("usuario", nombre);
        return Validator.getSingleResult(query);
    }

    public void guardarContrasena(final int idLogin, final String contrasena, final EstadoUsuario estadoUsuario) {
        final Login login = em.find(Login.class, idLogin);
        login.setEstado(estadoUsuario);
        login.setContrasena(contrasena);
        em.merge(login);
    }

    public void insertarHistorialUsuario(final int logId) {
        try {
            final StoredProcedureQuery storedProcedure 
                    = this.em.createStoredProcedureQuery("insertarHistorialUsuario")
                    .registerStoredProcedureParameter(Constant.ZERO, int.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(Constant.ONE, String.class, ParameterMode.IN);
            storedProcedure.setParameter(Constant.ZERO, logId);
            storedProcedure.setParameter(Constant.ONE, JsfUtility.getRemoteAddress());
            storedProcedure.execute();
        } catch (Exception e) {
            
        }
    }

}
