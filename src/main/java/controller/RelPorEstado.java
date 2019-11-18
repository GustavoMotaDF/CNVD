/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.CampanhaBO;
import business.VacinaBO;
import business.VacinaTomadaBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
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
@WebServlet(name = "RelPorEstado", urlPatterns = {"/relporEstado"})
public class RelPorEstado extends HttpServlet {

 private final VacinaTomadaBO vacinatomadabo = new VacinaTomadaBO();
    private final CampanhaBO campanhabo = new CampanhaBO();
    VacinaBO vacinaBO = new VacinaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
         HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        
        if (Objects.nonNull(req.getParameter("pesquisar"))) {
            try{
        req.setAttribute("estados",vacinatomadabo.RelatorioEstadoss(req.getParameter("datainicios"),
                                                                    req.getParameter("datafim"),
                                                                    req.getParameter("estado")                                                                    
                                                                    ));
        
            }catch(Exception e){
                req.setAttribute("mensagemErro", "Sem resultado para os parametros informados ");
            }
        }
      
         req.getRequestDispatcher("jsp/relatorioporEstado.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession sessao = req.getSession();
        
        String usuario = (String) sessao.getAttribute("login");
        if (usuario == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
               //req.setAttribute("estados",vacinatomadabo.RelatorioEstado(req.getParameter("estados"), req.getParameter("datainicio"),req.getParameter("datafim")));

       
         req.getRequestDispatcher("jsp/relatorioporEstado.jsp").forward(req, resp);
    }
}



