/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Autenticacao;
import entity.Usuario;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class AutenticacaoBO {
    private static final EntityManagerFactory emf = 
                         Persistence.createEntityManagerFactory("estadoPU");
    
   
    
    public void Incluirautenticacao(String datalogin, String idusuario){
        EntityManager en = emf.createEntityManager();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        en.getTransaction().begin();       
        
        Autenticacao autenticacao = new Autenticacao();
        
        
        /*autenticacao.setDatalogin(datalogin); implementar//*/
        
        
        Usuario usuario = en.find(Usuario.class, Integer.valueOf(idusuario));
        autenticacao.setUsuarios(usuario);
        
        en.persist(autenticacao); 
        
        
        en.getTransaction().commit();
        
        en.close();
    }
    public List<Autenticacao> getAutenticacao(){
          
        
        List<Autenticacao> autenticacaos;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        autenticacaos = en.createQuery("from Autenticacao").getResultList();
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return autenticacaos;
}

    
}
