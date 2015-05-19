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
@Table(name = "enseignes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignes.findAll", query = "SELECT e FROM Enseignes e"),
    @NamedQuery(name = "Enseignes.findByIdEnseigne", query = "SELECT e FROM Enseignes e WHERE e.idEnseigne = :idEnseigne"),
    @NamedQuery(name = "Enseignes.findByNom", query = "SELECT e FROM Enseignes e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enseignes.findByVersementMensuel", query = "SELECT e FROM Enseignes e WHERE e.versementMensuel = :versementMensuel")})
public class Enseignes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_enseigne")
    private Integer idEnseigne;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "versementMensuel")
    private Float versementMensuel;
    @OneToMany(mappedBy = "idEnseigne")
    private Collection<Vendeurs> vendeursCollection;

    public Enseignes() {
    }

    public Enseignes(Integer idEnseigne) {
        this.idEnseigne = idEnseigne;
    }

    public Integer getIdEnseigne() {
        return idEnseigne;
    }

    public void setIdEnseigne(Integer idEnseigne) {
        this.idEnseigne = idEnseigne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getVersementMensuel() {
        return versementMensuel;
    }

    public void setVersementMensuel(Float versementMensuel) {
        this.versementMensuel = versementMensuel;
    }

    @XmlTransient
    public Collection<Vendeurs> getVendeursCollection() {
        return vendeursCollection;
    }

    public void setVendeursCollection(Collection<Vendeurs> vendeursCollection) {
        this.vendeursCollection = vendeursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnseigne != null ? idEnseigne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignes)) {
            return false;
        }
        Enseignes other = (Enseignes) object;
        if ((this.idEnseigne == null && other.idEnseigne != null) || (this.idEnseigne != null && !this.idEnseigne.equals(other.idEnseigne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.adaming.models.Enseignes[ idEnseigne=" + idEnseigne + " ]";
    }
    
}
