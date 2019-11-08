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
 * @author gustavohenrique.m.s
 */
@WebServlet(name = "TotalVacinasTomada", urlPatterns = {"/totalvacinastomada"})
public class TotalVacinasTomada extends HttpServlet {
private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        req.setAttribute("cartaovacinas",vacinatomadabo.RelatorioVacina());
        
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/totalvacinastomada.jsp").forward(req, resp);
    }
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        req.setAttribute("cartaovacinas",vacinatomadabo.RelatorioVacina());
        
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/totalvacinastomada.jsp").forward(req, resp);
    }
}
