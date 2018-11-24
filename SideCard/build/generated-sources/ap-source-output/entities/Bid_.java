package entities;

import entities.Auction;
import entities.Suplier;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T07:15:04")
@StaticMetamodel(Bid.class)
public class Bid_ { 

    public static volatile SingularAttribute<Bid, Long> idbid;
    public static volatile SingularAttribute<Bid, Suplier> idsuplier;
    public static volatile SingularAttribute<Bid, Auction> idauction;

}