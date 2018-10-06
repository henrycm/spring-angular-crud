package com.facturacion.web.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.backend.model.domain.Producto;
import com.facturacion.backend.services.domain.ProductoService;

@RestController
@RequestMapping("${app.route.api}/productos")
public class ProductoController
{
    @Autowired
    ProductoService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Producto> list( Pageable request )
    {
        return service.listAll( request );
    }

    @RequestMapping(method = RequestMethod.POST)
    public Producto save( @RequestBody Producto producto )
    {
        return service.create( producto );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove( @PathVariable Long id )
    {
        service.delete( id );
    }
}
