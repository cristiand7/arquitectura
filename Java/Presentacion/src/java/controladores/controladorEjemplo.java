/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Negocio.UsuarioFacadeRemote;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author hikar
 */
@Named(value = "controladorEjemplo")
@RequestScoped
public class controladorEjemplo {

    @EJB
    private UsuarioFacadeRemote usuarioFacade;

    /**
     * Creates a new instance of controladorEjemplo
     */
    public controladorEjemplo() {
        
        
        System.out.println("-------->>  "+usuarioFacade.findAll());
    }
    
    
}
