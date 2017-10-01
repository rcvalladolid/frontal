/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.service;

import ec.edu.utpl.svied.model.TdiDetParametrosIndicador;
import ec.edu.utpl.svied.model.TheActividadesDocEvaCab;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author rcvalladolid
 */
public interface EvaService {

    List<Object> servicioListarPeriodosEva();

    List<BigDecimal[]> filtrosPeriodosEva();

    List<Object> listarDocentesEva(BigDecimal[] peId);

    List<Object> listarComponentesParalelosEva(BigDecimal peId, BigDecimal doId);

    List<Object> listarSemanasAcademicasEva(BigDecimal peId, String frecuencia);

    List<Object> listarRangosSemaforosEva(BigDecimal peId, BigDecimal rango_obtenido);

    List<Object> semanaActual(BigDecimal peId);

    List<Object> semanaMaximaEva(BigDecimal peId);

    List<Object> graficaActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal idId, BigDecimal[] onsId, BigDecimal ptId);

    List<Object> semaforosActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId);

    List<Object> cabeceraActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId);

    List<Object> detalleActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId, String frecuencia, BigDecimal[] numeracion);

    List<Object> listarDocentesAutoresEva(BigDecimal[] peId);
    
    List<Object> graficaActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId);
    
    List<Object> cabeceraActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId);
    
    List<Object> detalleActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId);
    
    List<Object> listarComponentesDocentesAutoresEva(BigDecimal peId, BigDecimal doId);
    
    String ultimaFechaActualizacion();
    
    /*
    Métodos para el periodo Oct/2017-Feb/2018    
    */
    
    public List<Object> listarPlanificacionEVA(BigDecimal peId, BigDecimal onsId);
}
