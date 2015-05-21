/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ComptesFacade;
import fr.adaming.models.Comptes;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author INTI-0214
 */
@Named(value = "gestionCompte")
@SessionScoped
public class GestionCompte {

    private Comptes compte;

    @EJB
    private ComptesFacade compteFacade;

    /**
     * Creates a new instance of GestionCompte
     */
    public GestionCompte() {
    }

    public void initComptes() {
        setCompte(new Comptes());
    }

    public void addCompte() {
        try {
            compteFacade.create(compte);
        } catch (Exception ex) {
            addMessage("Erreur pendant la création de votre compte", FacesMessage.SEVERITY_ERROR);
        }
    }

    public static void addMessage(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity, message, message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, facesMessage);
    }

    //Getters and setters
    public Comptes getCompte() {
        return compte;
    }

    public void setCompte(Comptes compte) {
        this.compte = compte;
    }

}
