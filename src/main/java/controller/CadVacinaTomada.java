/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.VacinaTomadaBO;
import business.UsuarioBO;
import business.VacinaBO;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CadVacinaTomada", urlPatterns = {"/cadvacinatomada"})
public class CadVacinaTomada extends HttpServlet {
    
    UsuarioBO usuarioBO = new UsuarioBO();
    VacinaBO vacinaBO = new VacinaBO();
    VacinaTomadaBO vacinatomadaBO = new VacinaTomadaBO();
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mensagemErro = "";
        String mensagemSucesso="";
        if (Objects.nonNull(req.getParameter("cadastrar"))) {
            try{
                vacinatomadaBO.IncluirVacinaTomada( req.getParameter("dose"), 
                                                    req.getParameter("idusuario"), 
                                                    req.getParameter("idvacina")
                                                    );
                
                    req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Registro salvo com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }catch(Exception e ){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao Salvar Vacina, tente novamente, caso o erro persista, contate o administrador do sistema "+ e.getMessage()+","+ e.getCause() +" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
               
            }
        
        
                   
        }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("vacinatomadaEditando",vacinatomadaBO.getVacinaTomada(req.getParameter("idvacinatomada")));
        }else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar            
            try{
            vacinatomadaBO.alterarVacinaTomada(     req.getParameter("idvacinatomada"),
                                                    req.getParameter("dose"),
                                                    req.getParameter("idusuario"), 
                                                    req.getParameter("idvacina"));
            req.setAttribute("mensagemSucesso", "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Registro Alterado com Sucesso! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }catch(Exception e){
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro ao Alterar "+e.getCause().getLocalizedMessage()+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
    }
        try{
            req.setAttribute("vacinatomada", vacinatomadaBO.getVacinasTomadas());
            req.setAttribute("vacina", vacinaBO.getVacinas());
            req.setAttribute("usuario", usuarioBO.getUsuarios());
            
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
        req.getRequestDispatcher("jsp/cadvacinatomada.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String mensagemErro = "";
        try{
            req.setAttribute("vacinatomada", vacinatomadaBO.getVacinasTomadas());
            req.setAttribute("vacina", vacinaBO.getVacinas());
            req.setAttribute("usuario", usuarioBO.getUsuarios());
            
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
        req.getRequestDispatcher("jsp/cadvacinatomada.jsp").forward(req, resp);
        
    }

}
