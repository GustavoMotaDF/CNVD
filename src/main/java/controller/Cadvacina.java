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
import business.VacinaBO;
import business.DoencaBO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CadVacina", urlPatterns = {"/cadvacina"})
public class Cadvacina extends HttpServlet {
    private VacinaBO vacinaBO = new VacinaBO(); 
    private DoencaBO doencaBO = new DoencaBO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        
        
        try{
        req.setAttribute("vacinas",vacinaBO.getVacinas());
        req.setAttribute("doencas",doencaBO.getDoencas());
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro "+e.getCause().getCause()+")"+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
        
        
        req.getRequestDispatcher("jsp/cadastrovacina.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        
        if (Objects.nonNull(req.getParameter("cadastrar"))) {
        try{
           
            vacinaBO.IncluirVacina(req.getParameter("vacina"),
                                    req.getParameter("iddoenca"));
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
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");}   
            
            
            
        }else if(Objects.nonNull(req.getParameter("excluir"))){
            //Tratando exclusão
            try{vacinaBO.excluirVacina(req.getParameter("idvacina"));
                req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Excluida com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                
            }catch(Exception e){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao Excluir "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                
            }
            
        }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("vacinaEditando",vacinaBO.getVacina(req.getParameter("idvacina")));
        }
        else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar
            
            try{
            vacinaBO.alterarVacina( req.getParameter("idvacina"),
                                    req.getParameter("vacina"),                                
                                    req.getParameter("iddoenca"));
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
                    + "<strong> Erro ao Alterar "+e.getCause().getCause()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
        }
        
        
        try{
        req.setAttribute("vacinas",vacinaBO.getVacinas());
        req.setAttribute("doencas",doencaBO.getDoencas());
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro "+e.getCause().getCause()+")"+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }

        
        
        req.getRequestDispatcher("jsp/cadastrovacina.jsp").forward(req, resp);
    }

}


