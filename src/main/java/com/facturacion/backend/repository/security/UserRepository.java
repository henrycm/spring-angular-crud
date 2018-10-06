package com.facturacion.backend.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.backend.model.security.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    public User findByUsername( String username );
}
