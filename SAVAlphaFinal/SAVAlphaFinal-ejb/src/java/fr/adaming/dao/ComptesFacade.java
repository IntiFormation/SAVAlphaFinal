/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.models.Comptes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

//    @Override
//    public boolean isValid(String login, String pwd) {
//        Query query = em.createNamedQuery("Comptes.findByLogin");
//        query.setParameter("login", login);
//        String real_pwd = query.getSingleResult().toString();
//        return real_pwd.equals(pwd);
//    }
    @Override
    public Integer findIdCompteByLogin(String login) {
        Query query = em.createNamedQuery("Comptes.findIdByLogin");
        query.setParameter("login", login);
        return (Integer) query.getSingleResult();
    }

    @Override
    public String findTypeCompte(Integer idCompte) {
        Query query = em.createNamedQuery("Comptes.findTypeById");
        query.setParameter("idCompte", idCompte);
        return (String) query.getSingleResult();
    }

    @Override
    public Comptes findByLogin(String login) {
        Query query = em.createNamedQuery("Comptes.findByLogin");
        query.setParameter("login", login);
        return (Comptes) query.getSingleResult();

    }

    @Override
    public boolean isValid(String login, String pwd) {
        try {
            Query query = em.createQuery("SELECT c.pwd FROM Comptes c WHERE c.login = :login ");
            query.setParameter("login", login);
            String pass = query.getSingleResult().toString();
            return pass.equals(pwd);
        } catch (NoResultException e) {
            return false;
        }

    }

}
