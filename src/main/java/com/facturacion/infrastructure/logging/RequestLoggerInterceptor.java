package com.facturacion.infrastructure.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class RequestLoggerInterceptor
{
    private final static Logger LOGGER = LoggerFactory.getLogger( RequestLoggerInterceptor.class );
    private final static Logger API_LOGGER = LoggerFactory.getLogger( "API_LOG" );
    private final static ObjectMapper mapper = new ObjectMapper();

    @Around("execution(* com.facturacion.web..*Controller.*(..))")
    public Object tamperWithResponseEntity( ProceedingJoinPoint joinPoint )
        throws Throwable
    {
        Object retVal = joinPoint.proceed();

        try {
            HttpServletRequest request = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes() ).getRequest();
            HttpServletResponse response = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes() ).getResponse();

            API_LOGGER.debug( "=====Start Request=====" );
            API_LOGGER.debug( "URL: {}", request.getRequestURI() );
            API_LOGGER.debug( "Method: " + request.getMethod() );
            API_LOGGER.debug( "Request body: " + getRequestBody( joinPoint ) );
            API_LOGGER.debug( "Response status: {}", response.getStatus() );
            API_LOGGER.debug( "Response: {}", mapper.writeValueAsString( retVal ) );
            API_LOGGER.debug( "=====End Request=====" );
        } catch ( Exception ex ) {
            LOGGER.warn( ex.getMessage() );
        }

        return retVal;
    }

    private String getRequestBody( ProceedingJoinPoint joinPoint )
    {
        String result = "";
        for ( Object par : joinPoint.getArgs() ) {
            if ( ! ( par instanceof Long ) ) {
                try {
                    result = mapper.writeValueAsString( par );
                } catch ( JsonProcessingException e ) {

                }

                break;
            }
        }

        return result;
    }
}