/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Adresses;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface AdressesFacadeLocal {

    void create(Adresses adresses);

    void edit(Adresses adresses);

    void remove(Adresses adresses);

    Adresses find(Object id);

    List<Adresses> findAll();

    List<Adresses> findRange(int[] range);

    int count();
    
}
