/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Comptes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INTI-0205
 */
@Stateless
public class ComptesFacade extends AbstractFacade<Comptes> implements ComptesFacadeLocal {

    @PersistenceContext(unitName = "SAVAlphaFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComptesFacade() {
        super(Comptes.class);
    }

    @Override
    public boolean isValid(String login, String pwd) {
        Query query = em.createNamedQuery("Comptes.findByLogin");
        query.setParameter("login", login);
        String real_pwd = query.getSingleResult().toString();
        return real_pwd.equals(pwd);
    }

    @Override
    public Integer findIdCompteByLogin(String login) {

        Query query = em.createNamedQuery("Comptes.findByLogin");
        query.setParameter("login", login);
        return (Integer) query.getSingleResult();
    }

}
