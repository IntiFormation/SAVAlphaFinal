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
@Table(name = "pannes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pannes.findAll", query = "SELECT p FROM Pannes p"),
    @NamedQuery(name = "Pannes.findByIdPanne", query = "SELECT p FROM Pannes p WHERE p.idPanne = :idPanne"),
    @NamedQuery(name = "Pannes.findByNom", query = "SELECT p FROM Pannes p WHERE p.nom = :nom"),
    @NamedQuery(name = "Pannes.findByForfait", query = "SELECT p FROM Pannes p WHERE p.forfait = :forfait"),
    @NamedQuery(name = "Pannes.findByCout", query = "SELECT p FROM Pannes p WHERE p.cout = :cout")})
public class Pannes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_panne")
    private Integer idPanne;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "forfait")
    private String forfait;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout")
    private Float cout;
    @JoinTable(name = "prod_panne", joinColumns = {
        @JoinColumn(name = "id_panne", referencedColumnName = "id_panne")}, inverseJoinColumns = {
        @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")})
    @ManyToMany
    private Collection<Produits> produitsCollection;
    @OneToMany(mappedBy = "idPanne")
    private Collection<Reparations> reparationsCollection;

    public Pannes() {
    }

    public Pannes(Integer idPanne) {
        this.idPanne = idPanne;
    }

    public Integer getIdPanne() {
        return idPanne;
    }

    public void setIdPanne(Integer idPanne) {
        this.idPanne = idPanne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getForfait() {
        return forfait;
    }

    public void setForfait(String forfait) {
        this.forfait = forfait;
    }

    public Float getCout() {
        return cout;
    }

    public void setCout(Float cout) {
        this.cout = cout;
    }

    @XmlTransient
    public Collection<Produits> getProduitsCollection() {
        return produitsCollection;
    }

    public void setProduitsCollection(Collection<Produits> produitsCollection) {
        this.produitsCollection = produitsCollection;
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
        hash += (idPanne != null ? idPanne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pannes)) {
            return false;
        }
        Pannes other = (Pannes) object;
        if ((this.idPanne == null && other.idPanne != null) || (this.idPanne != null && !this.idPanne.equals(other.idPanne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Pannes[ idPanne=" + idPanne + " ]";
    }
    
}
