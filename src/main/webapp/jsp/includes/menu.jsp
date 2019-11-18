<%-- 
    Document   : menu
    Created on : 17/10/2019, 19:32:45
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav id="sidebar">
    <div class="sidebar-header">
        <a href="${pageContext.request.contextPath}/Login"> <img src="jsp/imagens/Logo.png" alt="Cartão Nacional de Vacina Digital" width=160 height=85></a>
    </div>
    <ul class="list-unstyled components">
        <p><%

                  String usuario = (String) session.getAttribute("login");

                        if(usuario==null){
                            response.sendRedirect("index.jsp");
                           
                        }else{
                            out.print("Olá "+usuario);
                        }

        %></p> 	
        <li >
            <a href="${pageContext.request.contextPath}/Login">Página Inicial</a>
        </li>
        <li>
            <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Cadastros</a>
            <ul class="collapse list-unstyled" id="homeSubmenu">
                <li>
                    <a href="${pageContext.request.contextPath}/cadusuario">Cadastro de Usuario</a>
                </li>
                <li >
                    <a href="${pageContext.request.contextPath}/cadvacina">Cadastro de Vacina</a>                            
                </li>
                <li> 
                    <a href="${pageContext.request.contextPath}/caddoenca">Cadastro de Doenca</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/cadcampanha">Cadastro de Campanhas</a>
                </li>
            </ul> 
        </li>
        <li>
            <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Relatorios</a>
            <ul class="collapse list-unstyled" id="pageSubmenu">
               
                <li>
                    <a href="${pageContext.request.contextPath}/relestadoporVacina">Relatorio: Estado, Vacina e Campanha</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/relporEstado">Relatorio: Quantidade de Vacinas por Estado</a>
                </li>     
                <li>
                    <a href="${pageContext.request.contextPath}/totalvacinastomada">Relatorio: Numero de Vacinas aplicadas Total - Vacinas</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/totalVacinasEstados">Relatorio: Numero de Vacinas aplicadas Total - Estados</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/relestadoeGrupo">Relatorio: Usuarios cadastrados por Grupo e por Estado</a>
                </li>
                 <li>
                    <a href="${pageContext.request.contextPath}/relatorioEstadoUsuario">Relatorio: Usuarios cadastrados por Estado</a>
                </li>
            </ul> 
        </li>
        <li>
            <a href="#">Campanhas</a>
        </li>
        <li>
            <a href="#">Contact Us</a>
        </li>
    </ul>

    <ul class="list-unstyled CTAs">
        <li>
            <a href="${pageContext.request.contextPath}/cadvacinatomada" class="cadcartao">Vacinar Usuario!</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/cartaodevacina" class="cadcartao">Cartão de Vacina</a>
        </li>
    </ul>
</nav>