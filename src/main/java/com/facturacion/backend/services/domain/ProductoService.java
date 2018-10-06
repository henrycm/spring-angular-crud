package com.facturacion.backend.services.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.facturacion.backend.model.domain.Producto;
import com.facturacion.backend.repository.ProductoRepository;

@Service
public class ProductoService implements IPageableService<Producto>
{

    @Autowired
    ProductoRepository repository;

    @Override
    public Producto retrieve( Long id )
    {
        return repository.findOne( id );
    }

    @Override
    public Producto create( Producto entity )
    {
        return repository.save( entity );
    }

    @Override
    public Producto update( Producto entity )
    {
        return repository.save( entity );
    }

    @Override
    public Page<Producto> listAll( Pageable request )
    {
        return repository.findAll( request );
    }

    @Override
    public void delete( Long id )
    {
        repository.delete( id );
    }

}
