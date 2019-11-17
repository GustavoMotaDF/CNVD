/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
 * @author Gusta
 */
@WebServlet(name = "Deslogar", urlPatterns = {"/Deslogar"})
public class Deslogar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     HttpSession sessao = req.getSession();
     
     sessao.invalidate();
     req.getRequestDispatcher("index.jsp").forward(req, resp);
    
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        
     HttpSession sessao = req.getSession();
     
     sessao.invalidate();
     req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

   
}
