/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.controllers;

import java.util.Map;

/**
 *
 * @author INTI-0205
 */
public interface IReparationReparateur {
    
    Map<String,Float> remplirDevis();
    boolean seDeplacer();
    
}
