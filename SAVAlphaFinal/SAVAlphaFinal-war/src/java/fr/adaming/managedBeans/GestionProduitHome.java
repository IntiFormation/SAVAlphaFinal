/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ProduitsFacadeLocal;
import fr.adaming.models.Produits;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named
@SessionScoped
public class GestionProduitHome implements Serializable{
    
    List<Produits> listProd;
    List<String> categories = new ArrayList<>();
    List<String> marques = new ArrayList<>();
    List<String> modeles = new ArrayList<>();
    String categorie, marque, modele;
    
    
    @EJB
    private ProduitsFacadeLocal produitsFacade;
    
    public GestionProduitHome() {
        //categories.add("Informatique");
        //categories.add("Hi fi");
        
        marques.add("hp");
        marques.add("Aser");
        marques.add("Sony");
        marques.add("Yamaha");
        
        modeles.add("Ordinateur");
        modeles.add("Souris");
        modeles.add("Chaine hi fi");
        modeles.add("Enceinte");
        modeles.add("Micro");
    }

    public List<String> getCategories() {
        return produitsFacade.findAllCategories();
    }

    public List<String> getMarques() {
        return marques;
    }

    public List<String> getModeles() {
        return modeles;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
    
    public List<Produits> getProd(){
        
        return produitsFacade.findAll();
    }
    
    public void onCategorieChange() {
        if(categorie !=null && !categorie.equals(""))
            marques = produitsFacade.findMarquesByCategorie(categorie);
        else
            marques = new ArrayList<>();
    }
    
}
