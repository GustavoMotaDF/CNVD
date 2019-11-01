<%-- 
    Document   : cadastrodoenca
    Created on : 27/06/2019, 06:40:50
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="pt-br">
    <%-- head --%>
    <title>Doenças</title>
    <jsp:include page="includes/head.jsp"/>
    <%-- desativa o ENTER na pagina--%>
    <body onKeyDown="AnalizaTeclas()">
        <div class="wrapper">
            <%-- MENU --%>
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="box-shadow: 0 0 1em black;">                
            <div class="content"  id="ts" >
                <%-- menu superior --%>
                <jsp:include page="includes/menusuperior.jsp"/>
                <%-- FIM MENU --%>
                <%-- conteudo --%>
                <div class="formulario">
                    <c:if test="${empty doencaEditando}">
                        <%-- if PARA SABER SE O USUARIO ESTÁ EDITANDO ALGUMA DOENÇA --%>
                        <%-- FORMULARIO DE CADASTRO DE DOENÇA --%>
                        <form action="${pageContext.request.contextPath}/caddoenca"  method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                            <fieldset id="tabelaconteudo">
                                <legend>Cadastro de Doenca</legend>

                                <%-- DOENCA --%>
                                <label for="doenca" class="alinhamento">Doenca:</label>
                                <input type="text" name="doenca" id="doenca" placeholder="Placebo" required="Preencha"/>
                                <span class="style1">*</span>                        
                                <br>
                                <br>
                                <%-- DOENCA --%>

                            </fieldset>
                            <input type="submit" class="escondido "name="cadastrar" value="Cadastrar" id="cadastrar"/>
                        </form>
                        <%-- FIM DO FOMULARIO DE CADASTRO DE DOENÇA--%>
                        <%-- BOTÃO PARA ABRIR MODAL OU LIMPAR CAMPOS --%>
                        <input type="button" value="Cadastrar" onclick="abrir()" class="btn btn-outline-success"/>
                        <input type="button" value="Limpar"  onclick="resetar()" name="restar" class="btn btn-outline-danger"/>
                        <%-- INICIO DO MODAL --%>
                        <div id="myModal" class="modal">                            
                            <div class="modal-content">                                
                                <span class="close" onclick="fechar()">&times;</span>
                                <p>Tem certeza que deseja realizar o cadastro?</p>
                                <br>
                                <div style="float: left">
                                    <input type="button" value="Cadastrar"  onclick="enviar()" class="btn btn-success" name="cadastrar" />
                                    <input type="button" value="Revisar"  id="close" name="cancelar" class="btn btn-danger" onclick="fechar()"/>
                                </div>                                
                            </div>
                        </div> 
                        <%-- FIM DO MODAL --%>


                        
                    </c:if>
                    <%--FIM DO IF NÃO EDITANDO --%>
                    <c:if test="${not empty doencaEditando}">
                    <%-- INICIO IF EDITANDO--%>
                    <%-- INICIO FORMULARIO EDITANDO DOENCA--%>
                    
                        <form action="${pageContext.request.contextPath}/caddoenca" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)">
                            <fieldset id="tabelaconteudo">
                                <legend>Alteração de Doenca</legend>
                                <input type ="hidden" name="iddoenca" value="${doencaEditando.iddoenca}"/>
                                <%-- Doenca --%>
                                <label for="doenca" class="alinhamento">Doenca:</label>
                                <input type="text" name="doenca" value="${doencaEditando.doenca}" id="doenca" placeholder="Placebo"/>
                                <span class="style1">*</span>
                                <br>
                            </fieldset>
                            <input type="submit" class="escondido "name="alterar" value="Alterar" id="alterar"/>
                        </form>
                        <%-- FIM FORMULARIO EDITANDO DOENÇA --%>

                        <%-- BOTÃO ABRIR MODAL OU LIMPAR CAMPOS--%>
                        <input type="button" value="Alterar" onclick="abrir()" class="btn btn-outline-success"/>
                        <input type="button" value="Limpar"  onclick="resetar()" name="restar" class="btn btn-outline-danger"/>
                        <%-- INICIO MODAL --%>
                        <div id="myModal" class="modal">
                            <div class="modal-content">                                
                                <span class="close" onclick="fechar()">&times;</span>
                                <p>Tem certeza que deseja realizar a alteração?</p>
                                <br>
                                <div style="float: left">
                                    <input type="button" value="Confirmar Alterar" class="btn btn-success" onclick="alterar()" name="alterar" />
                                    <input type="button" value="Revisar"  id="close" name="cancelar" class="btn btn-danger" onclick="fechar()"/>
                                </div>                                
                            </div>
                        </div>
                        <%-- FIM MODAL --%>
                    <%-- FIM IF EDITANDO --%>    
                    </c:if>     
                    <%-- INICIO FORMULARIO-TABELA EDITANDO-EXCLUIR --%>    
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                     
                    
                    <form method="post" action="${pageContext.request.contextPath}/caddoenca" >          
                        <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px;  float: right; box-shadow: 0 0 1em black;">
                            <table class="table table-hover" style="border: 1px solid black; border-collapse: collapse; margin-top: 20px;  width:100%; font-size: 15px" border="1" >
                                <thead class="thead-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Doenca</th>
                                    </tr>
                                </thead>
                                <body>
                                    <c:forEach var= "doenca" items="${doenca}">
                                    <tr>
                                        <td>${doenca.iddoenca}</td>
                                        <td>${doenca.doenca}</td>                                        
                                        <td>
                                            <input type ="radio" name="iddoenca" id="radiodoenca"
                                                   onclick="habilitar(1); habilitar(2)" value ="${doenca.iddoenca}" required="Selecione">
                                        </td>

                                    </tr>
                                </c:forEach>
                                </body>

                            </table>     
                        </div>    
                            <%-- BOTÃO EDITAR --%>
                                <button type="submit" name="editar" class="btn btn-info" value="Editar" style="font-size: 10px;                                
                                width: 60px; margin: 0 auto; float: right;" disabled="disabled" id="1"><i class="fa fa-edit"></i>Editar</button>
                                
                                <%-- BOTÃO ABRIR MODAL-EXCLUIR --%>
                                <button type="button" onclick="abrir1()" class="btn btn-danger" disabled="disabled" id="2"value="Excluir" style="font-size: 10px;
                                width: 60px; margin: 0 auto; float: right;"><i class="fa fa-edit"></i>Excluir</button>  
                                
                                <%-- BOTÃO EXCLUI OCULTO --%>
                                <input type="submit" class="escondido" name="excluir" value="Excluir" id="excluir1"/>                                
                                       
                                <%-- INICIO MODAL --%>
                               
                                <div id="myModal1" class="modal1">
                                  <div class="modal-content1">
                                      <span class="close1" onclick="fechar1()">&times;</span>
                                         <p>Tem certeza que deseja excluir?</p>
                                         <input type="submit" value="Confirmar Excluir" name="excluir" class="btn btn-success" style=" border: 1px solid black;
                                                border-radius: 4px;
                                                width: 20%;
                                                top: -500px;" />
                                        <input type="button" value="Revisar"   name="cancelar"  class="btn btn-danger" onclick="fechar1()"/>
                                  </div>
                                </div>
                                <%-- FIM DO MODAL --%>                               
                                
                    </form>            
                    <%-- FIM FORMULARIO-TABELA --%>   
                </div>

                <%-- MENSAGENS ERRO OU SUCESSO --%>
                <div style="color: green" id="msgerro"><h1>${mensagemSucesso} </h1> </div>
                <div style="color: red"><h1> ${mensagemErro}</h1></div>
                <%-- fim conteudo --%>
            </div>
            </div>
        </div>
                <jsp:include page="includes/imports.jsp"/>       
    
    </body>
</html>












