/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Enseignes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface EnseignesFacadeLocal {

    void create(Enseignes enseignes);

    void edit(Enseignes enseignes);

    void remove(Enseignes enseignes);

    Enseignes find(Object id);

    List<Enseignes> findAll();

    List<Enseignes> findRange(int[] range);

    int count();
    
}
