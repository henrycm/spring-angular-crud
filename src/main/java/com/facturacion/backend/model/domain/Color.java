package com.facturacion.backend.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.facturacion.backend.model.BaseEntity;

@Entity
public class Color extends BaseEntity
{
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;

    @ColumnDefault("true")
    private boolean activo;

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
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

    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo( boolean activo )
    {
        this.activo = activo;
    }

}
