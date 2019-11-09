/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Grupo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gusta
 */
public class GrupoBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    public List<Grupo> getGrupos(){
        List<Grupo> grupo;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        grupo = en.createQuery("from Grupo").getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();
        
        return grupo;
    }
}

