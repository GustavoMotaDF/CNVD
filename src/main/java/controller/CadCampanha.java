/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.CampanhaBO;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CadCampanha", urlPatterns = {"/cadcampanha"})
public class CadCampanha extends HttpServlet {

    private final CampanhaBO campanhabo = new CampanhaBO();
    String mensagemErro = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull  (req.getParameter("cadastrar"))){
        
        try{
            
        campanhabo.IncluirCampanhas(req.getParameter("descricaocampanha"),
                                    req.getParameter("estadousuarios"),
                                    req.getParameter("datacampanha"),
                                    req.getParameter("datacampanhafim"));
        req.setAttribute("mensagemSucesso","Campanha adicionada com sucesso!" );
        
        
        }catch(Exception e){
            mensagemErro = "Erro ao adicionar Campanha "+e.getMessage();
        }
            
        
        
    }else if(Objects.nonNull(req.getParameter("excluir"))){
         //Tratando exclusão
            if(campanhabo.excluirCampanha(req.getParameter("idcampanha"))){
                req.setAttribute("mensagemSucesso", "Campanha Excluida com Sucesso!");
                
            }else{
                req.setAttribute("mensagemErro", "Erro ao Exclui!");                
            }
        
    }else if(Objects.nonNull(req.getParameter("editar"))){
            //Tratando editar
            req.setAttribute("campanhaEditando",campanhabo.getCampanha(req.getParameter("idcampanha")));
    }else if(Objects.nonNull(req.getParameter("alterar"))){
            //Tratando alterar            
            try{
            campanhabo.alterarCampanha(req.getParameter("idcampanha"),
                                    req.getParameter("descricaocampanha"),
                                    req.getParameter("estadousuarios"),
                                    req.getParameter("datacampanha"),
                                    req.getParameter("datacampanhafim"));
            req.setAttribute("mensagemSucesso", "Alterado com Sucesso!");
            }catch(Exception e){
            req.setAttribute("mensagemErro", "Erro ao Alterar "+e.getMessage());
            }
    }
        try{
            req.setAttribute("campanha", campanhabo.getCampanhas());
            
        }catch(Exception e){
            mensagemErro = "Erro ao listar Campanhas "+ e.getMessage();
        }
        req.getRequestDispatcher("jsp/cadcampanhas.jsp").forward(req, resp);
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setAttribute("campanha", campanhabo.getCampanhas());
            
        }catch(Exception e){
            mensagemErro = "Erro ao listar Doencas "+ e.getMessage();
        }
        req.getRequestDispatcher("jsp/cadcampanhas.jsp").forward(req, resp);
    }


}
