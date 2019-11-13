<%-- 
    Document   : relusuarios
    Created on : 21/09/2019, 18:38:57
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
    <head>        
        <title>Relatorio de usuário</title>
    </head>
    <jsp:include page="includes/head.jsp"/>
    <body >
       
        <div class="wrapper">
            
            <div class="container border" style="
               box-shadow: 0 0 1em black;">
            <div class="content">
                <jsp:include page="includes/menusuperior.jsp"/>
                
                <%-- conteudo --%>
                    <%--inicio tabela de consulta --%> 
                    <form method="post" action="${pageContext.request.contextPath}/cadusuario" onsubmit="return validarform1(this)"><br>
                    <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px; margin-left:50px; float: right;">
                            <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 10px" border="1" >
                                <caption>***Lista de usuários</caption>
                                <thead class="thead-light">
                                    <tr>
                                        
                                        
                                            <th>Nome</th>
                                            <th>Sexo</th>
                                            <th>CPF</th>
                                            <th>RG</th>
                                            <th>Tipo Saguineo</th>
                                            <th>Grupo de risco</th>
                                            <th>Email</th>
                                            <th>Telefone</th>
                                            <th>LocalNascimento</th>
                                            <th>DataNascimento</th>
                                            <th>CEP</th>
                                            <th>Logradouro</th>
                                            <th>Numero da Casa</th>
                                            <th>Tipo de Casa</th>
                                            <th>Bairro</th>
                                            <th>Cidade</th>
                                            <th>Estado-UF</th>                                        
                                            <th>Login</th>
                                            <th>Senha</th>
                                            <th>Tipo de Usuario</th>



                                        </tr>
                                    </thead>
                                    <body>
                                        <c:forEach var= "usuario" items="${usuarios}">
                                        <tr>
                                            
                                            <td>${usuario.nome}</td>
                                            <td>${usuario.sexo}</td>
                                            <td>${usuario.cpf}</td>
                                            <td>${usuario.rg}</td>
                                            <td>${usuario.tiposanguineo}</td>
                                            <td>${usuario.grupos.grupo}</td>
                                            <td>${usuario.email}</td>
                                            <td>${usuario.telefone}</td>
                                            <td>${usuario.localnascimento}</td>
                                            <td>${usuario.dia}/${usuario.mes}/${usuario.ano}</td>                                        
                                            <td>${usuario.cep}</td>
                                            <td>${usuario.logradouro}</td>
                                            <td>${usuario.numerocasa}</td>
                                            <td>${usuario.tiporesidencia}</td>
                                            <td>${usuario.bairro}</td>
                                            <td>${usuario.cidade}</td>
                                            <td>${usuario.estado.estado}, ${usuario.estado.uf}</td>
                                            <td>${usuario.login}</td>
                                            <td>${usuario.senha}</td>
                                            <td>${usuario.tipousuario.tipousuario}</td>
                                                                                 

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