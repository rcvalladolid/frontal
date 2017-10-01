/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.controller;

import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import ec.edu.utpl.svied.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 *
 * @author rcvalladolid
 */
@ControllerAdvice
public class ExceptionController {
    
    @Autowired
    LoginService loginService;

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView NoHandlerFoundExceptionError404(HttpServletRequest request, Exception e) {
        
        //TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());       
        
        ModelAndView mav = new ModelAndView("/404");
        mav.addObject("exception", e);
        mav.addObject("errorcode", "404");
        //mav.addObject("usuario", usuario);
        return mav;
    }        
    
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ModelAndView HttpMessageNotWritableExceptionError500(HttpServletRequest request, Exception e) {
        
        //TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());       
        
        ModelAndView mav = new ModelAndView("/500");
        mav.addObject("exception", e);
        mav.addObject("errorcode", "500");
        //mav.addObject("usuario", usuario);
        return mav;
    }
    
    @ExceptionHandler(ConversionNotSupportedException.class)
    public ModelAndView ConversionNotSupportedExceptionError500(HttpServletRequest request, Exception e) {
        
        //TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());       
        
        ModelAndView mav = new ModelAndView("/500");
        mav.addObject("exception", e);
        mav.addObject("errorcode", "500");
        //mav.addObject("usuario", usuario);
        return mav;
    }
    
    /*@ExceptionHandler(NoHandlerFoundException.class)
    public String handleError404(ModelMap model, Exception e) {
 
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        model.addAttribute("usuario", usuario);
 
        return "404";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleException(NoSuchRequestHandlingMethodException ex) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleExceptiond(NoHandlerFoundException ex) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public void handleConflict() {

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    public void handlesdConflict() {
    }

    /*@Autowired
    LoginService loginService;
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @RequestMapping(value = "/404", method = {RequestMethod.GET, RequestMethod.POST})
    public String paginaError404(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        TdsUsuarioUgda usuario = loginService.getUserUsername(getPrincipal());
        model.addAttribute("usuario", usuario);
        return "404";
    }*/
    
    /*Modificado el 05/09/2017*/
    /*private static String getPrincipal() {
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
    }*/
}
