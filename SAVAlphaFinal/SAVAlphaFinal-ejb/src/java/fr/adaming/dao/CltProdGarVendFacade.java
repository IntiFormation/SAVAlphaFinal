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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class CltProdGarVendFacade extends AbstractFacade<CltProdGarVend> implements CltProdGarVendFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CltProdGarVendFacade() {
        super(CltProdGarVend.class);
    }

    @Override
    public void addReparation(int idReparation, int idProduit, int idClient) {
        Query query = em.createNamedQuery("CltProdGarVend.addReparation");
        query.setParameter("idReparation", idReparation);
        query.setParameter("idProduit", idProduit);
        query.setParameter("idClient", idClient);
    }
    
}
