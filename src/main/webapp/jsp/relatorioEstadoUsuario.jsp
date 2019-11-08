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
        <title>Relatório: Usuarios cadastrados por Estado</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/menusuperior.jsp"/>
        
        <form method="post" action="${pageContext.request.contextPath}/pesqusuario" name="form01" id="formulario" onsubmit="return validarform1(this)"><br>
          
            <h3>Relatório: Usuarios cadastrados por Estado</h3>
            
            <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px; margin-left:50px; float: right;">
                            <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 10px" border="1" >
                                
                                <thead class="thead-light">
                                    <tr>                                        
                                        
                                        <th class="hovercoluna">Estado</th>
                                        <th class="hovercoluna">Numero de Usuarios</th>
                                        
                                    </tr>
                                </thead>
                                <body
                                    <c:forEach var="userEstado" items="${userEstado}">
                                    <tr>
                                        
                                        <td>${userEstado["0"].estado.estado}</td>
                                        <td>${userEstado["1"]}</td>
                                        
                                    </tr>
                                    </c:forEach>
                                </body>

                            </table>  
                        </div>
                    
                    </form>
                    <form>
                    <input id="imprimir" type="button" value="Salvar/Imprimir" style="" onClick="window.print()"/>
                    </form>
    </body>
    <jsp:include page="includes/imports.jsp"/>
</html>
