package Ged;

import Ged.Contient;
import Ged.Typedocument;
import Ged.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T17:17:43")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> nomDocument;
    public static volatile CollectionAttribute<Document, Contient> contientCollection;
    public static volatile SingularAttribute<Document, Typedocument> idTypeDocument;
    public static volatile SingularAttribute<Document, Date> dateCreation;
    public static volatile SingularAttribute<Document, Utilisateur> idCreateur;
    public static volatile SingularAttribute<Document, Integer> idDocument;
    public static volatile SingularAttribute<Document, Date> dateDerniereModif;
    public static volatile SingularAttribute<Document, String> commentaire;
    public static volatile SingularAttribute<Document, String> statut;

}