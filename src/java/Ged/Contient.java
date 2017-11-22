/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "contient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contient.findAll", query = "SELECT c FROM Contient c")
    , @NamedQuery(name = "Contient.findByIdContient", query = "SELECT c FROM Contient c WHERE c.idContient = :idContient")})
public class Contient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idContient")
    private Integer idContient;
    @JoinColumn(name = "idDocument", referencedColumnName = "idDocument")
    @ManyToOne(optional = false)
    private Document idDocument;
    @JoinColumn(name = "idDossier", referencedColumnName = "idDossier")
    @ManyToOne(optional = false)
    private Dossier idDossier;

    public Contient() {
    }

    public Contient(Integer idContient) {
        this.idContient = idContient;
    }

    public Integer getIdContient() {
        return idContient;
    }

    public void setIdContient(Integer idContient) {
        this.idContient = idContient;
    }

    public Document getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Document idDocument) {
        this.idDocument = idDocument;
    }

    public Dossier getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(Dossier idDossier) {
        this.idDossier = idDossier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContient != null ? idContient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contient)) {
            return false;
        }
        Contient other = (Contient) object;
        if ((this.idContient == null && other.idContient != null) || (this.idContient != null && !this.idContient.equals(other.idContient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ged.Contient[ idContient=" + idContient + " ]";
    }
    
}
