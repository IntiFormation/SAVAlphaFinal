/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "adresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresses.findAll", query = "SELECT a FROM Adresses a"),
    @NamedQuery(name = "Adresses.findByIdAdresse", query = "SELECT a FROM Adresses a WHERE a.idAdresse = :idAdresse"),
    @NamedQuery(name = "Adresses.findByNumero", query = "SELECT a FROM Adresses a WHERE a.numero = :numero"),
    @NamedQuery(name = "Adresses.findByNomVoie", query = "SELECT a FROM Adresses a WHERE a.nomVoie = :nomVoie"),
    @NamedQuery(name = "Adresses.findByCodePostal", query = "SELECT a FROM Adresses a WHERE a.codePostal = :codePostal"),
    @NamedQuery(name = "Adresses.findByVille", query = "SELECT a FROM Adresses a WHERE a.ville = :ville")})
public class Adresses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_adresse")
    private Integer idAdresse;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "nom_voie")
    private String nomVoie;
    @Size(max = 45)
    @Column(name = "code_postal")
    private String codePostal;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @OneToMany(mappedBy = "idAdresse")
    private Collection<Reparateurs> reparateursCollection;
    @OneToMany(mappedBy = "idAdresse")
    private Collection<Vendeurs> vendeursCollection;
    @OneToMany(mappedBy = "idAdresse")
    private Collection<Clients> clientsCollection;
    @OneToMany(mappedBy = "idAdresse2")
    private Collection<Clients> clientsCollection1;

    public Adresses() {
    }

    public Adresses(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @XmlTransient
    public Collection<Reparateurs> getReparateursCollection() {
        return reparateursCollection;
    }

    public void setReparateursCollection(Collection<Reparateurs> reparateursCollection) {
        this.reparateursCollection = reparateursCollection;
    }

    @XmlTransient
    public Collection<Vendeurs> getVendeursCollection() {
        return vendeursCollection;
    }

    public void setVendeursCollection(Collection<Vendeurs> vendeursCollection) {
        this.vendeursCollection = vendeursCollection;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection1() {
        return clientsCollection1;
    }

    public void setClientsCollection1(Collection<Clients> clientsCollection1) {
        this.clientsCollection1 = clientsCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresse != null ? idAdresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresses)) {
            return false;
        }
        Adresses other = (Adresses) object;
        if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Adresses[ idAdresse=" + idAdresse + " ]";
    }
    
}
