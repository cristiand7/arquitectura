/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
/**
 *
 * @author hikar
 */
@Path("Auction")
public class WsRestQueryAuction {
    @GET
    //@Path("usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerData(){
        return "hello";
    }
}
