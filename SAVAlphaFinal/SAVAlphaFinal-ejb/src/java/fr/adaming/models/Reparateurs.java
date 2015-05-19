/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reparateurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparateurs.findAll", query = "SELECT r FROM Reparateurs r"),
    @NamedQuery(name = "Reparateurs.findByIdReparateur", query = "SELECT r FROM Reparateurs r WHERE r.idReparateur = :idReparateur"),
    @NamedQuery(name = "Reparateurs.findByNom", query = "SELECT r FROM Reparateurs r WHERE r.nom = :nom"),
    @NamedQuery(name = "Reparateurs.findByNbReparation", query = "SELECT r FROM Reparateurs r WHERE r.nbReparation = :nbReparation"),
    @NamedQuery(name = "Reparateurs.findByMail", query = "SELECT r FROM Reparateurs r WHERE r.mail = :mail")})
public class Reparateurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reparateur")
    private Integer idReparateur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Column(name = "nb_reparation")
    private Integer nbReparation;
    @Size(max = 254)
    @Column(name = "mail")
    private String mail;
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    @ManyToOne
    private Adresses idAdresse;
    @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
    @ManyToOne
    private Comptes idCompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReparateur")
    private Collection<Reparations> reparationsCollection;

    public Reparateurs() {
    }

    public Reparateurs(Integer idReparateur) {
        this.idReparateur = idReparateur;
    }

    public Integer getIdReparateur() {
        return idReparateur;
    }

    public void setIdReparateur(Integer idReparateur) {
        this.idReparateur = idReparateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbReparation() {
        return nbReparation;
    }

    public void setNbReparation(Integer nbReparation) {
        this.nbReparation = nbReparation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Adresses getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresses idAdresse) {
        this.idAdresse = idAdresse;
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
        hash += (idReparateur != null ? idReparateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparateurs)) {
            return false;
        }
        Reparateurs other = (Reparateurs) object;
        if ((this.idReparateur == null && other.idReparateur != null) || (this.idReparateur != null && !this.idReparateur.equals(other.idReparateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Reparateurs[ idReparateur=" + idReparateur + " ]";
    }
    
}
