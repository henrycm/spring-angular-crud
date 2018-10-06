package com.facturacion.web.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationResponse
{
    private String token;
    private String username;
    private List<String> roles;

    public AuthenticationResponse()
    {
    }

    public AuthenticationResponse( String token, UserDetails user )
    {
        this.setToken( token );
        this.username = user.getUsername();
        List<String> roleNames = new LinkedList<>();

        for ( GrantedAuthority au : user.getAuthorities() ) {
            roleNames.add( au.getAuthority() );
        }
        this.roles = roleNames;
    }

    public String getToken()
    {
        return this.token;
    }

    public void setToken( String token )
    {
        this.token = token;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public List<String> getRoles()
    {
        return roles;
    }

    public void setRoles( List<String> roles )
    {
        this.roles = roles;
    }

}
