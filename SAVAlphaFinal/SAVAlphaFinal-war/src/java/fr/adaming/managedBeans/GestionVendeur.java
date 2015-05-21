/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.VendeursFacadeLocal;
import static fr.adaming.managedBeans.GestionClients.addMessage;
import fr.adaming.models.Vendeurs;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

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

    /**
     * Creates a new instance of GestionVendeur
     */
    public GestionVendeur() {
    }

    public void initVendeur() {
        setVendeur(new Vendeurs());
    }

    public void addClient() {
        try {
            vendeur.setIdVendeur(1);
            vendeurFacade.create(vendeur);
            addMessage("Merci pour votre inscription", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            addMessage("Erreur pendant votre inscription", FacesMessage.SEVERITY_ERROR);
        }
    }

    //Getters and setters
    public Vendeurs getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeurs vendeur) {
        this.vendeur = vendeur;
    }

}
