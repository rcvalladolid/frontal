/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.svied.dao.impl;

import ec.edu.utpl.svied.security.AbstractDao;
import ec.edu.utpl.svied.dao.LoginDao;
import ec.edu.utpl.svied.model.TdsRegistroAccesosUgda;
import ec.edu.utpl.svied.model.TdsUsuarioUgda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rcvalladolid
 */
@Repository("loginDao")
public class LoginDaoImpl extends AbstractDao<Integer, TdsUsuarioUgda> implements LoginDao {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LoginDaoImpl() {
    }

    @Override
    public TdsUsuarioUgda getUserUsername(String username) {

        TdsUsuarioUgda tdsUsuarioUgda = new TdsUsuarioUgda();

        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("usuUsername", username));
            tdsUsuarioUgda = (TdsUsuarioUgda) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return tdsUsuarioUgda;
    }

    @Override
    public List<TdsUsuarioUgda> listaUsuariosUgda() {

        List<TdsUsuarioUgda> users = new ArrayList<>();

        try {

            Criteria criteria = createEntityCriteria().addOrder(Order.asc("usuNombres"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); //Evitar duplicados
            users = (List<TdsUsuarioUgda>) criteria.list();

        } catch (HibernateException e) {
            e.getMessage();
        }

        return users;

    }

    @Override
    public void eliminarUsuario(String identificacion) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "delete from TdsUsuarioUgda where usuIdentificacion = :identificacion ";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("identificacion", identificacion);
            query.executeUpdate();

        } catch (HibernateException e) {
            e.getMessage();
        }
    }    

    @Override
    public BigDecimal maximoLogInsertado() {
        BigDecimal max_logs = new BigDecimal(0);                

        try {
            Session session = sessionFactory.getCurrentSession();
            String HQL_QUERY = "SELECT MAX(rac.racId)+1 "
                    + "FROM TdsRegistroAccesosUgda rac ";                    

            Query query = session.createQuery(HQL_QUERY);            
            max_logs = (BigDecimal) query.uniqueResult();                        

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return max_logs;
    }

    @Override
    public void insertarRegistros(TdsRegistroAccesosUgda registroAccesosUgda) {

        Session session = sessionFactory.openSession();
        
        try {                                    
            
            Transaction tx = session.beginTransaction();            
            session.save(registroAccesosUgda);
            tx.commit();
                    
        } catch (HibernateException e) {
            e.printStackTrace();            
        } catch (Exception e) {
            e.printStackTrace();            
        } finally{
            session.close();
        }
    }

}
