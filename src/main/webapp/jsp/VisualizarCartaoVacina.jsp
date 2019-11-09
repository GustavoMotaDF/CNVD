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
        <link rel="stylesheet" href="jsp/bootstrap/css/bootstrap-grid.css"> 
        
        <style>
            .alinhamento1{
                display: inline-block;
                width: 150px;
                font-weight: bold; 
                border: solid 1px black;
            }
            
        </style>
    </head>
    <body>
        <jsp:include page="includes/menusuperior.jsp"/>
        <div class="container" style="
               box-shadow: 0 0 1em black;">
            <h3>Informações do usuario</h3><br>
            <div class="row">
                <div class="col-md-10">
                    <label for="nome" class="alinhamento1">Nome:</label>    
                    <label id="nome">${cartao["0"]["0"]}</label><br>
                </div> <br>
                <div class="col-md-2">
                    <label for="sangue" class="alinhamento1">Tipo Sanguineo:</label>    
                    <label id="nome">${cartao["0"]["1"]}</label><br>
                </div> <br>
                <div class="col-md-6">
                    <label for="dtnascimento" class="alinhamento1">Dtª Nascimento: </label>
                    <label id="dtnascimento">${cartao["0"]["2"]}</label><br>
                </div>
                <div class="col-md-6">
                    <label for="cpf" class="alinhamento1">CPF:</label>
                    <label id="cpf">${cartao["0"]["3"]}</label>
                </div>                
                
                <div class="col-md-6">
                    <label for="cidade" class="alinhamento1">Cidade:</label>
                    <label id="cidade">${cartao["0"]["4"]}</label>
                    <label id="cidade">${cartao["0"]["5"]}</label><br>
                </div>
                <div class="col-md-6">
                    <label for="cep" class="alinhamento1">CEP:</label>
                    <label id="cidade">${cartao["0"]["6"]}</label><br>
                </div>
                <div class="col-md-12">
                    <label for="logradouro" class="alinhamento1">Logradouro: </label>
                    <label id="logradouro">${cartao["0"]["7"]}</label>
                    <label id="logradouro">Nº${cartao["0"]["8"]}</label><br>
                </div>
               
            </div>
               
            
        </div>
        <br>
        <div class="container" style=" box-shadow: 0 0 1em black;">
            <h3>Informações do cartao</h3><br>
            <div style="margin-bottom: 10px;">
                <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 15px" border="1" >

                                <thead class="thead-light">
                                    <tr>
                                        
                                        <th class="hovercoluna">Vacina</th>
                                        <th class="hovercoluna">Dose</th>
                                        <th class="hovercoluna">Data de aplicação</th>
                                        
                                    </tr>
                                </thead>
                                
                                <c:forEach var="cartao" items="${cartao}">
                                    <tr>
                                        
                                        <td>${cartao["9"]}</td>
                                        <td>${cartao["10"]}</td>
                                        <td>${cartao["11"]}</td>
                                        
                                        
                                    </tr>
                                </c:forEach>
                                    
                </table>  
                <br>
                
            </div>
            
        </div>
       
    </body>
    <jsp:include page="includes/imports.jsp"/>
</html>
