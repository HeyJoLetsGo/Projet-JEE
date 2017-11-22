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
import javax.inject.Named;

@Named(value = "dossierBean")
@SessionScoped
public class DossierBean implements Serializable{
    @EJB
    private DAO dao;
    
    private Dossier doss;
    private List<Dossier> dossier;
    
    public DossierBean() {
        doss = new Dossier();
    }

    public Dossier getDoss() {
        return doss;
    }

    public void setDoss(Dossier doss) {
        this.doss = doss;
    }

    public List<Dossier> getDossier() {
        return dossier;
    }

    public void setDossier(List<Dossier> dossier) {
        this.dossier = dossier;
    }

    public List<Dossier> allDossierForUser() {
        return dao.getAllDossier();
    }

}
