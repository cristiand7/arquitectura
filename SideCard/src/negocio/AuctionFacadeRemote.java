/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auction;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author hikar
 */
@Remote
public interface AuctionFacadeRemote {

    void create(Auction auction);

    void edit(Auction auction);

    void remove(Auction auction);

    Auction find(Object id);

    List<Auction> findAll();

    List<Auction> findRange(int[] range);

    int count();
    
}
