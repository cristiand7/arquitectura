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

/**
 *
 * @author hikar
 */
@WebService(serviceName = "WsSoapQueryAuction")
@Stateless()
public class WsSoapQueryAuction {

    @EJB
    private FacadeQueryAuction ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Auction entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Auction entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Auction entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Auction find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Auction> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Auction> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getAcutionByDates")
    public List<Auction> getAcutionByDates(@WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFin") String fechaFin) {
        return ejbRef.getAcutionByDates(fechaInicio, fechaFin);
    }
    
}
