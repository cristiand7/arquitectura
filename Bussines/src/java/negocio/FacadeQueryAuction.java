/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auction;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author hikar
 */
@Stateless
public class FacadeQueryAuction extends AbstractFacade<Auction> {

    @PersistenceContext(unitName = "BussinesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacadeQueryAuction() {
        super(Auction.class);
    }

    public List<Auction> getAcutionByDates(String fechaInicio, String fechaFin) {
        
            List<Auction> res = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(fechaInicio);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            Date parsedDate1 = dateFormat.parse(fechaFin);
            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate.getTime());

            res = getEntityManager().createQuery("select a from Auction a where a.startdate > :fechaInicio "
                    + " and < :fechafin ", Auction.class)
                    .setParameter("fechainicio", parsedDate,TemporalType.DATE)
                    .setParameter("fechafin", parsedDate1,TemporalType.DATE)
                    .getResultList();
        } catch (Exception e) { //this generic but you can control nother types of exception
            // look the origin of excption 
            System.out.println("error query --->"+e);
        }

        return res;
    }

}
