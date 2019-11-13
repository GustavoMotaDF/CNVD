/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.LoginBO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Mensagem = "";


        try {
            LoginBO.getLogin(req.getParameter("login"), req.getParameter("senha"));
                        
            req.getRequestDispatcher("jsp/inicio.jsp").forward(req, resp);
            
            
        } catch (Exception e) {

            Mensagem = "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Login ou Senha Incorreto! </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>";
            
            String msg="<style>\n" +
"body {font-family: Arial, Helvetica, sans-serif;}\n" +
"\n" +
"/* The Modal (background) */\n" +
".modal {\n" +
"  display: block; /* Hidden by default */\n" +
"  position: fixed; /* Stay in place */\n" +
"  z-index: 1; /* Sit on top */\n" +
"  padding-top: 100px; /* Location of the box */\n" +
"  left: 0;\n" +
"  top: 0;\n" +
"  width: 100%; /* Full width */\n" +
"  height: 100%; /* Full height */\n" +
"  overflow: auto; /* Enable scroll if needed */\n" +
"  background-color: rgb(0,0,0); /* Fallback color */\n" +
"  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n" +
"}\n" +
"\n" +
"/* Modal Content */\n" +
".modal-content {\n" +
"  background-color: #fefefe;\n" +
"  margin: auto;\n" +
"  padding: 20px;\n" +
"  border: 1px solid #888;\n" +
"  width: 50%; border-radius:20px\n" +
"}\n" +
"\n" +
 "h3{"+
  "color: red; text-align: center; }"+                  
"/* The Close Button */\n" +
".close {\n" +
"  color: #aaaaaa;\n" +
"  float: right;\n" +
"  font-size: 28px;\n" +
"  font-weight: bold;\n" +
"}\n" +
"\n" +
".close:hover,\n" +
".close:focus {\n" +
"  color: #000;\n" +
"  text-decoration: none;\n" +
"  cursor: pointer;\n" +
"}\n" +
"</style>\n" +


"\n" +

"\n" +
"<!-- Trigger/Open The Modal -->\n" +

"\n" +
"<!-- The Modal -->\n" +
"<div id=\"myModal\" class=\"modal\">\n" +
"\n" +
"  <!-- Modal content -->\n" +
"  <div class=\"modal-content\">\n" +
"    <span class=\"close\">&times;</span>\n" +
"    <p><h3>Senha incorreta ou usuario invalido!</h3></p>\n" +
"  </div>\n" +
"\n" +
"</div>\n" +
"\n" +
"<script>\n" +
"// Get the modal\n" +
"var modal = document.getElementById(\"myModal\");\n" +
"\n" +
"// Get the button that opens the modal\n" +

"\n" +
"// Get the <span> element that closes the modal\n" +
"var span = document.getElementsByClassName(\"close\")[0];\n" +
"\n" +
"// When the user clicks the button, open the modal \n" +

"\n" +
"// When the user clicks on <span> (x), close the modal\n" +
"span.onclick = function() {\n" +
"  modal.style.display = \"none\";\n" +
"}\n" +
"\n" +
"// When the user clicks anywhere outside of the modal, close it\n" +
"window.onclick = function(event) {\n" +
"  if (event.target == modal) {\n" +
"    modal.style.display = \"none\";\n" +
"  }\n" +
"}\n" +
"</script>";

            req.setAttribute("mensagem", msg);
            req.setAttribute("mensagem1", Mensagem);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }

    

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/inicio.jsp").forward(req, resp);
    }
    
}
