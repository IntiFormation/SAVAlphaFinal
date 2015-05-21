/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INTI-0215
 */
@Entity
@Table(name = "comptes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptes.findAll", query = "SELECT c FROM Comptes c"),
    @NamedQuery(name = "Comptes.findByIdCompte", query = "SELECT c FROM Comptes c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "Comptes.findByLogin", query = "SELECT c FROM Comptes c WHERE c.login = :login"),
    @NamedQuery(name = "Comptes.findByPwd", query = "SELECT c FROM Comptes c WHERE c.pwd = :pwd"),
    @NamedQuery(name = "Comptes.findByType", query = "SELECT c FROM Comptes c WHERE c.type = :type"),
    @NamedQuery(name = "Comptes.findIdByLogin", query = "SELECT c.idCompte FROM Comptes c WHERE c.login = :login"),
    @NamedQuery(name = "Comptes.findTypeById", query = "SELECT c.type FROM Comptes c WHERE c.idCompte = :idCompte")})
public class Comptes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compte")
    private Integer idCompte;
    @Size(max = 254)
    @Column(name = "login")
    private String login;
    @Size(max = 254)
    @Column(name = "pwd")
    private String pwd;
    @Size(max = 45)
    @Column(name = "type")
    private String type;

    public Comptes() {
    }

    public Comptes(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompte != null ? idCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comptes)) {
            return false;
        }
        Comptes other = (Comptes) object;
        if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Comptes[ idCompte=" + idCompte + " ]";
    }
    
}
