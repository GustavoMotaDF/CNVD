/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.VacinaBO;
import business.DoencaBO;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CadVacina", urlPatterns = {"/cadvacina"})
public class Cadvacina extends HttpServlet {
    private VacinaBO vacinaBO = new VacinaBO(); 
    private DoencaBO doencaBO = new DoencaBO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        req.setAttribute("vacinas",vacinaBO.getVacinas());
        req.setAttribute("doencas",doencaBO.getDoencas());
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }
        
        
        req.getRequestDispatcher("jsp/cadastrovacina.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.nonNull(req.getParameter("cadastrar"))) {
        try{
           
            vacinaBO.IncluirVacina(req.getParameter("vacina"),
                                    req.getParameter("iddoenca"));
            req.setAttribute("mensagemSucesso", "Cadastrado com sucesso!");
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }   
            
            req.setAttribute("mensagemSucesso", "Cadastrado com sucesso!");
            
        }else if(Objects.nonNull(req.getParameter("excluir"))){
            //Tratando exclusão
            if(vacinaBO.excluirVacina(req.getParameter("idvacina"))){
                req.setAttribute("mensagemSucesso", "Vacina Excluida com Sucesso!");
                
            }else{
                req.setAttribute("mensagemErro", "Erro ao excluir!");
                
            }
            
        }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("vacinaEditando",vacinaBO.getVacina(req.getParameter("idvacina")));
        }
        else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar
            
            try{
            vacinaBO.alterarVacina( req.getParameter("idvacina"),
                                    req.getParameter("vacina"),                                
                                    req.getParameter("iddoenca"));
            req.setAttribute("mensagemSucesso", "Alterado com Sucesso!");
            }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro ao Alterar");
            }
        }
        
        
        try{
        req.setAttribute("vacinas",vacinaBO.getVacinas());
        req.setAttribute("doencas",doencaBO.getDoencas());
    
        }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro interno, recarregue a pagina (F5), caso o erro persista, contate o administrator do sistema! (Especificação do erro " + e.getMessage()+")");
        }

        
        
        req.getRequestDispatcher("jsp/cadastrovacina.jsp").forward(req, resp);
    }

}


