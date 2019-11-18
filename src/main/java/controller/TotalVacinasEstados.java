/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.UsuarioBO;
import business.VacinaTomadaBO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TotalVacinasEstados", urlPatterns = {"/totalVacinasEstados"})
public class TotalVacinasEstados extends HttpServlet {
    private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
         
         
         try{
        req.setAttribute("cartaovacinas", vacinatomadabo.RelatorioTotalEstados());
        
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
        
        
        req.getRequestDispatcher("jsp/totalVacinasEstados.jsp").forward(req, resp);
    }


}
