function getContextPath() {
    return window.location.protocol + '//' + window.location.host + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

$(function () {
    
    var docente_login = $('#hv_docente_login').attr("value");
    var periodo = $("#combo_periodo").val();
    
    cargaComponentesParalelos(periodo, docente_login);
    
    $('#combo_periodo').multiselect({
        buttonWidth: '100%',
        onChange: function (option, checked, select) {
            var checked = $('#combo_periodo option:selected');
            var periodo = [];
            $(checked).each(function (index, brand) {
                periodo.push([$(this).val()]);
            });
            cargaDocentesEva(periodo);
            var docente = $("#hv_docente_login").val();
            cargaComponentesParalelos(periodo, docente);
        }
    });
    $('#combo_docentes').multiselect({
        buttonWidth: '100%',
        maxHeight: 400,
        enableFiltering: true,
        selectAllJustVisible: false,
        enableCaseInsensitiveFiltering: true,
        filterPlaceholder: 'Busque por nombres o apellidos...',
        onChange: function (option, checked, select) {
            var checked = $('#combo_docentes option:selected');
            var docente = [];
            $(checked).each(function (index, brand) {
                docente.push([$(this).val()]);
            });
            var periodo = $("#combo_periodo").val();
            if ((docente.length !== parseInt(0)) || (docente !== null)) {
                $("#hv_docente_login").empty();
                $("#hv_docente_login").val(docente);
                cargaComponentesParalelos(periodo, docente);
            }
        }
    });
    $('#combo_componentes').multiselect({
        buttonWidth: '100%',
        includeSelectAllOption: true,
        enableCaseInsensitiveFiltering: true,
        selectAllText: '(Seleccionar todo)',
        nonSelectedText: '-- Seleccione su(s) componente(s) educativo(s) --',
        allSelectedText: "Total componente(s) educativo(s)",
        onChange: function (option, checked, select) {
            var checked = $('#combo_componentes option:selected');
            var componente = [];
            $(checked).each(function (index, brand) {
                componente.push([$(this).val()]);
            });
            if (componente.length !== parseInt(0)) {
                var periodo = $("#combo_periodo").val();
                var docente = $('#hv_docente_login').attr("value");
                var semana_actual = $('#hv_semana_actual').attr("value");
                var tipo_actividad = $("#tipo_actividad_eva").val();
                if ((semana_actual.length !== parseInt(0)) || (semana_actual !== null)) {
                    $('#charActividadesEva').empty();
                    $('#charActividadesAcumEva').empty();
                    /*if (parseInt(tipo_actividad) === parseInt(1)) {//Anuncios académicos                 
                        charActividadesEva(periodo, docente, 185, componente, semana_actual, 'ANUNCIOS ACADÉMICOS');
                    } else if (parseInt(tipo_actividad) === parseInt(2)) { //Foros académicos                            
                        charActividadesEva(periodo, docente, 186, componente, semana_actual, 'FOROS ACADÉMICOS');
                    } else if (parseInt(tipo_actividad) === parseInt(3)) { //Chats permanentes
                        charActividadesEva(periodo, docente, 194, componente, semana_actual, 'CHATS PERMANENTES');
                    } else if (parseInt(tipo_actividad) === parseInt(4)) { //Chats académicos
                        charActividadesEva(periodo, docente, 187, componente, semana_actual, 'CHATS ACADÉMICOS');
                    } else if (parseInt(tipo_actividad) === parseInt(5)) { //Microvideos 1
                        charActividadesEva(periodo, docente, 188, componente, semana_actual, 'MICROVIDEOS DE 1ER CICLO Y FORM. BÁSICA');
                    } else if (parseInt(tipo_actividad) === parseInt(6)) { //Microvideos 2
                        charActividadesEva(periodo, docente, 377, componente, semana_actual, 'MICROVIDEOS DE SEGUNDO CICLO EN ADELANTE');
                    } else if (parseInt(tipo_actividad) === parseInt(7)) { //Cuestionarios
                        charActividadesEva(periodo, docente, 189, componente, semana_actual, 'CUESTIONARIOS');
                    }*/
                }
            }
        },
        onSelectAll: function () {
            var checked_componentes = $('#combo_componentes option:selected');
            var total_componentes = [];
            $(checked_componentes).each(function (index, brand) {
                total_componentes.push([$(this).val()]);
            });
            //var semana_actual = $('#hv_semana_actual').attr("value");
            var tipo_actividad = $("#tipo_actividad_eva").val();
            var periodo = $("#combo_periodo").val();
            var docente = $('#hv_docente_login').attr("value");
        }
    });
    
    anuncios();
    foros();
    chats();
});

function cargaDocentesEva(periodo) {
    $.ajax({
        type: "GET",
        url: "" + getContextPath() + "/eva/jsonListarDocentesEva/[" + periodo + "] ",
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function () {
            $("#loading_query").show();
        },
        success: function (data) {
            var jsonData = eval('(' + JSON.stringify(data) + ')');
            $('#combo_docentes').empty();
            var options = [];

            if (jsonData === undefined || jsonData === null) {
                $("#msn_aviso").text('Lamentamos no tener datos para listar los docentes del periodo seleccionado.');
                $('#modalInfo').modal('show');
            } else {
                for (var i = 0; i < jsonData.length; i++) {
                    $("#combo_docentes").append("<option value=" + jsonData[i][0] + ">" + jsonData[i][2] + "</option>");
                    options.push({label: jsonData[i][2], title: jsonData[i][2], value: jsonData[i][0], selected: true});
                }
                $('#combo_docentes').multiselect('dataprovider', options);
                var docente = $('#hv_docente_login').attr("value");
                $('#combo_docentes').multiselect('select', docente);
                $('#combo_docentes').multiselect('refresh');
            }
        },
        complete: function () {
            $("#loading_query").hide();
        }
    });
}

function cargaComponentesParalelos(peId, doId) {
    $.ajax({
        type: "GET",
        url: "" + getContextPath() + "/eva/jsonListarComponentesEva/" + peId + "/" + doId + " ",
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function () {
            $("#loading_query").show();
        },
        success: function (data) {
            var jsonData = eval('(' + JSON.stringify(data) + ')');
            $('#combo_componentes').empty();
            var options = [];
            if (jsonData === undefined || jsonData === null) {
                $("#msn_aviso").text('Lamentamos no tener datos para listar sus componentes educativos en el periodo seleccionado.');
                $('#modalInfo').modal('show');
            } else {
                for (var i = 0; i < jsonData.length; i++) {
                    options.push({label: jsonData[i][2] + " " + "[" + jsonData[i][3] + "]", title: jsonData[i][2] + " " + "[" + jsonData[i][3] + "]", value: jsonData[i][0], selected: true});
                }
                $('#combo_componentes').multiselect('dataprovider', options);
                $('#combo_componentes').multiselect('refresh');
            }
        },
        complete: function () {
            $("#loading_query").hide();
        }
    });
}

function anuncios() {            

    Highcharts.chart('char_anuncios_bimestres', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Primer Bimestre', 'Segundo Bimestre'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' anuncio(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [8, 8], color: '#004270'},
            {name: 'Cumplimiento', data: [8, 6], color: 'rgb(0, 128, 0)'
            }]
    });

    Highcharts.chart('char_anuncios_periodo_real', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Anuncios cumplidos', 'Anuncios realizados'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' anuncio(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [16, 16], color: '#004270'},
            {name: 'Cumplido/Realizado', data: [14, 19], color: 'rgb(0, 128, 0)'
            }]
    });


    Highcharts.chart('char_anuncios_periodo', {
        chart: {type: 'pie'},
        title: null,
        exporting: {enabled: false},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'},
        plotOptions: {pie: {allowPointSelect: true, cursor: 'pointer', dataLabels: {enabled: false}, showInLegend: true}},
        series: [{
                name: 'Anuncios',
                colorByPoint: true,
                data: [
                    {name: 'Cumplimiento', y: 87.50, color: 'rgb(0, 128, 0)'},
                    {name: 'No Cumplimiento', y: 12.50, sliced: true, selected: true, color: 'rgb(255, 0, 0)'
                    }]
            }]
    });
    
    Highcharts.chart('anuncios_semanales', {
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['SEMANA 1. [03/04/2017 AL 09/04/2017]', 'SEMANA 2. [10/04/2017 AL 16/04/2017]', 'SEMANA 3. [17/04/2017 AL 23/04/2017]', 'SEMANA 4. [24/04/2017 AL 30/04/2017]', 'SEMANA 5. [01/05/2017 AL 07/05/2017]', 'SEMANA 6. [08/05/2017 AL 14/05/2017]', 'SEMANA 7. [15/05/2017 AL 21/05/2017]', 'SEMANA 8. [22/05/2017 AL 28/05/2017]', 'SEMANA 9. [29/05/2017 AL 04/06/2017]', 'SEMANA 10. [05/06/2017 AL 11/06/2017]', 'SEMANA 11. [12/06/2017 AL 18/06/2017]', 'SEMANA 12. [19/06/2017 AL 25/06/2017]', 'SEMANA 13. [26/06/2017 AL 02/07/2017]', 'SEMANA 14. [03/07/2017 AL 09/07/2017]', 'SEMANA 15. [10/07/2017 AL 16/07/2017]', 'SEMANA 16. [17/07/2017 AL 31/07/2017]'], title: {text: null}},
        yAxis: {title: {text: 'Número de anuncios'}},
        series: [{
                name: 'Objetivo',
                data: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                marker: {lineWidth: 2, lineColor: '#004270', fillColor: 'blue'}
            }, {
                name: 'Cumplimiento',
                data: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
                color: 'rgb(0, 128, 0)'
            }, {
                name: 'Realizado',
                data: [1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 0, 0],
                marker: {lineWidth: 2, lineColor: Highcharts.getOptions().colors[5], fillColor: 'white'}
            }]
    });


}    

