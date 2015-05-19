/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Garanties;
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
public class GarantiesFacade extends AbstractFacade<Garanties> implements GarantiesFacadeLocal {

    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GarantiesFacade() {
        super(Garanties.class);
    }

    @Override
    public List<Garanties> findByProduit(int id_produit) {
        Query query = em.createNativeQuery("SELECT id_garanties FROM prod_gar WHERE id_produit=" + id_produit);
        List<Integer> id_garanties = query.getResultList();
        List<Garanties> garanties = new ArrayList<>();
        for (Integer id : id_garanties) {
            query = em.createNamedQuery("Garanties.findByIdGarantie");
            query.setParameter("idGarantie", id);
            garanties.add((Garanties) query.getSingleResult());
        }
        return garanties;
    }

}
