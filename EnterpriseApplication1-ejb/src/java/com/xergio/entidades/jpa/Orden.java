/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xergio.entidades.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tlako
 */
@Entity
@Table(name = "orden", catalog = "tienda_ws", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Orden.findByIdCliente", query = "SELECT o FROM Orden o WHERE o.idCliente = :idCliente")
    , @NamedQuery(name = "Orden.findByIdProducto", query = "SELECT o FROM Orden o WHERE o.idProducto = :idProducto")
    , @NamedQuery(name = "Orden.findByCantindad", query = "SELECT o FROM Orden o WHERE o.cantindad = :cantindad")
    , @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden", nullable = false)
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Column(name = "cantindad")
    private Integer cantindad;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Orden() {
    }

    public Orden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(Integer idOrden, int idCliente, int idProducto) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xergio.entidades.jpa.Orden[ idOrden=" + idOrden + " ]";
    }
    
}
