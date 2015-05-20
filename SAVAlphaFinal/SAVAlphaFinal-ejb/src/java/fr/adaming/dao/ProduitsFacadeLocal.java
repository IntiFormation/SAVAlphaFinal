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
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface ProduitsFacadeLocal {

    void create(Produits produits);

    void edit(Produits produits);

    void remove(Produits produits);

    Produits find(Object id);

    List<Produits> findAll();

    List<Produits> findRange(int[] range);

    int count();
    
    public List<Produits> findByCategorie(String categorie);
    
    public List<Produits> findByMarque(String marque);
    
    public Produits findByModele(String modele);
    
    public List<String> findAllCategories();
    
    public List<String> findMarquesByCategorie(String categorie);
    
    public List<String> findModelesByMarque(String marque);
    
    public Collection<Garanties> findGarantiesByProduit(int id_produit);
    
    public Collection<Pannes> findPannesByProduit(String idProduit);
    
}
