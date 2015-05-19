/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Produits;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0215
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

    List<Produits> getByCategorie(String categorie);

    Produits getById(int id);

    List<Produits> getByCategorieAndMarque(String categorie, String marque);
    
    List<String> getCategorie();
    
    List<String> getMarqueByCategorie(String categorie);
    
    
    
}
