/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Comptes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface ComptesFacadeLocal {

    void create(Comptes comptes);

    void edit(Comptes comptes);

    void remove(Comptes comptes);

    Comptes find(Object id);

    List<Comptes> findAll();

    List<Comptes> findRange(int[] range);

    int count();
    
}
