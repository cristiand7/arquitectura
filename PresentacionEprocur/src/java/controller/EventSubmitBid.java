/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Auction;
import entities.Auctionsuplier;
import entities.AuctionsuplierPK;
import entities.Bid;
import entities.Product;
import entities.Suplier;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import negocio.AuctionFacadeRemote;
import negocio.AuctionsuplierFacadeRemote;
import negocio.BidFacadeRemote;
import negocio.SuplierFacadeRemote;

/**
 *
 * @author hikar
 */
@Named(value = "EventSubmitBid")
@SessionScoped
public class EventSubmitBid implements Serializable {

    @EJB
    private AuctionsuplierFacadeRemote auctionsuplierFacade;

    @EJB
    private SuplierFacadeRemote suplierFacade;

    @EJB
    private AuctionFacadeRemote auctionFacade;



    
    List<Auction> auctions = new ArrayList<Auction> ();
    List<Suplier> supliers = new ArrayList<Suplier> ();
    List<Product> products = new ArrayList<Product>();
    int idNewBit;
    Auctionsuplier auctionA = new Auctionsuplier();
    Auction auction ;
    
    String value="";
    int idAuction ;
    
    Suplier suplier;
    int idSuplier ;
    
    /**
     * Creates a new instance of EventsubmitBid
     */
    public EventSubmitBid() {
            Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "10.192.230.31");
        //props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");//default port
        try {
            InitialContext ctx = new InitialContext(props);

            auctionsuplierFacade = (AuctionsuplierFacadeRemote) ctx.lookup("java:global/Bussines/AuctionsuplierFacade!negocio.AuctionsuplierFacadeRemote");
            
            auctionFacade = (AuctionFacadeRemote) ctx.lookup("java:global/Bussines/AuctionFacade!negocio.AuctionFacadeRemote");
            
            suplierFacade = (SuplierFacadeRemote) ctx.lookup("java:global/Bussines/SuplierFacade!negocio.SuplierFacadeRemote");
            
            
        } catch (Exception e) {
            System.out.println("error iniciando bean<<-------" + e);
        }
    }

    public void updateAuctionAndSuplier(){
         auction = auctionFacade.find(Long.parseLong(idAuction+""));
         suplier = suplierFacade.find(Long.parseLong(idSuplier+""));
         //auction = auctionFacade.find(Long.parseLong(idAuction+""));
        
    }

    
    
    
    public String save(){        
        //updateAuctionAndSuplier();
        System.out.println("editando mentodo");
        System.out.println("--> "+idAuction+"<<<<<<------->>>><"+idSuplier);
        int i = idNewBit;
        
        auctionA.setAuction(auction);
        auctionA.setOffer(value);
        auctionA.setSuplier(suplier);
        AuctionsuplierPK pk = new AuctionsuplierPK();
        pk.setIdauction(idAuction);
        pk.setIdsuplier(idSuplier);
        auctionA.setAuctionsuplierPK(pk);
        
        //auctionsuplierFacade.create(auctionA);
        auctionsuplierFacade.edit(auctionA);
        
        return "index";
    }


    public Auction getAuction() {
        auction = auctionFacade.find(Long.parseLong(idAuction+""));
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public int getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(int idAuction) {
        this.idAuction = idAuction;
    }

    public List<Auction> getAuctions() {
        auctions = auctionFacade.findAll();
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public int getIdNewBit() {
        idNewBit = auctionsuplierFacade.count() + 1;
        return idNewBit;
    }

    public void setIdNewBit(int idNewBit) {
        this.idNewBit = idNewBit;
    }

    public Suplier getSuplier() {
        suplier = suplierFacade.find(Long.parseLong(idSuplier+""));
        return suplier;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public int getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(int idSuplier) {
        this.idSuplier = idSuplier;
    }

    public List<Suplier> getSupliers() {
        supliers = suplierFacade.findAll();
        return supliers;
    }

    public void setSupliers(List<Suplier> supliers) {
        this.supliers = supliers;
    }

    public Auctionsuplier getAuctionA() {
        return auctionA;
    }

    public void setAuctionA(Auctionsuplier auctionA) {
        this.auctionA = auctionA;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    
    
    
    
}
