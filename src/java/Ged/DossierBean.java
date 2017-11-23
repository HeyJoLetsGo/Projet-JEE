/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named(value = "dossierBean")
@SessionScoped
public class DossierBean implements Serializable{
    @EJB
    private DAO dao;
    
    private Dossier doss;
    private List<Dossier> dossier;
    private TreeNode root;
    private Utilisateur connected;

   @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Root", null);
        List<Dossier> dossiersUtil = dao.getAllDossierForUser(1);
        TreeNode mesDoss = new DefaultTreeNode("Mes dossiers", root);
        
        for (Dossier dossUtil : dossiersUtil) {
            TreeNode newNode = new DefaultTreeNode(dossUtil.getNomDossier()); 
            List<Document> documentInside = dao.getAllDocumentInDoss(dossUtil.getIdDossier());
            
            for(Document doc : documentInside) {
                newNode.getChildren().add(new DefaultTreeNode(doc.getNomDocument(),newNode));
            }
            
            mesDoss.getChildren().add(newNode);
        }

    }
    
   
    
    public TreeNode getRoot() {
        return root;
    }
    
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


}
