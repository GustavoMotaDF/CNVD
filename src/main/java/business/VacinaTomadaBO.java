/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.VacinaTomada;
import entity.Usuario;
import entity.Vacina;
import java.lang.reflect.Array;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author gustavo
 */
public class VacinaTomadaBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    
   
    public List<VacinaTomada> getVacinasTomadas(){
        
        
        List<VacinaTomada> qtdVacinas;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        qtdVacinas = en.createQuery("From VacinaTomada").getResultList();
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return qtdVacinas;
    
    }
    public void IncluirVacinaTomada(String datavacinacao, String dose, String idusuario, String idvacina){
        EntityManager en = emf.createEntityManager();
        
        en.getTransaction().begin();
        
        VacinaTomada cartaovacina = new VacinaTomada();
        
        cartaovacina.setDatavacinacao(datavacinacao);
        cartaovacina.setDose(dose);
        
        Usuario usuario = en.find(Usuario.class, Integer.valueOf(idusuario));
        cartaovacina.setUsuario(usuario);
        
        Vacina vacina = en.find(Vacina.class, Integer.valueOf(idvacina));
        cartaovacina.setVacinas(vacina);
        
        en.persist(cartaovacina);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    public Boolean excluirVacinaTomada(String idvacinatomada){
        try{
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            
            VacinaTomada cartavacina = en.getReference(VacinaTomada.class, Integer.valueOf(idvacinatomada));
            en.remove(cartavacina);
            
            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        }catch(Exception e){
            
            System.err.println("Erro ao excluir Cartão de Vacina: Erro "+ e.getMessage() );
            return false;            
        }
    }
    
    public VacinaTomada getVacinaTomada(String idvacinatomada){
        
        VacinaTomada cartavacina;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            cartavacina = en.find(VacinaTomada.class,Integer.valueOf(idvacinatomada));
            
            en.getTransaction().commit();
            
            en.close();
            return cartavacina;
        
    }
    
    public void alterarVacinaTomada(String idvacinatomada, String datavacinacao, String dose, String idusuario, String idvacina){
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
       
        VacinaTomada cartavacina = en.find(VacinaTomada.class, Integer.valueOf(idvacinatomada));
        cartavacina.setDatavacinacao(datavacinacao);
        cartavacina.setDose(dose);
        
        Vacina vacina = en.find(Vacina.class, Integer.valueOf(idvacina));
        cartavacina.setVacinas(vacina);
        
        en.merge(cartavacina);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    //TESTE BUSCAR VACINAS TOMADAS POR ID DE USUARIO; RESULTADO TEM QUE SER LISTA
 
        
    public List<VacinaTomada> Relatorio(){
        List<VacinaTomada> cartaovacinas;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        cartaovacinas = en.createQuery("select distinct id_vacina as Vacinas, count(id_vacina) as qtd from VacinaTomada id_vacina group by vacinas order by qtd desc ").getResultList();
               
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return cartaovacinas;
}

    
}


