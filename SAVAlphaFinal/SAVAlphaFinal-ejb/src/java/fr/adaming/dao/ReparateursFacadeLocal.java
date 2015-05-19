/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Reparateurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface ReparateursFacadeLocal {

    void create(Reparateurs reparateurs);

    void edit(Reparateurs reparateurs);

    void remove(Reparateurs reparateurs);

    Reparateurs find(Object id);

    List<Reparateurs> findAll();

    List<Reparateurs> findRange(int[] range);

    int count();
    
}
