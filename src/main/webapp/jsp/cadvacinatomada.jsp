<%-- 
    Document   : cadastrovacina
    Created on : 27/06/2019, 06:23:45
    Author     : gustavo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-br">
     <%-- head --%>
    <title>Vacinar Usuário</title>
    <script type="text/javascript" src="jsp/js/Cadastro.js"></script>
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

                        <c:if test="${empty vacinatomadaEditando}">
                            <%-- inicio formulario de cadastro--%>
                            <form action="${pageContext.request.contextPath}/cadvacinatomada" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                                <fieldset id="tabelaconteudo">
                                    <legend>Cadastro de Registro</legend>
                                    <%-- USUARio --%>
                                    <label ><b>Usuário: </b></label><br>
                                    <select class="usuarios" name ="idusuario" id="idusuario" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione o Usuario...</option>   
                                        <c:forEach var="usuario" items="${usuario}">
                                            <option value="${usuario.idusuario}">${usuario.cpf}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>
                                    <br>                                

                                    <%-- ID VACINA --%>
                                    <label ><b>Vacina a ser Tomada:</b></label><br>
                                    <select class="vacinas" name ="idvacina" id="idvacina" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione a Vacina...</option>   
                                        <c:forEach var="vacina" items="${vacina}">
                                            <option value="${vacina.idvacina}">${vacina.vacina}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>                                
                                    <br>
                                    <%-- DOSE --%>
                                    <label><b>Dose a ser Tomada:</b></label><br>
                                    <select class="doses" name ="dose" id="dose" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione a Dose...</option>   
                                        <option value="Primeira">Primeira</option>   
                                        <option value="Segunda">Segunda</option>   
                                        <option value="Terceira">Terceira</option>   
                                        <option value="Reforço">Reforço</option>                                     

                                    </select>
                                    <span class="style1">*</span>                                
                                    <br>

                                    <label><b>Data que está tomando a vacina:</b></label><br>
                                    <input type="date" name="datavacinacao" id="datavacinacao" style="width: 70%; height: 30px;"/>
                                    <span class="style1">*</span>

                                    <br>
                                    <br>
                                    <br>
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

                        <c:if test="${not empty vacinatomadaEditando}">
                            <%-- inicio formulario editar--%>
                            <form action="${pageContext.request.contextPath}/cadvacinatomada" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                                <fieldset id="tabelaconteudo">
                                    <legend>Alteração de Registro</legend>
                                    <input type ="hidden" name="idvacinatomada" value="${vacinatomadaEditando.idvacinatomada}"/>

                                    <%-- USUARio --%>
                                    <label ><b>Usuário:</b></label><br>
                                    <select class="usuarios" name ="idusuario" id="idusuario" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="${vacinatomadaEditando.usuario.idusuario}">${vacinatomadaEditando.usuario.cpf}</option>   
                                        <c:forEach var="usuario" items="${usuario}">
                                            <option value="${usuario.idusuario}">${usuario.cpf}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>
                                    <br>                                

                                    <%-- ID VACINA --%>
                                    <label ><b>Vacina a ser Tomada:</b></label><br>
                                    <select class="vacinas" name ="idvacina" id="idvacina" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="${vacinatomadaEditando.vacinas.idvacina}">${vacinatomadaEditando.vacinas.vacina}</option>   
                                        <c:forEach var="vacina" items="${vacina}">
                                            <option value="${vacina.idvacina}">${vacina.vacina}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>                                
                                    <br>
                                    <%-- DOSE --%>
                                    <label ><b>Dose a ser Tomada: </b></label><br>
                                    <select class="doses" name ="dose" id="dose" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="$${vacinatomadaEditando.dose}">${vacinatomadaEditando.dose}</option>   
                                        <option value="Primeira">Primeira</option>   
                                        <option value="Segunda">Segunda</option>   
                                        <option value="Terceira">Terceira</option>   
                                        <option value="Reforço">Reforço</option>                                     

                                    </select>
                                    <span class="style1">*</span>                                
                                    <br>

                                    <label ><b>Data que está tomando a vacina:</b><b></label><br>
                                    <input type="date" name="datavacinacao" id="datavacinacao" value="${vacinatomadaEditando.datavacinacao}" style="width: 70%; height: 30px;"/>
                                    <span class="style1">*</span>

                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                </fieldset>
                                <%-- botao:none acionado via js--%>
                                <input type="submit" class="escondido" name="alterar" value="Alterar" id="alterar" />
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
                                        <input type="button" value="Confirmar"  onclick="alterar()" name="alterar" id="alterar"class="btn btn-success"/>
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

                        <form method="post" action="${pageContext.request.contextPath}/cadvacinatomada" >
                            <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px;  float: right;
                                 box-shadow: 0 0 1em black;">
                                <table  class="table table-hover" style="border: 1px solid black; border-collapse: collapse; margin-top: 20px;  width:100%; font-size: 15px" border="1" >
                                    <thead class="thead-light">
                                        <tr>
                                            <th>ID</th>
                                            <th>Usuario</th>
                                            <th>Vacina</th>
                                            <th>Dose</th>
                                            <th>Data de Vacinação</th>


                                        </tr>
                                    </thead>
                                    <body>
                                        <c:forEach var= "vacinatomada" items="${vacinatomada}">
                                        <tr>
                                            <td>${vacinatomada.idvacinatomada}</td>
                                            <td>${vacinatomada.usuario.nome}</td>
                                            <td>${vacinatomada.vacinas.vacina}</td>                                        
                                            <td>${vacinatomada.dose}</td>
                                            <td>${vacinatomada.datavacinacao}</td>
                                            <td>
                                                <%-- botao radio seleciona o item a ser editado ou excluido, ativa botao editar e excluir--%>
                                                <input type ="radio" name="idvacinatomada" value ="${vacinatomada.idvacinatomada}" 
                                                       onclick="habilitar(1); habilitar(2)" required="Selecione">
                                            </td>                                         </tr>
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
            $(document).ready(function () {
                $(".usuarios").select2();
                $(".vacinas").select2();
                $(".doses").select2();
            });
        </script>

        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>
