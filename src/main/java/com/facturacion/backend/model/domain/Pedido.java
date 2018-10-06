package com.facturacion.backend.model.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.facturacion.backend.model.BaseEntity;

@Entity
public class Pedido extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private Integer status;
    private String description;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.MERGE)
    private Set<DetallePedido> detalle;

    @ManyToOne
    private Cliente cliente;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus( Integer status )
    {
        this.status = status;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Set<DetallePedido> getDetalle()
    {
        return detalle;
    }

    public void setDetalle( Set<DetallePedido> detalle )
    {
        this.detalle = detalle;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente( Cliente cliente )
    {
        this.cliente = cliente;
    }

}
