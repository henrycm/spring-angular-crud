package com.facturacion.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public class ProductoTests extends BaseTest
{
    @Value("${app.route.api.test}/productos")
    private String API_PREFIX;

    @Test
    public void testListColores() throws Exception
    {
        ResponseEntity<JsonNode> resp = GET( API_PREFIX );
        assertEquals( 4, resp.getBody().get( "content" ).size() );
    }
}
