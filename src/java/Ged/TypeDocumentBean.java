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

@Named(value = "typeDocBean")
@SessionScoped
public class TypeDocumentBean implements Serializable{
 
    @EJB
    private DAO dao;
    
    private Typedocument type;
    private List<Typedocument> typeDoc;    

    public Typedocument getType() {
        return type;
    }

    public void setType(Typedocument type) {
        this.type = type;
    }

    public List<Typedocument> getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(List<Typedocument> typeDoc) {
        this.typeDoc = typeDoc;
    }
    
    public List<Typedocument> allTypeDoc() {
        return dao.getAllType();
    }
}
