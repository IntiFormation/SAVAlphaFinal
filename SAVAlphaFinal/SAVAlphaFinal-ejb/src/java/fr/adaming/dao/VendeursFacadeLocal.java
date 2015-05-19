/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Vendeurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface VendeursFacadeLocal {

    void create(Vendeurs vendeurs);

    void edit(Vendeurs vendeurs);

    void remove(Vendeurs vendeurs);

    Vendeurs find(Object id);

    List<Vendeurs> findAll();

    List<Vendeurs> findRange(int[] range);

    int count();
    
}
