/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.security;

import ec.edu.utpl.svied.model.TdsRolUsuarioUgda;
import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import ec.edu.utpl.svied.service.LoginService;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.LdapReferralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author rcvalladolid
 */
@Service("autentificacion")
public class Autentificacion implements AuthenticationProvider {

    @Autowired
    private LoginService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName().trim();
        String password = (String) authentication.getCredentials();

        TdsUsuarioUgda usuario = userService.getUserUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = null;

        boolean ldap = false;

        try {

            if (usuario == null || !usuario.getUsuUsername().equalsIgnoreCase(username)) {

                throw new BadCredentialsException("Usuario no encontrado.");

            } else {

                ldap = autentificacionLdap(username, password);

                //Autentificacion LDAP
                /*if (ldap == true) {
                    authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsuUsername(), password, obtenerRolUsuario(usuario));
                } else {
                    throw new BadCredentialsException("Contraseña no encontrada");
                }*/
                authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsuUsername(), usuario.getUsuPassword(), obtenerRolUsuario(usuario));

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NamingException en) {
            en.printStackTrace();
        }

        return authenticationToken;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private List<GrantedAuthority> obtenerRolUsuario(TdsUsuarioUgda usuario) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (TdsRolUsuarioUgda rolUsuarioUgda : usuario.getTdsRolUsuarioUgdas()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rolUsuarioUgda.getTdsRol().getRoCodigo()));
        }

        return authorities;
    }

    private boolean autentificacionLdap(String username, String password) throws NamingException {

        String url = "ldap://utpl.edu.ec";  //"ldap://172.16.50.247:389";          

        try {

            Hashtable env = new Hashtable();

            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "utpl\\" + username);
            env.put(Context.SECURITY_CREDENTIALS, password);

            // Create initial context
            DirContext ctx = new InitialDirContext(env);
            ctx.close();

        } catch (AuthenticationNotSupportedException ex) {
            //System.exit(1);
            return false;
        } catch (AuthenticationException | NamingException ex) {
            //System.exit(1);
            return false;
        }

        return true;

    }

}
