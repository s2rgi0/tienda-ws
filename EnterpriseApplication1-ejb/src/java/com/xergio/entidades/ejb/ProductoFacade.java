/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.ejb;

import com.xergio.tienda.entidades.ejb.impl.AbstractFacade;
import com.xergio.entidades.jpa.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tlako
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
}
