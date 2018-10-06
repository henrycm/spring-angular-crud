package com.facturacion.web.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class RequestEntityBuilder
{

    public static HttpEntity<Object> buildRequestEntity( String authenticationToken, Object body )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "X-Auth-Token", authenticationToken );
        headers.add( "Content-Type", "application/json" );
        HttpEntity<Object> entity = new HttpEntity<Object>(
            body,
            headers
            );
        return entity;
    }

    public static HttpEntity<Object> buildRequestEntity( String authenticationToken )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "X-Auth-Token", authenticationToken );
        headers.add( "Content-Type", "application/json" );
        HttpEntity<Object> entity = new HttpEntity<Object>( headers );
        return entity;
    }

    public static HttpEntity<Object> buildRequestEntity( Object body )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Type", "application/json" );
        HttpEntity<Object> entity = new HttpEntity<Object>(
            body,
            headers
            );
        return entity;
    }

    public static HttpEntity<Object> buildRequestEntity()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Type", "application/json" );
        HttpEntity<Object> entity = new HttpEntity<Object>( headers );
        return entity;
    }

}
