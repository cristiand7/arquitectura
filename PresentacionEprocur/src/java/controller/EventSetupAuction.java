/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Auction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import negocio.AuctionFacadeRemote;

/**
 *
 * @author hikar
 */
@Named(value = "EventSetupAuction")
@SessionScoped

public class EventSetupAuction implements Serializable {

    @EJB
    private AuctionFacadeRemote auctionFacade;

    /**
     * Creates a new instance of mbAuction
     */
    public EventSetupAuction() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");//default port
        try {
            InitialContext ctx = new InitialContext(props);

            auctionFacade = (AuctionFacadeRemote) ctx.lookup("java:global/Bussines/AuctionFacade");
        } catch (Exception e) {
            System.out.println("error iniciando bean<<-------" + e);
        }
    }

    String cadena = " from here";

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

}
