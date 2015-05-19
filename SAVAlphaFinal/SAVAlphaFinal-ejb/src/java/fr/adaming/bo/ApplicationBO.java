/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.bo;

import fr.adaming.dao.ReparationsFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author INTI-0205
 */
public class ApplicationBO implements IReparationApp{
    
    @EJB
    private ReparationsFacadeLocal reparation;
    
    @Override
    public boolean majEtat(int idReparation, String etat, Date date) {
        return reparation.updateEtat(etat, date, idReparation);
    }

    @Override
    public boolean solder(int idReparation) {
        return reparation.updatePayee(1, idReparation);
    }
    
}
