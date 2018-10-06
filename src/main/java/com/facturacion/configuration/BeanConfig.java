package com.facturacion.configuration;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.persistence.EntityManager;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
public class BeanConfig
{
    @Value("${queue.email}")
    private String emailQueue;

    @Resource
    EntityManager entityManager;

    @Bean
    public Queue helloJMSQueue()
    {
        return new ActiveMQQueue( emailQueue );
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter()
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType( MessageType.TEXT );
        converter.setTypeIdPropertyName( "_type" );
        return converter;
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory()
    {
        return new JPAQueryFactory( entityManager );
    }

}
