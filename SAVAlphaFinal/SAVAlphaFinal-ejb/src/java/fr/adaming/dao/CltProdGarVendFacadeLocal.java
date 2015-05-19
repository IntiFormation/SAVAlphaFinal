/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.CltProdGarVend;
import fr.adaming.models.Garanties;
import fr.adaming.models.Produits;
import fr.adaming.models.Reparations;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INTI-0205
 */
@Local
public interface CltProdGarVendFacadeLocal {

    void create(CltProdGarVend cltProdGarVend);

    void edit(CltProdGarVend cltProdGarVend);

    void remove(CltProdGarVend cltProdGarVend);

    CltProdGarVend find(Object id);

    List<CltProdGarVend> findAll();

    List<CltProdGarVend> findRange(int[] range);

    int count();
    
    public List<Garanties> findGarantiesByClient(int id_client);
    public List<Produits> findProduitsByClient(int id_client);
    public List<Reparations> findReparationsByClient(int id_client);
}
