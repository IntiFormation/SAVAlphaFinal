/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Garanties;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface GarantiesFacadeLocal {

    void create(Garanties garanties);

    void edit(Garanties garanties);

    void remove(Garanties garanties);

    Garanties find(Object id);

    List<Garanties> findAll();

    List<Garanties> findRange(int[] range);

    int count();
    
}
