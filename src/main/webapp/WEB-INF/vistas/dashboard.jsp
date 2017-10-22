<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<c:url value="/menu" var="inicio"/>
<c:url value="/autor" var="docente_autor"/>


<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Aplicativo para indicadores de Docentes">
        <meta name="author" content="Roberto Valladolid">
        <title>UTPL | Universidad Técnica Particular de Loja</title>
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
        <!-- Checkbox Componentes -->
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/bootstrap-multiselect/css/bootstrap-multiselect.css" />" type="text/css"/>
        <!-- DataTables -->           
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.css" />" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/recursos/plugins/datatables/buttons.dataTables.min.css" />" type="text/css"/>        

    </head>

    <body class="hold-transition skin-blue layout-top-nav" onload="cargaInicial()">        

        <header class="main-header">
            <nav class="navbar navbar-static-top">
                <div class="container">
                    <div class="navbar-header">
                        <a href="${inicio}" title="Universidad Técnica Particular de Loja" class="navbar-brand active"><i class="fa fa-home" aria-hidden="true"></i> <font color="orange"><b>UTPL</b></font></a>
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                        <ul class="nav navbar-nav">                                                       
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Información <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>                                                                                
                                        <a href="<c:url value="/recursos/app/doc/LT.pdf" />" target="_blank">
                                            <i class="fa fa-file-pdf-o"></i>Modelo de Labor Tutorial M.A.D de Grado
                                        </a>
                                    </li>                                                                      
                                    <li>
                                        <a href="#" id="openMenu">
                                            <i class="fa fa-calendar-times-o"></i>Información general y calendario de actividades
                                        </a>                                        
                                    </li>                                    
                                </ul>
                            </li>
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


        <div class="modal" id="loading_query" style="display: none">
            <div id="loading_img" class="center">
                <img alt="" src="<c:url value="/recursos/app/img/ajax-loader.gif" />" /><b>Cargando...</b>
            </div>
        </div>
          
        <input type="hidden" value="${docente}" id='hv_docente_login' class='hv_docente_login'>
        <input type="hidden" value="" id="hv_semana_actual">

        <div id="modalInfo" class="modal fade"  role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <span class="modal-title"><i class="fa fa-bell-o"></i>&nbsp;Aviso:</span>
                    </div>
                    <div class="modal-body">
                        <h4 class="text-red" id="msn_aviso"></h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="modalMAD" class="modal fade" role="dialog">                                
            <div class="modal-dialog modal-lg">                            
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><i class="fa fa-hand-o-right"></i>&nbsp;<b>Información General y Calendario de Actividades:</b></h4>
                    </div>
                    <div class="modal-body">
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab_1-1" data-toggle="tab">Información General</a></li>
                                <li><a href="#tab_2-2" data-toggle="tab">Calendario Primer Bimestre</a></li>
                                <li><a href="#tab_3-2" data-toggle="tab">Calendario Segundo Bimestre</a></li> 
                            </ul>
                            <div class="tab-content text-sm">                                            
                                <div class="tab-pane active" id="tab_1-1">
                                    <h5>Definición de colores (semáforos) utilizados para la medición de las actividades del Modelo de Labor Tutorial:</h5>
                                    <table border="1" class="table-condensed" id="info_general">
                                        <thead>
                                            <tr>
                                                <th>SEMÁFOROS</th>
                                                <th>DESCRIPCIÓN</th> 
                                                <th>PUNTUACIÓN</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="background-color: green">CUMPLIMIENTO</td>
                                                <td>CUMPLIMIENTO: Ha realizado la actividad en la semana y fecha establecidas. Además ha interactuado con los estudiantes en la actividad.</td>                                                                        
                                                <td>100%</td>
                                            </tr>                                            
                                            <tr>
                                                <td style="background-color: red">NO CUMPLIMIENTO</td>
                                                <td>NO CUMPLIMIENTO: Se da por dos razones:
                                                    <span>1.- No ha realizado la actividad.</span>
                                                    <span>2.- Ha realizado la actividad pero no ha interactuado con los estudiantes en la actividad.</span>                                                                            
                                                </td>  
                                                <td>0%</td>
                                            </tr>
                                            <tr>
                                                <td style="background-color: gray">SIN ACTIVIDAD OBLIGATORIA</td>
                                                <td>SIN ACTIVIDAD: No es obligatorio realizar la actividad.</td> 
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>                                                                                                
                                    <div class="box-body">                                                            
                                        <div class="alert alert-info">
                                            <strong>FRECUENCIA DE ACTUALIZACIÓN DE DATOS:</strong> El estado de cada una de las actividades de Labor Tutorial de la M.A.D. Pregrado, se actualizarán 24 horas luego de haber sido publicadas en el Eva.
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab_2-2">       
                                    <table border="1" width="100%" class="table-condensed" id="tabla_calendario_1b">
                                        <tr>
                                            <th class="text-center">Frecuencia</th>
                                            <th class="text-center">Anuncios Académicos</th>
                                            <th class="text-center">Foros Académicos</th>
                                            <th class="text-center">Chats Permanentes</th>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 1</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 2</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 3</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 4</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 5</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                              
                                        </tr>
                                        <tr>
                                            <td>Semana 6</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 7</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 8</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Bimestre 2</td>
                                            <td class="text-center"><span class="badge bg-green">8</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">7</span></td>                                           
                                        </tr>
                                    </table>
                                    <p><span class="badge bg-green">#</span> Actividades obligatorias según el Modelo de Labor Tutorial.</p>                                    
                                </div>
                                <div class="tab-pane" id="tab_3-2">
                                    <table border="1" width="100%" class="table-condensed" id="tabla_calendario_2b">
                                        <tr>
                                            <th class="text-center">Frecuencia</th>
                                            <th class="text-center">Anuncios Académicos</th>
                                            <th class="text-center">Foros Académicos</th>
                                            <th class="text-center">Chats Permanentes</th>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 9</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 10</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 11</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 12</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 13</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                              
                                        </tr>
                                        <tr>
                                            <td>Semana 14</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 15</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Semana 16</td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td></td>
                                            <td class="text-center"></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Bimestre 2</td>
                                            <td class="text-center"><span class="badge bg-green">8</span></td>
                                            <td class="text-center"><span class="badge bg-green">1</span></td>
                                            <td class="text-center"><span class="badge bg-green">7</span></td>                                           
                                        </tr>
                                    </table>
                                    <p><span class="badge bg-green">#</span> Actividades obligatorias según el Modelo de Labor Tutorial.</p>
                                </div>
                            </div>
                        </div>                                    
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid"> 

            <div class="box box-solid box-default">                                
                <div class="box-body">
                    <div class="col-md-2">
                        <div role="form">                                            
                            <div class="form-group">
                                <label for="combo_periodo">(*) Periodo Académico</label>
                                <select id="combo_periodo" name="combo_periodo">                                                       
                                    <option value="304">Oct/2016 - Feb/2017</option>
                                    <option value="307" selected="true">Abr/2017 - Ago/2017</option>
                                </select>
                            </div>                                                                                                                                   
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div role="form">                            
                            <s:authorize access="hasRole('RECTOR_EVA')">                                                                                                                               
                                <div class="form-group">
                                    <label for="combo_docentes">(*) Listado de Docentes</label>
                                    <select name="combo_docentes" id="combo_docentes">    
                                        <c:forEach items="${docentes_eva}" var="do_eva">
                                            <option value="${do_eva[0]}" ${do_eva[0] == docente_login ? 'selected="selected"' : ''}>${do_eva[2]}</option>
                                        </c:forEach>
                                    </select>                                                                                                                                     
                                </div>                                                                                            
                            </s:authorize>                                                                                                                                                     
                        </div>
                    </div>      
                    <div class="col-md-4">
                        <div role="form">                            
                            <div class="form-group">
                                <label for="combo_componentes">(*) Componente(s) Educativo(s)</label>
                                <select id="combo_componentes" multiple="multiple">                                                    
                                </select>
                            </div>                             
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-warning">
                        <div class="box-header with-border">
                            <h3 class="box-title"><strong>Indicador de Anuncios Académicos</strong></h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>                                
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">                            
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>a) Total de anuncios por bimestre</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_anuncios_bimestres" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>b) Total de anuncios por periodo</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_anuncios_periodo_real" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>c) Porcentaje de anuncios por periodo</strong>
                                    </p>  
                                    <div class="chart">                                                                                
                                        <div id="char_anuncios_periodo" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>                                
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="text-center">
                                        <strong>d) Total de anuncios por semanas académicas</strong>
                                    </p>
                                    <div id="anuncios_semanales" style="height: 300px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <div class="row">                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-warning">
                        <div class="box-header with-border">
                            <h3 class="box-title"><strong>Indicador de Foros Académicos</strong></h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>                                
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">                            
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>a) Total de foros por bimestre</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_foros_bimestres" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>b) Total de foros por periodo</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_foros_periodo_real" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>c) Porcentaje de foros por periodo</strong>
                                    </p>  
                                    <div class="chart">                                                                                
                                        <div id="char_foros_periodo" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>                                
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="text-center">
                                        <strong>d) Total de foros por semanas académicas</strong>
                                    </p>
                                    <div id="foros_semanales" style="height: 300px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <div class="row">                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-warning">
                        <div class="box-header with-border">
                            <h3 class="box-title"><strong>Indicador de Chats Tutorías o Permanentes</strong></h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>                                
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">                            
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>a) Total de chats por bimestre</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_chats_bimestres" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>b) Total de chats por periodo</strong>
                                    </p>
                                    <div class="chart">                                                                                
                                        <div id="char_chats_periodo_real" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>c) Porcentaje de chats por periodo</strong>
                                    </p>  
                                    <div class="chart">                                                                                
                                        <div id="char_chats_periodo" style="height: 300px; margin: 0 auto"></div>
                                    </div>
                                </div>                                
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="text-center">
                                        <strong>d) Total de chats por semanas académicas</strong>
                                    </p>
                                    <div id="chats_semanales" style="height: 300px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <div class="row">                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>



        <!-- jQuery 2.1.4 -->        
        <script src="<c:url value="/recursos/plugins/jQuery/jquery-3.1.1.min.js" />"></script>        
        <!-- Bootstrap 3.3.5 -->
        <script src="<c:url value="/recursos/bootstrap/js/bootstrap.min.js" />"></script>        
        <!-- Eva -->
        <script src="<c:url value="/recursos/app/js/login/eva_dashboard.js" />"></script>
        <!-- Checkbox Componentes -->
        <script src="<c:url value="/recursos/plugins/bootstrap-multiselect/js/bootstrap-multiselect.js" />"></script>


        <!-- DataTables -->
        <!--<script src="<c:url value="/recursos/plugins/datatables/jquery.dataTables.min.js" />"></script>
        <script src="<c:url value="/recursos/plugins/datatables/dataTables.bootstrap.min.js" />"></script>        
        <script src="<c:url value="/recursos/plugins/datatables/dataTables.buttons.min.js" />"></script>
        <script src="<c:url value="/recursos/plugins/datatables/jszip.min.js" />"></script>
        <script src="<c:url value="/recursos/plugins/datatables/pdfmake.min.js" />"></script>
        <script src="<c:url value="/recursos/plugins/datatables/buttons.html5.min.js" />"></script>
        <script src="<c:url value="/recursos/plugins/datatables/buttons.print.min.js" />"></script>-->
        <!-- HighCharts Gráficas -->
        <!--<script type="text/javascript" src="<c:url value="/recursos/plugins/highcharts/highcharts.js" />"></script>
        <script type="text/javascript" src="<c:url value="/recursos/plugins/highcharts/exporting.js" />"></script>-->

        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>


    </body>
</html>
