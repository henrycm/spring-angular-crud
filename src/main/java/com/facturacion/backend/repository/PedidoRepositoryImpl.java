package com.facturacion.backend.repository;

import java.util.List;

import javax.annotation.Resource;

import com.facturacion.backend.model.domain.Pedido;
import com.facturacion.backend.model.domain.QPedido;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class PedidoRepositoryImpl implements PedidoRepositoryCustom
{
    @Resource
    JPAQueryFactory factory;

    @Override
    public List<Pedido> searchByClient( String nombre )
    {
        return factory.selectFrom( QPedido.pedido ).where( QPedido.pedido.cliente.nombre.like( nombre ) ).fetch();
    }
}
