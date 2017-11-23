/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jonathan
 */

@Named(value = "utilCtrl")
@SessionScoped
public class UtilisateurControler implements Serializable{
    
    @EJB
    private DAO dao;
    
    private Utilisateur util;
    private Utilisateur connectedUtil;
    private String verifMDP, newMDP;

    public String getNewMDP() {
        return newMDP;
    }

    public void setNewMDP(String newMDP) {
        this.newMDP = newMDP;
    }

    public String getVerifMDP() {
        return verifMDP;
    }

    public void setVerifMDP(String verifMDP) {
        this.verifMDP = verifMDP;
    }

    public UtilisateurControler() {
        util = new Utilisateur();
    }

    public Utilisateur getUtil() {
        return util;
    }

    public void setUtil(Utilisateur util) {
        this.util = util;
    }

    public Utilisateur getConnectedUtil() {
        return connectedUtil;
    }

    public void setConnectedUtil(Utilisateur selectedUtil) {
        this.connectedUtil = selectedUtil;
    }

    public String testMDP() {
        List<Utilisateur> utilisateurs;
        utilisateurs = dao.getAllUtilisateur();
        
        for(Utilisateur utilBDD : utilisateurs) {
            if (utilBDD.getIdentifiant().equals(util.getIdentifiant()) && utilBDD.getPassword().equals(util.getPassword())) {
                connectedUtil = utilBDD;
                return "boiteReception";
            }
            else {
                return "index";
            }
        }
        return "ici";
    }   
    
    public String changeMDP() {
        List<Utilisateur> utilisateurs = dao.getAllUtilisateur();
        
        for(Utilisateur utilBDD : utilisateurs) {
            if (utilBDD.getIdentifiant().equals(util.getIdentifiant()) && utilBDD.getPassword().equals(util.getPassword())) {
                dao.updateMDP(newMDP, utilBDD.getIdUtilisateur());
                return "index";
            }
        }
        return "problem";
    }
    
}
