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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "garanties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garanties.findAll", query = "SELECT g FROM Garanties g"),
    @NamedQuery(name = "Garanties.findByIdGarantie", query = "SELECT g FROM Garanties g WHERE g.idGarantie = :idGarantie"),
    @NamedQuery(name = "Garanties.findByDuree", query = "SELECT g FROM Garanties g WHERE g.duree = :duree"),
    @NamedQuery(name = "Garanties.findByCout", query = "SELECT g FROM Garanties g WHERE g.cout = :cout")})
public class Garanties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_garantie")
    private Integer idGarantie;
    @Column(name = "duree")
    private Integer duree;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout")
    private Float cout;
    @ManyToMany(mappedBy = "garantiesCollection")
    private Collection<Produits> produitsCollection;
    @ManyToMany(mappedBy = "garantiesCollection")
    private Collection<Vendeurs> vendeursCollection;
    @OneToMany(mappedBy = "idGarantie")
    private Collection<CltProdGarVend> cltProdGarVendCollection;

    public Garanties() {
    }

    public Garanties(Integer idGarantie) {
        this.idGarantie = idGarantie;
    }

    public Integer getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(Integer idGarantie) {
        this.idGarantie = idGarantie;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
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
    public Collection<Vendeurs> getVendeursCollection() {
        return vendeursCollection;
    }

    public void setVendeursCollection(Collection<Vendeurs> vendeursCollection) {
        this.vendeursCollection = vendeursCollection;
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
        hash += (idGarantie != null ? idGarantie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garanties)) {
            return false;
        }
        Garanties other = (Garanties) object;
        if ((this.idGarantie == null && other.idGarantie != null) || (this.idGarantie != null && !this.idGarantie.equals(other.idGarantie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Garanties[ idGarantie=" + idGarantie + " ]";
    }
    
}
