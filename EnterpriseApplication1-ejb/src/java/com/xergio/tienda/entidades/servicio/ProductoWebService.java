/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.tienda.entidades.servicio;

import com.xergio.entidades.ejb.ProductoService;
import com.xergio.entidades.jpa.Producto;
import com.xergio.tienda.entidades.dto.ProductoDTO;
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
@WebService(serviceName = "ProductoWebService")
@Stateless()
public class ProductoWebService {

    @EJB
    private ProductoService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "buscarProductoId")
    public ProductoDTO buscarProductoId(@WebParam(name = "Id") Integer Id) {
        return ejbRef.buscarProductoId(Id);
    }

    @WebMethod(operationName = "transformarJpaDto")
    public ProductoDTO transformarJpaDto(@WebParam(name = "productoEntidad") Producto productoEntidad) {
        return ejbRef.transformarJpaDto(productoEntidad);
    }

    @WebMethod(operationName = "buscarTodosLosProducto")
    public List<ProductoDTO> buscarTodosLosProducto() {
        return ejbRef.buscarTodosLosProducto();
    }

    @WebMethod(operationName = "guardarProducto")
    public void guardarProducto(@WebParam(name = "producto") Producto producto) {
    }

    @WebMethod(operationName = "eliminarProducto")
    public void eliminarProducto(@WebParam(name = "producto") Producto producto) {
    }
    
}
