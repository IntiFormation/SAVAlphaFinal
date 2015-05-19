/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Reparations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class ReparationsFacade extends AbstractFacade<Reparations> implements ReparationsFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparationsFacade() {
        super(Reparations.class);
    }

    @Override
    public List<Reparations> findByReparateur(int id_reparateur) {
        Query query = em.createNamedQuery("Reparations.findByReparateur");
        query.setParameter("idReparateur", id_reparateur);
        return query.getResultList();
    }
    
}
