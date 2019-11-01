/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class EstadoBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    public List<Estado> getEstados(){
        List<Estado> estados;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        estados = en.createQuery("from Estado").getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();
        
        return estados;
    }
}
