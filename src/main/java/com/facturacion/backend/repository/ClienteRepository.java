package com.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{

}
