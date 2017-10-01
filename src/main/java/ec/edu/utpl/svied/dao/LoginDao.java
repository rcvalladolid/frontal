/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.dao;

import ec.edu.utpl.svied.model.TdsRegistroAccesosUgda;
import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author rcvalladolid
 */
public interface LoginDao {    
    
    TdsUsuarioUgda getUserUsername(String username);
    
    List<TdsUsuarioUgda> listaUsuariosUgda();
    
    void eliminarUsuario(String identificacion);        
    
    BigDecimal maximoLogInsertado();
    
    void insertarRegistros(TdsRegistroAccesosUgda registroAccesosUgda);
    
}
