package com.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, PedidoRepositoryCustom
{

}
