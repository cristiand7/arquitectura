/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Suplier;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author hikar
 */
@Remote
public interface SuplierFacadeRemote {

    void create(Suplier suplier);

    void edit(Suplier suplier);

    void remove(Suplier suplier);

    Suplier find(Object id);

    List<Suplier> findAll();

    List<Suplier> findRange(int[] range);

    int count();
    
}
