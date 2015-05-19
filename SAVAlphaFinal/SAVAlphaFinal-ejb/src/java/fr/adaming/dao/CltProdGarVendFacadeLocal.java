/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.CltProdGarVend;
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

    public void addReparation(int idReparation, int idProduit, int idClient);
}
