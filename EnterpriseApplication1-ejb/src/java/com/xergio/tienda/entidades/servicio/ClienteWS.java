/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.tienda.entidades.servicio;

import com.xergio.entidades.ejb.ClienteService;
import com.xergio.entidades.jpa.Cliente;
import com.xergio.tienda.entidades.dto.ClienteDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tlako
 */
@WebService(serviceName = "ClienteWS")
@Stateless()
public class ClienteWS {

    @EJB
    private ClienteService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "buscarClienteId")
    public ClienteDTO buscarClienteId(@WebParam(name = "Id") Integer Id) {
        return ejbRef.buscarClienteId(Id);
    }

    @WebMethod(operationName = "transformarJpaDto")
    public ClienteDTO transformarJpaDto(@WebParam(name = "clienteEntidad") Cliente clienteEntidad) {
        return ejbRef.transformarJpaDto(clienteEntidad);
    }

    @WebMethod(operationName = "buscarTodosLosCliente")
    public List<ClienteDTO> buscarTodosLosCliente() {
        return ejbRef.buscarTodosLosCliente();
    }

    @WebMethod(operationName = "guardarCliente")
    @Oneway
    public void guardarCliente(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.guardarCliente(cliente);
    }

    @WebMethod(operationName = "eliminarCliente")
    @Oneway
    public void eliminarCliente(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.eliminarCliente(cliente);
    }

    @WebMethod(operationName = "actualizarCliente")
    @Oneway
    public void actualizarCliente(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.actualizarCliente(cliente);
    }
    
}
