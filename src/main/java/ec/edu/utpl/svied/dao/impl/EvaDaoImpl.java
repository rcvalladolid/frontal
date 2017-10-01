/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.dao.impl;

import ec.edu.utpl.svied.dao.EvaDao;
import java.math.BigDecimal;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;

/**
 *
 * @author rcvalladolid
 */
@Repository("evaDao")
public class EvaDaoImpl implements EvaDao {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EvaDaoImpl() {
    }

    @Override
    public List<Object> comboPeriodos(List<BigDecimal[]> peId) {
        List<Object> listaPeriodos = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String hql = "SELECT DISTINCT pe.peId "
                    + ",pe.peNombre "
                    + ",pe.peAnio "
                    + ",pe.peOrdenPeriodo "
                    + ",pe.peNombre "
                    + "FROM TdiPeriodo pe "
                    + "WHERE pe.peId IN (:peId) "
                    + "ORDER BY pe.peOrdenPeriodo DESC ";

            Query query = session.createQuery(hql);
            query.setParameterList("peId", peId);

            listaPeriodos = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return listaPeriodos;
    }

    @Override
    public List<BigDecimal[]> filtrosPeriodosEva() {
        List<BigDecimal[]> filtrosPeriodos = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String hql = "SELECT DISTINCT fp.filCodigo "
                    + "FROM TdsFiltrosUgda fp "
                    + "WHERE fp.filModulo = 'DOCENTES_SEG_ACA_EVA' "
                    + "AND fp.filAplicacion = 'DOCENTES' "
                    + "AND fp.filVigencia = 'S' "
                    + "ORDER BY fp.filCodigo DESC ";
            Query query = session.createQuery(hql);
            filtrosPeriodos = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return filtrosPeriodos;
    }

