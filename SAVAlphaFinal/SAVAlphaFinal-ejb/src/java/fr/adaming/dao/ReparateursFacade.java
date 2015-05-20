/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Adresses;
import fr.adaming.models.Reparateurs;
import fr.adaming.models.Reparations;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class ReparateursFacade extends AbstractFacade<Reparateurs> implements ReparateursFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparateursFacade() {
        super(Reparateurs.class);
    }
    
    @Override
    public Adresses findAdresse(Integer idReparateur) {        
        return this.find(idReparateur).getIdAdresse();
    }
    
    @Override
    public Collection<Reparations> findReparationsByReparateur(int idReparateur) {
        return this.find(idReparateur).getReparationsCollection();
    }
    
}
