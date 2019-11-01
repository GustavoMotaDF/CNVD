<%-- 
    Document   : cadastrovacina
    Created on : 27/06/2019, 06:23:45
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
     <%-- head --%>
    <title>Vacinas</title>
   <jsp:include page="includes/head.jsp"/>
    <%-- desativa o enter na pagina--%>
    <body onKeyDown="AnalizaTeclas()">

        <div class="wrapper">
            <%-- inicio menu--%>
           <jsp:include page="includes/menu.jsp"/>
        <div class="container border" style="
               box-shadow: 0 0 1em black;"> 
            <div class="content"  id="ts" >
                <jsp:include page="includes/menusuperior.jsp"/>
                <%-- conteudo --%>
                
                <div class="formulario">
                    <div style="color: green" id="msgerro"> ${mensagemSucesso} </div>
                    <div style="color: red">${mensagemErro}</div>
                    <c:if test="${empty vacinaEditando}">
                        <%-- inicio formulario de cadastro--%>
                        <form action="${pageContext.request.contextPath}/cadvacina" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                            <fieldset id="tabelaconteudo">
                                <legend>Cadastro de Vacina</legend>

                                <%-- VACINA --%>
                                <label for="vacina" class="alinhamento">Vacina:</label>
                                <input type="text" name="vacina" id="vacina" placeholder="Placebo" required="Preencha o campo!"/>
                                <span class="style1">*</span>

                                <br>
                                <%-- DOENCA --%>
                                <label for="iddoenca" class="alinhamento">Doença:</label>
                                <select class="doencas" name ="iddoenca" id="iddoenca" required="Selecione!" style="width: 70%; height: 30px;">
                                    <option value="">Selecione a Doenca...</option>   
                                    <c:forEach var="doenca" items="${doencas}">
                                        <option value="${doenca.iddoenca}">${doenca.doenca}</option>
                                    </c:forEach>   
                                </select>
                                <span class="style1">*</span>
                                <br>
                                <br>
                            </fieldset>
                            <%-- submit none, acionado via js--%>    
                            <input type="submit" class="escondido "name="cadastrar" value="Cadastrar" id="cadastrar"/>
                        </form>
                            <%-- inicio modal--%>
                        <div id="myModal" class="modal">

                            <!-- Modal conteudo -->
                            <div class="modal-content">                                
                                <span class="close" onclick="fechar()">&times;</span>
                                <p>Tem certeza que deseja realizar o cadastro?</p>
                                <br>
                                <div style="float: left">
                                    <%-- botao envia formulario--%>
                                    <input type="button" value="Cadastrar"  onclick="enviar()" name="cadastrar" class="btn btn-success"/>
                                    <%-- botao fecha modal--%>
                                    <input type="button" value="Revisar"  id="close" name="cancelar"  class="btn btn-danger" onclick="fechar()"/>
                                </div>                                
                            </div>

                        </div>    

                        <div id="botoes">
                            <%-- abrir modal--%>
                            <input type="button" value="Cadastrar" onclick="abrir()" class="btn btn-outline-success"/>
                            <%-- limpar campos--%>
                            <input type="button" value="Limpar"  onclick="resetar()" name="restar" class="btn btn-outline-danger"/>
                        </div>
                    <%--fim formulario de cadastro --%>
                    </c:if>

                    <c:if test="${not empty vacinaEditando}">
                        <%-- inicio formulario editar--%>
                        <form action="${pageContext.request.contextPath}/cadvacina" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                            <fieldset id="tabelaconteudo">
                                <legend>Alteração de Vacina</legend>
                                <input type ="hidden" name="idvacina" value="${vacinaEditando.idvacina}"/>
                                <%-- VACINA --%>
                                <label for="vacina" class="alinhamento">Vacina:</label>
                                <input type="text" name="vacina" value="${vacinaEditando.vacina}" id="vacina" placeholder="Placebo"/>
                                <span class="style1">*</span>                        
                                <br>
                                <%-- DOENCA --%>
                                <label for="iddoenca" class="alinhamento">Doença:</label>
                                <select class="doencas" name ="iddoenca" id="iddoenca" style="width: 70%; height: 30px;">
                                    <option  value="${vacinaEditando.doenca.iddoenca}">${vacinaEditando.doenca.doenca}</option>   
                                    <c:forEach var="doenca" items="${doencas}">
                                        <option value="${doenca.iddoenca}">${doenca.doenca}</option>
                                    </c:forEach>   
                                </select>
                                <span class="style1">*</span>
                                <br>
                                <br>
                            </fieldset>
                                    <%-- botao:none acionado via js--%>
                            <input type="submit" class="escondido "name="alterar" value="Alterar" id="alterar"/>
                        </form>
                            
                            <%-- inicio modal--%>
                        <div id="myModal" class="modal">
                            <!-- Modal conteudo -->
                            <div class="modal-content">                                
                                <span class="close" onclick="fechar()">&times;</span>
                                <p>Tem certeza que deseja realizar a alteração?</p>
                                <br>
                                <div style="float: left">
                                    <%-- envia formulario de alteração--%>
                                    <input type="button" value="Confirmar"  onclick="alterar()" name="alterar" class="btn btn-success"/>
                                    <%-- fecha modal--%>
                                    <input type="button" value="Revisar"  id="close" name="cancelar"  class="btn btn-danger" onclick="fechar()"/>
                                </div>                                
                            </div>
                        </div>    
                          <%-- FIM MODAL--%>

                        <div id="botoes">
                            <%-- abre modal--%>
                            <input type="button" value="Alterar" onclick="abrir()" class="btn btn-outline-success"/>
                            <%-- limpa campos--%>
                            <input type="button" value="Limpar"  onclick="resetar()" name="restar" class="btn btn-outline-danger"/>
                        </div>

                    </c:if> 
                    
                    <%-- tabela mostragem - bota editar e excluir--%>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    
                    <form method="post" action="${pageContext.request.contextPath}/cadvacina" >
                        <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px;  float: right;
               box-shadow: 0 0 1em black;">
                            <table  class="table table-hover" style="border: 1px solid black; border-collapse: collapse; margin-top: 20px;  width:100%; font-size: 15px" border="1" >
                                <thead class="thead-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Vacina</th>
                                        <th>Doenca</th>


                                    </tr>
                                </thead>
                                <body>
                                    <c:forEach var= "vacina" items="${vacinas}">
                                    <tr>
                                        <td>${vacina.idvacina}</td>
                                        <td>${vacina.vacina}</td>
                                        <td>${vacina.doenca.doenca}</td>
                                        <td>
                                            <%-- botao radio seleciona o item a ser editado ou excluido, ativa botao editar e excluir--%>
                                            <input type ="radio" name="idvacina" value ="${vacina.idvacina}" 
                                                   onclick="habilitar(1); habilitar(2)" required="Selecione">
                                        </td>     
                                    </tr>
                                </c:forEach>
                                </body>

                            </table>  
                        </div>
                        <%-- botao editar--%>
                        <button type="submit" name="editar" class="btn btn-info" value="Editar" style="font-size: 10px;                                
                                width: 60px; margin: 0 auto; float: right;" disabled="disabled" id="1"><i class="fa fa-edit"></i>Editar</button>
                        <%-- abre modal excluit--%>
                        <button type="button" onclick="abrir1()" class="btn btn-danger"  value="Excluir" style="font-size: 10px;
                                width: 60px; margin: 0 auto; float: right;" disabled="disabled" id="2"><i class="fa fa-edit"></i>Excluir</button>  
                        <input type="submit" class="escondido" name="excluir" value="Excluir" id="excluir1"/>

                       <%--inicio modal --%>
                        <div id="myModal1" class="modal1">
                            <!-- Modal conteudo --> 
                            <div class="modal-content1">
                                <span class="close1" onclick="fechar1()">&times;</span>
                                <p>Tem certeza que deseja excluir?</p>
                                <%--botao confirmar excluir --%>
                                <input type="submit" value="Confirmar Excluir" name="excluir" class="btn btn-success" style=" border: 1px solid black;
                                       border-radius: 4px;
                                       width: 20%;
                                       top: -500px;"/>
                                <%-- fechar modal--%>
                                <input type="button" value="Revisar"   name="cancelar"  class="btn btn-danger " onclick="fechar1()"/>
                            </div>
                        </div>
                        <%-- fim modal--%>
                    </form>
                </div>

                <%-- fim conteudo --%>

            </div>
        </div>
        </div>
        
        <script>
            $(document).ready(function() {
                $(".doencas").select2();                   
             });
        </script>
        
        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>











