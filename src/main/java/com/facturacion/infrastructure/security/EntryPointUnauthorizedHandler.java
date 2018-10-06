package com.facturacion.infrastructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint
{

    private final static Logger LOGGER = LoggerFactory.getLogger( EntryPointUnauthorizedHandler.class );

    @Override
    public void commence(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        AuthenticationException ex ) throws IOException, ServletException
    {
        LOGGER.error( "Error authenticating", ex.getMessage() );
        httpServletResponse.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Access Denied" );
    }

}
