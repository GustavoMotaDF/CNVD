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
    <body style="background-color: #fff">
        <jsp:include page="includes/menusuperior.jsp"/>
        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/totalvacinastomada" name="form01" id="formulario" onsubmit="return validarform1(this)"><br>          

                <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px;  float: right;">
                    <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 15px" border="1" >
                        <thead class="thead-light">
                            <tr>
                                <th class="hovercoluna">Nome Vacina</th>
                                <th class="hovercoluna">Quantidade</th>
                            </tr>
                        </thead>

                        <c:forEach var="cartaovacinas" items="${cartaovacinas}">
                            <tr>

                                <td>${cartaovacinas["0"].vacinas.vacina}</td>
                                <td>${cartaovacinas["1"]}</td>

                            </tr>
                        </c:forEach>


                    </table>  
                </div>
                <style>
                    .form-control:hover > [class*=form-control] {
                        background-color:#A9F5F2;
                        border: 0;

                    }
                </style>

                <form style="width: 100%" >
                    <div  class="form-control" style="width: 100%">   
                        <input class="form-control"  id="imprimir" type="button" value="Salvar/Imprimir" style="width: 100%; border: 0;" onClick="window.print()"/>
                    </div>
                </form>
        </div>
    </body>
    <jsp:include page="includes/imports.jsp"/>
</html>
