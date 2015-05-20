/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Adresses;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class AdressesFacade extends AbstractFacade<Adresses> implements AdressesFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdressesFacade() {
        super(Adresses.class);
    }
    
    public Integer findIdAdresse(Integer num, String voie, String code){
        Query query = em.createNamedQuery("Vendeurs.findIdAdresseByIdVendeur");
        query.setParameter("numero", num);
        query.setParameter("nomVoie", voie);
        query.setParameter("codePostal", code);
        return (Integer) query.getSingleResult();
    }
    
}
