/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
@Stateless
public class DAO {

    @PersistenceContext(unitName = "JEEProjetPU")
    private EntityManager em;
    
    public List getAllUtilisateur() {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
            
    }   
    
    public List getAllDossierForUser(Utilisateur util) {
        Query query = em.createQuery("SELECT distinct(d) FROM Accede a JOIN Dossier d WHERE a.idUtilisateur = :util")
                .setParameter("util", util);
        return query.getResultList();
    }
    
    public List getAllType() {
        Query query = em.createNamedQuery("Typedocument.findAll");
        return query.getResultList();
    }
    
    public List getAllDocumentInDoss(int idDoss) {
        Query query = em.createQuery("SELECT distinct(doc) FROM Document doc JOIN Contient c JOIN Dossier d WHERE d.idDossier = :idDoss")
                .setParameter("idDoss", idDoss);
        return query.getResultList();
    }
    
    public List getAllDoss() {
        Query query = em.createNamedQuery("Dossier.findAll");
        return query.getResultList();
    }
    public void updateMDP(String newMDP, Integer id) {
        Query query = em.createQuery("UPDATE Utilisateur u SET u.password = :password WHERE u.idUtilisateur = :idUtilisateur")
                        .setParameter("password", newMDP)
                        .setParameter("idUtilisateur", id);
        query.executeUpdate();
    }
    
    public void addDocument(Document doc) {
        em.persist(doc);
        em.flush();
    }
    
    public void addContient(Contient c) {
        em.persist(c);
        em.flush();
    }
    
    public List getTypeByName(String name) {
        Query query = em.createNamedQuery("Typedocument.findByNomTypeDocument").setParameter("nomTypeDocument", name);
        return query.getResultList();
    }
    
    public List getDossByName(String name) {
        Query query = em.createNamedQuery("Dossier.findByNomTypeDocument").setParameter("nomDossier", name);
        return query.getResultList();
    }
}


