/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.VacinaBO;
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
@WebServlet(name = "relvacinasmaisusadas", urlPatterns = {"/Relvacinasmaisusadas"})
public class Relvacinasmaisusadas extends HttpServlet {

    private final VacinaBO vacinasBO = new VacinaBO();
    
    @Override
    
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            
            
        req.setAttribute("vacinas",vacinasBO.getVacinas());
        
        
        
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/relvacinasmaisusadas.jsp").forward(req, resp);
    }

}
