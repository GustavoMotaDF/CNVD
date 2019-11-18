<%-- 
    Document   : Teste
    Created on : 25/10/2019, 23:06:40
    Author     : gustavo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cartão de Vacina</title>
        <jsp:include page="includes/head.jsp"/>
        <link rel="stylesheet" href="jsp/bootstrap/css/bootstrap-grid.css"> 

        <style>
            .alinhamento1{
                display: inline-block;
                width: 150px;
                font-weight: bold; 

            }
            #nomela{                
                color: #000;
                text-align: center;
            }
            #borda{

            }
            hr{
                border-color:#aaa;
                box-sizing: content-box;
                width:100%;      
            }          
            .jumbotron .btn:focus{
                outline: thin dotted;
                outline: 0px auto -webkit-focus-ring-color;
                outline-offset: 0px;
            }
            .jumbotron:focus {
                outline: thin dotted;
                outline: 0px auto -webkit-focus-ring-color;
                outline-offset: 0px;
            }
        </style>
    </head>
    <body style="background-color: #fff ">
        <jsp:include page="includes/menusuperior.jsp"/>
        <div class="container"style="background: #A9D0F5;">
            <br>
            <h2 id="nomela">Cartão Nacional de Vacina Digital</h2>           
            <br>
        </div>

        <c:if test="${ empty cartao}">
            <br>
            <div class="container" style="
                 box-shadow: 0 0 1em black;">

                <form action="${pageContext.request.contextPath}/cartaodevacina" method="post">
                <div class="container" style="text-align: center">
                        <br>
                        <label>CPF do Usuário:</label><br>
                        <input name="cpf" type="text" style="width: 50%"/><br> <br>                   
                        <button type="submit" name="pesquisar" class="btn btn-primary" >Pesquisar</button>
                        <br>
                        <br>
                        <div>
                            ${mensagemErro}
                            <br>
                            <br>
                        </div>
                </form>
                    
                
                <div>
                </c:if>


                <c:if test="${ not empty cartao}">
                    <div class="container"style="background: #A9D0F5;" id="botao">

                        <style>
                            .form-control{
                                background: #A9D0F5;
                               
                            }
                            .gato:hover > [class*=form-control] {
                                background-color:#A9F5F2;
                                border: 0;
                            }
                        </style>


                        <div class="gato">   
                            <input class="form-control"  id="imprimir" type="button" value="Salvar/Imprimir" style="width: 100%;border: 0; " onClick="window.print()"/>
                        </div>

                    </div>
                    <br>
                    <div class="container" style=" background-color: #E0F8F7;  ">
                        <h3 style="text-align: center">Informações do usuario</h3>
                        <div class="row">
                            <hr>
                            <div class="col-md-6" id="borda">
                                <label for="nome" class="alinhamento1">Nome:</label>    
                                <label id="nome">${cartao["0"]["0"]}</label><br>
                            </div> <br>
                            <div class="col-md-3 " id="borda">
                                <label for="sangue" class="alinhamento1">Tipo Sanguineo:</label>    
                                <label id="nome">${cartao["0"]["1"]}</label>
                            </div> 
                            <div class="col-md-3" id="borda">
                                <label for="logradouro" class="alinhamento1">Grupo de risco: </label>                    
                                <label id="logradouro">${cartao["0"]["14"]}</label><br>
                            </div>
                            <hr>
                            <div class="col-md-6" id="borda">
                                <label for="dtnascimento" class="alinhamento1">Dtª Nascimento: </label>
                                <label id="dtnascimento">Dia ${cartao["0"]["2"]}</label>
                                <label id="dtnascimento">de ${cartao["0"]["3"]}</label>
                                <label id="dtnascimento">de ${cartao["0"]["4"]}</label>
                            </div>
                            <div class="col-md-6" id="borda">
                                <label for="cpf" class="alinhamento1">CPF:</label>
                                <label id="cpf">${cartao["0"]["5"]}</label>
                            </div>  <hr>              

                            <div class="col-md-6" id="borda">
                                <label for="cidade" class="alinhamento1">Cidade:</label>
                                <label id="cidade">${cartao["0"]["6"]},</label>
                                <label id="cidade">${cartao["0"]["7"]}</label><br>
                            </div>
                            <div class="col-md-6" id="borda">
                                <label for="cep" class="alinhamento1">CEP:</label>
                                <label id="cidade">${cartao["0"]["8"]}</label><br>
                            </div>
                            <hr>
                            <div class="col-md-8" id="borda">
                                <label for="logradouro" class="alinhamento1">Logradouro: </label>
                                <label id="logradouro">${cartao["0"]["9"]}</label>
                                <label id="logradouro">Nº${cartao["0"]["10"]}</label><br>
                            </div>

                            <hr>

                        </div>

                    </div>
                    <br>
                    <div class="container" style=" background: #A9D0F5; ">
                        <h3 style="text-align: center">Informações do cartão</h3><br>
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

                                        <td>${cartao["11"]}</td>
                                        <td>${cartao["12"]}</td>
                                        <%
                                            SimpleDateFormat ftm = new SimpleDateFormat("dd-MM-yyyy");

                                        %>
                                        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
                                        <fmt:formatDate pattern="dd/MM/yyyy" value="${cartao[13]}" var="dataFormatada" />                                        
                                        <td>${dataFormatada}</td>


                                    </tr>
                                </c:forEach>

                            </table>  
                            <br>

                        </div>

                    </div>
                </c:if>
                </body>
                <jsp:include page="includes/imports.jsp"/>
                </html>
