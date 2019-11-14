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
import business.VacinaTomadaBO;
import java.util.Objects;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Relvacinasmaisusadasporregiao", urlPatterns = {"/relvacinasmaisusadasporregiao"})
public class Relvacinasmaisusadasporregiao extends HttpServlet {
    
    private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if (Objects.nonNull(req.getParameter("pesquisar"))) {
        req.setAttribute("estados",vacinatomadabo.RelatorioEstadossss(req.getParameter("datainicio"),
                                                                     req.getParameter("datafim"), 
                                                                    req.getParameter("estado")));
        }
         req.getRequestDispatcher("jsp/relvacinasmaisusadasporregiao.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
               //req.setAttribute("estados",vacinatomadabo.RelatorioEstado(req.getParameter("estados"), req.getParameter("datainicio"),req.getParameter("datafim")));

        
         req.getRequestDispatcher("jsp/relvacinasmaisusadasporregiao.jsp").forward(req, resp);
    }

}
