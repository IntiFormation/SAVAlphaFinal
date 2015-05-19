/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.bo;

import java.util.Date;

/**
 *
 * @author INTI-0205
 */
public interface IReparationReparateur {
    
    public boolean recevoirProduit(int idReparation);
    public boolean reparerProduit(int idReparation);
    public boolean renvoyerProduit(int idReparation);
    
}
