/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Relusuario", urlPatterns = {"/relusuario"})
public class Relusuario extends HttpServlet {
    
    private final UsuarioBO usuarioBO = new UsuarioBO();
    
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        req.setAttribute("usuarios",usuarioBO.getUsuarios());
        
        }catch(Exception e){
           req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                    + "<strong> Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro "+e.getCause().getCause()+")"+" </strong>"
                    + "</div>" 
                    +"<script>$().ready(function() {\n" +
                        "	setTimeout(function () {\n" +
                        "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n" +
                        "	}, 5000); // O valor é representado em milisegundos.\n" +
                        "});</script>");
            }
        
        
        req.getRequestDispatcher("jsp/relusuarios.jsp").forward(req, resp);
    }


}
