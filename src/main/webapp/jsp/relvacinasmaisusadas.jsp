<%-- 
    Document   : relvacinasmaisusadas
    Created on : 21/09/2019, 20:52:25
    Author     : gustavo
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <title>Relatório: Vacinas</title>
    </head>
    <jsp:include page="includes/head.jsp"/>
    <body >
        ${mensagem1}
        ${login1}
        
        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="
               box-shadow: 0 0 1em black;">
            <div class="content">
                <jsp:include page="includes/menusuperior.jsp"/>
                
                <%-- conteudo --%>
                    <form method="post" action="${pageContext.request.contextPath}/caddoenca" >          
                        <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px;  float: right; box-shadow: 0 0 1em black;">
                            <table class="table table-hover" style="border: 1px solid black; border-collapse: collapse; margin-top: 20px;  width:100%; font-size: 15px" border="1" >
                                <thead class="thead-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Doenca</th>
                                        <th>Qt. Usada</th>
                                        <th>%</th>                                     
                                        
                                    </tr>
                                </thead>
                                <body>
                                    <c:forEach var= "doenca" items="${doenca}">
                                    <tr>
                                        <td>${doenca.iddoenca}</td>
                                        <td>${doenca.doenca}</td>                                        
                                        <td>
                                            
                                        </td>                                        
                                        <td>
                                            <input type ="radio" name="iddoenca" id="radiodoenca"
                                                   onclick="habilitar(1); habilitar(2)" value ="${doenca.iddoenca}" required="Selecione">
                                        </td>

                                    </tr>
                                </c:forEach>
                                </body>

                            </table>     
                        </div>    
                    </form>
               
                <%-- fim conteudo --%>
            </div>
            
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>

    </body>
</html>