/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.service.impl;

import ec.edu.utpl.svied.dao.LoginDao;
import ec.edu.utpl.svied.model.TdsRegistroAccesosUgda;
import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import ec.edu.utpl.svied.service.LoginService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcvalladolid
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;   

    @Override
    public TdsUsuarioUgda getUserUsername(String username) {        

        return loginDao.getUserUsername(username);
    }    

    @Override
    public List<TdsUsuarioUgda> listaUsuariosUgda() {
        return loginDao.listaUsuariosUgda();
    }

    @Override
    public void eliminarUsuario(String identificacion) {
        loginDao.eliminarUsuario(identificacion);
    }

    @Override
    public BigDecimal maximoLogInsertado() {
        return loginDao.maximoLogInsertado();
    }

    @Override
    public void insertarRegistros(TdsRegistroAccesosUgda registroAccesosUgda) {
        loginDao.insertarRegistros(registroAccesosUgda);
    }

}
