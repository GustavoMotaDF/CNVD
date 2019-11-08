/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.DoencaBO;
import business.VacinaBO;
import business.VacinaTomadaBO;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Relatorios", urlPatterns = {"/relatorios"})
public class Relatorios extends HttpServlet {
    
    private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("cartao",vacinatomadabo.RelatorioSangue());
        
         req.getRequestDispatcher("jsp/testeusuario.jsp").forward(req, resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("cartao",vacinatomadabo.RelatorioSangue());
        
         req.getRequestDispatcher("jsp/testeusuario.jsp").forward(req, resp);
    }

}
