/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.HojasDeVida;
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
public class HojasDeVidaFacade extends AbstractFacade<HojasDeVida> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojasDeVidaFacade() {
        super(HojasDeVida.class);
    }

    public boolean curriculumExiste(final String identificacion) {
        final TypedQuery<HojasDeVida> query
                = this.em.createQuery("SELECT h FROM HojasDeVida h WHERE h.numeroDocumento =:numeroDocumento",
                        HojasDeVida.class);
        query.setParameter("numeroDocumento", identificacion);
        return Validator.getSingleResult(query) != null;
    }

}
