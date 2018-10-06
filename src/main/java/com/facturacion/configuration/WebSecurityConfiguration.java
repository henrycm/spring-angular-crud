package com.facturacion.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.facturacion.infrastructure.security.AuthenticationTokenFilter;
import com.facturacion.infrastructure.security.EntryPointUnauthorizedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Value("${app.route.authentication}")
    private String authApiRoute;

    @Autowired
    private EntryPointUnauthorizedHandler unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication( AuthenticationManagerBuilder authenticationManagerBuilder ) throws Exception
    {
        authenticationManagerBuilder
            .userDetailsService( this.userDetailsService );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception
    {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager( authenticationManagerBean() );
        return authenticationTokenFilter;
    }

    @Override
    protected void configure( HttpSecurity httpSecurity ) throws Exception
    {
        httpSecurity
            .csrf()
            .disable()
            .exceptionHandling()
            .authenticationEntryPoint( this.unauthorizedHandler )
            .and()
            .sessionManagement()
            .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
            .and()
            .authorizeRequests()
            .antMatchers( HttpMethod.OPTIONS, "/**" ).permitAll()
            .antMatchers( authApiRoute ).permitAll()
            .antMatchers( "/*" ).permitAll()
            // .antMatchers( "/**" ).permitAll();
            .anyRequest().authenticated();

        // Custom JWT based authentication
        httpSecurity
            .addFilterBefore( authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class );
    }

}
