/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class LoginBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("estadoPU");
    
    public static Usuario getLogin(String login, String senha) throws Exception {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Usuario Login = null;  
        Login = (Usuario) em.createQuery("from Usuario where login =:login and senha = :senha").setParameter("login", login).setParameter("senha", senha).getSingleResult();
        
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null){
          throw new Exception("Sem resultado");
                    
         }

        return Login;

    }
    
}
