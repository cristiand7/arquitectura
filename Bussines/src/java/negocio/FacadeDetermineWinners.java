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
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author sala a
 */
@Stateless
@LocalBean
@Startup
public class FacadeDetermineWinners {

    @EJB
    private AuctionFacadeRemote auctionfacade;

    @Resource
    private TimerService timerService;

	
    
    private void determineWinners() {
        List<Auction> auctions=auctionfacade.findAll();
        
        for (Auction a:auctions)
        {
            Auctionsuplier as=auctionfacade.getWinner(a.getIdauction());//ganador
            System.out.println("WINNER !!!! bid-->"+as.getOffer()+" \n suplier "+as.getAuctionsuplierPK().getIdsuplier());
            
            
        }
    }
    
    
    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*/1", second = "0", persistent = false)
    public void test() {
            System.out.println(new Date() + " Determinate winners...");
            determineWinners();
    }
 
    
    
}
