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
    
    public List getAllDossier() {
        Query query = em.createNamedQuery("Dossier.findAll");
        return query.getResultList();
    }
    
    public List getAllType() {
        Query query = em.createNamedQuery("Typedocument.findAll");
        return query.getResultList();
    }
    
    public void updateMDP(String newMDP, Integer id) {
        Query query = em.createQuery("UPDATE Utilisateur u SET u.password = :password WHERE u.idUtilisateur = :idUtilisateur")
                        .setParameter("password", newMDP)
                        .setParameter("idUtilisateur", id);
        query.executeUpdate();
    }
    
        public void updateMdp(String newMdp, Integer idConnectedUser) {
        Query queryUpdateMdp = em.createQuery(
                "UPDATE Utilisateur u SET u.password = :newMdp WHERE u.idUtilisateur = :idConnectedUser")
                .setParameter("newMdp", newMdp)
                .setParameter("idConnectedUser", idConnectedUser);
        queryUpdateMdp.executeUpdate();
    }
}