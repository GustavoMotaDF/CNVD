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
        <c:if test="${empty usuario}">
            <form action="${pageContext.request.contextPath}/pesqusuario" method="post">
                <input type="text" name="usuario"/>
                <input type="submit" name="Pesquisar" value="Pesquisar"/>
                
            </form>
        </c:if>
        <c:if test="${not empty usuario}">
            <div>${erroBD}</div>
            <c:forEach var="usuario" items="${usuario}">
                <input type="text" name="${usuario.idvacinacao}" disabled/>
                <input type="text" name="${usuario.vacinas.vacina}" disabled/>
            </c:forEach>
        </c:if>
    </body>
</html>
