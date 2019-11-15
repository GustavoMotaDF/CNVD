/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.GrupoBO;
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
 * @author Gusta
 */
@WebServlet(name = "RelEstadoeGrupo", urlPatterns = {"/relestadoeGrupo"})
public class RelEstadoeGrupo extends HttpServlet {
 private final GrupoBO grupobo = new GrupoBO();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if (Objects.nonNull(req.getParameter("pesquisar"))) {
            try{
        req.setAttribute("grupo", grupobo.EstadoeGrupo(req.getParameter("estado")));
        
            }catch(Exception e){
                req.setAttribute("mensagemErro", "Sem resultado para os parametros informados "+e.getMessage());
            }
        }
         req.getRequestDispatcher("jsp/relestadoegrupo.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
               //req.setAttribute("estados",vacinatomadabo.RelatorioEstado(req.getParameter("estados"), req.getParameter("datainicio"),req.getParameter("datafim")));

        
         req.getRequestDispatcher("jsp/relestadoegrupo.jsp").forward(req, resp);
    }
}
