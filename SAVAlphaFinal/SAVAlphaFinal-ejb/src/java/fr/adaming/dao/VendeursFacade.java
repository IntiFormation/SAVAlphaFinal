/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Achats;
import fr.adaming.models.Adresses;
import fr.adaming.models.Garanties;
import fr.adaming.models.Vendeurs;
import java.util.Collection;
import java.util.LinkedList;
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
public class VendeursFacade extends AbstractFacade<Vendeurs> implements VendeursFacadeLocal {
    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendeursFacade() {
        super(Vendeurs.class);
    }
    
    @Override
    public Adresses findAdresse(Integer idVendeur) {
        return this.find(idVendeur).getIdAdresse();
    }
    
    @Override
    public Collection<Garanties> findGarantiesByVendeur(Integer idVendeur) {
        
        return this.find(idVendeur).getGarantiesCollection();
    }

    @Override
    public Adresses findAdresseByVendeur(Integer idVendeur) {
        
        return this.find(idVendeur).getIdAdresse();
    }
    
}
