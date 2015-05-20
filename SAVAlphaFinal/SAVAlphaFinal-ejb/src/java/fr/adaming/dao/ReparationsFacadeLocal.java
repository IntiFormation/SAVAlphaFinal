/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import fr.adaming.models.Reparations;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface ReparationsFacadeLocal {

    void create(Reparations reparations);

    void edit(Reparations reparations);

    void remove(Reparations reparations);

    Reparations find(Object id);

    List<Reparations> findAll();

    List<Reparations> findRange(int[] range);

    int count();
    
    public String findEtat(Integer idReparation);
    
    public Integer findPayement(Integer idReparation);
    
    public Pannes findPanne(Integer idReparation);
    
    public String findDescription(Integer idReparation);
    
    public boolean updatePayee(int p, int idReparation);
    
    public boolean updateEtat(String etat, Date date, int idReparation);
    
}
