/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INTI-0205
 */
@Entity
@Table(name = "clt_prod_gar_vend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CltProdGarVend.findAll", query = "SELECT c FROM CltProdGarVend c"),
    @NamedQuery(name = "CltProdGarVend.findByDateAchat", query = "SELECT c FROM CltProdGarVend c WHERE c.dateAchat = :dateAchat"),
    @NamedQuery(name = "CltProdGarVend.findByIdCltProdGarVend", query = "SELECT c FROM CltProdGarVend c WHERE c.idCltProdGarVend = :idCltProdGarVend")})
public class CltProdGarVend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clt_prod_gar_vend")
    private Integer idCltProdGarVend;
    @JoinColumn(name = "id_reparation", referencedColumnName = "id_reparation")
    @ManyToOne
    private Reparations idReparation;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
    @ManyToOne(optional = false)
    private Produits idProduit;
    @JoinColumn(name = "id_garantie", referencedColumnName = "id_garantie")
    @ManyToOne
    private Garanties idGarantie;
    @JoinColumn(name = "id_vendeur", referencedColumnName = "id_vendeur")
    @ManyToOne
    private Vendeurs idVendeur;

    public CltProdGarVend() {
    }

    public CltProdGarVend(Integer idCltProdGarVend) {
        this.idCltProdGarVend = idCltProdGarVend;
    }

    public CltProdGarVend(Integer idCltProdGarVend, Date dateAchat) {
        this.idCltProdGarVend = idCltProdGarVend;
        this.dateAchat = dateAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Integer getIdCltProdGarVend() {
        return idCltProdGarVend;
    }

    public void setIdCltProdGarVend(Integer idCltProdGarVend) {
        this.idCltProdGarVend = idCltProdGarVend;
    }

    public Reparations getIdReparation() {
        return idReparation;
    }

    public void setIdReparation(Reparations idReparation) {
        this.idReparation = idReparation;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Produits getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produits idProduit) {
        this.idProduit = idProduit;
    }

    public Garanties getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(Garanties idGarantie) {
        this.idGarantie = idGarantie;
    }

    public Vendeurs getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(Vendeurs idVendeur) {
        this.idVendeur = idVendeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCltProdGarVend != null ? idCltProdGarVend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CltProdGarVend)) {
            return false;
        }
        CltProdGarVend other = (CltProdGarVend) object;
        if ((this.idCltProdGarVend == null && other.idCltProdGarVend != null) || (this.idCltProdGarVend != null && !this.idCltProdGarVend.equals(other.idCltProdGarVend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.CltProdGarVend[ idCltProdGarVend=" + idCltProdGarVend + " ]";
    }
    
}
