/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.Empleado;
import com.sena.terra.utility.Validator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public Empleado obtenerEmpleadoPorLogin(final int idLogin) {
        final TypedQuery<Empleado> query
                = this.em.createQuery("SELECT e FROM Empleado e WHERE e.idLogin=:idLogin",
                        Empleado.class);
        query.setParameter("idLogin", idLogin);
        return Validator.getSingleResult(query);
    }
    
      public Empleado obtenerEmpleadoPorIdentificacion(final String identificacion) {
        final TypedQuery<Empleado> query
                = this.em.createQuery("SELECT e FROM Empleado e WHERE e.numeroDocumento=:identificacion",
                        Empleado.class);
        query.setParameter("identificacion", identificacion);
        return Validator.getSingleResult(query);
    }

}
