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
        
        <form method="post" action="" name="form01" id="formulario" onsubmit="return validarform1(this)"><br>
            <script>
                function enviarpesq() {
                    document.form01.action = '${pageContext.request.contextPath}/pesqusuario';                    
                    document.form01.submit();
                }
                function enviaruser() {
                    document.form01.action = '${pageContext.request.contextPath}/usuario';
                    document.form01.submit();
                }
                
                
                function enviar() {
                    var formulario = document.getElementById('formulario');
                    if(document.getElementById('pesqusuario').checked === true) {
                        formulario.action = "${pageContext.request.contextPath}/pesqusuario";
                    }
                     else {
                        formulario.action = "${pageContext.request.contextPath}/usuario";
                    }		
                        formulario.submit();
                    }

            </script>
            <c:if test="${empty usuarioEditando}">
                <input type="text" name="usuario"/>
                <input type="submit" name="pesquisar" value="Pesquisar" onClick="enviar();"/><br>
                
               PesUsuario: <input type="radio" name="pesqusuario" id="pesqusuario" value="PesqUsuario" />
                User:<input type="radio" name="user" value="User" id="user"/>
                
            </c:if>
            
            <c:if test="${not empty usuarioEditando}">]
            
            <h3>Relatório: Vacinas Mais usadas</h3>
            <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px; margin-left:50px; float: right;">
                            <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 10px" border="1" >

                                <thead class="thead-light">
                                    <tr>
                                        
                                        
                                        <th class="hovercoluna">Nome Vacina</th>
                                        <th class="hovercoluna">dose</th>
                                        <th class="hovercoluna">dataVacinação</th>
                                        
                                    </tr>
                                </thead>
                                body>
                                <c:forEach var="usuarioEditando" items="${usuarioEditando}">
                                    <tr>
                                        
                                        <td>${usuarioEditando}</td>
                                        <td>${usuarioEditando}</td>
                                        
                                    </tr>
                                </c:forEach>
                                

                            </table>  
                        </div> 
                     </c:if>
            </form>
                    
               
    </body>
    <jsp:include page="includes/imports.jsp"/>
</html>
