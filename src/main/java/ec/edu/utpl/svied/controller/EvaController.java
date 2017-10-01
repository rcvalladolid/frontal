/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ec.edu.utpl.svied.model.TdiPeriodoDetalle;
import ec.edu.utpl.svied.model.TheActividadesDocEvaCab;
import ec.edu.utpl.svied.service.EvaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author rcvalladolid
 */

@RestController
public class EvaController {

    @Autowired
    EvaService evaService;  
    
    @RequestMapping(value = "/eva/jsonListarPeriodosEva", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> listarPeriodosEva() {
        List<Object> objListarPeriodosEva = evaService.servicioListarPeriodosEva();
        try {
            if (objListarPeriodosEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objListarPeriodosEva.size() <= 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {             
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }
        return new ResponseEntity<>(objListarPeriodosEva, HttpStatus.OK);
    }

    @RequestMapping(value = "/eva/jsonListarDocentesEva/[{peId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> listarDocentesEva(@PathVariable BigDecimal[] peId) {
        List<Object> objListarDocentesEva = evaService.listarDocentesEva(peId);
        try {
            if (objListarDocentesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objListarDocentesEva.size() <= 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Object>>(objListarDocentesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonListarComponentesEva/{peId}/{doId}", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Object>> listarComponentesEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId){
        List<Object> objListarComponentesEva = evaService.listarComponentesParalelosEva(peId, doId);
        try {
            if (objListarComponentesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objListarComponentesEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objListarComponentesEva, HttpStatus.OK);
    }

    @RequestMapping(value = "/eva/jsonListarSemanasAcademicasEva/{peId}/{frecuencia}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<?> listarSemanasAcademicasEva(@PathVariable BigDecimal peId, @PathVariable String frecuencia) {
        List<Object> objListarSemanasAcademicasEva = evaService.listarSemanasAcademicasEva(peId, frecuencia);
        if (objListarSemanasAcademicasEva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (objListarSemanasAcademicasEva == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objListarSemanasAcademicasEva, HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/eva/jsonListarRangosSemaforosEva/{peId}/{rango_obtenido}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<?> listarRangosSemaforosEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal rango_obtenido) {
        List<Object> objListarRangosSemaforosEva = evaService.listarRangosSemaforosEva(peId, rango_obtenido);
        if (objListarRangosSemaforosEva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (objListarRangosSemaforosEva == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objListarRangosSemaforosEva, HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/eva/jsonListarSemanaActualEva/{peId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> listarSemanaActualEva(@PathVariable BigDecimal peId) {
        //List<Object> objListarSemanaEva = evaService.semanaActual();
        //List<Object> objListarSemanaMaximaEva = evaService.semanaMaximaEva();
        
        List<Object> semana_actual = new ArrayList<Object>();
                
        if (evaService.semanaActual(peId).size() != 0) {
            semana_actual = evaService.semanaActual(peId);
        }else {
            semana_actual = evaService.semanaMaximaEva(peId);
        }        
        
        try {
            if (semana_actual.isEmpty()) {
                return new ResponseEntity<List<Object>>(HttpStatus.NO_CONTENT);
            } else if (semana_actual == null) {
                return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(semana_actual, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonGraficaActividadesEva/{peId}/{doId}/{idId}/[{onsId}]/{ptId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> graficaActividadesEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal idId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal ptId){
        List<Object> objGraficaActividadesEva = evaService.graficaActividadesEva(peId, doId, idId, onsId, ptId);
        try {
            if (objGraficaActividadesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objGraficaActividadesEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objGraficaActividadesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonSemaforosActividadesEva/{peId}/{doId}/[{onsId}]/[{ptId}]/[{idId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> semaforosActividadesEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] ptId, @PathVariable BigDecimal[] idId){
        List<Object> objSemaforosActividadesEva = evaService.semaforosActividadesEva(peId, doId, onsId, ptId, idId);
        try {
            if (objSemaforosActividadesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objSemaforosActividadesEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(objSemaforosActividadesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonCabeceraActividadesEva/{peId}/{doId}/[{onsId}]/[{ptId}]/[{idId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> cabeceraActividadesEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] ptId, @PathVariable BigDecimal[] idId){
        List<Object> objCabeceraActividadesEva = evaService.cabeceraActividadesEva(peId, doId, onsId, ptId, idId);
        try {
            if (objCabeceraActividadesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objCabeceraActividadesEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objCabeceraActividadesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonDetalleActividadesEva/{peId}/{doId}/[{onsId}]/[{idId}]/{frecuencia}/[{numeracion}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> detalleActividadesEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] idId, @PathVariable String frecuencia, @PathVariable BigDecimal[] numeracion){
        List<Object> objDetalleActividadesEva = evaService.detalleActividadesEva(peId, doId, onsId, idId, frecuencia, numeracion);
        try {
            if (objDetalleActividadesEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objDetalleActividadesEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(objDetalleActividadesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonListarDocentesPrincipalesEva/[{peId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> listarDocentesPrincipalesEva(@PathVariable BigDecimal[] peId) {
        List<Object> objListarDocentesPrincipalesEva = evaService.listarDocentesAutoresEva(peId);
        try {
            if (objListarDocentesPrincipalesEva.isEmpty()) {
                return new ResponseEntity<List<Object>>(HttpStatus.NO_CONTENT);
            } else if (objListarDocentesPrincipalesEva == null) {
                return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objListarDocentesPrincipalesEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonGraficaActividadesDocentePrincipalEva/{peId}/{doId}/[{onsId}]/[{idId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> graficaActividadesDocentePrincipalEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] idId){
        List<Object> objGraficaActividadesDocentePrincipalEva = evaService.graficaActividadesDocentesAutoresEva(peId, doId, onsId, idId);
        try {
            if (objGraficaActividadesDocentePrincipalEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objGraficaActividadesDocentePrincipalEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objGraficaActividadesDocentePrincipalEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonCabeceraActividadesDocentesAutoresEva/{peId}/{doId}/[{onsId}]/[{idId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> cabeceraActividadesDocentesAutoresEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] idId){
        List<Object> objCabeceraActividadesDocentesAutoresEva = evaService.cabeceraActividadesDocentesAutoresEva(peId, doId, onsId, idId);
        try {
            if (objCabeceraActividadesDocentesAutoresEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objCabeceraActividadesDocentesAutoresEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objCabeceraActividadesDocentesAutoresEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonDetalleActividadesDocentePrincipalEva/{peId}/{doId}/[{onsId}]/[{idId}]", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> detalleActividadesDocentePrincipalEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId, @PathVariable BigDecimal[] onsId, @PathVariable BigDecimal[] idId){
        List<Object> objDetalleActividadesDocentePrincipalEva = evaService.detalleActividadesDocentesAutoresEva(peId, doId, onsId, idId);
        try {
            if (objDetalleActividadesDocentePrincipalEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objDetalleActividadesDocentePrincipalEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objDetalleActividadesDocentePrincipalEva, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eva/jsonListarComponentesDocentePrincipalEva/{peId}/{doId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> listarComponentesDocentePrincipalEva(@PathVariable BigDecimal peId, @PathVariable BigDecimal doId){
        List<Object> objListarComponentesDocentePrincipalEva = evaService.listarComponentesDocentesAutoresEva(peId, doId);
        try {
            if (objListarComponentesDocentePrincipalEva.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objListarComponentesDocentePrincipalEva == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objListarComponentesDocentePrincipalEva, HttpStatus.OK);
    }
    
    /*
    Métodos para el periodo Oct/2017-Feb/2018    
     */
    
    @RequestMapping(value = "/eva/jsonListarPlanificacionEVA/{peId}/{onsId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Object>> listarPlanificacionEVA(@PathVariable BigDecimal peId, @PathVariable BigDecimal onsId){
        List<Object> objListarPlanificacionEVA = evaService.listarPlanificacionEVA(peId, onsId);
        try {
            if (objListarPlanificacionEVA.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (objListarPlanificacionEVA == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Object>>(objListarPlanificacionEVA, HttpStatus.OK);
    }
    
    
}
