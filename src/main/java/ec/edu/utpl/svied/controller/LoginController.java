/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.controller;

import ec.edu.utpl.svied.model.TdsFiltrosUgda;
import ec.edu.utpl.svied.model.TdsRegistroAccesosUgda;
import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import ec.edu.utpl.svied.service.EvaService;
import ec.edu.utpl.svied.service.LoginService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author rcvalladolid
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    EvaService evaService;

    //@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String paginaLogin(HttpServletRequest request, HttpServletResponse response) {
        return "login_page";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String paginaMenu(ModelMap model, HttpServletRequest request) {

        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        model.addAttribute("usuario", usuario);
        return "menu";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String paginaAdministracionUsuarios(ModelMap model) {
        List<TdsUsuarioUgda> listaUsuarios = loginService.listaUsuariosUgda();
        model.addAttribute("listaUsuarios", listaUsuarios);
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        model.addAttribute("user", usuario);
        return "admin";
    }

    @RequestMapping(value = {"/seguimiento"}, method = RequestMethod.GET)
    public String paginaEvaDashboard(ModelMap model, HttpServletRequest request) {

        BigDecimal[] peId = {new BigDecimal(307)};
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        List<Object> lista_docentes_eva = evaService.listarDocentesEva(peId);
        String ultima_actualizacion = evaService.ultimaFechaActualizacion();
        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        model.addAttribute("usuario", usuario);
        request.setAttribute("docente", usuario.getUsuCod());
        model.addAttribute("docentes_eva", lista_docentes_eva);
        request.setAttribute("docente_login", usuario.getUsuCod());
        model.addAttribute("ultima_actualizacion", ultima_actualizacion);
        return "seguimiento/eva_semaforos_307";
    }

    @RequestMapping(value = {"/seguimiento/das"}, method = RequestMethod.GET)
    public String paginaEvaSemaforosDetalle(ModelMap model, HttpServletRequest request) {

        BigDecimal[] peId = {new BigDecimal(307)};
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        List<Object> lista_docentes_eva = evaService.listarDocentesEva(peId);
        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        model.addAttribute("usuario", usuario);
        request.setAttribute("docente", usuario.getUsuCod());
        model.addAttribute("docentes_eva", lista_docentes_eva);
        request.setAttribute("docente_login", usuario.getUsuCod());
        return "seguimiento/eva_dashboard";
    }

    @RequestMapping(value = {"/autor"}, method = RequestMethod.GET)
    public String paginaEvaDocenteAutor(ModelMap model, HttpServletRequest request) {

        BigDecimal[] peId = {new BigDecimal(307)};
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        List<Object> lista_docentes_autores_eva = evaService.listarDocentesAutoresEva(peId);

        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        model.addAttribute("usuario", usuario);
        model.addAttribute("docentes_autores_eva", lista_docentes_autores_eva);
        request.setAttribute("docente_login", usuario.getUsuCod());
        return "seguimiento/eva_docente_autor";
    }

    @RequestMapping(value = {"/planificacion"}, method = RequestMethod.GET)
    public String paginaPlanificacionActividadesEva(ModelMap model, HttpServletRequest request) {
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        BigDecimal[] peId = {new BigDecimal(310)};
        List<Object> lista_docentes = evaService.listarDocentesEva(peId);
        model.addAttribute("usuario", usuario);
        model.addAttribute("docentes_eva", lista_docentes);
        request.setAttribute("docente_login", usuario.getUsuCod());

        return "seguimiento/eva_docente_planificacion";

    }

    /*Periodo Oct/2017-Feb/2018*/
    @RequestMapping(value = {"/seguimiento_310"}, method = RequestMethod.GET)
    public String paginaEvaDashboard310(ModelMap model, HttpServletRequest request) {

        BigDecimal[] peId = {new BigDecimal(310)};
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        List<Object> lista_docentes_eva = evaService.listarDocentesEva(peId);
        String ultima_actualizacion = evaService.ultimaFechaActualizacion();
        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        model.addAttribute("usuario", usuario);
        request.setAttribute("docente", usuario.getUsuCod());
        model.addAttribute("docentes_eva", lista_docentes_eva);
        request.setAttribute("docente_login", usuario.getUsuCod());
        model.addAttribute("ultima_actualizacion", ultima_actualizacion);
        return "seguimiento/eva_semaforos_310";
    }

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String paginaDashboardEva(ModelMap model, HttpServletRequest request) {

        BigDecimal[] peId = {new BigDecimal(307)};
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        List<Object> lista_docentes_eva = evaService.listarDocentesEva(peId);
        //String ultima_actualizacion = evaService.ultimaFechaActualizacion();            

        model.addAttribute("usuario", usuario);
        request.setAttribute("docente", usuario.getUsuCod());
        model.addAttribute("docentes_eva", lista_docentes_eva);
        request.setAttribute("docente_login", usuario.getUsuCod());
        //model.addAttribute("ultima_actualizacion", ultima_actualizacion);
        return "dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        BigDecimal usuId = loginService.maximoLogInsertado();

        Date fecha_login = new Date();
        DateFormat formato_login = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha_ingreso = formato_login.format(fecha_login);

        TdsRegistroAccesosUgda registroAccesosUgda = new TdsRegistroAccesosUgda();
        registroAccesosUgda.setRacId(usuId);
        registroAccesosUgda.setUsId(usuario.getUsuId());
        registroAccesosUgda.setRacModulo(request.getServletPath());
        registroAccesosUgda.setRacFechaIngreso(fecha_ingreso);
        registroAccesosUgda.setRacTipoApp("SVIED");
        loginService.insertarRegistros(registroAccesosUgda);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = {"/eliminar-usuario-{identificacion}"}, method = RequestMethod.GET)
    public String eliminarUsuario(@PathVariable String identificacion) {
        loginService.eliminarUsuario(identificacion);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/acceso_denegado", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "403";
    }

    private String getPrincipal() {
        String userName = null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userName;
    }
}
