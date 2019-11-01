/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


import entity.Doenca;
import entity.Vacina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class DoencaBO {
     private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    
   
    public List<Doenca> getDoencas(){
        
        
        List<Doenca> doencas;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        doencas = en.createQuery("from Doenca ").getResultList();
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return doencas;
    
    }
    public void IncluirDoenca(String doenca){
        EntityManager en = emf.createEntityManager();
        
        en.getTransaction().begin();
        
        Doenca doencas = new Doenca();
        
        doencas.setDoenca(doenca);
        
        
        en.persist(doencas);
        
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    public Boolean excluirDoenca(String iddoenca){
        try{
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            
            Doenca doenca = en.getReference(Doenca.class, Integer.valueOf(iddoenca));
            en.remove(doenca);
            
            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao excluir doenca de id "+iddoenca +" :"+ e.getMessage() );
            return false;            
        }
    }
    
    public Doenca getDoenca(String iddoenca){
        
        Doenca doenca;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            doenca = en.find(Doenca.class,Integer.valueOf(iddoenca));
            
            en.getTransaction().commit();
            
            en.close();
            return doenca;
        
    }
    
    public void alterarDoenca(String doenca, String iddoenca){
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
       
        Doenca doencas = en.find(Doenca.class, Integer.valueOf(iddoenca));
        doencas.setDoenca(doenca);
       
        
        en.merge(doencas);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    public List<Doenca> Relatorio(){
        
        
        List<Doenca> doencas;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        doencas = en.createQuery("sefrom Doenca ").getResultList();
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return doencas;
    }
}
