/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.ejb;

import com.xergio.entidades.jpa.Orden;
import com.xergio.tienda.entidades.dto.OrdenDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author tlako
 */
@Stateless
@LocalBean
public class OrdenService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final Logger LOG = Logger.getLogger(ClienteService.class.getName());

    @EJB
    private OrdenFacade ordenFacade;

    public OrdenDTO buscarOrdenId(Integer Id) {
        
        OrdenDTO orden = new OrdenDTO();
        
        try{
            Orden  ordenEntidad =  ordenFacade.find(Id);
            if( ordenEntidad!=null){
                
                orden = transformarJpaDto(ordenEntidad);
                
            LOG.info("encontramos algo OK ");
            System.out.println("encontramos algo ");
        }
        }catch(Exception ex){
            ex.printStackTrace();
             LOG.info("no se peudo  ");
        }
        
        
        return orden;
    }
    
    public OrdenDTO transformarJpaDto(Orden ordenEntidad){
        
        OrdenDTO ordenDto = new OrdenDTO(ordenEntidad.getIdCliente(),ordenEntidad.getIdProducto(),ordenEntidad.getCantindad(),ordenEntidad.getFecha());
        
        return ordenDto;
    }
    
    
    public List<OrdenDTO> buscarTodosLasOrdenes() {
        
        List<OrdenDTO> ordenDto = new ArrayList<OrdenDTO>();
        
        try{
            List<Orden> ordenes = ordenFacade.findAll();
        
        if(!ordenes.isEmpty()){
            
            for (Orden temp : ordenes) {
                ordenDto.add(transformarJpaDto(temp));
            }
            
            LOG.info("encontramos algo OK ");
            System.out.println("encontramos algo ");
        }
        }catch(Exception ex){
            ex.printStackTrace();
            LOG.info("no se peudo  ");
        }
        
        return ordenDto;
    }
    
    public void guardarOrden(Orden orden){
        ordenFacade.create(orden);
    }
    
    public void eliminarOrden(Orden orden){
        ordenFacade.remove(orden);
    }
    
    public void actualizarOrden(Orden orden){
        ordenFacade.edit(orden);
    }
    
}
