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
@Table(name = "accede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accede.findAll", query = "SELECT a FROM Accede a")
    , @NamedQuery(name = "Accede.findByIdAccede", query = "SELECT a FROM Accede a WHERE a.idAccede = :idAccede")})
public class Accede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAccede")
    private Integer idAccede;
    @JoinColumn(name = "idDossier", referencedColumnName = "idDossier")
    @ManyToOne(optional = false)
    private Dossier idDossier;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;

    public Accede() {
    }

    public Accede(Integer idAccede) {
        this.idAccede = idAccede;
    }

    public Integer getIdAccede() {
        return idAccede;
    }

    public void setIdAccede(Integer idAccede) {
        this.idAccede = idAccede;
    }

    public Dossier getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(Dossier idDossier) {
        this.idDossier = idDossier;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccede != null ? idAccede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accede)) {
            return false;
        }
        Accede other = (Accede) object;
        if ((this.idAccede == null && other.idAccede != null) || (this.idAccede != null && !this.idAccede.equals(other.idAccede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ged.Accede[ idAccede=" + idAccede + " ]";
    }
    
}
