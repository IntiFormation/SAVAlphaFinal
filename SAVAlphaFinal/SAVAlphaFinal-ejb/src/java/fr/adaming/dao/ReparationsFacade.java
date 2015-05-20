/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import fr.adaming.models.Reparations;
import java.util.Date;
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
    public String findEtat(Integer idReparation) {
        return this.find(idReparation).getEtat();
    }

    @Override
    public Integer findPayement(Integer idReparation) {
        return this.find(idReparation).getPayee();
    }

    @Override
    public Pannes findPanne(Integer idReparation) {
        return this.find(idReparation).getIdPanne();
    }

    @Override
    public String findDescription(Integer idReparation) {
        return this.find(idReparation).getDescription();
    }
    
    @Override
    public boolean updatePayee(int p, int idReparation) {
        Query query = em.createNamedQuery("Reparations.updatePayee");
        query.setParameter("payee", p);
        query.setParameter("idReparation", idReparation);
        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateEtat(String etat, Date date, int idReparation) {
        Query query = em.createNamedQuery("Reparations.updtateEtat");
        query.setParameter("etat", etat);
        query.setParameter("date", date);
        query.setParameter("idReparation", idReparation);
        return query.executeUpdate() == 1;
    }
    
}
