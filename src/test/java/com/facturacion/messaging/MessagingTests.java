package com.facturacion.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.facturacion.integration.model.Email;
import com.facturacion.integration.services.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class MessagingTests
{
    @Autowired
    EmailService emailService;

    @Test
    public void testSendEmail() throws Exception
    {
        Email message = new Email();
        message.setFrom( "test@gmail.com" );
        emailService.sendEmail( message );

        Thread.sleep( 1_000 );
    }
}
