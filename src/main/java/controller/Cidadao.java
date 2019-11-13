/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.VacinaTomadaBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gusta
 */
@WebServlet(name = "Cidadao", urlPatterns = {"/Cidadao"})
public class Cidadao extends HttpServlet {
private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Mensagem = "";

        if (Objects.nonNull(req.getParameter("Entrar"))) {
        req.setAttribute("cartao",vacinatomadabo.CartaoVacinaPronto(req.getParameter("login"),req.getParameter("senha")));
        }
        else{           

           Mensagem = "<div class=\"alert alert-success\" id=\"foo\">"
                    + "<strong> Login ou Senha Incorreto! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 10000); // O valor é representado em milisegundos.\n" +
                        "});</script>";

        }
         req.getRequestDispatcher("jsp/Cidadao.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if (Objects.nonNull(req.getParameter("Entrar"))) {
        req.setAttribute("cartao",vacinatomadabo.CartaoVacinaPronto(req.getParameter("login"), req.getParameter("senha")));
        }
         req.getRequestDispatcher("jsp/Cidadao.jsp").forward(req, resp);
    }

}
