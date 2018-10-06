package com.facturacion.backend.repository;

import java.util.List;

import com.facturacion.backend.model.domain.Pedido;

public interface PedidoRepositoryCustom
{
    List<Pedido> searchByClient( String nombre );
}
