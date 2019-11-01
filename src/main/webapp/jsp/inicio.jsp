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
        ${mensagem1}
        ${login1}
        
        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="
               box-shadow: 0 0 1em black;">
            <div class="content">
                <jsp:include page="includes/menusuperior.jsp"/>
                
                <%-- conteudo --%>
                    <div style="color: green" id="msgerro"> ${mensagemSucesso} </div>
                    <div style="color: red">${mensagemErro}</div>

                    <div id="conteudopropriamentedito" style="background-color: #A9E2F3">
                        
                    </div>
                    
                    <div id="imgtext" style=" position:fixed; top : 75%;right: 1%;text-align: center;">                        
                        <div>                            
                            <span>Desde 2019<br>
                                Ajudando a população!</span>
                        </div>
                            
                        <img id="imgtelainicial"src="jsp/imagens/Logo.png" alt="Cartão Nacional de Vacina Digital" >                   
                    </div>
               
                <%-- fim conteudo --%>
            </div>
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>

    </body>
</html>