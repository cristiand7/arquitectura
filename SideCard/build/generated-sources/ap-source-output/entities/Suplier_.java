package entities;

import entities.Auctionsuplier;
import entities.Bid;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T07:15:04")
@StaticMetamodel(Suplier.class)
public class Suplier_ { 

    public static volatile SingularAttribute<Suplier, Usuario> iduser;
    public static volatile SingularAttribute<Suplier, String> name;
    public static volatile SingularAttribute<Suplier, Long> idsuplier;
    public static volatile ListAttribute<Suplier, Auctionsuplier> auctionsuplierList;
    public static volatile SingularAttribute<Suplier, String> email;
    public static volatile ListAttribute<Suplier, Bid> bidList;

}