    @Override
    public List<Object> listarDocentesEva(BigDecimal[] peId) {
        List<Object> listaDocentes = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT adc.tdiDocente.doId "
                    + ",adc.tdiDocente.doIdentificacion "
                    + ",adc.tdiDocente.doApellidoPaterno ||' '|| adc.tdiDocente.doApellidoMaterno ||' '|| adc.tdiDocente.doPrimerNombre ||' '|| adc.tdiDocente.doSegundoNombre AS nombres_docente "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiPeriodo.peId IN (:peId) "
                    + "AND adc.tdiExcepciones.texId IS NULL "
                    + "AND adc.aecVigente = 'S' "
                    + "ORDER BY 3 ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameterList("peId", peId);
            listaDocentes = query.list();                        

        } catch (HibernateException e) {
            e.getMessage();
        }
        return listaDocentes;
    }

    @Override
    public List<Object> listarComponentesParalelosEva(BigDecimal peId, BigDecimal doId) {
        List<Object> listaComponentesParalelos = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adc.tdiOfertaNsga.onsId "
                    + ",adc.tdiComponenteEducativo.ceCodigo "
                    + ",adc.tdiComponenteEducativo.ceNombre "
                    + ",adc.tdiGlosario.dicNombre "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiExcepciones.texId IS NULL "
                    + "AND adc.aecVigente = 'S' "
                    + "ORDER BY adc.tdiComponenteEducativo.ceNombre, adc.tdiGlosario.dicNombre ";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            //query.setParameter("excepcion", null);

            listaComponentesParalelos = query.list();

        } catch (HibernateException e) {
            e.getMessage();
        }
        return listaComponentesParalelos;
    }

    @Override
    public List<Object> listarSemanasAcademicasEva(BigDecimal peId, String frecuencia) {
        List<Object> objListarSemanas = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT ped.ptFrecuencia "
                    + ",ped.ptNumeracion "
                    + ",ped.ptFechaInicio "
                    + ",ped.ptFechaFin "
                    + ",ped.ptId "
                    + "FROM TdiPeriodoDetalle ped "
                    + "WHERE ped.tdiPeriodo.peId = :peId "
                    + "AND ped.ptFrecuencia IN (:frecuencia) "
                    + "AND ped.tdiModalidad.moId = 2 " //Modalidad Distancia
                    + "AND ped.tdiNivelAcademico.naId = 1 " //Nivel Académico de Pregrado
                    + "AND ped.ptNumeracion BETWEEN 1 AND 16 " //Semana 0 y semana 17 y 18 para medicina
                    + "ORDER BY ped.ptId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("frecuencia", frecuencia);

            objListarSemanas = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return objListarSemanas;
    }

    @Override
    public List<Object> listarRangosSemaforosEva(BigDecimal peId, BigDecimal rango_obtenido) {
        List<Object> objListarSemanas = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT ras.rseColor "
                    + ",ras.rseCodigoColor "
                    + ",ras.rseSignificadoColor "
                    + "FROM TdiRangosSemaforo ras "
                    + "WHERE ras.tdiPeriodo.peId = :peId "
                    + "AND :rango_obtenido BETWEEN ras.rseRangoInicial AND ras.rseRangoFinal ";
            //+ "AND ras.rseVigente = 'S' ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("rango_obtenido", rango_obtenido);

            objListarSemanas = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return objListarSemanas;
    }

    @Override
    public List<Object> semanaActualEva(BigDecimal peId) {
        List<Object> objSemanaActual = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT ped.ptId"
                    + ",ped.ptNumeracion "
                    + ",ped.ptFechaInicio "
                    + ",ped.ptFechaFin "
                    + "FROM TdiPeriodoDetalle ped "
                    + "WHERE sysdate BETWEEN ped.ptFechaInicio AND ped.ptFechaFin "
                    + "AND ped.ptFrecuencia = 'SM' "
                    + "AND ped.tdiModalidad.moId = 2 "
                    + "AND ped.tdiNivelAcademico.naId = 1 "
                    + "AND ped.tdiPeriodo.peId = :peId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            objSemanaActual = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objSemanaActual;
    }

    @Override
    public List<Object> semanaMaximaEva(BigDecimal peId) {
        List<Object> objSemanaMaxima = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT MAX(ped.ptId) "
                    + ",MAX(ped.ptNumeracion) "
                    + ",MAX(ped.ptFechaInicio) "
                    + ",MAX(ped.ptFechaFin) "
                    + "FROM TdiPeriodoDetalle ped "
                    + "WHERE ped.ptFrecuencia = 'SM' "
                    + "AND ped.tdiModalidad.moId = 2 "
                    + "AND ped.tdiNivelAcademico.naId = 1 "
                    + "AND ped.ptNumeracion <= 16 "
                    + "AND ped.tdiPeriodo.peId = :peId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            objSemanaMaxima = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objSemanaMaxima;
    }

    @Override
    public List<Object> graficaActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal idId, BigDecimal[] onsId, BigDecimal ptId) {
        List<Object> objTotalActividades = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT aec.tdiPeriodo.peId "
                    + ",aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",(CASE WHEN aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' END) "
                    + ",aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion "
                    + ",aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio ||' AL '|| aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",SUM(aec.aecObjetivo) "
                    + ",SUM(aec.aecCumplimiento) "
                    + ",SUM(aec.aecSeguimiento) "
                    + ",SUM(CASE WHEN aec.aecObjetivo > 0 THEN  ROUND(aec.aecObjetivo - aec.aecTotal) ELSE 0 END) AS NO_CUMPLIMIENTO "
                    + ",SUM(aec.aecTotal) "
                    + "FROM TheActividadesDocEvaCab aec "
                    + "WHERE aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND aec.tdiPeriodo.peId = :peId "
                    + "AND aec.tdiDocente.doId = :doId "
                    + "AND aec.tdiIndicador.idId = :idId "
                    + "AND aec.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion BETWEEN 1 AND 16 " //Semana 0 y semana 17 y 18 para medicina
                    + "AND aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptId <= :ptId "
                    + "AND aec.aecVigente = 'S' "
                    + "GROUP BY aec.tdiPeriodo.peId, aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptId, aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia, aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion, aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio, aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + "ORDER BY aec.tdiParametrosIndicador.tdiPeriodoDetalle.ptId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameter("idId", idId);
            query.setParameter("ptId", ptId);
            query.setParameterList("onsId", onsId);

            objTotalActividades = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objTotalActividades;
    }

    @Override
    public List<Object> semaforosActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId) {
        List<Object> totalSemaforosActividades = null;
        try {

            Session session = sessionFactory.getCurrentSession();
            double penalizacion = 0.50;

            //ROUND(((SUM(TOTAL_ACTIVIDADES_CUMPLE_FECHA HASTA LA SEMANA 0) + (SUM(TOTAL_ACTIVIDADES_NO_CUMPLE_FECHA HASTA LA SEMANA 0)*0.5))/PI_VALOR_OBJETIVO DE LA SEMANA 0)*100) 
            String HQL_QUERY = "SELECT DISTINCT adc.tdiPeriodo.peId "
                    + ",COUNT(DISTINCT adc.tdiOfertaNsga.onsId) AS totalCoe "
                    /*+ ",(CASE WHEN SUM(adc.tdiParametrosIndicador.piValorObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.tdiParametrosIndicador.piValorObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END)  "
                     + ",(CASE WHEN SUM(adc.tdiParametrosIndicador.piValorObjetivo+adc.aecCumplimiento) = 0 THEN 'SA_EVA3' "
                     + "       WHEN (CASE WHEN SUM(adc.tdiParametrosIndicador.piValorObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.tdiParametrosIndicador.piValorObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 0 AND 40 THEN 'NO_CO_EVA3' "
                     + "       WHEN (CASE WHEN SUM(adc.tdiParametrosIndicador.piValorObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.tdiParametrosIndicador.piValorObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 41 AND 89 THEN 'SE_EVA3' "
                     + "       WHEN (CASE WHEN SUM(adc.tdiParametrosIndicador.piValorObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.tdiParametrosIndicador.piValorObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 90 AND 100 THEN 'CO_EVA3' "
                     + " END) "*/
                    + ",(CASE WHEN SUM(adc.aecObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.aecObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END)  "
                    + ",(CASE WHEN SUM(adc.aecObjetivo+adc.aecCumplimiento) = 0 THEN 'SA_EVA3' "
                    + "       WHEN (CASE WHEN SUM(adc.aecObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.aecObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 0 AND 40 THEN 'NO_CO_EVA3' "
                    + "       WHEN (CASE WHEN SUM(adc.aecObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.aecObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 41 AND 89 THEN 'SE_EVA3' "
                    + "       WHEN (CASE WHEN SUM(adc.aecObjetivo) > 0 THEN ROUND((SUM(adc.aecCumplimiento+(adc.aecSeguimiento*" + penalizacion + "))/SUM(adc.aecObjetivo))*100) ELSE ROUND(SUM(adc.aecPorcentajeObtenido)/COUNT(DISTINCT adc.tdiOfertaNsga.onsId)) END) BETWEEN 90 AND 100 THEN 'CO_EVA3' "
                    + " END) "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId IN (:ptId) "
                    + "AND adc.tdiIndicador.idId IN (:idId) "
                    + "AND adc.aecColoresSemaforo <> 'SA_EVA3' "
                    + "AND adc.tdiExcepciones.texId IS NULL "
                    + "AND adc.aecVigente = 'S' "
                    + "GROUP BY adc.tdiPeriodo.peId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("ptId", ptId);
            query.setParameterList("idId", idId);

            totalSemaforosActividades = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalSemaforosActividades;
    }

    @Override
    public List<Object> cabeceraActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] ptId, BigDecimal[] idId) {
        List<Object> totalActividades = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adc.tdiPeriodo.peId "
                    + ",adc.tdiPeriodo.peNombre "
                    + ",(CASE WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion " //NUMERO DE SEMANA
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin AS rango_fecha "
                    + ",adc.tdiComponenteEducativo.ceCodigo "
                    + ",adc.tdiComponenteEducativo.ceNombre "
                    + ",adc.tdiGlosario.dicNombre "
                    + ",adc.aecObjetivo "
                    + ",adc.aecCumplimiento "
                    + ",adc.aecSeguimiento "
                    + ",adc.aecTotal "
                    + ",adc.aecPorcentajeObtenido "
                    + ",adc.aecColoresSemaforo "
                    + ",obs.opeMensaje "
                    + ",adc.tdiOfertaNsga.onsId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia AS periodicidad "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "     ,TdiObservacionPersonalizada obs "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId IN (:ptId) "
                    + "AND adc.tdiIndicador.idId IN (:idId) "
                    + "AND adc.aecColoresSemaforo = obs.opeCodigo "
                    + "AND adc.aecVigente = 'S' "
                    + "ORDER BY 17,7,8 ASC ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("ptId", ptId);
            query.setParameterList("idId", idId);

            totalActividades = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalActividades;
    }

    @Override
    public List<Object> detalleActividadesEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId, String frecuencia, BigDecimal[] numeracion) {
        List<Object> listaDetalleActividades = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adt.tdiPeriodo.peId "
                    + ",adt.tdiPeriodo.peNombre "
                    + ",(CASE WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) || ' ' || adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion "
                    + ",adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",adt.tdiComponenteEducativo.ceCodigo "
                    + ",adt.tdiComponenteEducativo.ceNombre "
                    + ",adt.tdiGlosario.dicNombre "
                    + ",adt.tdiParametrosIndicador.piValorObjetivo "
                    + ",adt.aedCumplimiento "
                    + ",adt.aedSeguimiento "
                    + ",adt.aedCantidad "
                    + ",adt.aedFechaActividad "
                    + ",adt.tdiObservacionPersonalizada.opeMensaje "
                    + ",adt.tdiObservacionPersonalizada.opeDescripcion "
                    + "FROM TheActividadesDocEvaDet adt "
                    + "WHERE adt.tdiPeriodo.peId = :peId "
                    + "AND adt.tdiDocente.doId = :doId "
                    + "AND adt.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adt.tdiIndicador.idId IN (:idId) "
                    + "AND adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = :frecuencia "
                    + "AND adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion IN (:numeracion) "
                    + "ORDER BY adt.tdiComponenteEducativo.ceNombre, adt.tdiGlosario.dicNombre, adt.aedFechaActividad ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("idId", idId);
            query.setParameter("frecuencia", frecuencia);
            query.setParameterList("numeracion", numeracion);

            listaDetalleActividades = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDetalleActividades;
    }

    @Override
    public List<Object> listarDocentesAutoresEva(BigDecimal[] peId) {
        List<Object> listaDocentesPrincipales = null;
        try {

            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT adc.tdiDocente.doId "
                    + ",adc.tdiDocente.doIdentificacion "
                    + ",adc.tdiDocente.doApellidoPaterno ||' '|| adc.tdiDocente.doApellidoMaterno ||' '|| adc.tdiDocente.doPrimerNombre ||' '|| adc.tdiDocente.doSegundoNombre AS nombresDocente "
                    + ",COUNT(DISTINCT adc.aecIdCursoEva) "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiPeriodo.peId IN (:peId) "
                    + "AND adc.tdiGlosario.dicNombre = 'A1' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 "
                    + "AND adc.tdiExcepciones.texId IS NULL "
                    + "AND adc.aecVigente = 'S' "
                    + "GROUP BY adc.tdiDocente.doId, adc.tdiDocente.doIdentificacion, adc.tdiDocente.doApellidoPaterno ||' '|| adc.tdiDocente.doApellidoMaterno ||' '|| adc.tdiDocente.doPrimerNombre ||' '|| adc.tdiDocente.doSegundoNombre "
                    + "HAVING COUNT(DISTINCT adc.aecIdCursoEva) > 1 "
                    + "ORDER BY 3 ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameterList("peId", peId);
            listaDocentesPrincipales = query.list();

        } catch (HibernateException e) {
            e.getMessage();
        }
        return listaDocentesPrincipales;
    }

    @Override
    public List<Object> graficaActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        List<Object> objTotalActividades = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            /*String HQL_QUERY = "SELECT DISTINCT adc.tdiPeriodo.peId "
                    + ",adc.tdiPeriodo.peNombre "
                    + ",(CASE WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion " //NUMERO DE SEMANA
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",adc.tdiComponenteEducativo.ceCodigo "
                    + ",adc.tdiComponenteEducativo.ceNombre "
                    + ",adc.tdiGlosario.dicNombre "
                    + ",adc.aecObjetivo "
                    + ",adc.aecCumplimiento "
                    + ",adc.aecSeguimiento "                    
                    + ",(CASE WHEN adc.aecObjetivo > 0 AND adc.aecTotal <= adc.aecObjetivo THEN ROUND(adc.aecObjetivo - adc.aecTotal) ELSE 0 END) AS NO_CUMPLIMIENTO "
                    + ",adc.aecTotal "
                    + ",adc.aecPorcentajeObtenido "
                    + ",adc.aecColoresSemaforo "
                    + ",obs.opeMensaje "
                    + ",adc.tdiOfertaNsga.onsId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia AS periodicidad "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "     ,TdiObservacionPersonalizada obs "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 "
                    + "AND adc.tdiIndicador.idId IN (:idId) "
                    + "AND adc.aecColoresSemaforo = obs.opeCodigo "
                    + "ORDER BY adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId, adc.tdiComponenteEducativo.ceNombre, adc.tdiGlosario.dicNombre ";*/
            String HQL_QUERY = "SELECT DISTINCT adc.tdiPeriodo.peId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",(CASE WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion " //NUMERO DE SEMANA
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",SUM(adc.aecObjetivo) "
                    + ",SUM(adc.aecCumplimiento) "
                    + ",SUM(adc.aecSeguimiento) "
                    + ",SUM(CASE WHEN adc.aecObjetivo > 0 THEN  ROUND(adc.aecObjetivo - adc.aecTotal) ELSE 0 END) AS NO_CUMPLIMIENTO "
                    + ",SUM(adc.aecTotal) "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiIndicador.idId IN (:idId) "
                    + "AND adc.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 " //Semana 0                    
                    + "AND adc.aecVigente = 'S' "
                    + "GROUP BY adc.tdiPeriodo.peId, adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId, adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia, adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion, adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio, adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + "ORDER BY adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("idId", idId);

            objTotalActividades = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objTotalActividades;
    }

    @Override
    public List<Object> cabeceraActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        List<Object> objTotalActividades = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adc.tdiPeriodo.peId "
                    + ",adc.tdiPeriodo.peNombre "
                    + ",(CASE WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion " //NUMERO DE SEMANA
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",adc.tdiComponenteEducativo.ceCodigo "
                    + ",adc.tdiComponenteEducativo.ceNombre "
                    + ",adc.tdiGlosario.dicNombre "
                    + ",adc.aecObjetivo "
                    + ",adc.aecCumplimiento "
                    + ",adc.aecSeguimiento "
                    + ",(CASE WHEN adc.aecObjetivo > 0 AND adc.aecTotal <= adc.aecObjetivo THEN ROUND(adc.aecObjetivo - adc.aecTotal) ELSE 0 END) AS NO_CUMPLIMIENTO "
                    + ",adc.aecTotal "
                    + ",adc.aecPorcentajeObtenido "
                    + ",adc.aecColoresSemaforo "
                    + ",obs.opeMensaje "
                    + ",adc.tdiOfertaNsga.onsId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia AS periodicidad "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "     ,TdiObservacionPersonalizada obs "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 "
                    + "AND adc.tdiIndicador.idId IN (:idId) "
                    + "AND adc.aecColoresSemaforo = obs.opeCodigo "
                    + "AND adc.aecVigente = 'S' "
                    + "ORDER BY adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptId, adc.tdiComponenteEducativo.ceNombre, adc.tdiGlosario.dicNombre ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("idId", idId);

            objTotalActividades = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objTotalActividades;
    }

    @Override
    public List<Object> detalleActividadesDocentesAutoresEva(BigDecimal peId, BigDecimal doId, BigDecimal[] onsId, BigDecimal[] idId) {
        List<Object> listaDetalleActividades = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adt.tdiPeriodo.peId "
                    + ",adt.tdiPeriodo.peNombre "
                    + ",(CASE WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'BM' THEN 'BIMESTRE' WHEN adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'PE' THEN 'PERIODO' END) || ' ' || adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion "
                    + ",adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio || ' AL ' || adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",adt.tdiComponenteEducativo.ceCodigo "
                    + ",adt.tdiComponenteEducativo.ceNombre "
                    + ",adt.tdiGlosario.dicNombre "
                    + ",adt.tdiParametrosIndicador.piValorObjetivo "
                    + ",adt.aedCumplimiento "
                    + ",adt.aedSeguimiento "
                    + ",adt.aedCantidad "
                    + ",adt.aedFechaActividad "
                    + ",adt.tdiObservacionPersonalizada.opeMensaje "
                    + ",adt.tdiObservacionPersonalizada.opeDescripcion "
                    + "FROM TheActividadesDocEvaDet adt "
                    + "WHERE adt.tdiPeriodo.peId = :peId "
                    + "AND adt.tdiDocente.doId = :doId "
                    + "AND adt.tdiOfertaNsga.onsId IN (:onsId) "
                    + "AND adt.tdiIndicador.idId IN (:idId) "
                    + "AND adt.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 "
                    + "ORDER BY adt.tdiComponenteEducativo.ceNombre, adt.tdiGlosario.dicNombre, adt.aedFechaActividad ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);
            query.setParameterList("onsId", onsId);
            query.setParameterList("idId", idId);

            listaDetalleActividades = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDetalleActividades;
    }

    @Override
    public List<Object> listarComponentesDocentesAutoresEva(BigDecimal peId, BigDecimal doId) {
        List<Object> listaComponentesParalelos = null;
        try {

            Session session = sessionFactory.getCurrentSession();

            String HQL_QUERY = "SELECT DISTINCT adc.tdiOfertaNsga.onsId "
                    + ",adc.tdiComponenteEducativo.ceCodigo "
                    + ",adc.tdiComponenteEducativo.ceNombre "
                    + ",adc.tdiGlosario.dicNombre "
                    + "FROM TheActividadesDocEvaCab adc "
                    + "WHERE adc.tdiPeriodo.peId = :peId "
                    + "AND adc.tdiDocente.doId = :doId "
                    + "AND adc.tdiGlosario.dicNombre = 'A1' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND adc.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion = 0 "
                    + "AND adc.tdiExcepciones.texId IS NULL "
                    + "AND adc.aecVigente = 'S' "
                    + "ORDER BY adc.tdiComponenteEducativo.ceNombre, adc.tdiGlosario.dicNombre ";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("doId", doId);

            listaComponentesParalelos = query.list();

        } catch (HibernateException e) {
            e.getMessage();
        }
        return listaComponentesParalelos;
    }

    @Override
    public String ultimaFechaActualizacion() {
        String ultima_actualizacion = null;

        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT fil.filDescripcion "
                    + "FROM TdsFiltrosUgda fil "
                    + "WHERE fil.filCodigo = 0 "
                    + "AND fil.filModulo = 'APP_DOCENTES_ULTIMA_EJECUCION_EVA' "
                    + "AND fil.filAplicacion = 'DOCENTES' "
                    + "AND fil.filVigencia = 'S' ";

            Query query = session.createQuery(HQL_QUERY);
            ultima_actualizacion = (String) query.uniqueResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return ultima_actualizacion;
    }

    /*
    Métodos para el periodo Oct/2017-Feb/2018    
     */
    @Override
    public List<Object> listarPlanificacionEVA(BigDecimal peId, BigDecimal onsId) {
        List<Object> tdpi = null;

        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT DISTINCT dpi.tdiParametrosIndicador.tdiPeriodoDetalle.tdiPeriodo.peId "
                    + ",dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + ",dpi.onsId "
                    + ",(CASE WHEN dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' THEN 'SEMANA' END) "
                    + ",dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion "
                    + ",dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio "
                    + ",dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 185 THEN dpi.dpiCantidadObjetivo END) as Anuncios "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 186 THEN dpi.dpiCantidadObjetivo END) as Foros "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 135 THEN dpi.dpiCantidadObjetivo END) as Wikis "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 194 THEN dpi.dpiCantidadObjetivo END) as ChatsPermanente "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 187 THEN dpi.dpiCantidadObjetivo END) as ChatAcademio "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 135 THEN dpi.dpiCantidadObjetivo END) as Videoconferencias "
                    + ",MAX(CASE WHEN dpi.tdiParametrosIndicador.tdiIndicador.idId = 189 THEN dpi.dpiCantidadObjetivo END) as Cuestionarios "
                    + "FROM TdiDetParametrosIndicador dpi "
                    + "WHERE dpi.tdiParametrosIndicador.tdiPeriodoDetalle.tdiPeriodo.peId = :peId "
                    + "AND dpi.onsId = :onsId "
                    + "AND dpi.tdiParametrosIndicador.tdiPeriodoDetalle.tdiModalidad = 2 "
                    + "AND dpi.tdiParametrosIndicador.tdiPeriodoDetalle.tdiNivelAcademico = 1 "
                    + "AND dpi.dpiEsMetacurso = 'N' "
                    + "AND dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia = 'SM' "
                    + "AND dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion BETWEEN 1 AND 16 "
                    + "GROUP BY dpi.tdiParametrosIndicador.tdiPeriodoDetalle.tdiPeriodo.peId "
                    + "         ,dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptId "
                    + "         ,dpi.onsId "
                    + "         ,dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFrecuencia "
                    + "         ,dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptNumeracion "
                    + "         ,dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaInicio "
                    + "         ,dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptFechaFin "
                    + "ORDER BY dpi.tdiParametrosIndicador.tdiPeriodoDetalle.ptId asc ";

            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("peId", peId);
            query.setParameter("onsId", onsId);
            tdpi = query.list();
        } catch (HibernateException e) {
            e.getMessage();
        }
        return tdpi;
    }

}
