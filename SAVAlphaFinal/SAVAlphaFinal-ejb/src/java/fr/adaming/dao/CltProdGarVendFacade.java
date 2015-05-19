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
    public List<Garanties> findGarantiesByClient(int id_client) {
        Query query = em.createNamedQuery("CltProdGarVend.findGarantiesByClient");
        query.setParameter("idClient", id_client);
        List<Integer> id_garanties = query.getResultList();
        List<Garanties> garanties = new ArrayList<>();
        for (Integer id : id_garanties) {
            query = em.createNamedQuery("Garanties.findByIdGarantie");
            query.setParameter("idGarantie", id);
            garanties.add((Garanties) query.getSingleResult());
        }
        return garanties;
    }

    @Override
    public List<Produits> findProduitsByClient(int id_client) {
        Query query = em.createNamedQuery("CltProdGarVend.findProduitsByClient");
        query.setParameter("idClient", id_client);
        List<Integer> id_garanties = query.getResultList();
        List<Produits> produits = new ArrayList<>();
        for (Integer id : id_garanties) {
            query = em.createNamedQuery("Produits.findByIdProduit");
            query.setParameter("idProduit", id);
            produits.add((Produits) query.getSingleResult());
        }
        return produits;
    }

    @Override
    public List<Reparations> findReparationsByClient(int id_client) {
        Query query = em.createNamedQuery("CltProdGarVend.findReparationsByClient");
        query.setParameter("idClient", id_client);
        List<Integer> id_garanties = query.getResultList();
        List<Reparations> reparations = new ArrayList<>();
        for (Integer id : id_garanties) {
            query = em.createNamedQuery("Reparations.findByIdReparation");
            query.setParameter("idReparation", id);
            reparations.add((Reparations) query.getSingleResult());
        }
        return reparations;
    }
    
}
