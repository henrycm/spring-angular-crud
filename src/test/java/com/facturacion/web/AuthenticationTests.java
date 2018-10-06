package com.facturacion.web;

import static com.facturacion.web.util.RequestEntityBuilder.buildRequestEntity;
import static org.junit.Assert.assertEquals;

import java.util.Base64;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.facturacion.web.security.AuthenticationRequest;

public class AuthenticationTests extends BaseTest
{
    @Value("${app.route.authentication.test}")
    private String API_PREFIX;

    @Value("${app.route.api.test}/colores")
    private String API_COLORS_PREFIX;

    @Test
    public void testAuthenticateWrongCredentials() throws Exception
    {
        AuthenticationRequest request = new AuthenticationRequest( testUsername, "" );
        ResponseEntity<String> response = restTemplate.exchange( API_PREFIX, HttpMethod.POST, buildRequestEntity( request ), String.class );

        assertEquals( HttpStatus.UNAUTHORIZED, response.getStatusCode() );
    }

    @Test
    public void testInvalidSignatureInToken()
    {
        String[] tokenParts = authenticationToken.split( "[.]" );
        tokenParts[2] = tokenParts[2] + "_";
        String alteredToken = String.join( ".", tokenParts );
        ResponseEntity<String> response = restTemplate.exchange( API_COLORS_PREFIX, HttpMethod.GET, buildRequestEntity( alteredToken ), String.class );

        assertEquals( HttpStatus.UNAUTHORIZED, response.getStatusCode() );
    }

    @Test
    public void testAlteredUsernameInToken()
    {
        String[] tokenParts = authenticationToken.split( "\\." );
        tokenParts[1] = Base64.getEncoder().encodeToString( new String( Base64.getDecoder().decode( tokenParts[1].getBytes() ) ).replace( testUsername, testUsername + "2" ).getBytes() );
        String alteredToken = String.join( ".", tokenParts );
        ResponseEntity<String> response = restTemplate.exchange( API_COLORS_PREFIX, HttpMethod.GET, buildRequestEntity( alteredToken ), String.class );

        assertEquals( HttpStatus.UNAUTHORIZED, response.getStatusCode() );
    }
}
