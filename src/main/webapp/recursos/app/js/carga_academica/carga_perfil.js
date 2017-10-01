function getContextPath() {
    return window.location.protocol + '//' + window.location.host + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function cargaInicial() {

    $('#charHorasDocencia').highcharts({
        chart: {type: 'pie'},
        title: {text: 'Distribución de horas de docencia'},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f} h</b>'},
        plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.1f}%'}}},
        series: [{
                name: 'Total',
                colorByPoint: true,
                data: [
                    {name: 'Clases', y: 37.5, color: Highcharts.getOptions().colors[0]},
                    {name: 'Tutorías', y: 12.5, color: Highcharts.getOptions().colors[2]},
                    {name: 'Preparación', y: 50, color: Highcharts.getOptions().colors[5]}
                ]
            }]
    });

    $('#charHorasAsignadas').highcharts({
        chart: {type: 'pie'},
        title: {text: 'Distribución de horas asignadas'},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f} h</b>'},
        plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.1f}%'}}},
        series: [{
                name: 'Total',
                colorByPoint: true,
                data: [
                    {name: 'Invest.', y: 10, color: Highcharts.getOptions().colors[3]},
                    {name: 'Trab. Tit.', y: 30, color: Highcharts.getOptions().colors[6]},
                    {name: 'Gest. Acad.', y: 60, color: Highcharts.getOptions().colors[9]}
                ]
            }]
    });


    cargaAcademicaGlobal(290, 278068);

}

function cargaAcademicaGlobal(peId, doId) {

    $.ajax({type: "GET",
        url: "" + getContextPath() + "/getCargaAcademicaGlobal/" + peId + "/" + doId + " ",
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function () {
            $("#load_query").show();
        },
        success: function (data) {
            var jsonData = eval('(' + JSON.stringify(data) + ')');

            var horas_case = 0;
            var porcentaje_horas_clase = 0;            
            var horas_tutoria = 0;            
            var porcentaje_horas_tutoria = 0;            
            var horas_preparacion = 0;
            var porcentaje_horas_preparacion = 0;            
            var horas_docencia = 0;
            var porcentaje_horas_docencia = 0;
            var horas_investigacion = 0;
            var porcentaje_horas_investigacion = 0;            
            var horas_titulacion = 0;
            var porcentaje_horas_titulacion = 0;
            var horas_gestion = 0;
            var porcentaje_horas_gestion = 0;
            
            var horas_asignadas = 0;
            
            $("#horas_clase").empty();            
            $("#porcentaje_horas_clase").empty();
            $("#horas_tutoria").empty();            
            $("#porcentaje_horas_tutoria").empty();
            $("#horas_preparacion").empty();            
            $("#porcentaje_horas_preparacion").empty();
            $("#horas_docencia").empty();            
            $("#porcentaje_horas_docencia").empty();
            $("#horas_investigacion").empty();            
            $("#porcentaje_horas_investigacion").empty();
            $("#horas_titulacion").empty();            
            $("#porcentaje_horas_titulacion").empty();
            $("#horas_gestion").empty();            
            $("#porcentaje_horas_gestion").empty();
            
            $("#total_horas_asignadas").empty();
            $("#horas_asignadas_clase").empty();
            $("#horas_asignadas_tutoria").empty();
            $("#horas_asignadas_preparacion").empty();
            $("#horas_asignadas_investigacion").empty();
            $("#horas_asignadas_titulacion").empty();
            $("#horas_asignadas_gestion").empty();

            for (var i = 0; i < jsonData.length; i++) {
                horas_asignadas = jsonData[i][19];
                
                horas_case = jsonData[i][12];                
                porcentaje_horas_clase = ((horas_case / horas_asignadas)*100);
                
                horas_tutoria = jsonData[i][13];                
                porcentaje_horas_tutoria = ((horas_tutoria / horas_asignadas)*100);
                
                horas_preparacion = jsonData[i][14];                
                porcentaje_horas_preparacion = ((horas_preparacion / horas_asignadas)*100);
                
                horas_docencia = jsonData[i][15];                
                porcentaje_horas_docencia = ((horas_docencia / horas_asignadas)*100);                                
                
                horas_investigacion = jsonData[i][16];                
                porcentaje_horas_investigacion = ((horas_investigacion / horas_asignadas)*100);
                
                horas_titulacion = jsonData[i][17];                
                porcentaje_horas_titulacion = ((horas_titulacion / horas_asignadas)*100);
                
                horas_gestion = jsonData[i][18];                
                porcentaje_horas_gestion = ((horas_gestion / horas_asignadas)*100);
                
                //alert("porcentaje_horas_investigacion: " + porcentaje_horas_investigacion);
            }            
            $("#horas_clase").text(horas_case);            
            $("#porcentaje_horas_clase").width(porcentaje_horas_clase);
            
            $("#horas_tutoria").text(horas_tutoria);            
            $("#porcentaje_horas_tutoria").width(porcentaje_horas_tutoria);
            
            $("#horas_preparacion").text(horas_preparacion);            
            $("#porcentaje_horas_preparacion").width(porcentaje_horas_preparacion);
            
            $("#horas_docencia").text(horas_docencia);            
            $("#porcentaje_horas_docencia").text(porcentaje_horas_docencia);
            
            $("#horas_investigacion").text(horas_investigacion);            
            $("#porcentaje_horas_investigacion").width(porcentaje_horas_investigacion);
            
            $("#horas_titulacion").text(horas_titulacion);            
            $("#porcentaje_horas_titulacion").width(porcentaje_horas_titulacion);
            
            $("#horas_gestion").text(horas_gestion);            
            $("#porcentaje_horas_gestion").width(porcentaje_horas_gestion);              
            
            $("#total_horas_asignadas").text(horas_asignadas); 
            $("#horas_asignadas_clase").text(horas_asignadas);
            $("#horas_asignadas_tutoria").text(horas_asignadas);
            $("#horas_asignadas_preparacion").text(horas_asignadas);
            $("#horas_asignadas_investigacion").text(horas_asignadas);
            $("#horas_asignadas_titulacion").text(horas_asignadas);
            $("#horas_asignadas_gestion").text(horas_asignadas);
            
            $('#charTotalHoras').highcharts({
                chart: {type: 'pie'},
                title: {text: 'Porcentaja de distribución de su carga académica'},
                tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f} h</b>'},
                plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.1f}%'}}},
                series: [{
                        name: 'Total',
                        colorByPoint: true,
                        data: [
                            {name: 'Clases', y: porcentaje_horas_clase, color: Highcharts.getOptions().colors[0]},
                            {name: 'Tutorías', y: porcentaje_horas_tutoria, color: Highcharts.getOptions().colors[2]},
                            {name: 'Preparación', y: porcentaje_horas_preparacion, color: Highcharts.getOptions().colors[5]},
                            {name: 'Invest.', y: porcentaje_horas_investigacion, color: Highcharts.getOptions().colors[3]},
                            {name: 'Trab. Tit.', y: porcentaje_horas_titulacion, color: Highcharts.getOptions().colors[6]},
                            {name: 'Gest. Acad.', y: porcentaje_horas_gestion, color: Highcharts.getOptions().colors[9]}
                        ]
                    }]
            });

        },
        complete: function () {
            $("#load_query").hide();
        }
    });

}
    