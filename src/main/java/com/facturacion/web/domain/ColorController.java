package com.facturacion.web.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.backend.model.domain.Color;
import com.facturacion.backend.repository.ColorRepository;

@RestController
@RequestMapping("${app.route.api}/colores")
public class ColorController
{
    @Autowired
    ColorRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Color> list( Pageable request )
    {
        return repository.findAll( request );
    }

    @RequestMapping(method = RequestMethod.POST)
    public Color create( @RequestBody Color color )
    {
        return repository.save( color );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove( @PathVariable Integer id )
    {
        repository.delete( id );
    }
}
