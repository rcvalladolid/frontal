/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author rcvalladolid
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    PersonalizacionRoles personalizacionRoles;

    @Autowired
    @Qualifier("autentificacion")
    Autentificacion autentificacion;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(autentificacion);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //.antMatchers("/", "/menu").access("hasAnyRole('DOCENTES_EVA', 'RECTOR_EVA')")
                .antMatchers("/", "/menu").access("hasRole('DOCENTES_EVA')")
                .antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("/seguimiento/**").access("hasRole('DOCENTES_EVA') and hasRole('RECTOR_EVA')")
                .antMatchers("/seguimiento/**").access("hasRole('DOCENTES_EVA')")
                .antMatchers("/autor/**").access("hasRole('DOCENTES_EVA')")
                .antMatchers("/planificacion/**").access("hasRole('DOCENTES_EVA')")
                .and().formLogin().loginPage("/login")
                .failureUrl("/logout")
                .defaultSuccessUrl("/menu", true)
                .successHandler(personalizacionRoles)
                .usernameParameter("username")
                .passwordParameter("password")
                .and().csrf()                                
                .and().exceptionHandling().accessDeniedPage("/403") //acceso denegado
                .and().logout().deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/")
        ;
                

        //http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }

}
