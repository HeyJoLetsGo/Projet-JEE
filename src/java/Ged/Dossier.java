/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "dossier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossier.findAll", query = "SELECT d FROM Dossier d")
    , @NamedQuery(name = "Dossier.findByIdDossier", query = "SELECT d FROM Dossier d WHERE d.idDossier = :idDossier")
    , @NamedQuery(name = "Dossier.findByNomDossier", query = "SELECT d FROM Dossier d WHERE d.nomDossier = :nomDossier")})
public class Dossier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDossier")
    private Integer idDossier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomDossier")
    private String nomDossier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDossier")
    private Collection<Accede> accedeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDossier")
    private Collection<Contient> contientCollection;
    @OneToMany(mappedBy = "idDossierParent")
    private Collection<Dossier> dossierCollection;
    @JoinColumn(name = "idDossierParent", referencedColumnName = "idDossier")
    @ManyToOne
    private Dossier idDossierParent;

    public Dossier() {
    }

    public Dossier(Integer idDossier) {
        this.idDossier = idDossier;
    }

    public Dossier(Integer idDossier, String nomDossier) {
        this.idDossier = idDossier;
        this.nomDossier = nomDossier;
    }

    public Integer getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(Integer idDossier) {
        this.idDossier = idDossier;
    }

    public String getNomDossier() {
        return nomDossier;
    }

    public void setNomDossier(String nomDossier) {
        this.nomDossier = nomDossier;
    }

    @XmlTransient
    public Collection<Accede> getAccedeCollection() {
        return accedeCollection;
    }

    public void setAccedeCollection(Collection<Accede> accedeCollection) {
        this.accedeCollection = accedeCollection;
    }

    @XmlTransient
    public Collection<Contient> getContientCollection() {
        return contientCollection;
    }

    public void setContientCollection(Collection<Contient> contientCollection) {
        this.contientCollection = contientCollection;
    }

    @XmlTransient
    public Collection<Dossier> getDossierCollection() {
        return dossierCollection;
    }

    public void setDossierCollection(Collection<Dossier> dossierCollection) {
        this.dossierCollection = dossierCollection;
    }

    public Dossier getIdDossierParent() {
        return idDossierParent;
    }

    public void setIdDossierParent(Dossier idDossierParent) {
        this.idDossierParent = idDossierParent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDossier != null ? idDossier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossier)) {
            return false;
        }
        Dossier other = (Dossier) object;
        if ((this.idDossier == null && other.idDossier != null) || (this.idDossier != null && !this.idDossier.equals(other.idDossier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ged.Dossier[ idDossier=" + idDossier + " ]";
    }
    
}
