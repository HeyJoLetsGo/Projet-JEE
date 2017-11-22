package Ged;

import Ged.Accede;
import Ged.Contient;
import Ged.Dossier;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T15:22:36")
@StaticMetamodel(Dossier.class)
public class Dossier_ { 

    public static volatile CollectionAttribute<Dossier, Contient> contientCollection;
    public static volatile SingularAttribute<Dossier, Integer> idDossier;
    public static volatile SingularAttribute<Dossier, Dossier> idDossierParent;
    public static volatile CollectionAttribute<Dossier, Dossier> dossierCollection;
    public static volatile SingularAttribute<Dossier, String> nomDossier;
    public static volatile CollectionAttribute<Dossier, Accede> accedeCollection;

}