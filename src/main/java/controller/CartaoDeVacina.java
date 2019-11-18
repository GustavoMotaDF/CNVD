/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.VacinaTomadaBO;
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
 * @author Gusta
 */
@WebServlet(name = "CartaoDeVacina", urlPatterns = {"/cartaodevacina"})
public class CartaoDeVacina extends HttpServlet {

     
    private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        
        if (Objects.nonNull(req.getParameter("pesquisar"))) {
            try{
        req.setAttribute("cartao",vacinatomadabo.RelatorioSangue(req.getParameter("cpf")));
            }catch(Exception erro){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Sem resultado para o CPF informado! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 15000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
        }
         req.getRequestDispatcher("jsp/VisualizarCartaoVacina.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        if (Objects.nonNull(req.getParameter("pesquisar"))) {
            
            try{
            req.setAttribute("cartao",vacinatomadabo.RelatorioSangue(req.getParameter("cpf")));         
            }catch(Exception erro){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Sem resultado para o CPF informado! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 15000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
        
        }
         req.getRequestDispatcher("jsp/VisualizarCartaoVacina.jsp").forward(req, resp);
    }

}
