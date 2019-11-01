<%-- 
    Document   : vercampanhasAtivas
    Created on : 16/08/2019, 00:24:59
    Author     : gustavo
--%>



<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <title>Campanhas Ativas</title>
    </head>
    <jsp:include page="includes/head.jsp"/>
    <body >

        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>

            <div class="content">
                <jsp:include page="includes/menusuperior.jsp"/>
                
                <%-- conteudo --%>
                
               <h1 align="center">
                   Em breve<br>Campanhas Ativas!!!<br>
                    Aguarde..
                </h1>
                    
                <%-- fim conteudo --%>
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>
