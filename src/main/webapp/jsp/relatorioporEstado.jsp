<%-- 
    Document   : relatorioporEstado
    Created on : 18/11/2019, 16:46:53
    Author     : Gusta
--%>

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
        <title>Relatorio: Quantidade de Vacinas por Estado</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body style="background-color: #fff" >
        <jsp:include page="includes/menusuperior.jsp"/>

        <br>
        <c:if test="${empty estados}">

            <div class="container"style="background: #A9D0F5;">
                <br>
                <h2 id="nomela">Relatorio: Quantidade de Vacinas por Estado</h2>           
                <br>
            </div>
            <br>
            <div class="container" style="
                 box-shadow: 0 0 1em black;">

                <form action="${pageContext.request.contextPath}/relporEstado" method="post">
                    <div class="container" style="text-align: center">
                        <br>
                        <label>Data inicio:</label>
                        <input class="form-control" type="date" name="datainicios" id="datainicio" />
                        <br>
                        <label>Data fim:</label>
                        <input class="form-control" type="date" name="datafim" id="datafim" />
                        <br>

                        <select class="form-control"  name="estado" id="estado" required="Selecione!" >
                            <option value="">Selecione o Estado...</option>   
                            <option value="1">Acre</option>
                            <option value="2">Alagoas</option>
                            <option value="4">Amapá</option>
                            <option value="3">Amazonas</option>
                            <option value="5">Bahia</option>
                            <option value="6">Ceará</option>
                            <option value="7">Distrito Federal</option>
                            <option value="8">Espírito Santo</option>
                            <option value="9">Goiás</option>
                            <option value="10">Maranhão</option>
                            <option value="13">Mato Grosso</option>
                            <option value="12">Mato Grosso do Sul</option>
                            <option value="11">Minas Gerais</option>
                            <option value="14">Pará</option>
                            <option value="15">Paraíba</option>
                            <option value="18">Paraná</option>
                            <option value="16">Pernambuco</option>
                            <option value="17">Piauí</option>
                            <option value="19">Rio de Janeiro</option>
                            <option value="20">Rio Grande do Norte</option>
                            <option value="23">Rio Grande do Sul</option>
                            <option value="21">Rondônia</option>
                            <option value="22">Roraima</option>
                            <option value="24">Santa Catarina</option>
                            <option value="26">São Paulo</option>
                            <option value="25">Sergipe</option>
                            <option value="27">Tocantins</option>

                        </select>   
                        <br>
                        

                        <br>
                        <br>
                        <button  type="submit" name="pesquisar" class="btn btn-primary" >Pesquisar</button>
                        <div>
                            ${mensagemErro}
                            <br>
                            <br>
                        </div>
                    </div>

                </form>
            </div>


        </c:if>
        <c:if test="${not empty estados}">
            <div class="container">
                <h3>Relatório: Total de vacinas aplicadas no estado <label style="color: #4e555b"><i>${estados["0"]["0"]}</i></label></h3>

                <div id="tabelalista" style="overflow: auto; width: 100%; height: auto; border:solid 1px;  float: right;">
                    <table class="table table-hover table-sm"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 15px" border="1" >
                        <thead class="thead-light">
                            <tr>                                         
                                <th class="hovercoluna">Vacinas Aplicadas</th>
                                <th class="hovercoluna">Numero de Vacinas Aplicadas</th>
                            </tr>
                        </thead>
                        <body
                            <c:forEach var="estados" items="${estados}">
                        <tr>
                            <td>${estados["1"]}</td>
                            <td>${estados["2"]}</td>
                        </tr>
                    </c:forEach>
                    </body>

                </table>  
            </div>
            <style>
                .form-control:hover > [class*=form-control] {
                    background-color:#A9F5F2;
                    border: 0;

                }
            </style>

            <form style="width: 100%" >
                <div  class="form-control" style="width: 100%">   
                    <input class="form-control"  id="imprimir" type="button" value="Salvar/Imprimir" style="width: 100%; border: 0;" onClick="window.print()"/>
                </div>
            </form>
        </div>
    </c:if> 


    <script>
        $(document).ready(function () {
            $("#estado").select2();
            $("#vacina").select2();



        });
    </script>
</body>
<jsp:include page="includes/imports.jsp"/>
</html>
