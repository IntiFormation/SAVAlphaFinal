/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Adresses;
import fr.adaming.models.Garanties;
import fr.adaming.models.Vendeurs;
import java.util.Collection;
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
public class VendeursFacade extends AbstractFacade<Vendeurs> implements VendeursFacadeLocal {

    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendeursFacade() {
        super(Vendeurs.class);
    }

    @Override
    public Collection<Garanties> getGaranties(Integer idVendeur) {
        
        return this.find(idVendeur).getGarantiesCollection();
    }
    
    public Adresses getAdresse(Integer idVendeur){
        return this.find(idVendeur).getIdAdresse();
    }
    
    public Integer getIdAdresse(Integer num, String voie, String code){
        Query query = em.createQuery("SELECT a.idAdresse FROM Adresses a WHERE a.numero = :numero AND a.nomVoie = :nomVoie AND a.codePostal = :codePostal");
        query.setParameter("numero", num);
        query.setParameter("nomVoie", voie);
        query.setParameter("codePostal", code);
        
        return (Integer) query.getSingleResult();
    }
    
    public Integer getIdCompte (String login){
        Query query = em.createNamedQuery("Comptes.findByLogin");
        query.setParameter("login", login);
        
        return (Integer) query.getSingleResult();
    }
}
