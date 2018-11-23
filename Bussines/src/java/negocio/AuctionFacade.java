/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auction;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
