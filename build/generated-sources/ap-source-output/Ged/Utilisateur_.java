package Ged;

import Ged.Accede;
import Ged.Document;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T17:17:43")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile SingularAttribute<Utilisateur, String> identifiant;
    public static volatile SingularAttribute<Utilisateur, String> nomUtilisateur;
    public static volatile CollectionAttribute<Utilisateur, Document> documentCollection;
    public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateur;
    public static volatile SingularAttribute<Utilisateur, String> prenomUtilisateur;
    public static volatile CollectionAttribute<Utilisateur, Accede> accedeCollection;

}