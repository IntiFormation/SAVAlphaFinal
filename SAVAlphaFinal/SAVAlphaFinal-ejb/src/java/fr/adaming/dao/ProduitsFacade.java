/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Garanties;
import fr.adaming.models.Pannes;
import fr.adaming.models.Produits;
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
public class ProduitsFacade extends AbstractFacade<Produits> implements ProduitsFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitsFacade() {
        super(Produits.class);
    }
    
    @Override
    public List<Produits> findByCategorie(String categorie) {

        Query query = em.createNamedQuery("Produits.findByCategorie");
        query.setParameter("categorie", categorie);
        return query.getResultList();
    }

    @Override
    public List<Produits> findByMarque(String marque) {
        
        Query query = em.createNamedQuery("Produits.findByMarque");
        query.setParameter("marque", marque);
        return query.getResultList();
    }

    @Override
    public Produits findByModele(String modele) {
        
        Query query = em.createNamedQuery("Produits.findByModele");
        query.setParameter("modele", modele);
        return (Produits) query.getSingleResult();
    }

    @Override
    public List<String> findAllCategories() {

        Query query = em.createNamedQuery("Produits.findAllCategories");
        return query.getResultList();
    }

    @Override
    public List<String> findMarquesByCategorie(String categorie) {

        Query query = em.createNamedQuery("Produits.findMarquesByCategories");
        query.setParameter("categorie", categorie);
        return query.getResultList();
    }

    @Override
    public List<String> findModelesByMarque(String marque) {

        Query query = em.createNamedQuery("Produits.findModelesByMarque");
        query.setParameter("marque", marque);
        return query.getResultList();
    }

    @Override
    public Collection<Garanties> findGarantiesByProduit(int id_produit) {
        return this.find(id_produit).getGarantiesCollection();
    }
    
    @Override
    public Collection<Pannes> findPannesByProduit(String idProduit) {
        return this.find(idProduit).getPannesCollection();
    }
    
    @Override
    public List<String> findModelesByMarqueAndCategorie(String marque, String categorie) {
        Query query = em.createNamedQuery("Produits.findModelesByMarqueAndCategories");
        query.setParameter("marque", marque);
        query.setParameter("categorie", categorie);
        return (List<String>) query.getSingleResult();
    }
}
