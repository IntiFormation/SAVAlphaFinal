/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Pannes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0215
 */
@Stateless
public class PannesFacade extends AbstractFacade<Pannes> implements PannesFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PannesFacade() {
        super(Pannes.class);
    }
    
    @Override
    public List<Pannes> getPannesByProduit(String idProduit)
    {
        List<Pannes> pannes = null;
        Query query1 = em.createQuery("SELECT pp FROM prod_panne pp WHERE id_produit = : idProduit");
        query1.setParameter("idProduit", idProduit);
        List<Integer> idPannes = (List<Integer>) query1.getResultList();
        
        for (int i = 0; i < idPannes.size(); i++) {
            int idPanne = idPannes.get(i);
            Query query = em.createNamedQuery("Pannes.findByIdPanne");
            query.setParameter("idPanne", idPanne);
            Pannes panne = (Pannes) query.getSingleResult();            
            pannes.add(panne);
        }
        return pannes;
    }
}
