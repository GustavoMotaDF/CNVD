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
    <style>
        hr{
            border-color:#aaa;
            box-sizing:border-box;
            width:100%;  
        }
    </style>
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
                                    <hr>
                                    <h5><i>Usuario que será Vacinado</i></h5>
                                    <select class="usuarios" name ="idusuario" id="idusuario" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione o Usuario...</option>   
                                        <c:forEach var="usuario" items="${usuario}">
                                            <option value="${usuario.idusuario}">${usuario.cpf}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>
                                     <hr>
                                    
                                                                   

                                    <%-- ID VACINA --%>
                                    <hr>
                                    <h5><i>Vacina a ser tomada</i></h5>
                                    <select class="vacinas" name ="idvacina" id="idvacina" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione a Vacina...</option>   
                                        <c:forEach var="vacina" items="${vacina}">
                                            <option value="${vacina.idvacina}">${vacina.vacina}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>                                
                                    <hr>
                                    
                                    <%-- DOSE --%>
                                    <hr>
                                    <h5><i>Vacina a ser tomada</i></h5>
                                    <select class="doses" name ="dose" id="dose" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="">Selecione a Dose...</option>   
                                        <option value="Primeira">Primeira</option>   
                                        <option value="Segunda">Segunda</option>   
                                        <option value="Terceira">Terceira</option>   
                                        <option value="Reforço">Reforço</option>                                     

                                    </select>
                                    <span class="style1">*</span>                                
                                    <hr>

                                    <%-- Data inicio --%>
                                    <hr> 
                                    <h5><i>Data em que está tomando a vacina</i></h5>
                                    <label for="dia" style="font-weight: bold;">Dia: &nbsp;</label>
                                    <select class="dia" name="dia" id="dia" style="width: 15%; height: 30px;">
                                        <option value="">&nbsp;</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>

                                    </select>  
                                    <label for="mes"style="font-weight: bold;">Mês:</label>
                                    <select class="mes" name="mess" id="mes" style="width: 26%; height: 30px;">
                                        <option value="">Selecione o mês...</option>                                
                                        <option value="Janeiro">Janeiro</option>
                                        <option value="Fevereiro">Fevereiro</option>
                                        <option value="Março">Março</option>
                                        <option value="Abril">Abril</option>
                                        <option value="Maio">Maio</option>
                                        <option value="Junho">Junho</option>
                                        <option value="Julho">Julho</option>
                                        <option value="Agosto">Agosto</option>
                                        <option value="Setembro">Setembro</option>
                                        <option value="Outubro">Outubro</option>
                                        <option value="Novembro">Novembro</option>
                                        <option value="Dezembro">Dezembro</option>

                                    </select>
                                    <label for="ano"style="font-weight: bold;" >Ano:</label>
                                    <select class="ano" name="ano" id="ano" style="width: 12%; height: 30px;">
                                        <option value="">&nbsp;</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                    </select>  
                                    <span class="style1">*</span>
                                    <br>
                                    <hr> 

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
                                    <legend>Cadastro de Registro</legend>
                                    
                                    <%-- USUARio --%>
                                    <hr>
                                    <h5><i>Usuario que está sendo Vacinado</i></h5>
                                    <select class="usuarios" name ="idusuario" id="idusuario" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="${vacinatomadaEditando.usuario.idusuario}">${vacinatomadaEditando.usuario.nome}</option>                                         
                                        <c:forEach var="usuario" items="${usuario}">
                                            <option value="${usuario.idusuario}">${usuario.cpf}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>
                                     <hr>
                                    
                                                                   

                                    <%-- ID VACINA --%>
                                    <hr>
                                    <h5><i>Vacina a ser tomada</i></h5>
                                    <select class="vacinas" name ="idvacina" id="idvacina" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="${vacinatomadaEditando.vacinas.idvacina}">${vacinatomadaEditando.vacinas.vacina}</option>   
                                        <c:forEach var="vacina" items="${vacina}">
                                            <option value="${vacina.idvacina}">${vacina.vacina}</option>
                                        </c:forEach>   
                                    </select>
                                    <span class="style1">*</span>                                
                                    <hr>
                                    
                                    <%-- DOSE --%>
                                    <hr>
                                    <h5><i>Vacina a ser tomada</i></h5>
                                    <select class="doses" name ="dose" id="dose" required="Selecione!" style="width: 70%; height: 30px;">
                                        <option value="${vacinatomadaEditando.dose}">${vacinatomadaEditando.dose}</option>   
                                        <option value="">&nbsp;</option>   
                                        <option value="Primeira">Primeira</option>   
                                        <option value="Segunda">Segunda</option>   
                                        <option value="Terceira">Terceira</option>   
                                        <option value="Reforço">Reforço</option>                                     

                                    </select>
                                    <span class="style1">*</span>                                
                                    <hr>

                                    <%-- Data inicio --%>
                                    <hr> 
                                    <h5><i>Data em que está tomando a vacina</i></h5>
                                    <label for="dia" style="font-weight: bold;">Dia: &nbsp;</label>
                                    <select class="dia" name="dia" id="dia" style="width: 15%; height: 30px;">
                                        <option value="${vacinatomadaEditando.dia}">${vacinatomadaEditando.dia}</option>
                                        <option value="">&nbsp;</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>

                                    </select>  
                                    <label for="mes"style="font-weight: bold;">Mês:</label>
                                    <select class="mes" name="mess" id="mes" style="width: 26%; height: 30px;">
                                        <option value="${vacinatomadaEditando.mess}">${vacinatomadaEditando.mess}</option>                                
                                        <option value="">&nbsp;</option>                                
                                        <option value="Janeiro">Janeiro</option>
                                        <option value="Fevereiro">Fevereiro</option>
                                        <option value="Março">Março</option>
                                        <option value="Abril">Abril</option>
                                        <option value="Maio">Maio</option>
                                        <option value="Junho">Junho</option>
                                        <option value="Julho">Julho</option>
                                        <option value="Agosto">Agosto</option>
                                        <option value="Setembro">Setembro</option>
                                        <option value="Outubro">Outubro</option>
                                        <option value="Novembro">Novembro</option>
                                        <option value="Dezembro">Dezembro</option>

                                    </select>
                                    <label for="ano"style="font-weight: bold;" >Ano:</label>
                                    <select class="ano" name="ano" id="ano" style="width: 12%; height: 30px;">
                                        <option value="${vacinatomadaEditando.ano}">${vacinatomadaEditando.ano}</option>
                                        <option value="">&nbsp;</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                    </select>  
                                    <span class="style1">*</span>
                                    <br>
                                    <hr> 

                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>


                                </fieldset>
                                <%-- submit none, acionado via js--%>    
                                <input type="submit" class="escondido "name="alterar" value="alterar" id="alt"/>
                            

                            <%-- inicio modal--%>
                            <div id="myModal" class="modal">
                                <!-- Modal conteudo -->
                                <div class="modal-content">                                
                                    <span class="close" onclick="fechar()">&times;</span>
                                    <p>Tem certeza que deseja realizar a alteração?</p>
                                    <br>
                                    <div style="float: left">
                                        <%-- envia formulario de alteração--%>
                                        <script>
                                            function alterar() {
                                                document.getElementById('alt').click();
                                            }
                                        </script>
                                        <input type="submit" value="Confirmar"  name="alterar" class="btn btn-success" onclick="alterar()"/>
                                        <%-- fecha modal--%>
                                        <input type="button" value="Revisar"  id="close" name="cancelar"  class="btn btn-danger" onclick="fechar()"/>
                                    </div>                                
                                </div>
                            </div>    
                            <%-- FIM MODAL--%>
                                </form>
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
                                            <td>${vacinatomada.dia}/${vacinatomada.mess}/${vacinatomada.ano}</td>
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
                $(".dia").select2();
                $(".mes").select2();
                $(".ano").select2();
            });
        </script>

        <jsp:include page="includes/imports.jsp"/>
    </body>
</html>
