/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ged;

import static com.sun.faces.facelets.util.Path.context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.servlet.http.HttpServletResponse;
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
            doss = (Dossier) dao.getAllDoss().get(0);
            List<Typedocument> listeType = dao.getAllType();
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
                c.setIdDossier(doss);
                c.setIdDocument(newDoc);
                dao.addDocument(newDoc);
                dao.addContient(c);
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
    
    
    public void openFile() throws FileNotFoundException, IOException {
        File file = new File("C:/Users/Jonathan/Documents/NetBeansProjects/JEEProjet/web/ressources/doc/", "remove_blinks.pdf");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open file.
            input = new BufferedInputStream(new FileInputStream(file), 10240);

            // Init servlet response.
            response.reset();
            // lire un fichier pdf
            response.setHeader("Content-type", "application/pdf"); 
            response.setContentLength((int)file.length());

            response.setHeader("Content-disposition", "inline; filename=3" );
            response.setHeader("pragma", "public");
            output = new BufferedOutputStream(response.getOutputStream(), 10240);

            // Write file contents to response.
            byte[] buffer = new byte[10240];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            // Finalize task.
            output.flush();
        } finally {
            // Gently close streams.

                output.close();
                input.close();
        }
}

}
