/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Auction;
import entities.Auctionsuplier;
import entities.AuctionsuplierPK;
import entities.Suplier;
import entities.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import negocio.AuctionFacadeRemote;
import negocio.AuctionsuplierFacadeRemote;
import negocio.ProductFacadeRemote;
import negocio.SuplierFacadeRemote;

/**
 *
 * @author hikar
 */
@Named(value = "EventSetupAuction")
@SessionScoped

public class EventSetupAuction implements Serializable {

    @EJB
    private AuctionsuplierFacadeRemote auctionsuplierFacade;

    @EJB
    private SuplierFacadeRemote suplierFacade;

    @EJB
    private AuctionFacadeRemote auctionFacade;

    
    List<Suplier> supliers = new ArrayList<Suplier> ();
    List<Suplier> supliersSelected = new ArrayList<Suplier> ();
    int idSuplier ;
    Date dateInit = new Date();
    Date dateEnd = new Date ();
    Suplier suplier = new Suplier();
    Auction auction = new Auction();
    Long idNewAuction;
    
    /**
     * Creates a new instance of mbAuction
     */
    public EventSetupAuction() {
      
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

    String cadena = " from here";

    public void addSuplier(){
        
        
        Suplier s = suplierFacade.find(Long.parseLong(idSuplier+""));
        
        boolean esta = false;
    
        for(Suplier sp : supliersSelected){
            if(sp.getIdsuplier() == s.getIdsuplier())
                esta = true;
        }
        
        if(!esta)
            supliersSelected.add(s);
        //supliersSelected.add(suplier);
         
    }
    
    public String save() throws IOException {
        auction.setIdauction(idNewAuction);
        List<Auctionsuplier> aux = new ArrayList<Auctionsuplier>();
        
        auctionFacade.create(auction);
        
        for(Suplier s : supliersSelected){
            Auctionsuplier as = new Auctionsuplier();
            AuctionsuplierPK pk = new AuctionsuplierPK();
            pk.setIdauction(auction.getIdauction());
            pk.setIdsuplier(s.getIdsuplier());
            
            as.setOffer("0");
            as.setWin(Short.parseShort("0"));
            as.setAuction(auction);
            as.setSuplier(s);
            as.setAuctionsuplierPK(pk);
            auctionsuplierFacade.create(as);
        }
      supliers.clear();
        return "index";
    }
    
    
    
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    List<Auction> subastas = new ArrayList<>();

    public List<Auction> getSubastas() {
        System.out.println("get");
        subastas = auctionFacade.findAll();
        return subastas;
    }

    public void setSubastas(List<Auction> subastas) {
        this.subastas = subastas;
    }

    public List<Suplier> getSupliers() {
        supliers.clear();
        List<Suplier> aux = suplierFacade.findAll();
        boolean esta = false;
        
        for(Suplier s : aux){
            esta = false;
            for(Suplier s2 : supliersSelected){
                if(s2.getIdsuplier() == s.getIdsuplier())
                    esta=true;
            }
            if(!esta){
                supliers.add(s);
            }
        }
        
        
        
        return supliers;
    }

    public void setSupliers(List<Suplier> supliers) {
        this.supliers = supliers;
    }

    public int getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(int idSuplier) {
        this.idSuplier = idSuplier;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Suplier getSuplier() {
        return suplier;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<Suplier> getSupliersSelected() {
        return supliersSelected;
    }

    public void setSupliersSelected(List<Suplier> supliersSelected) {
        this.supliersSelected = supliersSelected;
    }

    public Long getIdNewAuction() {
        idNewAuction = Long.parseLong(auctionFacade.count()+"")+1;
        return idNewAuction;
    }

    public void setIdNewAuction(Long idNewAuction) {
        this.idNewAuction = idNewAuction;
    }



    
    
    
}
