/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ClientsFacade;
import fr.adaming.models.Clients;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI-0214
 */
@ManagedBean(name = "getsionClients")
@SessionScoped
public class GestionClients {

    private Clients client;

    @EJB
    private ClientsFacade clientFacade;

    /**
     * Creates a new instance of GestionUtilisateur
     */
    public GestionClients() {
    }

    public void initClients() {
        setClient(new Clients());
    }

    public void addClient() {
        try {
            clientFacade.create(client);
            addMessage("Merci pour votre inscription", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            addMessage("Erreur pendant votre inscription", FacesMessage.SEVERITY_ERROR);
        }
    }

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

}
