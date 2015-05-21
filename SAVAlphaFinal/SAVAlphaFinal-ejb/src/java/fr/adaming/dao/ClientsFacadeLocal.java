/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Clients;
import fr.adaming.models.Comptes;
import fr.adaming.models.Garanties;
import fr.adaming.models.Produits;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface ClientsFacadeLocal {

    void create(Clients clients);

    void edit(Clients clients);

    void remove(Clients clients);

    Clients find(Object id);

    List<Clients> findAll();

    List<Clients> findRange(int[] range);

    int count();
    
    public Collection<Produits> findProduitsByClient(int id_client);
    
    public Collection<Garanties> findGarantiesByClient(int id_client);
    
    public Clients findByIdCompte(Comptes idCompte);
    
}
