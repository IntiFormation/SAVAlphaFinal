/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Clients;
import fr.adaming.models.CltProdGarVend;
import fr.adaming.models.Garanties;
import fr.adaming.models.Produits;
import fr.adaming.models.Reparations;
import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class ClientsFacade extends AbstractFacade<Clients> implements ClientsFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;
    
    @EJB
    ProduitsFacadeLocal produitsDao;
    
    @EJB
    GarantiesFacadeLocal garantiesDao;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientsFacade() {
        super(Clients.class);
    }
    
    @Override
    public Collection<Produits> findProduitsByClient(int id_client) {
        Collection<CltProdGarVend> tmp = this.find(id_client).getCltProdGarVendCollection();
        Collection<Produits> produits = new LinkedList<>();
        for (CltProdGarVend t : tmp) {
            produits.add(produitsDao.find(t.getIdProduit()));
        }
        return produits;
    }

    @Override
    public Collection<Garanties> findGarantiesByClient(int id_client) {
        Collection<CltProdGarVend> tmp = this.find(id_client).getCltProdGarVendCollection();
        Collection<Garanties> garanties = new LinkedList<>();
        for (CltProdGarVend t : tmp) {
            garanties.add(garantiesDao.find(t.getIdGarantie()));
        }
        return garanties;
    }

}
