/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.entity.Cargo;
import com.sena.terra.entity.Parametrizacion;
import com.sena.terra.utility.Validator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
@Stateless
public class ParametrizacionFacade extends AbstractFacade<Parametrizacion> {

    @PersistenceContext(unitName = "TerraDs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametrizacionFacade() {
        super(Parametrizacion.class);
    }

    public List<Parametrizacion> listaParametrizacion(final String paramAbrev) {
        final Query query = this.em.createQuery("SELECT p FROM Parametrizacion "
                + "p WHERE p.paramAbrev=:paramAbrev");
        query.setParameter("paramAbrev", paramAbrev);
        return query.getResultList();
        
    }
    
    
     public Parametrizacion obtenerCiudad(final String valor) {
        final TypedQuery<Parametrizacion> query
                = this.em.createQuery("SELECT c FROM Parametrizacion c WHERE c.valor =:valor AND c.paramAbrev =:param", Parametrizacion.class);
        query.setParameter("valor", valor);
        query.setParameter("param", "CDD");    
        return Validator.getSingleResult(query);
    }

}
