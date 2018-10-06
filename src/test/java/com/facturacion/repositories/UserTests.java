package com.facturacion.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.facturacion.backend.repository.security.UserRepository;
import com.facturacion.web.BaseTest;

public class UserTests extends BaseTest
{
    @Autowired
    UserRepository repository;

    @Test
    public void testListUsers() throws Exception
    {
        assertEquals( 2, repository.findAll().size() );
    }
}
