/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entities.Suplier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hikar
 */
@Stateless
public class SuplierFacade extends AbstractFacade<Suplier> implements Negocio.SuplierFacadeRemote {

    @PersistenceContext(unitName = "BusinessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuplierFacade() {
        super(Suplier.class);
    }
    
}
