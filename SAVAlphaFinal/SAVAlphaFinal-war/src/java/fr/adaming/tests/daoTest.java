/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.tests;

import fr.adaming.dao.GarantiesFacade;
import fr.adaming.dao.GarantiesFacadeLocal;
import fr.adaming.dao.ProduitsFacade;
import fr.adaming.dao.ProduitsFacadeLocal;
import fr.adaming.models.Garanties;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author INTI-0205
 */
@Named
@SessionScoped
public class daoTest implements Serializable {

    private Collection<Garanties> garanties;

    @EJB
    private ProduitsFacadeLocal produitsTest;

    /**
     * Creates a new instance of daoTest
     */
    public daoTest() {
    }

    
    
    public Collection<Garanties> getGaranties() {
        return garanties;
    }

    public void setGaranties(Collection<Garanties> garanties) {
        this.garanties = garanties;
    }

    public ProduitsFacadeLocal getProduitsTest() {
        return produitsTest;
    }

    public void setProduitsTest(ProduitsFacadeLocal produitsTest) {
        this.produitsTest = produitsTest;
    }

}
