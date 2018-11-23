/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entities.Auctionsuplier;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author hikar
 */
@Remote
public interface AuctionsuplierFacadeRemote {

    void create(Auctionsuplier auctionsuplier);

    void edit(Auctionsuplier auctionsuplier);

    void remove(Auctionsuplier auctionsuplier);

    Auctionsuplier find(Object id);

    List<Auctionsuplier> findAll();

    List<Auctionsuplier> findRange(int[] range);

    int count();
    
}
