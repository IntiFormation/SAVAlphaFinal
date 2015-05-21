/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ReparationsFacadeLocal;
import fr.adaming.dao.VendeursFacadeLocal;
import fr.adaming.models.Reparations;
import fr.adaming.models.Vendeurs;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author INTI-0214
 */
@Named(value = "gestionVendeur")
//@Dependent
@SessionScoped
public class GestionVendeur implements Serializable {

    private Vendeurs vendeur;

    @EJB
    private VendeursFacadeLocal vendeurFacade;

    @Inject
    private GestionProduitHome gestionProduitHome;

    @Inject
    private GestionClients gestionClients;

    //Propriété pour récupérer le param de l'url
    private int idVendeur;

    /**
     * Creates a new instance of GestionVendeur
     */
    public GestionVendeur() {
        /*vendeur = new Vendeurs();
         vendeur.setIdVendeur(2);
         vendeur.setNom("Henry");
         Enseignes enseigne = new Enseignes();
         enseigne.setNom("Carrefour");
         vendeur.setIdEnseigne(enseigne);*/
    }

    public void initVendeur() {
        setVendeur(new Vendeurs());
    }

//    public void majReparation() {
//        gestionProduitHome.reparationFacade.setDescription(reparation.getReparation);
//        gestionProduitHome.reparationFacade.setVendeur(vendeur);
//        gestionProduitHome.reparationFacade.setClient(gestionClients.getClient());
//    }

    /**
     * Récupération d'un vendeur
     */
    /*public void loadVendeur() {
     this.setVendeur(vendeurFacade.find(vendeur.getIdVendeur()));
     }*/
    //Getters and setters
    public Vendeurs getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeurs vendeur) {
        this.vendeur = vendeur;
    }

    public int getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(int idVendeur) {
        this.idVendeur = idVendeur;
    }

}
