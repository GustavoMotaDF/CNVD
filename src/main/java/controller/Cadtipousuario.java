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
import business.TipoUsuarioBO;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Cadtipousuario", urlPatterns = {"/cadtipousuario"})
public class Cadtipousuario extends HttpServlet {
    private TipoUsuarioBO tipousuarioBO = new TipoUsuarioBO();
String mensagemErro = null;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull  (req.getParameter("cadastrar"))){
        
        try{
            
        tipousuarioBO.IncluirTipousuario(req.getParameter("tipousuario"));
        req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Cadastrado com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        
        }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao cadastrar "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        }
            
        
        
    }else if(Objects.nonNull(req.getParameter("excluir"))){
         //Tratando exclusão
            try{tipousuarioBO.excluirTipousuario(req.getParameter("idtipousuario"));
                req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Excluido com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                
            }catch(Exception e){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao excluir! Verifique se o Tipo de Usuario em questão, está relacionado com algum Usuario! "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                 }
        
    }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("tipousuarioEditando",tipousuarioBO.getTipoUsuario(req.getParameter("idtipousuario")));
    }else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar            
            try{
            tipousuarioBO.alterarTipoUsuario(req.getParameter("tipousuario"),                                
                                    req.getParameter("idtipousuario"));
            req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Alterado com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao Alterar"+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
    }
        try{
            req.setAttribute("tipousuario", tipousuarioBO.getTipoUsuarios());
            
        }catch(Exception e){
           req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        }
        req.getRequestDispatcher("jsp/cadtipodeusuario.jsp").forward(req, resp);
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setAttribute("tipousuario", tipousuarioBO.getTipoUsuarios());
            
        }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        }
        req.getRequestDispatcher("jsp/cadtipodeusuario.jsp").forward(req, resp);
    }

}
