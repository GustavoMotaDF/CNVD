/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.LoginBO;

import java.io.IOException;
import static java.lang.System.out;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
LoginBO loginbo = new LoginBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        
        String Mensagem = "";
      
        HttpSession sessao = req.getSession();

        if (Objects.nonNull(req.getParameter("Entrar"))) {
            try{
            String login = req.getParameter("login");            

            LoginBO.getLogin(req.getParameter("login"),req.getParameter("senha")).getNome();
            sessao.setAttribute("login", login);
            req.getRequestDispatcher("jsp/inicio.jsp").forward(req, resp);
            
            
        }catch(Exception errologin){

           req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Login ou senha incorretos! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 15000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        
    }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");

        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
           req.getRequestDispatcher("jsp/inicio.jsp").forward(req, resp);
        } 
    }

    
}
