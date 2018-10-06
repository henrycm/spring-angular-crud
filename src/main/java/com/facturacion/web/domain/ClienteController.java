package com.facturacion.web.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.backend.model.domain.Cliente;
import com.facturacion.backend.services.domain.ClienteService;

@RestController
@RequestMapping("${app.route.api}/clientes")
public class ClienteController
{
    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> list()
    {
        return clienteService.listAll();
    }
}
