package com.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>
{

}
