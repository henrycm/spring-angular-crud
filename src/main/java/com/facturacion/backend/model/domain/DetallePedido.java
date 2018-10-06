package com.facturacion.backend.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.facturacion.backend.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetallePedido extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private String sku;

    @ManyToOne
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    private Producto producto;

    public DetallePedido()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku( String sku )
    {
        this.sku = sku;
    }

    public Pedido getPedido()
    {
        return pedido;
    }

    public void setPedido( Pedido pedido )
    {
        this.pedido = pedido;
    }

    public Producto getProducto()
    {
        return producto;
    }

    public void setProducto( Producto producto )
    {
        this.producto = producto;
    }

}
