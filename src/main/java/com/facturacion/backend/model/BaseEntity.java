package com.facturacion.backend.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity
{

    @Version
    @NotNull
    @ColumnDefault("1")
    private Long version = 1L;

    @CreatedBy
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @JsonIgnore
    private Date creationTime;

    @LastModifiedBy
    @JsonIgnore
    private String modifiedBy;

    @LastModifiedDate
    @JsonIgnore
    private Date modificationTime;

    public Long getVersion()
    {
        return version;
    }

    public void setVersion( Long version )
    {
        this.version = version;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy( String createdBy )
    {
        this.createdBy = createdBy;
    }

    public Date getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime( Date creationTime )
    {
        this.creationTime = creationTime;
    }

    public String getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy( String modifiedBy )
    {
        this.modifiedBy = modifiedBy;
    }

    public Date getModificationTime()
    {
        return modificationTime;
    }

    public void setModificationTime( Date modificationTime )
    {
        this.modificationTime = modificationTime;
    }

}
