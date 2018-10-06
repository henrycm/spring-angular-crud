package com.facturacion.integration.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.facturacion.integration.model.Email;

@Component
public class EmailListener
{
    private final static Logger LOGGER = LoggerFactory.getLogger( EmailListener.class );

    @JmsListener(destination = "mailbox")
    public void receiveMessage( Email email )
    {
        LOGGER.info( "Received <" + email.getFrom() + ">" );
    }
}
