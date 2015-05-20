/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Achats;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface AchatsFacadeLocal {

    void create(Achats achats);

    void edit(Achats achats);

    void remove(Achats achats);

    Achats find(Object id);

    List<Achats> findAll();

    List<Achats> findRange(int[] range);

    int count();
    
}
