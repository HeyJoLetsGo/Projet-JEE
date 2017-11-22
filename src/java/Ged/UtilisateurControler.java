/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Jonathan
 */

@Named(value = "utilCtrl")
@SessionScoped
public class UtilisateurControler implements Serializable{
    
    @EJB
    private UtilisateurDAO dao;
    
    private Utilisateur util;
    private Utilisateur connectedUtil;

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

    public String testMDP() throws NoSuchAlgorithmException, IOException{
        List<Utilisateur> utilisateurs;
        utilisateurs = dao.getAllUtilisateur();
        
        for(Utilisateur utilBDD : utilisateurs) {
            if (utilBDD.getIdentifiant().equals(util.getIdentifiant()) && utilBDD.getPassword().equals(util.getPassword())) {
                connectedUtil = utilBDD;
                return "boiteReception";
                //FacesContext.getCurrentInstance().getExternalContext().redirect("boiteReception.xhtml");
            }
            else {
                return "index";
                //FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        }
        return "ici";
    }    
}
