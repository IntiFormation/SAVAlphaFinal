/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "achats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achats.findAll", query = "SELECT a FROM Achats a"),
    @NamedQuery(name = "Achats.findByIdAchat", query = "SELECT a FROM Achats a WHERE a.idAchat = :idAchat"),
    @NamedQuery(name = "Achats.findByDateAchat", query = "SELECT a FROM Achats a WHERE a.dateAchat = :dateAchat")})
public class Achats implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_achat")
    private Integer idAchat;
    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
    @ManyToOne
    private Produits idProduit;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private Clients idClient;
    @JoinColumn(name = "id_garantie", referencedColumnName = "id_garantie")
    @ManyToOne
    private Garanties idGarantie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAchat")
    private Collection<Reparations> reparationsCollection;

    public Achats() {
    }

    public Achats(Integer idAchat) {
        this.idAchat = idAchat;
    }

    public Integer getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(Integer idAchat) {
        this.idAchat = idAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Produits getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produits idProduit) {
        this.idProduit = idProduit;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Garanties getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(Garanties idGarantie) {
        this.idGarantie = idGarantie;
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
        hash += (idAchat != null ? idAchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achats)) {
            return false;
        }
        Achats other = (Achats) object;
        if ((this.idAchat == null && other.idAchat != null) || (this.idAchat != null && !this.idAchat.equals(other.idAchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Achats[ idAchat=" + idAchat + " ]";
    }
    
}
