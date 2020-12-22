/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.tienda.entidades.servicio;

import com.xergio.entidades.ejb.OrdenService;
import com.xergio.entidades.jpa.Orden;
import com.xergio.tienda.entidades.dto.OrdenDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tlako
 */
@WebService(serviceName = "OrdenWebService")
@Stateless()
public class OrdenWebService {

    @EJB
    private OrdenService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "buscarOrdenId")
    public OrdenDTO buscarOrdenId(@WebParam(name = "Id") Integer Id) {
        return ejbRef.buscarOrdenId(Id);
    }

    @WebMethod(operationName = "transformarJpaDto")
    public OrdenDTO transformarJpaDto(@WebParam(name = "ordenEntidad") Orden ordenEntidad) {
        return ejbRef.transformarJpaDto(ordenEntidad);
    }

    @WebMethod(operationName = "buscarTodosLasOrdenes")
    public List<OrdenDTO> buscarTodosLasOrdenes() {
        return ejbRef.buscarTodosLasOrdenes();
    }

    @WebMethod(operationName = "guardarOrden")
    public void guardarOrden(@WebParam(name = "orden") Orden orden) {
       
    }

    @WebMethod(operationName = "eliminarOrden")
    public void eliminarOrden(@WebParam(name = "orden") Orden orden) {
        
    }
    
    
}
