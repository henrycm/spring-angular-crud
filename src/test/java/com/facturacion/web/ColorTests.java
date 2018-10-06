package com.facturacion.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public class ColorTests extends BaseTest
{
    @Value("${app.route.api.test}/colores")
    private String API_PREFIX;

    @Test
    public void testListColores() throws Exception
    {
        ResponseEntity<JsonNode> resp = GET( API_PREFIX );
        assertEquals( 3, resp.getBody().get( "content" ).size() );
    }
}
