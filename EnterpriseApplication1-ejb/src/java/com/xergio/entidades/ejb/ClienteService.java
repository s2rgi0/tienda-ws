/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.ejb;

import com.xergio.entidades.jpa.Cliente;
import com.xergio.tienda.entidades.dto.ClienteDTO;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author tlako
 */
@Stateless
@LocalBean
public class ClienteService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final Logger LOG = Logger.getLogger(ClienteService.class.getName());
    
    @EJB
    private ClienteFacade clienteFacade;

    public ClienteDTO buscarClienteId(Integer Id) {
        
        ClienteDTO cliente = new ClienteDTO();
        
        try{
            Cliente clienteEntidad = clienteFacade.find(Id);
            if(clienteEntidad!=null){
                
                cliente = transformarJpaDto(clienteEntidad);
                
            LOG.info("encontramos algo OK ");
            System.out.println("encontramos algo ");
            }
        }catch(Exception ex){
            ex.printStackTrace();
             LOG.info("no se peudo  ");
        }
        
        
        return cliente;
    }
    
    
    
    public ClienteDTO transformarJpaDto(Cliente clienteEntidad){
        
        ClienteDTO clienteDto = new ClienteDTO();
        try {
            //ClienteDTO clienteDto = new ClienteDTO(clienteEntidad.getId(),clienteEntidad.getNombres(),clienteEntidad.getApellidos());
            BeanUtils.copyProperties(clienteDto, clienteEntidad);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clienteDto;
    }
    
    
    public List<ClienteDTO> buscarTodosLosCliente() {
        
        List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
        
        try{
            List<Cliente> clientes = clienteFacade.findAll();
        
        if(!clientes.isEmpty()){
            LOG.info("encontramos algo OK ");
            
            for (Cliente temp : clientes) {
                clientesDto.add(transformarJpaDto(temp));
            }
            System.out.println("encontramos algo ");
        }
        }catch(Exception ex){
            ex.printStackTrace();
            LOG.info("no se peudo  ");
        }
        
        return clientesDto;
    }
    
    public void guardarCliente(Cliente cliente){
        
        clienteFacade.create(cliente);
    }
    
    public void eliminarCliente(Cliente cliente){
        clienteFacade.remove(cliente);
    }
    
    public void actualizarCliente(Cliente cliente){
        clienteFacade.edit(cliente);
    }
    
   
 
}
