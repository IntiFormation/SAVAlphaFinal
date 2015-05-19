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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "reparations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparations.findAll", query = "SELECT r FROM Reparations r"),
    @NamedQuery(name = "Reparations.findByIdReparation", query = "SELECT r FROM Reparations r WHERE r.idReparation = :idReparation"),
    @NamedQuery(name = "Reparations.findByDescription", query = "SELECT r FROM Reparations r WHERE r.description = :description"),
    @NamedQuery(name = "Reparations.findByDateEtat", query = "SELECT r FROM Reparations r WHERE r.dateEtat = :dateEtat"),
    @NamedQuery(name = "Reparations.findByEtat", query = "SELECT r FROM Reparations r WHERE r.etat = :etat"),
    @NamedQuery(name = "Reparations.findByPayee", query = "SELECT r FROM Reparations r WHERE r.payee = :payee")})
public class Reparations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reparation")
    private Integer idReparation;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "date_etat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEtat;
    @Size(max = 254)
    @Column(name = "etat")
    private String etat;
    @Column(name = "payee")
    private Integer payee;
    @OneToMany(mappedBy = "idReparation")
    private Collection<CltProdGarVend> cltProdGarVendCollection;
    @JoinColumn(name = "id_reparateur", referencedColumnName = "id_reparateur")
    @ManyToOne(optional = false)
    private Reparateurs idReparateur;
    @JoinColumn(name = "id_panne", referencedColumnName = "id_panne")
    @ManyToOne
    private Pannes idPanne;

    public Reparations() {
    }

    public Reparations(Integer idReparation) {
        this.idReparation = idReparation;
    }

    public Integer getIdReparation() {
        return idReparation;
    }

    public void setIdReparation(Integer idReparation) {
        this.idReparation = idReparation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEtat() {
        return dateEtat;
    }

    public void setDateEtat(Date dateEtat) {
        this.dateEtat = dateEtat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    @XmlTransient
    public Collection<CltProdGarVend> getCltProdGarVendCollection() {
        return cltProdGarVendCollection;
    }

    public void setCltProdGarVendCollection(Collection<CltProdGarVend> cltProdGarVendCollection) {
        this.cltProdGarVendCollection = cltProdGarVendCollection;
    }

    public Reparateurs getIdReparateur() {
        return idReparateur;
    }

    public void setIdReparateur(Reparateurs idReparateur) {
        this.idReparateur = idReparateur;
    }

    public Pannes getIdPanne() {
        return idPanne;
    }

    public void setIdPanne(Pannes idPanne) {
        this.idPanne = idPanne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparation != null ? idReparation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparations)) {
            return false;
        }
        Reparations other = (Reparations) object;
        if ((this.idReparation == null && other.idReparation != null) || (this.idReparation != null && !this.idReparation.equals(other.idReparation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Reparations[ idReparation=" + idReparation + " ]";
    }
    
}
