<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Aplicativo para indicadores del EVA">
        <meta name="author" content="Roberto Valladolid">
        <title>SVIED | Registro de Usuarios</title>
        <!--Icono de la página-->
        <link href="<c:url value="/recursos/app/img/favicon.ico" />" rel="shortcut icon">
        <!-- Para que el navegador sea sensible al ancho de la pantalla -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css" />" type="text/css"/>        
        <!-- Estilo app -->
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" type="text/css"/> 
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/skins/_all-skins.min.css" />" type="text/css"/> 
        <link rel="stylesheet" href="<c:url value="/recursos/app/css/admin.css" />" type="text/css"/>   
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">

    </head>

    <body class="hold-transition skin-blue layout-top-nav">

        <div class="wrapper">

            <header class="main-header">        

                <nav class="navbar navbar-static-top" role="navigation">      

                    <div class="container">
                        <div class="navbar-header">
                            <a href="${inicio}" title="Unidad de Gestión de Datos Académicos" class="navbar-brand active"><font color="orange"><b>U</b></font>GDA</a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>

                        <div class="navbar-custom-menu">
                            <ul class="nav navbar-nav">                                                                                                                        
                                <li class="dropdown user user-menu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">                                    
                                        <i class="fa fa-user" aria-hidden="true"></i>
                                        <span class="hidden-xs">${user.usuNombres}</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="user-body">  
                                            <p>
                                                <b>Administrador:</b>
                                                <a href="">${user.usuUsername}@utpl.edu.ec</a>
                                            </p>                                        
                                            <a href="<c:url value="/logout" />" class="btn btn-default btn-flat"><i class="fa fa-sign-out" aria-hidden="true"></i>Cerrar Sesión</a>
                                        </li>
                                    </ul>
                                </li>                               
                            </ul>                              
                        </div>
                    </div>

                </nav>
            </header>

            <div class="content-wrapper">
                <section class="content">                    

                    <div class="panel panel-default">                
                        <div class="panel-heading">
                            <span class="lead">Registro de Usuarios en APLICATIVO DOCENTES:</span>
                        </div>
                        <form class="form-horizontal">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="identificacion" class="col-sm-2 control-label">DOCENTE:</label>
                                    <div class="col-sm-10">                                    
                                        <select data-live-search="true" class="selectpicker show-menu-arrow" name="cmbDocentes" id="cmbDocentes">                                            
                                            <c:forEach items="${listaDocentes}" var="docente">
                                                <option value="${docente[0]}">${docente[1]} - ${docente[2]}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label for="identificacion" class="col-sm-2 control-label">Identificación:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="identificacion" placeholder="Ingrese su identificación">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nombres" class="col-sm-2 control-label">Nombres:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nombres" placeholder="Ingrese sus nombres completos">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="fecha" class="col-sm-2 control-label">Fecha inicio:</label>
                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="fecha" placeholder="Ingrese la fecha de registro">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="activo" class="col-sm-2 control-label">Usuario activo:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="activo" value="S" disabled="true">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="correo" class="col-sm-2 control-label">Usuario de correo:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="correo" placeholder="Ingrese su usuario de correo utpl">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="codigo" class="col-sm-2 control-label">Código de usuario:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="codigo" disabled="true">
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <button type="submit" class="btn btn-default">Cancelar Registro</button>
                                <button type="submit" class="btn btn-info pull-right">Registrar Nuevo Usuario</button>
                            </div>
                        </form>
                    </div>                    
                </section>
            </div>

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Versión</b> 1.0
                </div>
                <strong>Copyright &copy; 2016 <a href="http://gestiondatos.utpl.edu.ec">UGDA</a>.</strong> Todos los derechos reservados.
            </footer>

        </div>

        <!-- jQuery 2.1.4 -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/jQuery/jQuery-2.1.4.min.js" />"></script>
        <!-- Bootstrap 3.3.5 -->
        <script type="text/javascript" src="<c:url value="/recursos/bootstrap/js/bootstrap.min.js" />"></script>        
        <!-- AdminLTE App -->
        <script type="text/javascript" src="<c:url value="/recursos/dist/js/app.min.js" />"></script>
        <!--Jquery app -->
        <script type="text/javascript" src="<c:url value="/recursos/app/js/admin/admin.js" />"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>

    </body>
</html>
