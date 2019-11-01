/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Doenca;
import entity.Estado;
import entity.TipoUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class TipoUsuarioBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    
    public List<TipoUsuario> getTipoUsuarios(){
        List<TipoUsuario> tipousuarios;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        tipousuarios = en.createQuery("from TipoUsuario").getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();
        
        return tipousuarios;
    }
    
    public void IncluirTipousuario(String tipousuario){
        EntityManager en = emf.createEntityManager();
        
        en.getTransaction().begin();
        
        TipoUsuario tipousuarios = new TipoUsuario();
        
        tipousuarios.setTipousuario(tipousuario);
        
        
        en.persist(tipousuarios);
        
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
    
    public Boolean excluirTipousuario(String idtipousuario){
        try{
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            
            TipoUsuario tipousuarios = en.getReference(TipoUsuario.class, Integer.valueOf(idtipousuario));
            en.remove(tipousuarios);
            
            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao excluir Tipo de Usuario de id "+idtipousuario +" :"+ e.getMessage() );
            return false;            
        }
    }
    
    public TipoUsuario getTipoUsuario(String idtipousuario){
        
        TipoUsuario tipousuarios;
       
            EntityManager en = emf.createEntityManager();
        
            en.getTransaction().begin();

            tipousuarios = en.find(TipoUsuario.class,Integer.valueOf(idtipousuario));
            
            en.getTransaction().commit();
            
            en.close();
            return tipousuarios;
        
    }
    
    public void alterarTipoUsuario(String tipousuario, String idtipousuario){
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
       
        TipoUsuario tipousuarios = en.find(TipoUsuario.class, Integer.valueOf(idtipousuario));
        tipousuarios.setTipousuario(tipousuario);
       
        
        en.merge(tipousuarios);
        
        en.getTransaction().commit();
        en.clear();
        en.close();
    }
}
