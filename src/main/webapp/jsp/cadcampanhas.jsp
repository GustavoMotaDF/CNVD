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
    <title>Campanhas</title>
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
                    <c:if test="${empty campanhaEditando}">
                        <%-- inicio formulario de cadastro--%>
                        <form action="${pageContext.request.contextPath}/cadcampanha" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                            <fieldset id="tabelaconteudo">
                                <legend>Cadastro de Campanha</legend>

                                <%-- Descrição da campanha --%>
                                <label for="descricaocampanha" class="alinhamento"><b>Descrição: </b></label>
                                <textarea style="width: 70%!important" name="descricaocampanha" id="descricaocampanha" placeholder="Descrição da campanha" required="Preencha o campo!"></textarea>
                                
                                <span class="style1">*</span>
                                <br>
                                <br>
                                <%-- Estado do Usuario --%>
                                <label for="estadousuarios" class="alinhamento">Estado da Campanha:</label>
                                <select name ="estadousuarios" id="estadousuarios" required="Selecione!" style="width: 70%; height: 30px;">
                                    <option value="">Selecione o Estado...</option>   
                                    <option value="1">Acre</option>
                                    <option value="2">Alagoas</option>
                                    <option value="3">Amapá</option>
                                    <option value="4">Amazonas</option>
                                    <option value="5">Bahia</option>
                                    <option value="6">Ceará</option>
                                    <option value="7">Distrito Federal</option>
                                    <option value="8">Espírito Santo</option>
                                    <option value="9">Goiás</option>
                                    <option value="10">Maranhão</option>
                                    <option value="11">Mato Grosso</option>
                                    <option value="12">Mato Grosso do Sul</option>
                                    <option value="13">Minas Gerais</option>
                                    <option value="14">Pará</option>
                                    <option value="15">Paraíba</option>
                                    <option value="16">Paraná</option>
                                    <option value="17">Pernambuco</option>
                                    <option value="18">Piauí</option>
                                    <option value="19">Rio de Janeiro</option>
                                    <option value="20">Rio Grande do Norte</option>
                                    <option value="21">Rio Grande do Sul</option>
                                    <option value="22">Rondônia</option>
                                    <option value="23">Roraima</option>
                                    <option value="24">Santa Catarina</option>
                                    <option value="25">São Paulo</option>
                                    <option value="26">Sergipe</option>
                                    <option value="27">Tocantins</option>
                                    
                                </select>
                                <span class="style1">*</span>
                                <br>
                                <label for="datacampanha" class="alinhamento" >Data inicio:</label>
                                <input type="date" name="datacampanha" id="datacampanha" style="width: 70%; height: 30px;"/>
                                <span class="style1">*</span>
                                <br>
                                <label for="datacampanhafim" class="alinhamento" >Data final:</label>
                                <input type="date" name="datacampanhafim" id="datacampanhafim" style="width: 70%; height: 30px;"/>
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

                    <c:if test="${not empty campanhaEditando}">
                        <%-- inicio formulario editar--%>
                        <form action="${pageContext.request.contextPath}/cadcampanha" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                            <fieldset id="tabelaconteudo">
                                <legend>Alteração de Vacina</legend>
                                <input type ="hidden" name="idcampanha" value="${campanhaEditando.idcampanha}"/>
                                
                                <%-- Descrição da campanha --%>                
                                <label for="descricaocampanha" class="alinhamento"><b>Descrição: </b></label>
                                <textarea style="width: 70%!important" name="descricaocampanha" id="descricaocampanha" placeholder="Descrição da campanha" required="Preencha o campo!">${campanhaEditando.descricaocampanha}</textarea>
                                
                                <span class="style1">*</span>                     
                                <br>
                                <%-- Estado do Usuario --%>
                                <label for="estadousuarios" class="alinhamento">Estado da Campanha:</label>
                                <select name ="estadousuarios" id="estadousuarios" required="Selecione!" style="width: 70%; height: 30px;">
                                    <option value="${campanhaEditando.estadousuarios.idestado}">${campanhaEditando.estadousuarios.estado}-${campanhaEditando.estadousuarios.uf}</option>   
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
                                    <option value="11">Mato Grosso</option>
                                    <option value="12">Mato Grosso do Sul</option>
                                    <option value="13">Minas Gerais</option>
                                    <option value="14">Pará</option>
                                    <option value="15">Paraíba</option>
                                    <option value="16">Paraná</option>
                                    <option value="17">Pernambuco</option>
                                    <option value="18">Piauí</option>
                                    <option value="19">Rio de Janeiro</option>
                                    <option value="20">Rio Grande do Norte</option>
                                    <option value="21">Rio Grande do Sul</option>
                                    <option value="22">Rondônia</option>
                                    <option value="23">Roraima</option>
                                    <option value="24">Santa Catarina</option>
                                    <option value="25">São Paulo</option>
                                    <option value="26">Sergipe</option>
                                    <option value="27">Tocantins</option>
                                    
                                </select>
                                <span class="style1">*</span>
                                <br>
                                <label for="datacampanha" class="alinhamento" >Data:</label>
                                <input type="date" name="datacampanha" id="datacampanha" value="${campanhaEditando.datacampanha}" style="width: 70%; height: 30px;"/>
                                <span class="style1">*</span>
                                <br>
                                <label for="datacampanhafim" class="alinhamento" >Data final:</label>
                                <input type="date" name="datacampanhafim" id="datacampanhafim" value="${campanhaEditando.datacampanhafim}"style="width: 70%; height: 30px;"/>
                                <span class="style1">*</span>
                                <br>
                                <br>
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
                    
                    <form method="post" action="${pageContext.request.contextPath}/cadcampanha" >
                        <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px;  float: right;
               box-shadow: 0 0 1em black;">
                            <table  class="table table-hover" style="border: 1px solid black; border-collapse: collapse; margin-top: 20px;  width:100%; font-size: 15px" border="1" >
                                <thead class="thead-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Descrição Campanha</th>
                                        <th>Estado da Campanha</th>
                                        <th>Data da Campanha inicio</th>
                                        <th>Data da Campanha fim</th>


                                    </tr>
                                </thead>
                                <body>
                                    <c:forEach var= "campanha" items="${campanha}">
                                    <tr>
                                        <td>${campanha.idcampanha}</td>
                                        <td>${campanha.descricaocampanha}</td>
                                        <td>${campanha.estadousuarios.estado}-${campanha.estadousuarios.uf}</td>
                                        <td>${campanha.datacampanha}</td>
                                        <td>${campanha.datacampanhafim}</td>
                                        <td>
                                            <%-- botao radio seleciona o item a ser editado ou excluido, ativa botao editar e excluir--%>
                                            <input type ="radio" name="idcampanha" value ="${campanha.idcampanha}" 
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
        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>











