package Ged;

import Ged.Document;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T17:17:43")
@StaticMetamodel(Typedocument.class)
public class Typedocument_ { 

    public static volatile SingularAttribute<Typedocument, Integer> tempsDeConservation;
    public static volatile SingularAttribute<Typedocument, Integer> idTypeDocument;
    public static volatile SingularAttribute<Typedocument, String> nomTypeDocument;
    public static volatile CollectionAttribute<Typedocument, Document> documentCollection;

}