function foros() {    

    Highcharts.chart('char_foros_bimestres', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Primer Bimestre', 'Segundo Bimestre'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' foro(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [1, 1], color: '#004270'},
            {name: 'Cumplimiento', data: [1, 0], color: 'rgb(0, 128, 0)'
            }]
    });

    Highcharts.chart('char_foros_periodo_real', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Foros cumplidos', 'Foros realizados'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' foro(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [2, 2], color: '#004270'},
            {name: 'Cumplido/Realizado', data: [1, 2], color: 'rgb(0, 128, 0)'
            }]
    });


    Highcharts.chart('char_foros_periodo', {
        chart: {type: 'pie'},
        title: null,
        exporting: {enabled: false},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'},
        plotOptions: {pie: {allowPointSelect: true, cursor: 'pointer', dataLabels: {enabled: false}, showInLegend: true}},
        series: [{
                name: 'Foros',
                colorByPoint: true,
                data: [
                    {name: 'Cumplimiento', y: 50.00, color: 'rgb(0, 128, 0)'},
                    {name: 'No Cumplimiento', y: 50.50, sliced: true, selected: true, color: 'rgb(255, 0, 0)'
                    }]
            }]
    });
    
    Highcharts.chart('foros_semanales', {
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['SEMANA 1. [03/04/2017 AL 09/04/2017]', 'SEMANA 2. [10/04/2017 AL 16/04/2017]', 'SEMANA 3. [17/04/2017 AL 23/04/2017]', 'SEMANA 4. [24/04/2017 AL 30/04/2017]', 'SEMANA 5. [01/05/2017 AL 07/05/2017]', 'SEMANA 6. [08/05/2017 AL 14/05/2017]', 'SEMANA 7. [15/05/2017 AL 21/05/2017]', 'SEMANA 8. [22/05/2017 AL 28/05/2017]', 'SEMANA 9. [29/05/2017 AL 04/06/2017]', 'SEMANA 10. [05/06/2017 AL 11/06/2017]', 'SEMANA 11. [12/06/2017 AL 18/06/2017]', 'SEMANA 12. [19/06/2017 AL 25/06/2017]', 'SEMANA 13. [26/06/2017 AL 02/07/2017]', 'SEMANA 14. [03/07/2017 AL 09/07/2017]', 'SEMANA 15. [10/07/2017 AL 16/07/2017]', 'SEMANA 16. [17/07/2017 AL 31/07/2017]'], title: {text: null}},
        yAxis: {title: {text: 'Número de foros'}},
        series: [{
                name: 'Objetivo',
                data: [0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0],
                marker: {lineWidth: 2, lineColor: '#004270', fillColor: 'blue'}
            }, {
                name: 'Cumplimiento',
                data: [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                color: 'rgb(0, 128, 0)'
            }, {
                name: 'Realizado',
                data: [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
                marker: {lineWidth: 2, lineColor: Highcharts.getOptions().colors[5], fillColor: 'white'}
            }]
    });


} 

