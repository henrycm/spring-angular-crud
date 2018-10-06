package com.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.domain.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>
{

}
