package com.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.domain.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>
{

}
