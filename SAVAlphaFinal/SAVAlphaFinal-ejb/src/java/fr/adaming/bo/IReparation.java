/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.bo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author INTI-0205
 */
public interface IReparation {
    
    public List<String> choisirCategorieProduit(String categorie);
    public List<String> choisirMarqueProduit(String marque);
    public List<String> choisirModeleProduit(String modele);
    
    public boolean ajouter(int idReparateur, int idPanne, String details, 
            Date date, String etat, int payee);
    public boolean majEtat(String etat, Date date);
    public boolean payer();
    
}
