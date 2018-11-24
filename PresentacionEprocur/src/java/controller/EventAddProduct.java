/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Auction;
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
import negocio.ProductFacadeRemote;

/**
 *
 * @author hikar
 */
@Named(value = "eventAddProduct")
@SessionScoped
public class EventAddProduct implements Serializable {

    @EJB
    private AuctionFacadeRemote auctionFacade;

    @EJB
    private ProductFacadeRemote productFacade;

    

    /**
     * Creates a new instance of EventosAddProduct
     */
    
    List<Product> products = new ArrayList<Product> ();
    List<Auction> auctions = new ArrayList<Auction> ();
    Product product = new Product();
    int idAuction ;
    int idNewProduct;
    Auction auction;
    String name;
    String description;
    
    
    
    public EventAddProduct() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "10.192.230.31");
        //props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");//default port
        try {
            InitialContext ctx = new InitialContext(props);

            productFacade = (ProductFacadeRemote) ctx.lookup("java:global/Bussines/ProductFacade!negocio.ProductFacadeRemote");
            
            auctionFacade = (AuctionFacadeRemote) ctx.lookup("java:global/Bussines/AuctionFacade!negocio.AuctionFacadeRemote");
            
            
            
        } catch (Exception e) {
            System.out.println("error iniciando bean<<-------" + e);
        }
    }

    public void updateAuction(){
         auction = auctionFacade.find(Long.parseLong(idAuction+""));
         //auction = auctionFacade.find(Long.parseLong(idAuction+""));
        
    }
    
    public void addProduct(){
    
        Product p = new Product();
        p.setName(name);
        p.setDetail(description);
        p.setIdproduct(Long.parseLong(idNewProduct+""));
        p.setIdauction(auction);
        products.add(p);
        
        product = new Product();
        name="";
        description="";
        
    }
    
    public String save(){        
        int i = idNewProduct;
        for(Product p : products){
            p.setIdproduct(Long.parseLong(i+""));
            productFacade.create(p);    
            i++;
        }
        
        products.clear();
        
        return "index";
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(int idAuction) {
        this.idAuction = idAuction;
    }

    public Auction getAuction() {
        //auction = auctionFacade.find(Long.parseLong(idAuction+""));
        auction = auctionFacade.find(Long.parseLong(idAuction+""));
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<Auction> getAuctions() {
        auctions = auctionFacade.findAll();
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public int getIdNewProduct() {
        idNewProduct = productFacade.count() + 1;
        return idNewProduct;
    }

    public void setIdNewProduct(int idNewProduct) {
        this.idNewProduct = idNewProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
