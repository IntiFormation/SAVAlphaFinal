/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.AdressesFacade;
import fr.adaming.models.Adresses;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author INTI-0214
 */
@Named(value = "gestionAdresse")
@SessionScoped
public class GestionAdresse {

    private Adresses adresse;

    @EJB
    private AdressesFacade adresseFacade;

    /**
     * Creates a new instance of GestionAdresse
     */
    public GestionAdresse() {
    }

    public void initAdresses() {
        setAdresse(new Adresses());
    }

    public void addAdresse() {
        try {
            adresseFacade.create(adresse);
        } catch (Exception ex) {
            addMessage("Erreur pendant la création de votre adresse", FacesMessage.SEVERITY_ERROR);
        }
    }

    public static void addMessage(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity, message, message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, facesMessage);
    }

    //Getters and setters
    public Adresses getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresses adresse) {
        this.adresse = adresse;
    }

}
