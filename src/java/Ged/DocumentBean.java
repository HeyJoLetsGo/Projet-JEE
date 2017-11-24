/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.commons.io.FilenameUtils;
import static org.primefaces.component.focus.Focus.PropertyKeys.context;
import static org.primefaces.component.menuitem.UIMenuItem.PropertyKeys.outcome;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable{
    @EJB
    private DAO dao;
    
    private Document newDoc;
    private Document readingDoc;
    private List<Document> documents;
    private UploadedFile file;
    private Dossier doss;
    private Contient c;
    private Typedocument type;
    private String typeName;
    private String dossName;

    public Document getNewDoc() {
        return newDoc;
    }

    public String getDossName() {
        return dossName;
    }

    public void setDossName(String dossName) {
        this.dossName = dossName;
    }

    
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public Dossier getDoss() {
        return doss;
    }

    public void setDoss(Dossier doss) {
        this.doss = doss;
    }

    public Typedocument getType() {
        return type;
    }

    public void setType(Typedocument type) {
        this.type = type;
    }

    
    public Contient getC() {
        return c;
    }

    public void setC(Contient c) {
        this.c = c;
    }

    
    
    public DocumentBean() {
        newDoc = new Document();
    }

   
    public Document getReadingDoc() {
        return readingDoc;
    }

    public void setReadingDoc(Document readingDoc) {
        this.readingDoc = readingDoc;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void setNewDoc(Document newDoc) {
        this.newDoc = newDoc;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void upload(Utilisateur connectedUser) throws IOException {
        if(file != null) {
            List<Typedocument> listeType = dao.getTypeByName(typeName);
            List<Dossier> listeDoss = dao.getDossByName(typeName);
            newDoc.setIdCreateur(connectedUser);
            Date actuelle = new Date();
            newDoc.setDateCreation(actuelle);
            newDoc.setDateDerniereModif(actuelle);
            newDoc.setIdCreateur(connectedUser);
            newDoc.setStatut("A traiter");
            newDoc.setIdTypeDocument(listeType.get(0));
            
            InputStream input = file.getInputstream();
            Path folder = Paths.get("C:/Users/Jonathan/Documents/NetBeansProjects/JEEProjet/web/ressources/doc");
            String filename = FilenameUtils.getBaseName(file.getFileName()); 
            String extension = FilenameUtils.getExtension(file.getFileName());
            Path file2 = Files.createTempFile(folder, filename + "-", "." + extension);
            try (InputStream input2 = file.getInputstream()) {
                Files.copy(input2, file2, StandardCopyOption.REPLACE_EXISTING);
                
                String filename2 = FilenameUtils.getBaseName(file.getFileName()); 
                String extension2 = FilenameUtils.getExtension(file.getFileName());
                newDoc.setDocumentPath(file2.getFileName().toString());
                c.setIdDossier(listeDoss.get(0));
                c.setIdDocument(newDoc);
                dao.addDocument(newDoc, c);
                newDoc = new Document();
                file = null;
            }
        }
    }
    
    public void onNodeSelect(NodeSelectEvent event) throws IOException {
        Document object = (Document) event.getTreeNode().getData();
        
        FacesContext
        .getCurrentInstance()
        .getApplication()
        .getNavigationHandler()
        .handleNavigation(FacesContext.getCurrentInstance(),
                "null", "administration.xhtml");
    }

}
