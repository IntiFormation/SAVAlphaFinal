/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ComptesFacade;
import fr.adaming.models.Comptes;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author INTI-0215
 */
@Named(value = "gestionConnection")
@SessionScoped
public class GestionConnection implements Serializable {

    Comptes compte;
    
    @EJB
    ComptesFacade compteF;
    
    public GestionConnection() {
    }
    
    public boolean isValid(String login, String pwd) {
        return compteF.isValid(login, pwd);
        
    }
    
}
