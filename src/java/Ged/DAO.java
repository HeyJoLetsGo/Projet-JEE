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
    
    public List getAllDossierForUser(int idUtil) {
        Query query = em.createQuery("SELECT distinct(d) FROM Dossier d JOIN Accede a JOIN Utilisateur u JOIN Contient c WHERE u.idUtilisateur = :idUtil")
                .setParameter("idUtil", idUtil);
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
    
}