/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import business.DoencaBO;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Caddoenca", urlPatterns = {"/caddoenca"})
public class Caddoenca extends HttpServlet {
    private DoencaBO doencaBO = new DoencaBO();
    String mensagemErro = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull  (req.getParameter("cadastrar"))){
        
        try{
            
        doencaBO.IncluirDoenca(req.getParameter("doenca"));
        req.setAttribute("mensagemSucesso","Doenca adicionada com sucesso!" );
        
        
        }catch(Exception e){
            mensagemErro = "Erro ao adicionar Doenca "+e.getMessage();
        }
            
        
        
    }else if(Objects.nonNull(req.getParameter("excluir"))){
         //Tratando exclusão
            if(doencaBO.excluirDoenca(req.getParameter("iddoenca"))){
                req.setAttribute("mensagemSucesso", "Doenca Excluida com Sucesso!");
                
            }else{
                req.setAttribute("mensagemErro", "Erro ao excluir! <br>Verifique se a DOENCA em questão, está relacionada com alguma VACINA!");                
            }
        
    }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("doencaEditando",doencaBO.getDoenca(req.getParameter("iddoenca")));
    }else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar            
            try{
            doencaBO.alterarDoenca( req.getParameter("doenca"),                                
                                    req.getParameter("iddoenca"));
            req.setAttribute("mensagemSucesso", "Alterado com Sucesso!");
            }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro ao Alterar "+e.getMessage());
            }
    }
        try{
            req.setAttribute("doenca", doencaBO.getDoencas());
            
        }catch(Exception e){
            mensagemErro = "Erro ao listar Doencas "+ e.getMessage();
        }
        req.getRequestDispatcher("jsp/cadastrodoenca.jsp").forward(req, resp);
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setAttribute("doenca", doencaBO.getDoencas());
            
        }catch(Exception e){
            mensagemErro = "Erro ao listar Doencas "+ e.getMessage();
        }
        req.getRequestDispatcher("jsp/cadastrodoenca.jsp").forward(req, resp);
    }


}
