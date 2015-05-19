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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "produits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
    @NamedQuery(name = "Produits.findByIdProduit", query = "SELECT p FROM Produits p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "Produits.findByCategorie", query = "SELECT p FROM Produits p WHERE p.categorie = :categorie"),
    @NamedQuery(name = "Produits.findByMarque", query = "SELECT p FROM Produits p WHERE p.marque = :marque"),
    @NamedQuery(name = "Produits.findByModele", query = "SELECT p FROM Produits p WHERE p.modele = :modele"),
    @NamedQuery(name = "Produits.findByUrlImg", query = "SELECT p FROM Produits p WHERE p.urlImg = :urlImg"),
    @NamedQuery(name = "Produits.findByTransportable", query = "SELECT p FROM Produits p WHERE p.transportable = :transportable"),
    @NamedQuery(name = "Produits.findByGarantieConstructeur", query = "SELECT p FROM Produits p WHERE p.garantieConstructeur = :garantieConstructeur"),
    @NamedQuery(name = "Produits.findByGarantieIncluse", query = "SELECT p FROM Produits p WHERE p.garantieIncluse = :garantieIncluse")})
public class Produits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private Integer idProduit;
    @Size(max = 254)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 254)
    @Column(name = "marque")
    private String marque;
    @Size(max = 254)
    @Column(name = "modele")
    private String modele;
    @Size(max = 254)
    @Column(name = "urlImg")
    private String urlImg;
    @Column(name = "transportable")
    private Integer transportable;
    @Column(name = "garantieConstructeur")
    private Integer garantieConstructeur;
    @Column(name = "garantieIncluse")
    private Integer garantieIncluse;
    @ManyToMany(mappedBy = "produitsCollection")
    private Collection<Pannes> pannesCollection;
    @JoinTable(name = "prod_gar", joinColumns = {
        @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")}, inverseJoinColumns = {
        @JoinColumn(name = "id_garantie", referencedColumnName = "id_garantie")})
    @ManyToMany
    private Collection<Garanties> garantiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduit")
    private Collection<CltProdGarVend> cltProdGarVendCollection;

    public Produits() {
    }

    public Produits(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Integer getTransportable() {
        return transportable;
    }

    public void setTransportable(Integer transportable) {
        this.transportable = transportable;
    }

    public Integer getGarantieConstructeur() {
        return garantieConstructeur;
    }

    public void setGarantieConstructeur(Integer garantieConstructeur) {
        this.garantieConstructeur = garantieConstructeur;
    }

    public Integer getGarantieIncluse() {
        return garantieIncluse;
    }

    public void setGarantieIncluse(Integer garantieIncluse) {
        this.garantieIncluse = garantieIncluse;
    }

    @XmlTransient
    public Collection<Pannes> getPannesCollection() {
        return pannesCollection;
    }

    public void setPannesCollection(Collection<Pannes> pannesCollection) {
        this.pannesCollection = pannesCollection;
    }

    @XmlTransient
    public Collection<Garanties> getGarantiesCollection() {
        return garantiesCollection;
    }

    public void setGarantiesCollection(Collection<Garanties> garantiesCollection) {
        this.garantiesCollection = garantiesCollection;
    }

    @XmlTransient
    public Collection<CltProdGarVend> getCltProdGarVendCollection() {
        return cltProdGarVendCollection;
    }

    public void setCltProdGarVendCollection(Collection<CltProdGarVend> cltProdGarVendCollection) {
        this.cltProdGarVendCollection = cltProdGarVendCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Produits[ idProduit=" + idProduit + " ]";
    }
    
}
