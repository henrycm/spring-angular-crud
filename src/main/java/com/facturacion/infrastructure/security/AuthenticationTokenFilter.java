package com.facturacion.infrastructure.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.util.UrlPathHelper;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter
{
    private final static Logger LOGGER = LoggerFactory.getLogger( AuthenticationTokenFilter.class );

    @Value("${app.security.token.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
        throws IOException,
        ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader( this.tokenHeader );
        String username = this.tokenUtils.getUsernameFromToken( authToken );

        LOGGER.debug( "Resource: {}", new UrlPathHelper().getPathWithinApplication( httpRequest ) );
        LOGGER.debug( "Token: {}", authToken );
        LOGGER.debug( "Username from token: {}", username );

        if ( username != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername( username );
            LOGGER.debug( "Username from DB: {}", username );
            if ( this.tokenUtils.validateToken( authToken, userDetails ) ) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities() );
                authentication.setDetails( new WebAuthenticationDetailsSource().buildDetails( httpRequest ) );
                SecurityContextHolder.getContext().setAuthentication( authentication );
            }
        }

        chain.doFilter( request, response );
    }
}