function chats() {    

    Highcharts.chart('char_chats_bimestres', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Primer Bimestre', 'Segundo Bimestre'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' chat(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [7, 7], color: '#004270'},
            {name: 'Cumplimiento', data: [7, 6], color: 'rgb(0, 128, 0)'
            }]
    });

    Highcharts.chart('char_chats_periodo_real', {
        chart: {type: 'bar'},
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['Chats cumplidos', 'Chats realizados'], title: {text: null}},
        yAxis: {min: 0, labels: {overflow: 'justify'}},
        tooltip: {valueSuffix: ' chat(s)'},
        plotOptions: {bar: {dataLabels: {enabled: true}}},
        credits: {enabled: false},
        series: [
            {name: 'Objetivo', data: [14, 14], color: '#004270'},
            {name: 'Cumplido/Realizado', data: [13, 13], color: 'rgb(0, 128, 0)'
            }]
    });


    Highcharts.chart('char_chats_periodo', {
        chart: {type: 'pie'},
        title: null,
        exporting: {enabled: false},
        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'},
        plotOptions: {pie: {allowPointSelect: true, cursor: 'pointer', dataLabels: {enabled: false}, showInLegend: true}},
        series: [{
                name: 'Chats',
                colorByPoint: true,
                data: [
                    {name: 'Cumplimiento', y: 92.85, color: 'rgb(0, 128, 0)'},
                    {name: 'No Cumplimiento', y: 7.15, sliced: true, selected: true, color: 'rgb(255, 0, 0)'
                    }]
            }]
    });
    
    Highcharts.chart('chats_semanales', {
        title: null,
        exporting: {enabled: false},
        xAxis: {categories: ['SEMANA 1. [03/04/2017 AL 09/04/2017]', 'SEMANA 2. [10/04/2017 AL 16/04/2017]', 'SEMANA 3. [17/04/2017 AL 23/04/2017]', 'SEMANA 4. [24/04/2017 AL 30/04/2017]', 'SEMANA 5. [01/05/2017 AL 07/05/2017]', 'SEMANA 6. [08/05/2017 AL 14/05/2017]', 'SEMANA 7. [15/05/2017 AL 21/05/2017]', 'SEMANA 8. [22/05/2017 AL 28/05/2017]', 'SEMANA 9. [29/05/2017 AL 04/06/2017]', 'SEMANA 10. [05/06/2017 AL 11/06/2017]', 'SEMANA 11. [12/06/2017 AL 18/06/2017]', 'SEMANA 12. [19/06/2017 AL 25/06/2017]', 'SEMANA 13. [26/06/2017 AL 02/07/2017]', 'SEMANA 14. [03/07/2017 AL 09/07/2017]', 'SEMANA 15. [10/07/2017 AL 16/07/2017]', 'SEMANA 16. [17/07/2017 AL 31/07/2017]'], title: {text: null}},
        yAxis: {title: {text: 'Número de chats'}},
        series: [{
                name: 'Objetivo',
                data: [1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0],
                marker: {lineWidth: 2, lineColor: '#004270', fillColor: 'blue'}
            }, {
                name: 'Cumplimiento',
                data: [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
                color: 'rgb(0, 128, 0)'
            }, {
                name: 'Realizado',
                data: [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
                marker: {lineWidth: 2, lineColor: Highcharts.getOptions().colors[5], fillColor: 'white'}
            }]
    });
} 

$("#openMenu").click(function () {
    $('#modalMAD').modal('show');
});