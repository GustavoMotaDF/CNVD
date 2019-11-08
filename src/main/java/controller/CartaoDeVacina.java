/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.VacinaTomadaBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gusta
 */
@WebServlet(name = "CartaoDeVacina", urlPatterns = {"/cartaodevacina"})
public class CartaoDeVacina extends HttpServlet {

     
    private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("cartao",vacinatomadabo.RelatorioSangue());
        
         req.getRequestDispatcher("jsp/VisualizarCartaoVacina.jsp").forward(req, resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("cartao",vacinatomadabo.RelatorioSangue());
        
         req.getRequestDispatcher("jsp/VisualizarCartaoVacina.jsp").forward(req, resp);
    }

}
