package com.facturacion.backend.services.domain;

import java.util.List;

public interface IService<T>
{
    T retrieve( Long id );

    T create( T entity );

    T update( T entity );

    List<T> listAll();

    void delete( Long id );
}
