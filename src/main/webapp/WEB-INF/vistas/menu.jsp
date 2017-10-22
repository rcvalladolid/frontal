<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<c:url value="/menu" var="inicio"/>
<c:url value="/seguimiento" var="eva_307"/>
<c:url value="/seguimiento_310" var="eva_310"/>
<c:url value="/autor" var="autor"/>
<c:url value="/planificacion" var="planificacion"/>
<c:url value="/dashboard" var="dashboard"/>


<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Aplicativo para indicadores de Docentes">
        <meta name="author" content="Roberto Valladolid">
        <title>SVIED | Sistema de Visualización de Indicadores Estratégicos de Docentes</title>
        <!--Icono de la página-->
        <link href="<c:url value="/recursos/app/img/favicon.ico" />" rel="shortcut icon">
        <!-- Para que el navegador sea sensible al ancho de la pantalla -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css" />" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Estilo app -->
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/skins/_all-skins.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/app/css/eva/eva.css" />" type="text/css"/>                    

    </head>

    <body oncontextmenu="return false" onkeydown="return true" class="hold-transition skin-blue layout-top-nav">        

        <header class="main-header">
            <nav class="navbar navbar-static-top">
                <div class="container">
                    <div class="navbar-header">
                        <!--<a href="${inicio}" title="Sistema de Visualización de Indicadores Estratégicos de Docentes" class="navbar-brand active"><font color="orange"><b>S</b></font>VIED</a>-->
                        <a class="navbar-brand" href="https://gestiondatos.utpl.edu.ec/" ><font color="orange">UGDA</font></a>
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>                    
                    <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                        <ul class="nav navbar-nav">      
                            <li class="active"><a href="${inicio}">Inicio</a></li>                            
                        </ul>                            
                    </div>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">                               
                            <li class="dropdown user user-menu">                                    
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span class="hidden-xs">${usuario.usuNombres}</span>
                                </a>
                                <ul class="dropdown-menu">                                                                                                                        
                                    <li class="user-body">
                                        <p>
                                            <b>Usuario:</b>
                                            <a href="">${usuario.usuUsername}@utpl.edu.ec</a>
                                        </p>                                        
                                        <a href="<c:url value="/logout" />" class="btn btn-default btn-vimeo">Cerrar Sesión</a>
                                    </li>                                        
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container-fluid">

            <div class="container text-center">
                <h2>Indicadores del Docente</h2>
                <br>
                <s:authorize access="hasRole('DOCENTES_EVA')">
                    <p class="text-bold">Periodo: Abr/2017-Ago/2017</p>
                    <div class="btn-group btn-group-vertical">
                        <a href="${autor}" class="btn btn-default btn-social btn-default text-blue">
                            <i class="fa fa-bar-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del Docente Autor en el E.V.A. - M.A.D Grado
                        </a>                    
                        <a href="${eva_307}" class="btn btn-block btn-social btn-default text-blue">
                            <i class="fa fa-line-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del Docente en el E.V.A. - M.A.D Grado
                        </a>                                            
                    </div>  
                </s:authorize>
            </div>
            <br>
            <div class="container text-center">
                <s:authorize access="hasRole('RECTOR_EVA')">
                    <p class="text-bold">Periodo: Oct/2017-Feb/2018</p>
                    <div class="btn-group btn-group-vertical">
                        <a href="${planificacion}" class="btn btn-block btn-social btn-default text-green">
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> Actividades planificadas por el Docente en el E.V.A. - M.A.D Grado   
                        </a>
                        <!--<a href="${autor_310}" class="btn btn-block btn-social btn-default text-green">
                            <i class="fa fa-bar-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del Docente Autor en el E.V.A. - M.A.D Grado
                        </a>-->                    
                        <a href="${eva_310}" class="btn btn-block btn-social btn-default text-green">
                            <i class="fa fa-line-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del Docente en el E.V.A. - M.A.D Grado&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                        <a href="${dashboard}" class="btn btn-block btn-social btn-default text-info">
                            <i class="fa fa-line-chart" aria-hidden="true"></i> unir&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </div>
                </s:authorize>
            </div>

            <!--<div class="row">
                <div class="col-md-12 text-center">
                    <div class="text-center">
                        <br />
                        <h2>Indicadores del Docente</h2>                                
                        <br />
                    </div>

                    <div class="text-center">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
            <s:authorize access="hasRole('DOCENTES_EVA')">
                <a class="btn btn-block btn-social btn-default" onclick="location.href = '${eva}';">
                    <i class="fa fa-line-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del docente en el E.V.A. Distancia
                </a>
                <a class="btn btn-block btn-social btn-default" onclick="location.href = '${autor}';">
                    <i class="fa fa-bar-chart" aria-hidden="true"></i> Seguimiento académico a las actividades del Docente Autor
                </a> 
            </s:authorize>
            <s:authorize access="hasRole('RECTOR_EVA')">
                <a class="btn btn-block btn-social btn-warning" onclick="location.href = '${planificacion}';">
                    <i class="fa fa-address-book-o" aria-hidden="true"></i> Planificación de Actividades en el EVA
                </a>
            </s:authorize>
        </div>    

        <div class="col-md-3"></div>
    </div>


</div>
</div>-->
        </div>



        <!-- jQuery 2.1.4 -->        
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>        
        <!-- Bootstrap 3.3.7 -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>                                             


    </body>
</html>
