package com.facturacion.web.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.backend.model.domain.DetallePedido;
import com.facturacion.backend.model.domain.Pedido;
import com.facturacion.backend.services.domain.PedidoService;

@RestController
@RequestMapping("${app.route.api}/pedidos")
public class PedidoController
{
    @Autowired
    private PedidoService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Pedido> list( Pageable request )
    {
        return service.listAll( request );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pedido retrieve( @PathVariable Long id )
    {
        return service.retrieve( id );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Pedido update( @PathVariable Long id, @RequestBody Pedido pedido )
    {
        pedido.setId( id );
        return service.update( pedido );
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pedido create( @RequestBody Pedido pedido )
    {
        return service.create( pedido );
    }

    @RequestMapping(value = "/{id}/detalle", method = RequestMethod.POST)
    public List<DetallePedido> updateDetalle( @PathVariable Long id, @RequestBody List<DetallePedido> detalle )
    {
        return service.updateDetalle( id, detalle );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete( @PathVariable Long id )
    {
        service.delete( id );
    }
}
