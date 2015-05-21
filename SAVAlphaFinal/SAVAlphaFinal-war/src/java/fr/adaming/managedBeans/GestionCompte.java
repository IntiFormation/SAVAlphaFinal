/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author INTI-0214
 */
@Named(value = "gestionCompte")
@SessionScoped
public class GestionCompte implements Serializable{
    
    @Inject
    private GestionClients gestionClients;
    
    /**
     * Creates a new instance of GestionCompte
     */
    public GestionCompte() {
    }

    public void save() {
        gestionClients.getAdresseFacade().edit(gestionClients.getAdresse());
        gestionClients.getCompteFacade().edit(gestionClients.getCompte());
        gestionClients.getClientFacade().edit(gestionClients.getClient());
    }

    public static void addMessage(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity, message, message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, facesMessage);
    }

    public GestionClients getGestionClients() {
        return gestionClients;
    }
    
}
