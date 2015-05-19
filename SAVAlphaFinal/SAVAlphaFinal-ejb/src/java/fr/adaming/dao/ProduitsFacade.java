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
 * @author INTI-0215
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
    public List<Produits> getByCategorie(String categorie){
        
        Query query = em.createNamedQuery("Produits.findByCategorie");
        query.setParameter("categorie", categorie);
        return query.getResultList();

    }
    
    @Override
    public List<Produits> getByCategorieAndMarque(String categorie, String marque){
        
        Query query =  em.createQuery("SELECT p FROM Produits p WHERE p.categorie = :categorie AND p.marque = :marque");
        query.setParameter("categorie", categorie);
        query.setParameter("marque", marque);
        return query.getResultList();
    }
    
    @Override
    public  List<String> getCategorie(){
        
        Query query =  em.createQuery("SELECT p.categorie FROM Produits p");
        return query.getResultList();
    }
    
    @Override
    public List<String> getMarqueByCategorie(String categorie)
    {
        Query query = em.createQuery("SELECT p.marque FROM Produits p WHERE p.categorie = :categorie");
        query.setParameter("categorie", categorie);
        return query.getResultList();
    }
    
    @Override
    public Collection<Garanties> findGarantiesByProduit(int id_produit) {
        return this.find(id_produit).getGarantiesCollection();
    }

    @Override
    public Collection<Pannes> findPannesByProduit(int id_produit) {
        return this.find(id_produit).getPannesCollection();
    }
 
}
