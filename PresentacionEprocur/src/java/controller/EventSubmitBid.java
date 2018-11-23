/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import negocio.AuctionFacadeRemote;
import negocio.BidFacadeRemote;

/**
 *
 * @author hikar
 */
@Named(value = "eventSubmitBid")
@SessionScoped
public class EventSubmitBid implements Serializable {

    @EJB
    private BidFacadeRemote bidFacade;

    /**
     * Creates a new instance of EventsubmitBid
     */
    public EventSubmitBid() {
            Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");//default port
        try {
            InitialContext ctx = new InitialContext(props);

            bidFacade = (BidFacadeRemote) ctx.lookup("java:global/Bussines/BidFacade");
        } catch (Exception e) {
            System.out.println("error iniciando bean<<-------" + e);
        }
    }
    
}
