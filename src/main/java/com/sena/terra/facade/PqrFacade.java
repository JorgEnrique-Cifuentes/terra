/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.Pqr;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gaes1
 */
@Stateless
public class PqrFacade extends AbstractFacade<Pqr> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrFacade() {
        super(Pqr.class);
    }

    public List<Pqr> listAll(final int empleadoId) {
        final Query query = this.em.createQuery("SELECT p FROM Pqr p WHERE p.idEmpleado.id=:idEmpleado");
        query.setParameter("idEmpleado", empleadoId);
        return query.getResultList();
    }

}
