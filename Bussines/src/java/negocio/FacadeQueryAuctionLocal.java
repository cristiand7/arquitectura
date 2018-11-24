/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Auction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sala a
 */
@Local
public interface FacadeQueryAuctionLocal {

    public List<Auction> getAcutionByDates(String fechaInicio, String fechaFin);
  
}
