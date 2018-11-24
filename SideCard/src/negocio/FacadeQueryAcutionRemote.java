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
public interface FacadeQueryAcutionRemote {

      public List<Auction> getAcutionByDatesRest(String fechaInicio, String fechaFin) ;
    
}
