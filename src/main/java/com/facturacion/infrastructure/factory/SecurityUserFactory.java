package com.facturacion.infrastructure.factory;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;

import com.facturacion.backend.model.security.Role;
import com.facturacion.backend.model.security.User;
import com.facturacion.infrastructure.security.SecurityUser;

public class SecurityUserFactory
{

    public static SecurityUser create( User user )
    {
        List<String> roleNames = new LinkedList<>();

        for ( Role role : user.getRoles() ) {
            roleNames.add( role.getName() );
        }
        return new SecurityUser(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getEmail(),
            AuthorityUtils.commaSeparatedStringToAuthorityList( String.join( ",", roleNames ) ) );
    }

}
