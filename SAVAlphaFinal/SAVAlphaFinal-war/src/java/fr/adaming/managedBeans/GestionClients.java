/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.AdressesFacadeLocal;
import fr.adaming.dao.ClientsFacadeLocal;
import fr.adaming.dao.ComptesFacadeLocal;
import fr.adaming.models.Adresses;
import fr.adaming.models.Clients;
import fr.adaming.models.Comptes;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author INTI-0214
 */
@Named(value = "gestionClients")
@SessionScoped
public class GestionClients implements Serializable {

    private Clients client;
    private Adresses adresse;
    private Comptes compte;

    @EJB
    private ClientsFacadeLocal clientFacade;
    @EJB
    private AdressesFacadeLocal adresseFacade;
    @EJB
    private ComptesFacadeLocal compteFacade;

    /**
     * Creates a new instance of GestionUtilisateur
     */
    public GestionClients() {
    }

    public void initClients() {
        setClient(new Clients());
        setAdresse(new Adresses());
        setCompte(new Comptes());
    }

    /*public void initAdresses() {
        setAdresse(new Adresses());
    }

    public void initComptes() {
        setCompte(new Comptes());
    }*/

    public void addClient() {
        try {
            client.setIdClient(1);
            clientFacade.create(client);
            adresse.setIdAdresse(1);
            adresseFacade.create(adresse);
            compte.setIdCompte(1);
            compteFacade.create(compte);
            addMessage("Merci pour votre inscription", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            addMessage("Erreur pendant votre inscription", FacesMessage.SEVERITY_ERROR);
        }
    }

    /*public void addAdresse() {
        try {
            adresseFacade.create(adresse);
        } catch (Exception ex) {
            addMessage("Erreur pendant la création de votre adresse", FacesMessage.SEVERITY_ERROR);
        }
    }

    public void addCompte() {
        try {
            compteFacade.create(compte);
        } catch (Exception ex) {
            addMessage("Erreur pendant la création de votre compte", FacesMessage.SEVERITY_ERROR);
        }
    }*/

    public static void addMessage(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity, message, message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, facesMessage);
    }

    //Getters and setters
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Adresses getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresses adresse) {
        this.adresse = adresse;
    }
    
    public Comptes getCompte() {
        return compte;
    }

    public void setCompte(Comptes compte) {
        this.compte = compte;
    }
}
