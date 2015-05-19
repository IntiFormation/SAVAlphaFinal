/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.controllers;

import fr.adaming.models.Pannes;
import fr.adaming.models.Produits;
import fr.adaming.models.Reparateurs;
import java.util.Date;
import java.util.List;

/**
 *
 * @author INTI-0205
 */
public interface IReparationClient {
    
    public List<String> choisirCategorieProduit(String categorie);
    public List<String> choisirMarqueProduit(String marque);
    public Produits choisirModeleProduit(String modele);
    
    public void ajouterReparation(Reparateurs reparateurs, Pannes pannes, String details, 
            Date date, String etat, int payee, int idProduit, int idClient);
    
}
