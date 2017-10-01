/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author rcvalladolid
 */
@Component
public class PersonalizacionRoles extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determinarUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("No se puede redireccionar");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /*
     * Determina el rol del usaurio al ingresar y redirige a la URL correspondiente
     */
    protected String determinarUrl(Authentication authentication) {

        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());

        }

        if (isAdmin(roles)) {
            url = "/admin";
        } else if (isUser(roles)) {
            url = "/menu"; //home
        } else {
            url = "/acceso_denegado";
        }

        return url;
    }

    /*private boolean isAdminEva(List<String> roles) {
     if (roles.contains("ROLE_EVA_RECTOR")) {
     return true;
     }
     return false;
     }*/
    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_DOCENTES_EVA")) {
            return true;
        }
        return false;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
