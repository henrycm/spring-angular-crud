package com.facturacion.integration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.facturacion.integration.model.Email;

@Component
public class EmailService
{
    @Value("${queue.email}")
    private String emailQueue;

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendEmail( Email message )
    {
        jmsTemplate.convertAndSend( emailQueue, message );
    }
}
