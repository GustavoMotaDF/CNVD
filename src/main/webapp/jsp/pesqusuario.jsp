<%--
    Document   : vercataovacina
    Created on : 12/10/2019, 01:28:02
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : inicio
    Created on : 04/06/2019, 15:42:13
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
   

        <title>Pesquisar Cartão de Vacina</title>
    
    <jsp:include page="includes/head.jsp"/>
    <body >

        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="
                 box-shadow: 0 0 1em black;">
                <div class="content">
                    <jsp:include page="includes/menusuperior.jsp"/>

                    <%-- conteudo --%>

                    <div class="container">

                        <c:if test="${empty usuarioEditando}">
                            <div>
                                <form action="${pageContext.request.contextPath}/pesqusuario" method="post">

                                    <fieldset style="border: 1px black solid;">
                                        <div style="margin: 10px">
                                            <legend>
                                                Pesquisar Usuário
                                            </legend>

                                            <label class="alinhamento" for="usuario" >Usuario:</label>
                                            <input type="text" name="cpf" id="usuario" onkeypress="return sonumeros(event)" maxlength="11" placeholder="identificação com CPF" style="width: 30%"/>
                                            <span style="font-style: italic; font-size: 12px">**CPF</span>
                                            <br>
                                            <input type="submit" name="pesquisar" value="Pesquisar Usuário" class="btn btn-light" style="position: relative; float:right "/>
                                            <br>
                                        </div>
                                    </fieldset>
                                </form>
                            </c:if>


                            <c:if test="${not empty usuarioEditando}">
                                <form action="${pageContext.request.contextPath}/cartaoVacina" method="post">
                                    <fieldset>
                                        <div style="margin: 10px">
                                            <legend><b>É você?</b></legend>
                                            <input type="hidden" name="idusuario" value="${usuarioEditando.idusuario}"/>
                                            <label name="nome">${usuarioEditando.nome}</label><br>
                                            <label name="cpf">${usuarioEditando.cpf}</label><br>
                                            <input type="submit" name="VacinaPeq" value="Sim" class="btn btn-light" style="position: relative; float:right "/>
                                            <input type="submit" name="VacinaPeq" value="Não" class="btn btn-outline-danger" style="position: relative; float:right "/>

                                            <link rel="stylesheet" href="css/style.css">
                                            <link rel="stylesheet" href="css/conteudo.css">
                                            <script type="text/javascript" src="js/Cadastro.js"></script>
                                        </div>
                                    </fieldset>
                                </form>
                            </c:if>




                        </div>
                    </div>

                    <%-- fim conteudo --%>
                </div>
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>