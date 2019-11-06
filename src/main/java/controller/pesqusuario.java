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
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "pesqusuario", urlPatterns = {"/pesqusuario"})
public class pesqusuario extends HttpServlet {
        private final UsuarioBO usuariobo = new UsuarioBO();
        private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         req.setAttribute("userEstado",usuariobo.RelatorioUsuarioEstado());
        
        req.getRequestDispatcher("jsp/testeRelatorioUsuario.jsp").forward(req, resp);
    
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userEstado",usuariobo.RelatorioUsuarioEstado());
          
        req.getRequestDispatcher("jsp/testeRelatorioUsuario.jsp").forward(req, resp);
    }
    
    
    
}