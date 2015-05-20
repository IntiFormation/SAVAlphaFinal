/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Clients;
import fr.adaming.models.CltProdGarVend;
import fr.adaming.models.Garanties;
import fr.adaming.models.Produits;
import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0215
 */
@Stateless
public class ClientsFacade extends AbstractFacade<Clients> implements ClientsFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientsFacade() {
        super(Clients.class);
    }

//    @Override
//    public Collection<Produits> findProduitsByClient(int id_client) {
//        Collection<CltProdGarVend> tmp = this.find(id_client).getCltProdGarVendCollection();
//        Collection<Produits> produits = new LinkedList<>();
//        for (CltProdGarVend t : tmp) {
//            produits.add(produitsDao.find(t.getIdProduit()));
//        }
//        return produits;
//    }
//
//    @Override
//    public Collection<Garanties> findGarantiesByClient(int id_client) {
//        Collection<CltProdGarVend> tmp = this.find(id_client).getCltProdGarVendCollection();
//        Collection<Garanties> garanties = new LinkedList<>();
//        for (CltProdGarVend t : tmp) {
//            garanties.add(garantiesDao.find(t.getIdGarantie()));
//        }
//        return garanties;
//    }
    
    @Override
    public Integer getIdAdresse(Integer num, String voie, String code){
        Query query = em.createQuery("SELECT a.idAdresse FROM Adresses a WHERE a.numero = :numero AND a.nomVoie = :nomVoie AND a.codePostal = :codePostal");
        query.setParameter("numero", num);
        query.setParameter("nomVoie", voie);
        query.setParameter("codePostal", code);
        
        return (Integer) query.getSingleResult();
    }
    
    @Override
    public Integer getIdCompte (String login){
        Query query = em.createNamedQuery("Comptes.findByLogin");
        query.setParameter("login", login);
        
        return (Integer) query.getSingleResult();
    }
    
}
