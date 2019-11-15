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
    public List<Grupo> EstadoeGrupo(String estado){
        List<Grupo> grupo;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        grupo = en.createQuery("select distinct es.estado , gr.grupo, count(gr.grupo) from Grupo gr join Usuario us on gr.idgrupo=us.grupos join Estado es on es.idestado = us.estado where es.idestado=:estado group by gr.grupo order by gr.grupo").setParameter("estado", Integer.valueOf(estado)).getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();
        
        return grupo;
    }
}

