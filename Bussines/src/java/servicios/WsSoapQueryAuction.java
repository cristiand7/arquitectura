/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entities.Auction;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import negocio.FacadeQueryAuction;
import negocio.FacadeQueryAuctionLocal;

/**
 *
 * @author hikar
 */
@WebService(serviceName = "WsSoapQueryAuction")
@Stateless()
public class WsSoapQueryAuction {

    @EJB
    private FacadeQueryAuctionLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    
    @WebMethod(operationName = "getAcutionByDates")
    public List<Auction> getAcutionByDates(@WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFin") String fechaFin) {
        return ejbRef.getAcutionByDates(fechaInicio, fechaFin);
    }
    
}
