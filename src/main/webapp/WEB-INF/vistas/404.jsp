<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/logout" var="logoutUrl"/>
<c:url value="/menu" var="inicio"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SIEC | Acceso</title>
        <!--Icono de la página-->
        <link href="<c:url value="/recursos/app/img/favicon.ico" />" rel="shortcut icon" />
        <!-- Para que el navegador sea sensible al ancho de la pantalla -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css" />" rel="stylesheet"/>
        <!-- Font Awesome -->        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Theme style -->
        <link href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" rel="stylesheet" />        
        <link href="<c:url value="/recursos/dist/css/skins/skin-blue.min.css" />" rel="stylesheet" />

    </head>
    <body oncontextmenu="return false" onkeydown="return true" class="hold-transition skin-blue layout-top-nav">

        <div class="wrapper">          

            <header class="main-header">                                          
                <nav class="navbar navbar-static-top">                    
                    <div class="container">
                        <div class="navbar-header">
                            <a href="#" class="navbar-brand" title="Unidad de Gestión de Datos Académicos"><font color="#FFCC00;"><b>U</b></font>GDA</a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>                        
                    </div>                    
                </nav>
            </header>

            <div class="content-wrapper">                

                <section class="content">
                    <div class="error-page">
                        <h2 class="headline text-yellow"> 404</h2>
                        <div class="error-content">
                            <h3><i class="fa fa-warning text-yellow"></i> HTTP Status 404 - Página no encontrada!!!.</h3>
                            <p>
                                Estimado <strong>${usuario.usuUsername}</strong>, usted no tiene acceso a esta pagina.                                                                
                            </p>     
                            <br>
                            <form class="search-form">
                                <div class="input-group">                                    
                                    Puedes intentar volver al <a href="<c:url value="/menu" />">Menú principal</a>                                                       
                                </div>
                            </form>
                            <p>

                            </p>
                        </div>
                    </div>
                </section>
                

            </div>

            <!-- Se incluye pié de página -->
            <footer class="main-footer">               
                <div class="pull-right hidden-xs">
                    <b>Versión</b> 1.1.0
                </div>
                <strong>Copyright &copy; 2016 <a href="http://gestiondatos.utpl.edu.ec/">UGDA</a>.</strong> Todos los derechos reservados.
            </footer>                  

        </div>

        <!-- REQUIRED JS SCRIPTS -->
        <!-- jQuery 2.1.4 -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/jQuery/jQuery-2.1.4.min.js" />"></script>
        <!-- Bootstrap 3.3.5 -->
        <script type="text/javascript" src="<c:url value="/recursos/bootstrap/js/bootstrap.min.js" />"></script>        
        <!-- AdminLTE App -->
        <script type="text/javascript" src="<c:url value="/recursos/dist/js/app.min.js" />"></script>   

    </body>
</html>
