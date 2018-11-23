/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auctionsuplier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hikar
 */
@Stateless
public class AuctionsuplierFacade extends AbstractFacade<Auctionsuplier> implements negocio.AuctionsuplierFacadeRemote {

    @PersistenceContext(unitName = "BussinesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuctionsuplierFacade() {
        super(Auctionsuplier.class);
    }
    
}
