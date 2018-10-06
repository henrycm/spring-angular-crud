package com.facturacion.backend.services.security.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.facturacion.backend.services.security.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService
{

    @Override
    public Boolean hasProtectedAccess()
    {
        return ( SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains( new SimpleGrantedAuthority( "ADMIN" ) ) );
    }

}
