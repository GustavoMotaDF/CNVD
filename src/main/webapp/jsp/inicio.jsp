<%-- 
    Document   : inicio
    Created on : 04/06/2019, 15:42:13
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
     <%-- head --%>
    <title>Início</title>
    <jsp:include page="includes/head.jsp"/>
    <body >
        
        ${login1}
        
        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="
               box-shadow: 0 0 1em black;">
            <div class="content">
                <jsp:include page="includes/menusuperior.jsp"/>
                <%-- conteudo --%>
                  

                    <iframe style="border: 0;" src="http://saude.gov.br/" width=400px" height="500px" frameborder="0" scrolling="yes"></iframe>
                    <iframe style="border: 0;" src="http://saude.gov.br/saude-de-a-z/vacinacao/" width=400px" height="500px" frameborder="0" scrolling="yes"></iframe>
                    
                    
               
                <%-- fim conteudo --%>
            </div>
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>

    </body>
</html>