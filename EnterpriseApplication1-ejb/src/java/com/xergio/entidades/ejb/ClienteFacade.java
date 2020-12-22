/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.ejb;

import com.xergio.tienda.entidades.ejb.impl.AbstractFacade;
import com.xergio.entidades.jpa.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tlako
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    
    
}
