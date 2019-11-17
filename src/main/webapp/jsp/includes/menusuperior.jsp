<%-- 
    Document   : menusuperior
    Created on : 17/10/2019, 19:36:13
    Author     : gustavo
--%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light"  id="ts">
                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fa fa-align-justify"></i> <span>Menu</span>
                    </button>                   
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Página Inicial<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                               <a class="nav-link" href="jsp/vercampanhasAtivas.jsp">Campanhas</a>
                            </li>
                            <li class="nav-item">
                               <a class="nav-link" href="${pageContext.request.contextPath}/Deslogar">Deslogar</a>
                            </li>
                        </ul>
                    </div>
                </nav>