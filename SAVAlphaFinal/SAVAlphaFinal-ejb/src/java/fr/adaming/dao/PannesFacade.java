/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0215
 */
@Stateless
public class PannesFacade extends AbstractFacade<Pannes> implements PannesFacadeLocal {

    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PannesFacade() {
        super(Pannes.class);
    }

    @Override
    public List<Pannes> findAll() {
        Query query = em.createNamedQuery("Pannes.findAll");
        return query.getResultList();
    }

    @Override
    public Pannes find(Object id) {
        Query query = em.createNamedQuery("Pannes.findByIdPanne");
        query.setParameter("idPanne", id);
        return (Pannes) query.getSingleResult();
    }



}
