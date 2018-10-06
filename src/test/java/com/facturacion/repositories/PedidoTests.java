package com.facturacion.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;

import com.facturacion.backend.model.domain.Cliente;
import com.facturacion.backend.model.domain.Pedido;
import com.facturacion.backend.repository.ClienteRepository;
import com.facturacion.backend.repository.PedidoRepository;
import com.facturacion.web.BaseTest;

public class PedidoTests extends BaseTest
{
    @Resource
    ClienteRepository clienteRepository;

    @Resource
    PedidoRepository repository;

    @Test
    public void testSearchByClient()
    {
        Cliente cliente = clienteRepository.findOne( 1l );

        Pedido pedido = buildPedido();
        pedido.setCliente( cliente );
        repository.save( pedido );

        List<Pedido> pedidos = repository.searchByClient( cliente.getNombre() );

        assertTrue( pedidos.size() == 1 );
        assertEquals( pedidos.get( 0 ).getCliente().getId(), pedido.getCliente().getId() );

        assertEquals( 0, repository.searchByClient( UUID.randomUUID().toString() ).size() );
    }
}
