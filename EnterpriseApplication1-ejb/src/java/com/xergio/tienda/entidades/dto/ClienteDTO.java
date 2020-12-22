/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.tienda.entidades.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tlako
 */
@XmlRootElement(name = "cliente")
public class ClienteDTO implements Serializable{
    
    private Integer id;
    private String nombres;
    private String apellidos;

    public ClienteDTO() {
        
    }

    public ClienteDTO(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public ClienteDTO(Integer id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
    
}
