/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.tests;

import fr.adaming.dao.GarantiesFacade;
import fr.adaming.dao.GarantiesFacadeLocal;
import fr.adaming.models.Garanties;
import java.io.Serializable;

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

    private Garanties garantie;

    @EJB
    private GarantiesFacadeLocal garantiesTest;

    /**
     * Creates a new instance of daoTest
     */
    public daoTest() {
    }

    public void appTest() {
        try {
            Garanties tmp = garantiesTest.find(2);
            setGarantie(tmp);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public Garanties getGarantie() {
        return garantie;
    }

    public void setGarantie(Garanties garantie) {
        this.garantie = garantie;
    }

    public GarantiesFacadeLocal getGarantiesTest() {
        return garantiesTest;
    }

    public void setGarantiesTest(GarantiesFacade garantiesTest) {
        this.garantiesTest = garantiesTest;
    } 
}
