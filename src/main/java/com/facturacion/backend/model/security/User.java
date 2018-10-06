package com.facturacion.backend.model.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.facturacion.backend.model.BaseEntity;

@Entity
@Table(name = "t_user")
public class User extends BaseEntity
{
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private String email;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    public User()
    {
    }

    public User( String username, String password )
    {
        this.username = username;
        this.password = password;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles( List<Role> roles )
    {
        this.roles = roles;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }
}
