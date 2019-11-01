/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Campanhas;
import entity.Estado;
import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class CampanhaBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    
    
    
public List<Campanhas> getCampanhas(){       
        List<Campanhas> campanha;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
       campanha  = en.createQuery("from Campanhas").getResultList();
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return campanha;
    
    }
    public void IncluirCampanhas(String descricaocampanha, String estadousuarios, String datacampanha,String datacampanhafim){
        EntityManager en = emf.createEntityManager();  
        
        en.getTransaction().begin();
        
        Campanhas campanhas = new Campanhas();
        campanhas.setDescricaocampanha(descricaocampanha);
        
        campanhas.setDatacampanha(datacampanha);
        campanhas.setDatacampanhafim(datacampanhafim);
        Estado estado = en.find(Estado.class, Integer.valueOf(estadousuarios));
        campanhas.setEstadousuarios(estado);
        
       
        
        
        en.persist(campanhas);
        
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    public Boolean excluirCampanha(String idcampanha){
        try{
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            
            Campanhas campanhas = en.getReference(Campanhas.class, Long.valueOf(idcampanha));
            en.remove(campanhas);
            
            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao excluir Camapanha de id "+idcampanha +" :"+ e.getMessage() );
            return false;            
        }
    }
    
    public Campanhas getCampanha(String idcampanha){
        
        Campanhas campanha;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            campanha = en.find(Campanhas.class,Long.valueOf(idcampanha));
            
            en.getTransaction().commit();
            
            en.close();
            return campanha;
        
    }
    
    public void alterarCampanha(String idcampanha, String descricaocampanha, String estadousuarios, String datacampanha, String datacampanhafim){
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
       
        Campanhas campanhas = en.find(Campanhas.class, Long.valueOf(idcampanha));
        campanhas.setDescricaocampanha(descricaocampanha);
        campanhas.setDatacampanha(datacampanha);
        campanhas.setDatacampanhafim(datacampanhafim);
        Estado estado = en.find(Estado.class, Integer.valueOf(estadousuarios));
        campanhas.setEstadousuarios(estado);
       
        
        en.merge(campanhas);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
     
    public static Usuario getEstadoUsuario(String estadousuarios) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario EstadoUsuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.estado =:estadousuarios").setParameter("estadousuarios", estadousuarios).getSingleResult();
        
        em.getTransaction().commit();
        em.close();

        return EstadoUsuario;

    }
    
    
    
}
