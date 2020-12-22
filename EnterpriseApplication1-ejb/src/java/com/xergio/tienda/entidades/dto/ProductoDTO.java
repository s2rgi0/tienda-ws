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
public class ProductoDTO {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private long precio;
    private Date fecha;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String descripcion, Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public ProductoDTO(Integer id, String nombre, String descripcion, Long precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
    
    
    
    
    
    
}
