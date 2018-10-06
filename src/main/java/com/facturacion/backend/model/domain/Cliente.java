package com.facturacion.backend.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.facturacion.backend.model.BaseEntity;

@Entity
public class Cliente extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

}
