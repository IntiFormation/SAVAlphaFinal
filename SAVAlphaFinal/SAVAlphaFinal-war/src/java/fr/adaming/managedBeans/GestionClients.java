/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.AdressesFacadeLocal;
import fr.adaming.dao.ClientsFacadeLocal;
import fr.adaming.dao.ComptesFacadeLocal;
import fr.adaming.dao.ReparateursFacade;
import fr.adaming.dao.ReparateursFacadeLocal;
import fr.adaming.dao.VendeursFacade;
import fr.adaming.dao.VendeursFacadeLocal;
import fr.adaming.models.Adresses;
import fr.adaming.models.Clients;
import fr.adaming.models.Comptes;
import fr.adaming.models.Reparateurs;
import fr.adaming.models.Vendeurs;
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

    private Clients client = null;
    private Vendeurs vendeur = null;
    private Reparateurs reparateur = null;
    private Adresses adresse;
    private Comptes compte = new Comptes();
    private Comptes compteP;

    @EJB
    private ClientsFacadeLocal clientFacade;
    @EJB
    private AdressesFacadeLocal adresseFacade;
    @EJB
    private ComptesFacadeLocal compteFacade;
    @EJB
    private VendeursFacadeLocal vendeurFacade;
    @EJB
    private ReparateursFacadeLocal reparateurFacade;

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

    public String connexion() {
        String page = null;
        compteP = new Comptes();

        if (compteFacade.isValid(compte.getLogin(), compte.getPwd())) {
            compteP = compteFacade.findByLogin(compte.getLogin());

            String type = compteFacade.findTypeCompte(compteP.getIdCompte());
            if ("client".equals(type)) {
                setClient(clientFacade.findByIdCompte(compteP));
                System.out.println(client);
                page = "/paiement.xhtml";
            }
            if ("vendeur".equals(type)) {
                setVendeur(vendeurFacade.findByIdCompte(compteP));
                page = "/faces/ficheRepVendeur.xhtml?faces-redirect=true";
            }
            if ("reparateur".equals(type)) {
                setReparateur(reparateurFacade.findByIdCompte(compteP));
                page = "/faces/progtech.xhtml?faces-redirect=true";
            }

            compte.setPwd("");

            return page;
        } else {
            System.out.println("erreur");
            return null;
        }
    }

    public String deconnexion() {
        setCompte(new Comptes());
        setClient(new Clients());
        setVendeur(new Vendeurs());
        setReparateur(new Reparateurs());
        return "/home.xhtml";
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

    public Vendeurs getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeurs vendeur) {
        this.vendeur = vendeur;
    }

    public Reparateurs getReparateur() {
        return reparateur;
    }

    public void setReparateur(Reparateurs reparateur) {
        this.reparateur = reparateur;
    }

}
