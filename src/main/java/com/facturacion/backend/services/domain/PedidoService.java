package com.facturacion.backend.services.domain;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.facturacion.backend.model.domain.DetallePedido;
import com.facturacion.backend.model.domain.Pedido;
import com.facturacion.backend.repository.DetallePedidoRepository;
import com.facturacion.backend.repository.PedidoRepository;
import com.facturacion.backend.repository.ProductoRepository;

@Service
public class PedidoService implements IPageableService<Pedido>
{
    @Autowired
    PedidoRepository repositoryPedido;
    @Autowired
    DetallePedidoRepository repositoryDetalle;
    @Autowired
    ProductoRepository repositoryProducto;

    public Pedido update( Pedido pedido )
    {
        return repositoryPedido.save( pedido );
    }

    @Transactional
    public Pedido create( Pedido pedido )
    {
        return repositoryPedido.save( pedido );
    }

    public Pedido retrieve( Long id )
    {
        return repositoryPedido.findOne( id );
    }

    public List<DetallePedido> updateDetalle( Long idPedido, List<DetallePedido> detalle )
    {
        List<DetallePedido> result = new LinkedList<>();

        Pedido pedido = repositoryPedido.findOne( idPedido );

        for ( DetallePedido item : detalle ) {
            item.setPedido( pedido );
            DetallePedido itemSaved = repositoryDetalle.save( item );
            result.add( itemSaved );
        }

        return result;
    }

    @Override
    public Page<Pedido> listAll( Pageable request )
    {
        return repositoryPedido.findAll( request );
    }

    @Override
    public void delete( Long id )
    {
        repositoryPedido.delete( id );
    }
}
