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
@Table(name = "typedocument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typedocument.findAll", query = "SELECT t FROM Typedocument t")
    , @NamedQuery(name = "Typedocument.findByIdTypeDocument", query = "SELECT t FROM Typedocument t WHERE t.idTypeDocument = :idTypeDocument")
    , @NamedQuery(name = "Typedocument.findByNomTypeDocument", query = "SELECT t FROM Typedocument t WHERE t.nomTypeDocument = :nomTypeDocument")})
public class Typedocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeDocument")
    private Integer idTypeDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomTypeDocument")
    private String nomTypeDocument;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeDocument")
    private Collection<Document> documentCollection;

    public Typedocument() {
    }

    public Typedocument(Integer idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public Typedocument(Integer idTypeDocument, String nomTypeDocument) {
        this.idTypeDocument = idTypeDocument;
        this.nomTypeDocument = nomTypeDocument;
    }

    public Integer getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(Integer idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public String getNomTypeDocument() {
        return nomTypeDocument;
    }

    public void setNomTypeDocument(String nomTypeDocument) {
        this.nomTypeDocument = nomTypeDocument;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDocument != null ? idTypeDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typedocument)) {
            return false;
        }
        Typedocument other = (Typedocument) object;
        if ((this.idTypeDocument == null && other.idTypeDocument != null) || (this.idTypeDocument != null && !this.idTypeDocument.equals(other.idTypeDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ged.Typedocument[ idTypeDocument=" + idTypeDocument + " ]";
    }
    
}
