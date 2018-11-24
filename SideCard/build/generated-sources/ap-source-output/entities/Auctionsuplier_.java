package entities;

import entities.Auction;
import entities.AuctionsuplierPK;
import entities.Suplier;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T07:20:13")
@StaticMetamodel(Auctionsuplier.class)
public class Auctionsuplier_ { 

    public static volatile SingularAttribute<Auctionsuplier, String> offer;
    public static volatile SingularAttribute<Auctionsuplier, Suplier> suplier;
    public static volatile SingularAttribute<Auctionsuplier, AuctionsuplierPK> auctionsuplierPK;
    public static volatile SingularAttribute<Auctionsuplier, Short> win;
    public static volatile SingularAttribute<Auctionsuplier, Auction> auction;

}