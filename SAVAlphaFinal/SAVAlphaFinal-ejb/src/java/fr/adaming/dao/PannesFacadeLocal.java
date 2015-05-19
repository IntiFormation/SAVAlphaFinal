/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0215
 */
@Local
public interface PannesFacadeLocal {

    void create(Pannes pannes);

    void edit(Pannes pannes);

    void remove(Pannes pannes);

    Pannes find(Object id);

    List<Pannes> findAll();

    List<Pannes> findRange(int[] range);

    int count();
    
    List<Pannes> getPannesByProduit(String idProduit);
    
}
