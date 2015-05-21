/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.controllers;

import fr.adaming.dao.*;
import fr.adaming.models.Pannes;
import fr.adaming.models.Produits;
import fr.adaming.models.Reparateurs;
import fr.adaming.models.Reparations;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;

/**
 *
 * @author INTI-0205
 */
public class ControllerApp implements IReparationApp, IReparationClient,
        IReparationReparateur{
    
    @EJB
    private ReparationsFacadeLocal reparation;
    
    @EJB
    private ClientsFacadeLocal client;
    
    @EJB
    private ProduitsFacadeLocal produit;
    
    
    @Override
    public boolean majEtat(int idReparation, String etat, Date date) {
        return reparation.updateEtat(etat, date, idReparation);
    }

    @Override
    public boolean solder(int idReparation) {
        return reparation.updatePayee(1, idReparation);
    }

    @Override
    public List<String> choisirCategorieProduit(String categorie) {
        return produit.findMarquesByCategorie(categorie);
    }

    @Override
    public List<String> choisirMarqueProduit(String marque) {
        return produit.findModelesByMarque(marque);
    }

    @Override
    public Produits choisirModeleProduit(String modele) {
        return produit.findByModele(modele);
    }

    @Override
    public void ajouterReparation(Reparateurs reparateurs, Pannes pannes, String details,
            Date date, String etat, int payee, int idProduit, int idClient) {
    }

    @Override
    public Map<String, Float> remplirDevis() {
        return null;
    }

    @Override
    public boolean seDeplacer() {
        return true;
    }
    
}
