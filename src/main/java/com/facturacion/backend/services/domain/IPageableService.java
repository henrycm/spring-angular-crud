package com.facturacion.backend.services.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPageableService<T>
{
    T retrieve( Long id );

    T create( T entity );

    T update( T entity );

    Page<T> listAll( Pageable request );

    void delete( Long id );
}
