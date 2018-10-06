package com.facturacion.web;

import static com.facturacion.web.util.RequestEntityBuilder.buildRequestEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.facturacion.backend.model.domain.DetallePedido;
import com.facturacion.backend.model.domain.Pedido;

public class PedidoTests extends BaseTest
{
    @Value("${app.route.api.test}/pedidos")
    private String API_PREFIX;

    @Test
    public void testCreatePedido()
    {
        Pedido pedido = buildPedido();
        ResponseEntity<Pedido> resp = this.restTemplate.exchange(
            API_PREFIX,
            HttpMethod.POST,
            buildRequestEntity( authenticationToken, pedido ),
            Pedido.class,
            pedido.getId()
            );

        assertEquals( HttpStatus.OK, resp.getStatusCode() );
        assertEquals( pedido.getDescription(), resp.getBody().getDescription() );
    }

    @Test
    public void testUpdatePedido()
    {
        Pedido req = buildPedido();
        Pedido pedido = rPedido.save( req );

        req.setDescription( "MOD" );
        ResponseEntity<Pedido> resp = this.restTemplate.exchange(
            API_PREFIX + "/{id}",
            HttpMethod.PUT,
            buildRequestEntity( authenticationToken, req ),
            Pedido.class,
            pedido.getId()
            );

        assertEquals( HttpStatus.OK, resp.getStatusCode() );
        assertEquals( req.getDescription(), resp.getBody().getDescription() );
    }

    @Test
    public void testCreateDetalle()
    {
        Pedido pedido = rPedido.save( buildPedido() );
        for ( int i = 0; i < 5; i++ ) {
            rDetalle.save( buildDetalle( pedido ) );
        }

        ResponseEntity<Pedido> resp = this.restTemplate.exchange(
            API_PREFIX + "/{id}",
            HttpMethod.GET,
            buildRequestEntity( authenticationToken ),
            Pedido.class,
            pedido.getId()
            );

        assertNotNull( resp.getBody() );
        assertEquals( 5, resp.getBody().getDetalle().size() );
    }

    @Test
    public void testUpdateDetalle()
    {
        List<DetallePedido> detalle = new LinkedList<>();

        Pedido pedido = rPedido.save( buildPedido() );
        for ( int i = 0; i < 5; i++ ) {
            DetallePedido item = rDetalle.save( buildDetalle( pedido ) );
            item.setSku( item.getId() + "_SKU_X" );
            detalle.add( item );
        }

        ResponseEntity<DetallePedido[]> resp = this.restTemplate.postForEntity(
            API_PREFIX + "/{id}/detalle",
            buildRequestEntity( authenticationToken, detalle ),
            DetallePedido[].class,
            pedido.getId()
            );

        assertNotNull( resp.getBody() );

        for ( DetallePedido d : resp.getBody() ) {
            assertEquals( d.getId() + "_SKU_X", d.getSku() );
        }
    }
}
