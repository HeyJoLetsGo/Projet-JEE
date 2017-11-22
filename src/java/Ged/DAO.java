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
}