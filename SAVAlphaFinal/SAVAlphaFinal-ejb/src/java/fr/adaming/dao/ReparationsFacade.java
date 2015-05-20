/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import fr.adaming.models.Reparations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public String getEtat(Integer idReparation) {
        return this.find(idReparation).getEtat();
    }

    @Override
    public Integer getPayement(Integer idReparation) {
        return this.find(idReparation).getPayee();
    }

    @Override
    public Pannes getPanne(Integer idReparation) {
        return this.find(idReparation).getIdPanne();
    }

    @Override
    public String getDescription(Integer idReparation) {
        return this.find(idReparation).getDescription();
    }
}
