/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.service.impl;

import ec.edu.utpl.svied.dao.EvaDao;
import ec.edu.utpl.svied.model.TdiDetParametrosIndicador;
import ec.edu.utpl.svied.model.TheActividadesDocEvaCab;
import ec.edu.utpl.svied.service.EvaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcvalladolid
 */

@Service("evaService")
@Transactional
public class EvaServiceImpl implements EvaService{
    
    @Autowired
    private EvaDao evaDao;
    
    @Override
    public List<Object> servicioListarPeriodosEva() {
        List<BigDecimal[]> listaPeriodos = filtrosPeriodosEva();
        return evaDao.comboPeriodos(listaPeriodos);
    }
    
    @Override
    public List<BigDecimal[]> filtrosPeriodosEva() {
        return evaDao.filtrosPeriodosEva();
    }
    
    @Override
    public List<Object> listarDocentesEva(BigDecimal[] peId) {
        return evaDao.listarDocentesEva(peId);
    }
    
    @Override
    public List<Object> listarComponentesParalelosEva(BigDecimal peId, BigDecimal doId) {
        return evaDao.listarComponentesParalelosEva(peId, doId);
    }
    
    @Override
    public List<Object> listarSemanasAcademicasEva(BigDecimal peId, String frecuencia) {
        return evaDao.listarSemanasAcademicasEva(peId, frecuencia);
    }      
    
    @Override
    public List<Object> listarRangosSemaforosEva(BigDecimal peId, BigDecimal rango_obtenido) {
        return evaDao.listarRangosSemaforosEva(peId, rango_obtenido);
    }
    
    @Override
    public List<Object> semanaActual(BigDecimal peId) {
        return evaDao.semanaActualEva(peId);
    }
    
    @Override
    public List<Object> semanaMaximaEva(BigDecimal peId) {
        return evaDao.semanaMaximaEva(peId);
    }

    @Override
    public List<Object> graficaActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal idId, BigDecimal[] onsId, BigDecimal ptId) {
        return evaDao.graficaActividadesEva(peId, doId, idId, onsId, ptId);
    }
    
    @Override
    public List<Object> semaforosActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId) {
        return evaDao.semaforosActividadesEva(peId, doId, onsId, ptId, idId);
    }

    @Override
    public List<Object> cabeceraActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId) {
        return evaDao.cabeceraActividadesEva(peId, doId, onsId, ptId, idId);
    }

    @Override
    public List<Object> detalleActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId, String frecuencia, BigDecimal[] numeracion) {
        return evaDao.detalleActividadesEva(peId, doId, onsId, idId, frecuencia, numeracion);
    }    

    @Override
    public List<Object> listarDocentesAutoresEva(BigDecimal[] peId) {
        return evaDao.listarDocentesAutoresEva(peId);
    }

    @Override
    public List<Object> graficaActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        return evaDao.graficaActividadesDocentesAutoresEva(peId, doId, onsId, idId);
    }
    
    @Override
    public List<Object> cabeceraActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        return evaDao.cabeceraActividadesDocentesAutoresEva(peId, doId, onsId, idId);
    }

    @Override
    public List<Object> detalleActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        return evaDao.detalleActividadesDocentesAutoresEva(peId, doId, onsId, idId);
    }

    @Override
    public List<Object> listarComponentesDocentesAutoresEva(BigDecimal peId, BigDecimal doId) {
        return evaDao.listarComponentesDocentesAutoresEva(peId, doId);
    }                    

    @Override
    public String ultimaFechaActualizacion() {
        return evaDao.ultimaFechaActualizacion();
    }

    @Override
    public List<Object> listarPlanificacionEVA(BigDecimal peId, BigDecimal onsId) {
        return evaDao.listarPlanificacionEVA(peId, onsId);
    }

    
    
}
