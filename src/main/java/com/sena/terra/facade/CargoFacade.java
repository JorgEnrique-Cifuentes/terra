/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.Cargo;
import com.sena.terra.entity.Login;
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
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }

    public Cargo obtenerCargo(final String valor) {
        final TypedQuery<Cargo> query
                = this.em.createNamedQuery("Cargo.findByNombre", Cargo.class);
        query.setParameter("nombre", valor);
        return Validator.getSingleResult(query);
    }

}
