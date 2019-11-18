/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.CampanhaBO;
import business.VacinaBO;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CadCampanha", urlPatterns = {"/cadcampanha"})
public class CadCampanha extends HttpServlet {

    private final CampanhaBO campanhabo = new CampanhaBO();
    private final VacinaBO vacinabo = new VacinaBO();
    String mensagemErro = null;
    String mensagemSucesso = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
        
        if(Objects.nonNull  (req.getParameter("cadastrar"))){
        
        try{
            
        campanhabo.IncluirCampanhas(
                                        req.getParameter("descricaocampanha"),
                                        req.getParameter("estadousuarios"),                                                                       
                                        req.getParameter("vacinacampanha"),
                                        req.getParameter("datainicio"),
                                        req.getParameter("datafim"));    
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
                    + "<strong> Erro ao cadastrar "+e.getMessage()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");

        }
            
        
        
    }else if(Objects.nonNull(req.getParameter("excluir"))){
         //Tratando exclusão
            if(campanhabo.excluirCampanha(req.getParameter("idcampanha"))){
                req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Excluido com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                
            }else{
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao Excluir! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");                
            }
        
    }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("campanhaEditando",campanhabo.getCampanha(req.getParameter("idcampanha")));
    }else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar            
            try{
            campanhabo.alterarCampanha( req.getParameter("idcampanha"),
                                        req.getParameter("descricaocampanha"),
                                        req.getParameter("estadousuarios"),                                                                       
                                        req.getParameter("vacinacampanha"),
                                        req.getParameter("datainicio"),
                                        req.getParameter("datafim"));   
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
                    + "<strong> Erro ao Alterar"+e.getMessage()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
    }
        try{
            req.setAttribute("campanha", campanhabo.getCampanhas());
            req.setAttribute("vacinacampanhas",vacinabo.getVacinas());
            
        }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        }
        req.getRequestDispatcher("jsp/cadcampanhas.jsp").forward(req, resp);
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        
        
        try{
            req.setAttribute("campanha", campanhabo.getCampanhas());
                        req.setAttribute("vacinacampanhas",vacinabo.getVacinas());

            
        }catch(Exception e){
           req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
        }
        
 req.getRequestDispatcher("jsp/cadcampanhas.jsp").forward(req, resp);
       
        
    }


}
