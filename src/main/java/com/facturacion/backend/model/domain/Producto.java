package com.facturacion.backend.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.facturacion.backend.model.BaseEntity;

@Entity
public class Producto extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @ColumnDefault("0")
    private Integer status;
    private String description;

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

}
