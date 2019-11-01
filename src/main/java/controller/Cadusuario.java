/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
import java.util.HashSet;
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import business.EstadoBO;

import business.TipoUsuarioBO;
import business.UsuarioBO;


/**
 *
 * @author gustavo
 */
@WebServlet(name = "Cadestado", urlPatterns = {"/cadusuario"})
public class Cadusuario extends HttpServlet {
    
     private final UsuarioBO usuarioBO = new UsuarioBO();
     private final TipoUsuarioBO tipousuarioBO= new TipoUsuarioBO();
      
     private final EstadoBO estadoBO = new EstadoBO();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        req.setAttribute("usuarios",usuarioBO.getUsuarios());
        req.setAttribute("tipousuarios", tipousuarioBO.getTipoUsuarios());
        
        req.setAttribute("estados", estadoBO.getEstados());
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/cadastrousuario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mensagemErro = "";
        
        
        if (Objects.nonNull(req.getParameter("cadastrar"))) {
            try{
                usuarioBO.IncluirUsuario(req.getParameter("bairro"),/*bairro*/
                                         req.getParameter("cep"), /*cepl*/
                                         req.getParameter("cpf"), /*cpf*/
                                         req.getParameter("email"),/*email*/
                                         req.getParameter("localnascimento"),/*localnascimento*/
                                         req.getParameter("logradouro"),/*endereco*/                                      
                                         req.getParameter("nome"),/*nome*/
                                         req.getParameter("rg"),/*rg*/
                                         req.getParameter("telefone"),/*tel*/
                                         req.getParameter("login"),                                    
                                         req.getParameter("senha"),
                                         req.getParameter("numerocasa"),/*numerocasa*/                                       
                                         
                                         req.getParameter("idtipousuarios"),
                                         req.getParameter("idestado"),/*estado*/
                                         req.getParameter("cidade"),/*cidade*/
                                         req.getParameter("sexo"),/*sexo*/
                                         req.getParameter("datanascimento"),
                                         req.getParameter("tiporesidencia"),
                                         req.getParameter("tiposanguineo"),
                                         req.getParameter("alergia")
                );/*datanascimento*/
                
                
                                         req.setAttribute("mensagemSucesso", "USUARIO Cadastrado com sucesso!");
            }catch(Exception e){
                req.setAttribute("mensagemErro", "Erro ao cadastrar USUARIO" + e.getMessage()+")");
            }   
            
        }else if(Objects.nonNull(req.getParameter("excluir"))){
            //Tratando exclusão
            if(usuarioBO.excluirUsuario(req.getParameter("idusuario"))){
                req.setAttribute("mensagemSucesso", "USUARIO Excluida com Sucesso!");
                
            }else{
                req.setAttribute("mensagemErro", "Erro ao excluir USUARIO!");
                
            }
            
        }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            try{
                req.setAttribute("usuarioEditando",usuarioBO.getUsuario(req.getParameter("idusuario")));

            }catch(Exception e){
                req.setAttribute("erroBD","Sem resultado para a pesquisa!");
            }
        } else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar
            
            try{
                usuarioBO.alterarAluno(  req.getParameter("idusuario"),
                                         req.getParameter("bairro"),
                                         req.getParameter("cep"), 
                                         req.getParameter("cpf"), 
                                         req.getParameter("email"),/*email*/
                                         req.getParameter("localnascimento"),
                                         req.getParameter("logradouro"),                                         
                                         req.getParameter("nome"),
                                         req.getParameter("rg"),
                                         req.getParameter("telefone"),
                                         req.getParameter("login"),                                    
                                         req.getParameter("senha"),
                                         req.getParameter("numerocasa"),                                          
                                          
                                         req.getParameter("idtipousuarios"),
                                         req.getParameter("idestado"),
                                         req.getParameter("cidade"),
                                         req.getParameter("sexo"),
                                         req.getParameter("datanascimento"),
                                         req.getParameter("tiporesidencia"),
                                         req.getParameter("tiposanguineo"),
                                         req.getParameter("alergia"));               
                                         
                
                                         req.setAttribute("mensagemSucesso", "USUARIO Alterado com sucesso!");                                         
                                         
            }catch(Exception e){
                req.setAttribute("mensagemErro", "Erro ao Alterar USUARIO" + e.getMessage()+")");
            }   
        }
        
        try{
        req.setAttribute("usuarios",usuarioBO.getUsuarios());
        req.setAttribute("tipousuarios", tipousuarioBO.getTipoUsuarios());        
        req.setAttribute("estados", estadoBO.getEstados());
        
     
        
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/cadastrousuario.jsp").forward(req, resp);

    
    
    
    
    
    

    }       
}
