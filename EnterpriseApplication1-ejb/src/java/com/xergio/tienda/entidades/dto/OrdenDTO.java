/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.tienda.entidades.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tlako
 */
@XmlRootElement
public class OrdenDTO {
    
    private Integer idOrden;
    private int idCliente;
    private int idProducto;
    private Integer cantindad;
    private Date fecha;

    public OrdenDTO() {
    }

    public OrdenDTO(int idCliente, int idProducto, Integer cantindad, Date fecha) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantindad = cantindad;
        this.fecha = fecha;
    }
    
    
    

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantindad() {
        return cantindad;
    }

    public void setCantindad(Integer cantindad) {
        this.cantindad = cantindad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
