package com.facturacion.backend.services.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.backend.model.domain.Cliente;
import com.facturacion.backend.repository.ClienteRepository;

@Service
public class ClienteService implements IService<Cliente>
{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente retrieve( Long id )
    {
        return clienteRepository.findOne( id );
    }

    @Override
    public Cliente create( Cliente entity )
    {
        return clienteRepository.save( entity );
    }

    @Override
    public Cliente update( Cliente entity )
    {
        return clienteRepository.save( entity );
    }

    @Override
    public List<Cliente> listAll()
    {
        return clienteRepository.findAll();
    }

    @Override
    public void delete( Long id )
    {
        clienteRepository.delete( id );

    }

}
