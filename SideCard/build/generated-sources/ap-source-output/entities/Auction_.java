package entities;

import entities.Auctionsuplier;
import entities.Bid;
import entities.Product;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T07:15:04")
@StaticMetamodel(Auction.class)
public class Auction_ { 

    public static volatile SingularAttribute<Auction, Usuario> iduser;
    public static volatile SingularAttribute<Auction, Date> closedate;
    public static volatile ListAttribute<Auction, Auctionsuplier> auctionsuplierList;
    public static volatile SingularAttribute<Auction, Long> idauction;
    public static volatile SingularAttribute<Auction, Date> startdate;
    public static volatile ListAttribute<Auction, Product> productList;
    public static volatile ListAttribute<Auction, Bid> bidList;

}