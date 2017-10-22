<%-- 
    Document   : login
    Created on : 03/10/2017, 12:42:13 PM
    Author     : rcvalladolid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Aplicativo para indicadores de Docentes">
        <meta name="author" content="Roberto Valladolid">
        <title>LRS | Learning Record Store</title>
        <!--Icono de la página-->
        <link href="<c:url value="/recursos/app/img/favicon.ico" />" rel="shortcut icon">
        <!-- Para que el navegador sea sensible al ancho de la pantalla -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->        
        <link rel="stylesheet" href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css" />" />        
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Estilo app -->
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" />
        <!-- iCheck -->        
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/iCheck/square/blue.css" />" />       
        <!-- Login -->        
        <link rel="stylesheet" href="<c:url value="/recursos/app/css/login/login.css" />" />   

    </head>
    
    <body class="hold-transition">

        <nav class="navbar navbar-header navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://gestiondatos.utpl.edu.ec/" title="UTPL | Learning Record Store">                        
                        <img src="<c:url value="/recursos/app/img/utpl_lrs.png" />" alt="UTPL">
                    </a>
                </div>                
            </div>
        </nav>

        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <br><br>
                    <div class="login-box">
                        <div class="login-logo">           
                            <!--<h3><p class="text-center text-primary text-bold">SVIED</p></h3>-->
                        </div>                        
                    </div>      

                    <br><br>
                    <h3><p class="text-center text-bold">Sistema de Visualización de Experiencias de Aprendizaje de la UTPL</p></h3>
                    <br><br><br><br>

                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>Ingrese a nuestro sitio:</h3>
                                        <p>Introduzca su nombre de usuario y contraseña para iniciar sesión.</p>
                                    </div>
                                    <c:url value="/login" var="loginUrl" />
                                    <div class="form-top-right">
                                        <i class="fa fa-pencil"></i>
                                    </div>
                                </div>
                                <div class="form-bottom">
                                    <form id="form-login" class="form-horizontal" action="${loginUrl}" method="POST" autocomplete="off">
                                        <c:if test="${param.error != null}">
                                            <div class="alert alert-danger">
                                                <p>Su usuario y contraseña no son correctos.</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${param.logout != null}">
                                            <div class="alert alert-success">
                                                <p>Su sesión se ha cerrado correctamente.</p>
                                            </div>
                                        </c:if>
                                        <div class="input-group input-sm">
                                            <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                            <input type="text" class="form-control" id="username" name="username" placeholder="Nombre de usuario sin @utpl.edu.ec" required>
                                        </div>
                                        <div class="input-group input-sm">
                                            <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                            <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                                        </div>
                                        <div class="input-group input-sm">
                                            <div class="checkbox">
                                                <span class="character-checkbox" onclick="showPassword()"></span>
                                                <span class="label">Mostrar contraseña</span>
                                            </div>                                                                        
                                        </div>                                                                                                                            
                                        <div class="form-actions">                                            
                                            <input id="iniciar-sesion" type="submit" class="btn btn-primary btn-block btn-flat" value="Iniciar Sesión">
                                        </div>                                        
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>                                    
                                </div>
                                <div class="form-actions">                                        
                                    <i class="fa fa-bell-o" aria-hidden="true"></i> Si aún no ha ingresado, solicite su acceso a nuestro sitio
                                    <a href="#" class="forget" data-toggle="modal" data-target=".forget-modal">aquí.</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-1 middle-border"></div>                        

                        <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>Indicadores de Experiencia de Aprendizaje:</h3>
                                        <p>Brindamos información en los siguientes indicadores del Eva.</p>
                                    </div>
                                    <br>
                                </div>
                                <div class="form-bottom">
                                    <ul class="list-unstyled" style="line-height: 2">                                        
                                        <li><span class="fa fa-check text-yellow"></span> Anuncios Académicos.</li>
                                        <li><span class="fa fa-check text-yellow"></span> Foros Académicos.</li>                                                                                
                                        <li><span class="fa fa-check text-yellow"></span> Chats Tutoría.</li>                                        
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>                    

                    <div class="modal fade forget-modal" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">
                                        <span aria-hidden="true">×</span>
                                        <span class="sr-only">Cerar</span>
                                    </button>
                                    <h4 class="modal-title">Solicite un rol dentro del aplicativo:</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Envíe un correo electrónico a <a href="#">rcvalladolid@utpl.edu.ec</a> con sus datos personales solicitando el acceso a cualquier indicador del aplicativo</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>                                    
                                </div>
                            </div> 
                        </div>
                    </div>


                </div>
            </div>              
        </div>        

        <!-- jquery-1.11.1.min -->
        <script src="<c:url value="/recursos/plugins/jQuery/jquery-1.11.1.min.js" />"></script>        
        <!-- Bootstrap 3.3.6 -->
        <script src="<c:url value="/recursos/bootstrap/js/bootstrap.min.js" />"></script>        
        <!-- iCheck -->
        <script src="<c:url value="/recursos/plugins/iCheck/icheck.min.js" />"></script>   
        <!-- Login -->
        <script src="<c:url value="/recursos/app/js/login/login.js" />"></script>                     


    </body>
</html>

