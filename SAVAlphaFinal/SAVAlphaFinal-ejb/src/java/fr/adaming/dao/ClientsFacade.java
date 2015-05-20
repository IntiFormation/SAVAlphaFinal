/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Achats;
import fr.adaming.models.Clients;
import fr.adaming.models.Garanties;
import fr.adaming.models.Produits;
import fr.adaming.models.Vendeurs;
import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0205
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
    
    @Override
    public Collection<Produits> findProduitsByClient(int id_client) {
        
        Collection<Achats> achats = this.find(id_client).getAchatsCollection();
        Collection<Produits> produits = new LinkedList<>();
        ProduitsFacadeLocal produit = new ProduitsFacade();
        for (Achats a : achats) {
            produits.add(produit.find(a.getIdProduit()));
        }
        return produits;
    }

    @Override
    public Collection<Garanties> findGarantiesByClient(int id_client) {
        
        Collection<Achats> achats = this.find(id_client).getAchatsCollection();
        Collection<Garanties> garanties = new LinkedList<>();
        GarantiesFacadeLocal garantie = new GarantiesFacade();
        for (Achats a : achats) {
            garanties.add(garantie.find(a.getIdClient()));
        }
        return garanties;
    }
    
    @Override
    public Clients findByIdCompte(int idCompte) {
        Query query = em.createNamedQuery("Clients.findByIdCompte");
        query.setParameter("idCompte", idCompte);
        return (Clients) query.getSingleResult();
    }
    
}
