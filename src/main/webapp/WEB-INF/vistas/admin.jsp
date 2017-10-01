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
        <title>SVIED | Lista de usuarios</title>
        <!--Icono de la página-->
        <link href="<c:url value="/recursos/app/img/favicon.ico" />" rel="shortcut icon">
        <!-- Para que el navegador sea sensible al ancho de la pantalla -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css" />" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Estilo app -->
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" type="text/css"/> 
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/skins/_all-skins.min.css" />" type="text/css"/> 
        <link rel="stylesheet" href="<c:url value="/recursos/app/css/admin.css" />" type="text/css"/>        
        <!-- DataTables -->           
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/buttons.dataTables.min.css" />" type="text/css"/>

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
                            <span class="lead">Lista de Usuarios en APLICATIVO DOCENTES:</span>
                        </div>
                        <div class="panel-body">
                            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>IDENTIFICACIÓN</th>
                                        <th>NOMBRES DEL USUARIO</th>
                                        <th>ESTADO ACTIVO</th>
                                        <th>USERNAME</th>
                                        <th>CÓDIGO</th>
                                        <th width="100"></th>
                                        <th width="100"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listaUsuarios}" var="listUser">
                                        <tr>
                                            <td>${listUser.usuIdentificacion}</td>
                                            <td>${listUser.usuNombres}</td>
                                            <td>${listUser.usuActivo}</td>
                                            <td>${listUser.usuUsername}</td>
                                            <td>${listUser.usuCod}</td>
                                            <td><a href="<c:url value='/editar-usuario-${listUser.usuIdentificacion}' />" class="btn btn-success custom-width">Editar</a></td>
                                            <td><a href="<c:url value='/eliminar-usuario-${listUser.usuIdentificacion}' />" class="btn btn-danger custom-width">Eliminar</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="well">
                        <a href="<c:url value='/nuevo-usuario' />">Añadir Nuevo Usuario</a>
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
        <script type="text/javascript" src="<c:url value="/recursos/app/js/admin.js" />"></script>

        <!-- DataTables -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/jquery.dataTables.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.js" />"></script>        
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/dataTables.buttons.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/jszip.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/pdfmake.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/buttons.html5.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/buttons.print.min.js" />"></script>

    </body>
</html>
