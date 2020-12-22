/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.ejb;


import com.xergio.entidades.jpa.Producto;
import com.xergio.tienda.entidades.dto.ProductoDTO;
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
public class ProductoService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final Logger LOG = Logger.getLogger(ClienteService.class.getName());

    @EJB
    private ProductoFacade productoFacade;

    public ProductoDTO buscarProductoId(Integer Id) {
        
        ProductoDTO producto = new ProductoDTO();
        
        try{
            Producto  productoEntidad =  productoFacade.find(Id);
            if( productoEntidad!=null){
                
                producto = transformarJpaDto(productoEntidad);
                
            LOG.info("encontramos algo OK ");
            System.out.println("encontramos algo ");
        }
        }catch(Exception ex){
            ex.printStackTrace();
             LOG.info("no se peudo  ");
        }
        
        
        return  producto;
    }
    
    public ProductoDTO transformarJpaDto(Producto productoEntidad){
        
        ProductoDTO productoDto = new ProductoDTO(productoEntidad.getId(),productoEntidad.getNombre(),productoEntidad.getDescripcion(),productoEntidad.getPrecio());
        
        return productoDto;
    }
    
    
    public List<ProductoDTO> buscarTodosLosProducto() {
        
        List<ProductoDTO> productoDto = new ArrayList<ProductoDTO>();
        
        try{
            List<Producto>  productos = productoFacade.findAll();
        
        if(!productos.isEmpty()){
            LOG.info("encontramos algo OK ");
            
            for (Producto temp : productos) {
                productoDto.add(transformarJpaDto(temp));
            }
            System.out.println("encontramos algo ");
        }
        }catch(Exception ex){
            ex.printStackTrace();
            LOG.info("no se peudo  ");
        }
        
        return  productoDto;
    }
    
    public void guardarProducto(Producto  producto){
        productoFacade.create(producto);
    }
    
    public void eliminarProducto(Producto  producto){
        productoFacade.remove(producto);
    }
    
    public void actualizarProducto(Producto producto){
        productoFacade.edit(producto);
    }
}
