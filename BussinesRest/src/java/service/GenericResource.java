/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.Auction;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import negocio.FacadeQueryAcutionRemote;
import negocio.ProductFacadeRemote;
import java.lang.reflect.Type;
/**
 * REST Web Service
 *
 * @author sala a
 */
@Path("auction")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     *
     */
    @EJB
    private FacadeQueryAcutionRemote facade;

    /**
     * Creates a new instance of EventosAddProduct
     */
    public GenericResource() {
        Properties props = new Properties();
        props.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");//default port
        try {
            InitialContext ctx = new InitialContext(props);

            facade = (FacadeQueryAcutionRemote) ctx.lookup("java:global/Bussines/FacadeQueryAuction!negocio.FacadeQueryAcutionRemote");
        } catch (Exception e) {
            System.out.println("error iniciando bean<<-------" + e);
        }
    }

    /**
     * Retrieves representation of an instance of service.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{inicio}/{fin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Auction> getText(@PathParam("inicio") String inicio, @PathParam("fin") String fin) {
        //TODO return proper representation object
        return facade.getAcutionByDatesRest(inicio, fin);
    }

}
