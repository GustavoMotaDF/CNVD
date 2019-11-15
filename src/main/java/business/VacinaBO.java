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
public class VacinaBO {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("estadoPU");

    public List<Vacina> getVacinas() {
        try{
            List<Vacina> vacinas;

            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();

            vacinas = en.createQuery("from Vacina where ativo=1").getResultList();
            en.getTransaction().commit();

            en.clear();
            en.close();
            
            return vacinas;
        }catch(Exception e){
            System.err.println("Erro ao excluirlistar vacinas: Erro "+ e.getMessage() );
            return null;
        }
        
    }

    public void IncluirVacina(String vacina, String iddoenca) {
       try{
            EntityManager en = emf.createEntityManager();

            en.getTransaction().begin();


            Vacina vacinas = new Vacina();

            vacinas.setVacina(vacina);
            
            Doenca doencas = en.find(Doenca.class, Integer.valueOf(iddoenca));
            vacinas.setDoenca(doencas);

            en.persist(vacinas);

            en.getTransaction().commit();
            en.clear();
            en.close();
       }catch(Exception e){
           System.err.println("Erro ao cadastrar vacina: Erro "+ e.getMessage() );
       }
    }
    public Boolean excluirVacina(String idvacina){
        try{
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            
            Vacina vacina = en.getReference(Vacina.class, Integer.valueOf(idvacina));
            en.remove(vacina);
            
            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao excluir vacina de id "+idvacina +" :"+ e.getMessage() );
            return false;            
        }
    }
    public Vacina getVacina(String idvacina /*,String iddoenca*/){
        Vacina vacina;
        //Doenca doenca;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            vacina = en.find(Vacina.class,Integer.valueOf(idvacina));
            //doenca = en.find(Doenca.class,Integer.valueOf(iddoenca));
            //vacina.setDoenca(doenca);
            en.getTransaction().commit();
            
            en.close();
            return vacina;
        
    }
    
    public void alterarVacina(String idvacina, String vacina, String iddoenca){
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        Vacina vacinas = en.find(Vacina.class, Integer.valueOf(idvacina));
        vacinas.setVacina(vacina);
        Doenca doencas = en.find(Doenca.class, Integer.valueOf(iddoenca));
        vacinas.setDoenca(doencas);
        
        en.merge(vacinas);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    
    
    public List<Vacina> getpesquisaVacina() {
        try{
            List<Vacina> vacinas;

            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();

            vacinas = en.createQuery("from Vacina where vacina like'% %'").getResultList();
            en.getTransaction().commit();

            en.clear();
            en.close();
            
            return vacinas;
        }catch(Exception e){
            System.err.println("Erro ao excluirlistar vacinas: Erro "+ e.getMessage() );
            return null;
        }
        
    }
    
    
}
