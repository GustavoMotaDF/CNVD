/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Usuario;
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
    
    public static Usuario getLogin(String login, String senha) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario Login = (Usuario) em.createQuery("from Usuario where login =:login and senha = :senha").setParameter("login", login).setParameter("senha", senha).getSingleResult();
        
        em.getTransaction().commit();
        em.clear();
        em.close();

        return Login;

    }
    public static Usuario getNome(String login){
        
        Usuario usuario;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            usuario = en.find(Usuario.class,Integer.valueOf(login));
            
            en.getTransaction().commit();
            
            en.close();
            return usuario;
        
    }
}
