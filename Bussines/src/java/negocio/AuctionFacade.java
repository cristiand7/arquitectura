/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auction;
import entities.Auctionsuplier;
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
public class AuctionFacade extends AbstractFacade<Auction> implements AuctionFacadeRemote {

    @PersistenceContext(unitName = "BussinesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuctionFacade() {
        super(Auction.class);
    }
    
    public Auctionsuplier getWinner(Long id){
        
        return getEntityManager().createQuery("select a from Auctionsuplier a where a.auctionsuplierPK.idauction = "+id+"    limit 1", Auctionsuplier.class).getSingleResult();
        
    }
    public List<Auction> getAuctions(Date fechafin){
       
                return  getEntityManager().createQuery("select a from Auction a where :fechaFin = a.closedate", Auction.class)
                    .setParameter("fechaFin", fechafin,TemporalType.DATE)
                    .getResultList();
        
    }
    
    
}
