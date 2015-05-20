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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "vendeurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendeurs.findAll", query = "SELECT v FROM Vendeurs v"),
    @NamedQuery(name = "Vendeurs.findByIdVendeur", query = "SELECT v FROM Vendeurs v WHERE v.idVendeur = :idVendeur"),
    @NamedQuery(name = "Vendeurs.findByNom", query = "SELECT v FROM Vendeurs v WHERE v.nom = :nom"),
    @NamedQuery(name = "Vendeurs.findIdAdresseByIdVendeur", query = "SELECT a.idAdresse FROM Adresses a WHERE a.numero = :numero AND a.nomVoie = :nomVoie AND a.codePostal = :codePostal")})
public class Vendeurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vendeur")
    private Integer idVendeur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @JoinTable(name = "vend_gar", joinColumns = {
        @JoinColumn(name = "id_vendeur", referencedColumnName = "id_vendeur")}, inverseJoinColumns = {
        @JoinColumn(name = "id_garantie", referencedColumnName = "id_garantie")})
    @ManyToMany
    private Collection<Garanties> garantiesCollection;
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    @ManyToOne
    private Adresses idAdresse;
    @JoinColumn(name = "id_enseigne", referencedColumnName = "id_enseigne")
    @ManyToOne
    private Enseignes idEnseigne;
    @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
    @ManyToOne
    private Comptes idCompte;
    @OneToMany(mappedBy = "idVendeur")
    private Collection<Reparations> reparationsCollection;

    public Vendeurs() {
    }

    public Vendeurs(Integer idVendeur) {
        this.idVendeur = idVendeur;
    }

    public Integer getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(Integer idVendeur) {
        this.idVendeur = idVendeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Garanties> getGarantiesCollection() {
        return garantiesCollection;
    }

    public void setGarantiesCollection(Collection<Garanties> garantiesCollection) {
        this.garantiesCollection = garantiesCollection;
    }

    public Adresses getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresses idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Enseignes getIdEnseigne() {
        return idEnseigne;
    }

    public void setIdEnseigne(Enseignes idEnseigne) {
        this.idEnseigne = idEnseigne;
    }

    public Comptes getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Comptes idCompte) {
        this.idCompte = idCompte;
    }

    @XmlTransient
    public Collection<Reparations> getReparationsCollection() {
        return reparationsCollection;
    }

    public void setReparationsCollection(Collection<Reparations> reparationsCollection) {
        this.reparationsCollection = reparationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendeur != null ? idVendeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendeurs)) {
            return false;
        }
        Vendeurs other = (Vendeurs) object;
        if ((this.idVendeur == null && other.idVendeur != null) || (this.idVendeur != null && !this.idVendeur.equals(other.idVendeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Vendeurs[ idVendeur=" + idVendeur + " ]";
    }
    
}
