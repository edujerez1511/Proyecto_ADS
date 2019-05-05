/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import hibernate.Usuario;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author eduje
 */
public class UsuarioDAO {
    
    public Usuario autenticar(Usuario usuario){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.flush();
        
        Query query = session.createQuery("Select u from Usuario u where u.user = :user and u.pass = :pass");
        query.setString("user", usuario.getUser());
        query.setString("pass", usuario.getPass());
        
        for(Object user : query.list()){
            Hibernate.initialize(((Usuario)user));
            session.close();
            return (Usuario)user;
        }
        
     
        return null;
    }
    
}