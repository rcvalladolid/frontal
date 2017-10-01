<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<c:url value="/menu" var="inicio"/>


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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Estilo app -->
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/AdminLTE.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/dist/css/skins/_all-skins.min.css" />" type="text/css"/> 
        <link rel="stylesheet" href="<c:url value="/recursos/app/css/eva/eva.css" />" type="text/css"/>
        <!-- Select Docentes -->
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/select2/select2.min.css" />" type="text/css"/>
        <!-- Checkbox Componentes -->
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/bootstrap-multiselect/css/bootstrap-multiselect.css" />" type="text/css"/>
        <!-- DataTables -->           
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/buttons.dataTables.min.css" />" type="text/css"/>

    </head>

    <body oncontextmenu="return false" onkeydown="return true" class="hold-transition skin-blue layout-top-nav" onload="cargaInicial();">        


        <div class="wrapper">

            <header class="main-header">
                <nav class="navbar navbar-static-top">
                    <div class="container">                        
                        <div class="navbar-header">
                            <a href="${inicio}" title="Sistema de Visualización de Indicadores Estratégicos de Docentes" class="navbar-brand active"><font color="orange"><b>S</b></font>VIED</a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>

                        <!--<div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                            <ul class="nav navbar-nav">                                                       
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Información <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#" onclick="window.open('<c:url value="/recursos/app/doc/LT.pdf" />', '_blank', 'fullscreen=yes');
                                                return false;">Modelo de la Labor Tutorial M.A.D</a></li>                                        
                                        <li><a href="#" onclick="window.open('<c:url value="/recursos/app/doc/D_LT.pdf" />', '_blank', 'fullscreen=yes');
                                                return false;">Directrices para el conteo de actividades</a></li>
                                        <li><a href="#" id="openMenu">Información general y calendario de actividades</a></li>
                                    </ul>
                                </li>
                            </ul>                            
                        </div>-->

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
                                                <b>Usuario:</b>
                                                <a href="">${user.usuUsername}@utpl.edu.ec</a>
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

            <div class="content-wrapper">
                <div class="container">
                    <section class="content-header">
                        <!--<h3>
                            Seguimiento Académico:
                            <small>Estado de las actividades del Docente en el EVA.</small>
                        </h3>-->
                        <ol class="breadcrumb">
                            <li><a href="${inicio}"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
                            <li><a href="#">Carga Académica</a></li>                            
                        </ol>
                    </section>
                    <br>
                    <h3 class="text-center text-blue">CARGA Y PERFIL ACADÉMICO DEL PERSONAL DOCENTE DE LA UTPL</h3>
                    <hr>
                    <section class="content" id="contenido">
                        <div class="container">
                            <div class="modal" id="load_query" style="display: none">
                                <div id="load_img" class="center">
                                    <img alt="" src="<c:url value="/recursos/app/img/ajax-loader.gif" />" /><b>Cargarndo...</b>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>* PERIODO ACADÉMICO OFICIAL:</label>
                                        <select class="form-control select2" id="cbmPeriodo" name="cbmPeriodo">       
                                            <option value="290">Abr/2016 - Ago/2016</option>                                            
                                        </select>
                                    </div>
                                </div>                                
                                <!--<div class="col-md-6">
                                <s:authorize access="hasRole('RECTOR_EVA')">
                                    <div class="form-group">
                                        <label>* DOCENTE:</label>
                                        <select class="form-control select2-dropdown" name="cmbDocentes" id="cmbDocentes" data-placeholder="Seleccione el docente que desee...">
                                            <option></option>
                                    <c:forEach items="${listaDocentes}" var="docente">
                                        <option value="${docente[0]}">${docente[1]} - ${docente[2]}</option>
                                    </c:forEach>
                                </select> 
                            </div>
                                </s:authorize>
                            </div>-->
                            </div>                                                       
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                        <li class="active text-bold"><a href="#tab_1" data-toggle="tab"><i class="fa fa-balance-scale" aria-hidden="true"></i> CARGA ACADÉMICA:</a></li>
                                        <li class="text-bold"><a href="#tab_2" data-toggle="tab"><i class="fa fa-user" aria-hidden="true"></i> PERFIL ACADÉMICO:</a></li>                                                                                
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_1">                                                                                                                                                                          
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <!--<div class="box-header with-border">
                                                        <h3 class="box-title">Dedicación Académica</h3>
                                                        <div class="box-tools pull-right">
                                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                            <div class="btn-group">
                                                                <button class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i></button>
                                                                <ul class="dropdown-menu" role="menu">
                                                                    <li><a href="#">Action</a></li>
                                                                    <li><a href="#">Another action</a></li>
                                                                    <li><a href="#">Something else here</a></li>
                                                                    <li class="divider"></li>
                                                                    <li><a href="#">Separated link</a></li>
                                                                </ul>
                                                            </div>
                                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                                        </div>
                                                    </div>-->
                                                    <div class="box-body">
                                                        <div class="row">
                                                            <div class="col-md-8">
                                                                <!--<p class="text-center">
                                                                    <strong>Distribución de la carga académica</strong>
                                                                </p>-->
                                                                <div class="chart">
                                                                    <div id="charTotalHoras"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <p class="text-center">
                                                                    <strong>Distribución de Horas Asignadas</strong>
                                                                </p>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas clase</span>
                                                                    <span class="progress-number"><b id="horas_clase"></b>/<span id="horas_asignadas_clase"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-aqua" id="porcentaje_horas_clase"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas tutoría</span>
                                                                    <span class="progress-number"><b id="horas_tutoria"></b>/<span id="horas_asignadas_tutoria"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-green" id="porcentaje_horas_tutoria"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas preparación</span>
                                                                    <span class="progress-number"><b id="horas_preparacion"></b>/<span id="horas_asignadas_preparacion"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-red" id="porcentaje_horas_preparacion"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas de Investigación</span>
                                                                    <span class="progress-number"><b id="horas_investigacion"></b>/<span id="horas_asignadas_investigacion"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-warning" id="porcentaje_horas_investigacion"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas de Trabajo de Titulación</span>
                                                                    <span class="progress-number"><b id="horas_titulacion"></b>/<span id="horas_asignadas_titulacion"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-primary" id="porcentaje_horas_titulacion"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-group">
                                                                    <span class="progress-text">Horas de Gestión Académica</span>
                                                                    <span class="progress-number"><b id="horas_gestion"></b>/<span id="horas_asignadas_gestion"></span></span>
                                                                    <div class="progress sm">
                                                                        <div class="progress-bar progress-bar-striped" id="porcentaje_horas_gestion"></div>
                                                                    </div>
                                                                </div>
                                                            </div>                                                                                                                            
                                                        </div>
                                                    </div>
                                                    <div class="box-footer">
                                                        <div class="row">
                                                            <div class="col-sm-6 col-xs-6">
                                                                <div class="description-block border-right">
                                                                    <span class="description-percentage text-green"><i class="fa fa-caret-up"></i><span id="porcentaje_horas_docencia"></span>%</span>
                                                                    <h5 class="description-header" id="horas_docencia"></h5>
                                                                    <span class="description-text">TOTAL HORAS DOCENCIA</span>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6 col-xs-6">
                                                                <div class="description-block border-right">
                                                                    <span class="description-percentage text-yellow"><i class="fa fa-caret-left"></i> 100%</span>
                                                                    <h5 class="description-header" id="total_horas_asignadas"></h5>
                                                                    <span class="description-text">TOTAL HORAS ASIGNADAS</span>
                                                                </div>
                                                            </div>                                                                                                                                                                                  
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="tab-pane" id="tab_2">                                            
                                            <div class="box-body">
                                            </div>
                                        </div>                                   
                                    </div>
                                </div>
                            </div>
                        </div>





                    </section>
                </div>

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
        <!-- Eva -->
        <script type="text/javascript" src="<c:url value="/recursos/app/js/carga_academica/carga_perfil.js" />"></script>        
        <!-- Select Docentes -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/select2/select2.full.min.js" />"></script>
        <!-- Checkbox Componentes -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/bootstrap-multiselect/js/bootstrap-multiselect.js" />"></script>
        <!-- DataTables -->
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/jquery.dataTables.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.js" />"></script>        
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/dataTables.buttons.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/jszip.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/pdfmake.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/buttons.html5.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/datatables/buttons.print.min.js" />"></script>
        <!-- HighCharts Gráficas -->
        <!--<script type="text/javascript" src="<c:url value="/recursos/plugins/highcharts/highcharts.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/highcharts/exporting.js" />"></script>-->

        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/highcharts-more.js"></script>
        <!--<script src="https://code.highcharts.com/modules/exporting.js"></script>-->

    </body>
</html>
