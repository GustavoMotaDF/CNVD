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
    </head>
    <body>
        <form method="get" action="${pageContext.request.contextPath}/pesqusuario" onsubmit="return validarform1(this)"><br>
                    <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px; margin-left:50px; float: right;">
                            <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 10px" border="1" >
                                <caption>***Lista de usuários</caption>
                                <thead class="thead-light">
                                    <tr>
                                        <th class="hovercoluna">ID</th>
                                        <th>idVacina</th>
                                        <th>Nome Vacina</th>
                                        <th>Quantidade</th>
                                        
                                    </tr>
                                </thead>
                                <body>
                                <c:forEach var= "qtdVacina" items="${qtdVacina}">
                                    <tr>
                                        <td>${qtdVacina.vacinas.idvacina}</td>
                                        <td>${qtdVacina.vacinas.vacina}</td>
                                        <td>${qtdVacina.qdt}</td>
                                        
                                    </tr>
                                </c:forEach>
                                </body>

                            </table>  
                        </div> 
                    </form>
    </body>
</html>
