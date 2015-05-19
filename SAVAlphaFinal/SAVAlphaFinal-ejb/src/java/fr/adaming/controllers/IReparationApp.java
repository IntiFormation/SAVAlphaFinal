/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.controllers;

import java.util.Date;

/**
 *
 * @author INTI-0205
 */
public interface IReparationApp {
    
    public boolean majEtat(int idReparation, String etat, Date date);
    public boolean solder(int idReparation);
    
}
