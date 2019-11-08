<%-- 
    Document   : Teste
    Created on : 25/10/2019, 23:06:40
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/menusuperior.jsp"/>
        
        <form method="post" action="${pageContext.request.contextPath}/relatorios" name="form01" id="formulario" onsubmit="return validarform1(this)"><br>
           
            <h3>Relatório: Vacinas Mais usadas</h3>
            <label>${cartao["0"]["0"]}</label><br>
            <label>${cartao["0"]["1"]}</label><br>
            <label>${cartao["0"]["2"]}</label><br>
            <label>${cartao["0"]["3"]}</label><br>
            <label>${cartao["0"]["4"]}</label><br>
            <label>${cartao["0"]["5"]}</label><br>
            
            <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px; margin-left:50px; float: right;">
                            <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 15px" border="1" >

                                <thead class="thead-light">
                                    <tr>
                                        
                                        
                                        <th class="hovercoluna">Nome</th>
                                        <th class="hovercoluna">Vacina</th>
                                        <th class="hovercoluna">Dose</th>
                                        <th class="hovercoluna">Data de aplicação</th>
                                        
                                    </tr>
                                </thead>
                                
                                <c:forEach var="cartao" items="${cartao}">
                                    <tr>
                                        
                                        <td>${cartao["0"]}</td>
                                        <td>${cartao["6"]}</td>
                                        <td>${cartao["7"]}</td>
                                        <td>${cartao["8"]}</td>
                                        
                                    </tr>
                                </c:forEach>
                                

                            </table>  
                        </div> 
                     
            </form>
                    
               
    </body>
    <jsp:include page="includes/imports.jsp"/>
</html>
