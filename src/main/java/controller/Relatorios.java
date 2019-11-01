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

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Relatorios", urlPatterns = {"/relatorios"})
public class Relatorios extends HttpServlet {
    
    private VacinaBO vacinaBO = new VacinaBO();
    private DoencaBO doencaBO = new DoencaBO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vacinas",vacinaBO.getVacinas());
        req.setAttribute("doencas",doencaBO.getDoencas());
        req.getRequestDispatcher("jsp/relatoriovd.jsp").forward(req, resp);
    }
    

}
