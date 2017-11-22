/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

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
import javax.persistence.Lob;
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
 * @author Jonathan
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByNomDocument", query = "SELECT d FROM Document d WHERE d.nomDocument = :nomDocument")
    , @NamedQuery(name = "Document.findByDateCreation", query = "SELECT d FROM Document d WHERE d.dateCreation = :dateCreation")
    , @NamedQuery(name = "Document.findByDateDerniereModif", query = "SELECT d FROM Document d WHERE d.dateDerniereModif = :dateDerniereModif")
    , @NamedQuery(name = "Document.findByStatut", query = "SELECT d FROM Document d WHERE d.statut = :statut")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocument")
    private Integer idDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomDocument")
    private String nomDocument;
    @Lob
    @Size(max = 65535)
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDerniereModif")
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "statut")
    private String statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocument")
    private Collection<Contient> contientCollection;
    @JoinColumn(name = "idCreateur", referencedColumnName = "idUtilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idCreateur;
    @JoinColumn(name = "idTypeDocument", referencedColumnName = "idTypeDocument")
    @ManyToOne(optional = false)
    private Typedocument idTypeDocument;

    public Document() {
    }

    public Document(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public Document(Integer idDocument, String nomDocument, Date dateCreation, Date dateDerniereModif, String statut) {
        this.idDocument = idDocument;
        this.nomDocument = nomDocument;
        this.dateCreation = dateCreation;
        this.dateDerniereModif = dateDerniereModif;
        this.statut = statut;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDerniereModif() {
        return dateDerniereModif;
    }

    public void setDateDerniereModif(Date dateDerniereModif) {
        this.dateDerniereModif = dateDerniereModif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public Collection<Contient> getContientCollection() {
        return contientCollection;
    }

    public void setContientCollection(Collection<Contient> contientCollection) {
        this.contientCollection = contientCollection;
    }

    public Utilisateur getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Utilisateur idCreateur) {
        this.idCreateur = idCreateur;
    }

    public Typedocument getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(Typedocument idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ged.Document[ idDocument=" + idDocument + " ]";
    }
    
}
