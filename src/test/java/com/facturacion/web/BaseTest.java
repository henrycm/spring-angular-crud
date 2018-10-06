package com.facturacion.web;

import static com.facturacion.web.util.RequestEntityBuilder.buildRequestEntity;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.facturacion.backend.model.domain.DetallePedido;
import com.facturacion.backend.model.domain.Pedido;
import com.facturacion.backend.repository.DetallePedidoRepository;
import com.facturacion.backend.repository.PedidoRepository;
import com.facturacion.web.security.AuthenticationRequest;
import com.facturacion.web.security.AuthenticationResponse;
import com.fasterxml.jackson.databind.JsonNode;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class BaseTest
{
    protected String authenticationToken;

    @Value("${app.route.authentication.test}")
    private String authenticationRoute;
    @Value("${test.auth.username}")
    protected String testUsername;
    @Value("${test.auth.password}")
    private String testPassword;

    @Autowired
    protected TestRestTemplate restTemplate;
    @Autowired
    protected PedidoRepository rPedido;
    @Autowired
    protected DetallePedidoRepository rDetalle;

    @Before
    public void setUp()
    {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setOutputStreaming( false );
        restTemplate.getRestTemplate().setRequestFactory( requestFactory );

        AuthenticationRequest authenticationRequest = new AuthenticationRequest( testUsername, testPassword );

        ResponseEntity<AuthenticationResponse> authenticationResponse = this.restTemplate.postForEntity(
            authenticationRoute,
            authenticationRequest,
            AuthenticationResponse.class
            );

        assertNotNull( authenticationResponse.getBody() );
        assertNotNull( authenticationResponse.getBody().getToken() );
        assertNotNull( authenticationResponse.getBody().getUsername() );

        authenticationToken = authenticationResponse.getBody().getToken();
    }

    @Test
    public void testSetUpEnv() throws Exception
    {

    }

    protected Pedido buildPedido()
    {
        Pedido pedido = new Pedido();
        pedido.setDescription( "Test1" );
        return pedido;
    }

    protected DetallePedido buildDetalle( Pedido pedido )
    {
        DetallePedido detalle = new DetallePedido();
        detalle.setSku( "TestSKU" );
        detalle.setPedido( pedido );
        return detalle;
    }

    public ResponseEntity<JsonNode> GET( String context )
    {
        return this.restTemplate.exchange( context, HttpMethod.GET, buildRequestEntity( authenticationToken ), JsonNode.class );
    }
}
