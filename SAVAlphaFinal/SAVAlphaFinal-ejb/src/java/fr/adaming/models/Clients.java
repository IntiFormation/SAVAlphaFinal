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
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByIdClient", query = "SELECT c FROM Clients c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom"),
    @NamedQuery(name = "Clients.findByPrenom", query = "SELECT c FROM Clients c WHERE c.prenom = :prenom")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    @ManyToOne
    private Adresses idAdresse;
    @JoinColumn(name = "id_adresse2", referencedColumnName = "id_adresse")
    @ManyToOne
    private Adresses idAdresse2;
    @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
    @ManyToOne
    private Comptes idCompte;
    @OneToMany(mappedBy = "idClient")
    private Collection<Achats> achatsCollection;

    public Clients() {
    }

    public Clients(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresses getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresses idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Adresses getIdAdresse2() {
        return idAdresse2;
    }

    public void setIdAdresse2(Adresses idAdresse2) {
        this.idAdresse2 = idAdresse2;
    }

    public Comptes getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Comptes idCompte) {
        this.idCompte = idCompte;
    }

    @XmlTransient
    public Collection<Achats> getAchatsCollection() {
        return achatsCollection;
    }

    public void setAchatsCollection(Collection<Achats> achatsCollection) {
        this.achatsCollection = achatsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Clients[ idClient=" + idClient + " ]";
    }
    
}
