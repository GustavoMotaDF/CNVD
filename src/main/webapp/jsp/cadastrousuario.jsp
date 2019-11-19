<%-- 
    Document   : cadastrousuario
    Created on : 26/06/2019, 16:46:51
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html lang="pt-br">
<html lang="pt-br">
    <%-- head --%>
    <title>Usuários</title>
    <jsp:include page="includes/head.jsp"/>
    <style>
        hr{
            border-color:#aaa;
            box-sizing:border-box;
            width:100%;  
        }
    </style>
    <%-- desativa o ENTER na pagina--%>
    <body onKeyDown="AnalizaTeclas()">

        <div class="wrapper">
            <jsp:include page="includes/menu.jsp"/>
            <div class="container border" style="
                 box-shadow: 0 0 1em black;">
                <div class="content"  id="ts" >
                    <%-- menu superior --%>
                    <jsp:include page="includes/menusuperior.jsp"/>
                    <%-- FIM MENU --%>
                    <%-- conteudo --%>

                    <div class="formulario">
                        <div style="color: green">${mensagemSucesso}</div>
                        <div style="color: red">${mensagemErro}</div>
                        <c:if test="${empty usuarioEditando}">

                            <%-- Inicio formulario de cadastro de usuario --%>

                            <form action="${pageContext.request.contextPath}/cadusuario" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                                <fieldset id="tabelaconteudo" >
                                    <legend>Cadastro de Usuario</legend>

                                    <div class="form-group" >
                                        <div style="margin: 10px">
                                            <hr>
                                            <h5><i>Informações Pessoais</i></h5>
                                            <hr>
                                            <br>

                                            <%-- NOME --%>
                                            <label for="nome" class="alinhamento">Nome:</label>
                                            <input type="text" name="nome" maxlength="60" id="nome" placeholder="João Maria"/>
                                            <span class="style1">*</span>                            
                                            <br>

                                            <%-- CPF--%>
                                            <label for="cpf" class="alinhamento">CPF:</label>
                                            <input type="text"  onkeypress="return sonumeros(event)" class ="cpf" id="cpf" name="cpf"maxlength="11" pattern="[0-9]{11}" title="Digite apenas numeros!"placeholder="Apenas Numeros"/>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- RG --%>
                                            <label for="rg" class="alinhamento">RG:</label>
                                            <input type="text" onkeypress="return sonumeros(event)" id ="rg" name="rg" maxlength="9" pattern="[0-9]{5-9}" title="Digite apenas numeros!" placeholder="Apenas Numeros"/>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- SEXO --%>
                                            <label for="sexo" class="alinhamento">Sexo:</label>
                                            <select class="sexo" name ="sexo" id="sexo" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o sexo...</option>                                
                                                <option value="M">M</option>
                                                <option value="F">F</option>

                                            </select>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- TIPOS ANGUINEO --%>
                                            <label for="tiposanguineo" class="alinhamento">Tipo Sanguineo:</label>
                                            <select class="tiposanguineos" name ="tiposanguineo" id="tiposanguineo" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o Tipo Sanguineo...</option>                                
                                                <option value="A+">A+</option>
                                                <option value="A-">A-</option>
                                                <option value="B+">B+</option>
                                                <option value="B-">B-</option>
                                                <option value="AB+">AB+</option>
                                                <option value="AB-">AB-</option>
                                                <option value="O+">O+</option>
                                                <option value="O-">O-</option>
                                                <option value="N\D">N\D</option>

                                            </select>
                                            <span class="style1">*</span>

                                            <br>
                                            <%-- DATANASCIMENTO--%>
                                            <label for="dia"style="font-weight:bold;" >DaNasc:</label>
                                            <label for="dia" style="font-weight:bold;">Dia:</label>
                                            <select class="dia" name="dia" id="dia" style="width: 10%; height: 30px;">
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
                                            <label for="mes" style="font-weight:bold;">Mês:</label>
                                            <select class="mes" name="mes" id="mes" style="width: 30%; height: 30px;">
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
                                            <label for="ano" style="font-weight:bold;">Ano:</label>
                                            <select class="ano" name="ano" id="ano" style="width: 20%; height: 30px;">
                                                <option value="2019">2019</option>
                                                <option value="2018">2018</option>
                                                <option value="2017">2017</option>
                                                <option value="2016">2016</option>
                                                <option value="2015">2015</option>
                                                <option value="2014">2014</option>
                                                <option value="2013">2013</option>
                                                <option value="2012">2012</option>
                                                <option value="2011">2011</option>
                                                <option value="2010">2010</option>
                                                <option value="2009">2009</option>
                                                <option value="2008">2008</option>
                                                <option value="2007">2007</option>
                                                <option value="2006">2006</option>
                                                <option value="2005">2005</option>
                                                <option value="2004">2004</option>
                                                <option value="2003">2003</option>
                                                <option value="2002">2002</option>
                                                <option value="2001">2001</option>
                                                <option value="2000">2000</option>
                                                <option value="1999">1999</option>
                                                <option value="1998">1998</option>
                                                <option value="1997">1997</option>
                                                <option value="1996">1996</option>
                                                <option value="1995">1995</option>
                                                <option value="1994">1994</option>
                                                <option value="1993">1993</option>
                                                <option value="1992">1992</option>
                                                <option value="1991">1991</option>
                                                <option value="1990">1990</option>
                                                <option value="1989">1989</option>
                                                <option value="1988">1988</option>
                                                <option value="1987">1987</option>
                                                <option value="1986">1986</option>
                                                <option value="1985">1985</option>
                                                <option value="1984">1984</option>
                                                <option value="1983">1983</option>
                                                <option value="1982">1982</option>
                                                <option value="1981">1981</option>
                                                <option value="1980">1980</option>
                                                <option value="1979">1979</option>
                                                <option value="1978">1978</option>
                                                <option value="1977">1977</option>
                                                <option value="1976">1976</option>
                                                <option value="1975">1975</option>
                                                <option value="1974">1974</option>
                                                <option value="1973">1973</option>
                                                <option value="1972">1972</option>
                                                <option value="1971">1971</option>
                                                <option value="1970">1970</option>
                                                <option value="1969">1969</option>
                                                <option value="1968">1968</option>
                                                <option value="1967">1967</option>
                                                <option value="1966">1966</option>
                                                <option value="1965">1965</option>
                                                <option value="1964">1964</option>
                                                <option value="1963">1963</option>
                                                <option value="1962">1962</option>
                                                <option value="1961">1961</option>
                                                <option value="1960">1960</option>
                                                <option value="1959">1959</option>
                                                <option value="1958">1958</option>
                                                <option value="1957">1957</option>
                                                <option value="1956">1956</option>
                                                <option value="1955">1955</option>
                                                <option value="1954">1954</option>
                                                <option value="1953">1953</option>
                                                <option value="1952">1952</option>
                                                <option value="1951">1951</option>
                                                <option value="1950">1950</option>
                                                <option value="1949">1949</option>
                                                <option value="1948">1948</option>
                                                <option value="1947">1947</option>
                                                <option value="1946">1946</option>
                                                <option value="1945">1945</option>
                                                <option value="1944">1944</option>
                                                <option value="1943">1943</option>
                                                <option value="1942">1942</option>
                                                <option value="1941">1941</option>
                                                <option value="1940">1940</option>
                                                <option value="1939">1939</option>
                                                <option value="1938">1938</option>
                                                <option value="1937">1937</option>
                                                <option value="1936">1936</option>
                                                <option value="1935">1935</option>
                                                <option value="1934">1934</option>
                                                <option value="1933">1933</option>
                                                <option value="1932">1932</option>
                                                <option value="1931">1931</option>
                                                <option value="1930">1930</option>
                                                <option value="1929">1929</option>
                                                <option value="1928">1928</option>
                                                <option value="1927">1927</option>
                                                <option value="1926">1926</option>
                                                <option value="1925">1925</option>
                                                <option value="1924">1924</option>
                                                <option value="1923">1923</option>
                                                <option value="1922">1922</option>
                                                <option value="1921">1921</option>
                                                <option value="1920">1920</option>
                                            </select>                            
                                            <br>
                                            <label for="grupos" class="alinhamento">Grupo de risco:</label>
                                            <select class="grupos" name ="grupos" id="grupos" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o Grupo...</option> 
                                                <option value="1">Doentes Cronicos</option>
                                                <option value="2">Idosos</option>
                                                <option value="3">Gestantes</option>
                                                <option value="4">Crianças de 1 a 4 anos</option>
                                                <option value="5">Sem grupo</option>

                                            </select>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- localNASCIMENTO--%>
                                            <label for="localnascimento" class="alinhamento">Local Nasc':</label>
                                            <input type="text" onkeypress="return socaracter(event)" name="localnascimento" id="localnascimento" placeholder="Ex: Taguatinga-DF"/>
                                            <span class="style1">*</span>
                                            <br>
                                            <%-- EMAIL--%>
                                            <label for="email" class="alinhamento">Email:</label>
                                            <input type="text" name="email" id="email" pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="Digite um E-mail valido!" placeholder="Apenas E-mail valido!"/>
                                            <span class="style1">*</span>
                                            <br>
                                            <%-- TELEFONE--%>

                                            <label for="telefone" class="alinhamento">Telefone:</label>
                                            <input type="text"  onkeypress="return sonumeros(event)" name="telefone"  id="telefone" maxlength="11"  pattern="[0-9]{11}" title="Digite apenas numeros!" maxlength="11" placeholder="(ddd) 9 seu - numero"/>
                                            <span class="style1">*</span>

                                            <br>
                                        </div>
                                    </div>
                                    <br>
                                    

                                    <div class="form-group" >
                                        <div style="margin: 10px"> <br>
                                            <hr>
                                            <h5><i>Endereço</i></h5>
                                            <hr> 
                                            <br>
                                            <%-- CEP--%>
                                            <label for="cep" class="alinhamento">CEP:</label>
                                            <input type="text" id="cep" onkeypress="return sonumeros(event)" name="cep" maxlength="8" pattern="[0-9]{6-8}" placeholder="99.999-999" />
                                            <span class="style1">*</span>

                                            <br>
                                            <%-- LOGRADOURO--%>
                                            <label for="endereco" class="alinhamento">Logradouro:</label>
                                            <input type="text" name="logradouro" id="endereco" placeholder="Ex: Quadra 10, Rua Maria, Conjunto K " />
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- BAIRRO--%>
                                            <label for="bairro" class="alinhamento">Bairro:</label>
                                            <input type="text" name="bairro" id="bairro" placeholder="Ex: Taguatinga Sul " />
                                            <span class="style1">*</span>                            
                                            <br>

                                            <%-- numerodacasa--%>
                                            <label for="numerocasa" class="alinhamento">Nº Casa:</label>
                                            <input type="text" onkeypress="return sonumeros(event)" name="numerocasa" id="numerocasa" maxlength="5" placeholder="01"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- cidade--%>
                                            <label for="cidade" class="alinhamento">Cidade</label>
                                            <input type="text" name="cidade" onkeypress="return socaracter(event)" id="cidade" placeholder="Taguatinga"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- ESTADO --%>
                                            <label  for="idestado" class="alinhamento">Estado:</label>
                                            <select class="estados" name ="idestado" id="idestado" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o Estado...</option>   
                                                <c:forEach var="estado" items="${estados}">
                                                    <option value="${estado.idestado}">${estado.estado}</option>
                                                </c:forEach>   
                                            </select>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- TIPORESIDENCIA --%>
                                            <label for="tiporesidencia" class="alinhamento">Tipo Residencia:</label>
                                            <select  class="tiporesidencias" name ="tiporesidencia" id="tiporesidencia" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o Tipo...</option>                                  
                                                <option value="Casa Urbana">Casa Urbana</option>
                                                <option value="Casa Rural">Casa Rural</option>
                                                <option value="Residencia Comercial">Residencia Comercial</option>
                                                <option value="Apartamento">Apartamento</option>

                                            </select>
                                            <span class="style1">*</span>
                                            <br>
                                        </div>
                                    </div>
                                    <br>
                                    


                                    <div class="form-group" >
                                        <div style="margin: 10px"><br>
                                            <hr> 
                                            <h5><i>Login e Permissão</i></h5>   
                                            <hr> 
                                            <br>

                                            <%-- LOGIN--%>
                                            <label for="login" class="alinhamento">Login:</label>
                                            <input type="text" name="login" onkeypress="return sonumeros(event)" id="login" maxlength="11"  pattern="[0-9]{11}"placeholder="Por padrão será o CPF"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- SENHA--%>
                                            <label for="senha" class="alinhamento">Senha:</label>
                                            <input type="password" name="senha" onkeypress="return sonumeros(event)" id="senha" maxlength="11"  pattern="[0-9]{11}" placeholder="Por padrão será o CPF"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- TIPOUSUARIO --%>
                                            <label for="idtipousuario" class="alinhamento">Tipo Usuarios:</label>
                                            <select class="tiposdeusuarios" name ="idtipousuarios" id="idtipousuario" style="width: 70%; height: 30px;">
                                                <option value="">Selecione o Tipo...</option>   
                                                <c:forEach var="tipousuario" items="${tipousuarios}">
                                                    <option value="${tipousuario.idtipousuario}">${tipousuario.tipousuario}</option>
                                                </c:forEach>   
                                            </select>
                                            <span class="style1">*</span>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <%-- submit em display:none (será acionado via js)--%> 
                                    <input type="submit" class="escondido "name="cadastrar" value="Cadastrar" id="cadastrar"/>

                                </fieldset>  
                            </form>
                            <%-- botoes do formulario--%>        
                            <div id="botoes" >
                                <%-- botoes do formulario = abre modal --%>
                                <input type="button" value="Cadastrar" onclick="abrir()" class="btn btn-outline-success"/>
                                <%-- botoes do formulario = limpa campos--%>
                                <input type="button" value="Limpar"  onclick="resetar()" name="restar" class="btn btn-outline-danger"/>
                            </div>

                            <%--inicio modal --%>    
                            <div id="myModal" class="modal">
                                <!-- Modal conteudo modal -->
                                <div class="modal-content">                                
                                    <span class="close" onclick="fechar()">&times;</span>
                                    <p>Tem certeza que deseja realizar a alteração?</p>
                                    <br>
                                    <div style="float: left">
                                        <%-- envia formulario--%>
                                        <input type="button" value="Cadastrar"  onclick="enviar()" name="cadastrar" class="btn btn-success"/>
                                        <%-- fecha modal--%>
                                        <input type="button" value="Revisar"  id="close" name="cancelar"  class="btn btn-danger" onclick="fechar()"/>
                                    </div>                                
                                </div>
                            </div>
                            <%--fim modal --%>         
                            <%-- fim formulario de cadastro --%> 
                        </c:if>

                        <%--inicio editar usuario --%> 
                        <c:if test="${not empty usuarioEditando}">
                            <form action="${pageContext.request.contextPath}/cadusuario" method="post" name="formulariocadastro" class="conteudo" onsubmit="return validarform(this)" >
                                <fieldset id="tabelaconteudo">
                                    <legend>Formulario de Cadastro</legend>
                                    <input type ="hidden" name="idusuario" value="${usuarioEditando.idusuario}"/>
                                    <div class="form-group" >
                                        <div style="margin: 10px">
                                            <hr>
                                            <h5><i>Informações Pessoais</i></h5>
                                            <hr>
                                            <br>

                                            <%-- NOME --%>

                                            <label for="nome" class="alinhamento">Nome:</label>
                                            <input type="text" name="nome" value="${usuarioEditando.nome}"maxlength="60" id="nome" placeholder="João Maria"/>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- CPF--%>
                                            <label for="cpf" class="alinhamento">CPF:</label>
                                            <input type="text"  onkeypress="return sonumeros(event)" value="${usuarioEditando.cpf}" class ="cpf" id="cpf" name="cpf"maxlength="14" pattern="[0-9]{11}" title="Digite apenas numeros!"placeholder="Apenas Numeros"/>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- RG --%>
                                            <label for="rg" class="alinhamento">RG:</label>
                                            <input type="text" onkeypress="return sonumeros(event)" value="${usuarioEditando.rg}" id ="rg" name="rg" maxlength="9" pattern="[0-9]{5-9}" title="Digite apenas numeros!" placeholder="Apenas Numeros"/>
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- SEXO --%>
                                            <label for="sexo" class="alinhamento">Sexo:</label>
                                            <select class="sexo" name ="sexo" id="sexo" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.sexo}">${usuarioEditando.sexo}</option>                                 
                                                <option value="M">M</option>
                                                <option value="F">F</option>

                                            </select>
                                            <span class="style1">*</span>                            
                                            <br>

                                            <%-- TIPOS ANGUINEO --%>
                                            <label for="tiposanguineo" class="alinhamento">Tipo Sanguineo:</label>
                                            <select class="tiposanguineos" name ="tiposanguineo" id="tiposanguineo" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.tiposanguineo}">${usuarioEditando.tiposanguineo}</option>                                
                                                <option value="A+">A+</option>
                                                <option value="A-">A-</option>
                                                <option value="B+">B+</option>
                                                <option value="B-">B-</option>
                                                <option value="AB+">AB+</option>
                                                <option value="AB-">AB-</option>
                                                <option value="O+">O+</option>
                                                <option value="O-">O-</option>
                                                <option value="N\D">N\D</option>


                                            </select>
                                            <span class="style1">*</span>                            
                                            <br>



                                            <%-- DATANASCIMENTO--%>
                                            <%-- DATANASCIMENTO--%>
                                            <label for="dia" style="font-weight:bold;" >DaNasc:</label>
                                            <label for="dia" style="font-weight:bold;" >Dia:</label>
                                            <select class="dia" name="dia" id="dia" style="width: 10%; height: 30px;">
                                                <option value="${usuarioEditando.dia}">${usuarioEditando.dia}</option>
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
                                            <label for="mes" style="font-weight:bold;">Mês:</label>
                                            <select class="mes" name="mes" id="mes" style="width: 30%; height: 30px;">
                                                <option value="${usuarioEditando.mes}">${usuarioEditando.mes}</option>                                
                                                <option value=""></option>
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
                                            <label for="ano" style="font-weight:bold;">Ano:</label>
                                            <select class="ano" name="ano" id="ano" style="width: 20%; height: 30px;">
                                                <option value="${usuarioEditando.ano}">${usuarioEditando.ano}</option>
                                                <option value="2019">2019</option>
                                                <option value="2018">2018</option>
                                                <option value="2017">2017</option>
                                                <option value="2016">2016</option>
                                                <option value="2015">2015</option>
                                                <option value="2014">2014</option>
                                                <option value="2013">2013</option>
                                                <option value="2012">2012</option>
                                                <option value="2011">2011</option>
                                                <option value="2010">2010</option>
                                                <option value="2009">2009</option>
                                                <option value="2008">2008</option>
                                                <option value="2007">2007</option>
                                                <option value="2006">2006</option>
                                                <option value="2005">2005</option>
                                                <option value="2004">2004</option>
                                                <option value="2003">2003</option>
                                                <option value="2002">2002</option>
                                                <option value="2001">2001</option>
                                                <option value="2000">2000</option>
                                                <option value="1999">1999</option>
                                                <option value="1998">1998</option>
                                                <option value="1997">1997</option>
                                                <option value="1996">1996</option>
                                                <option value="1995">1995</option>
                                                <option value="1994">1994</option>
                                                <option value="1993">1993</option>
                                                <option value="1992">1992</option>
                                                <option value="1991">1991</option>
                                                <option value="1990">1990</option>
                                                <option value="1989">1989</option>
                                                <option value="1988">1988</option>
                                                <option value="1987">1987</option>
                                                <option value="1986">1986</option>
                                                <option value="1985">1985</option>
                                                <option value="1984">1984</option>
                                                <option value="1983">1983</option>
                                                <option value="1982">1982</option>
                                                <option value="1981">1981</option>
                                                <option value="1980">1980</option>
                                                <option value="1979">1979</option>
                                                <option value="1978">1978</option>
                                                <option value="1977">1977</option>
                                                <option value="1976">1976</option>
                                                <option value="1975">1975</option>
                                                <option value="1974">1974</option>
                                                <option value="1973">1973</option>
                                                <option value="1972">1972</option>
                                                <option value="1971">1971</option>
                                                <option value="1970">1970</option>
                                                <option value="1969">1969</option>
                                                <option value="1968">1968</option>
                                                <option value="1967">1967</option>
                                                <option value="1966">1966</option>
                                                <option value="1965">1965</option>
                                                <option value="1964">1964</option>
                                                <option value="1963">1963</option>
                                                <option value="1962">1962</option>
                                                <option value="1961">1961</option>
                                                <option value="1960">1960</option>
                                                <option value="1959">1959</option>
                                                <option value="1958">1958</option>
                                                <option value="1957">1957</option>
                                                <option value="1956">1956</option>
                                                <option value="1955">1955</option>
                                                <option value="1954">1954</option>
                                                <option value="1953">1953</option>
                                                <option value="1952">1952</option>
                                                <option value="1951">1951</option>
                                                <option value="1950">1950</option>
                                                <option value="1949">1949</option>
                                                <option value="1948">1948</option>
                                                <option value="1947">1947</option>
                                                <option value="1946">1946</option>
                                                <option value="1945">1945</option>
                                                <option value="1944">1944</option>
                                                <option value="1943">1943</option>
                                                <option value="1942">1942</option>
                                                <option value="1941">1941</option>
                                                <option value="1940">1940</option>
                                                <option value="1939">1939</option>
                                                <option value="1938">1938</option>
                                                <option value="1937">1937</option>
                                                <option value="1936">1936</option>
                                                <option value="1935">1935</option>
                                                <option value="1934">1934</option>
                                                <option value="1933">1933</option>
                                                <option value="1932">1932</option>
                                                <option value="1931">1931</option>
                                                <option value="1930">1930</option>
                                                <option value="1929">1929</option>
                                                <option value="1928">1928</option>
                                                <option value="1927">1927</option>
                                                <option value="1926">1926</option>
                                                <option value="1925">1925</option>
                                                <option value="1924">1924</option>
                                                <option value="1923">1923</option>
                                                <option value="1922">1922</option>
                                                <option value="1921">1921</option>
                                                <option value="1920">1920</option>
                                            </select>                            
                                            <br>
                                            <label for="grupos" class="alinhamento">Grupo de risco:</label>
                                            <select class="grupos" name ="grupos" id="grupos" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.grupos.idgrupo}">${usuarioEditando.grupos.grupo}</option> 
                                                <option value="1">Doentes Cronicos</option>
                                                <option value="2">Idosos</option>
                                                <option value="3">Gestantes</option>
                                                <option value="4">Crianças de 1 a 4 anos</option>
                                                <option value="5">Sem grupo</option>

                                            </select>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- localNASCIMENTO--%>
                                            <label for="localnascimento" class="alinhamento">Local Nasc':</label>
                                            <input type="text" onkeypress="return socaracter(event)" value="${usuarioEditando.localnascimento}"name="localnascimento" id="localnascimento" placeholder="Ex: Taguatinga-DF"/>
                                            <span class="style1">*</span>
                                            <br>
                                            <%-- EMAIL--%>
                                            <label for="email" class="alinhamento">Email:</label>
                                            <input type="text" name="email" id="email" value="${usuarioEditando.email}"pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="Digite um E-mail valido!" placeholder="Apenas E-mail valido!"/>
                                            <span class="style1">*</span>
                                            <br>
                                            <%-- TELEFONE--%>

                                            <label for="telefone" class="alinhamento">Telefone:</label>
                                            <input type="text"  onkeypress="return sonumeros(event)" name="telefone" value="${usuarioEditando.telefone}"  id="telefone" maxlength="11"  pattern="[0-9]{11}" title="Digite apenas numeros!" maxlength="11" placeholder="(ddd) 9 seu - numero"/>
                                            <span class="style1">*</span>

                                        </div>
                                    </div>
                                    <br>
                                    


                                    <div class="form-group" >
                                        <div style="margin: 10px"> <br>
                                            <hr>
                                            <h5><i>Endereço</i></h5>
                                            <hr> 
                                            <br>
                                            <br>
                                            <%-- CEP--%>
                                            <label for="cep" class="alinhamento">CEP:</label>
                                            <input type="text" id="cep" name="cep" maxlength="8" value="${usuarioEditando.cep}" pattern="[0-9]{6-8}" placeholder="99.999-999" />
                                            <span class="style1">*</span>

                                            <br>
                                            <%-- LOGRADOURO--%>
                                            <label for="endereco" class="alinhamento">Logradouro:</label>
                                            <input type="text" name="logradouro" id="endereco" value="${usuarioEditando.logradouro}" placeholder="Ex: Quadra 10, Rua Maria, Conjunto K " />
                                            <span class="style1">*</span>

                                            <br>

                                            <%-- BAIRRO--%>
                                            <label for="bairro" class="alinhamento">Bairro:</label>
                                            <input type="text" name="bairro" id="bairro" value="${usuarioEditando.bairro}" placeholder="Ex: Taguatinga Sul " />
                                            <span class="style1">*</span>                            
                                            <br>

                                            <%-- numerodacasa--%>
                                            <label for="numerocasa" class="alinhamento">Nº Casa:</label>
                                            <input type="text" onkeypress="return sonumeros(event)" value="${usuarioEditando.numerocasa}"  name="numerocasa" value="${usuarioEditando.numerocasa}" id="numerocasa" maxlength="5" placeholder="01"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- cidade--%>
                                            <label for="cidade" class="alinhamento">Cidade</label>
                                            <input type="text" name="cidade" onkeypress="return socaracter(event)" value="${usuarioEditando.cidade}"  id="cidade" placeholder="Taguatinga"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- ESTADO --%>
                                            <label for="idestado" class="alinhamento">Estado:</label>
                                            <select class="estados" name ="idestado" id="idestado" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.estado.idestado}">${usuarioEditando.estado.estado}</option> 
                                                <c:forEach var="estado" items="${estados}">
                                                    <option value="${estado.idestado}">${estado.estado}</option>
                                                </c:forEach>   
                                            </select>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- TIPORESIDENCIA --%>
                                            <label for="tiporesidencia" class="alinhamento">Tipo Residencia:</label>
                                            <select  class="tiporesidencias" name ="tiporesidencia" id="tiporesidencia" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.tiporesidencia}">${usuarioEditando.tiporesidencia}</option>                                  
                                                <option value="Casa Urbana">Casa Urbana</option>
                                                <option value="Casa Rural">Casa Rural</option>
                                                <option value="Residencia Comercial">Residencia Comercial</otption>
                                                <option value="Apartamento">Apartamento</option>

                                            </select>
                                            <span class="style1">*</span>

                                        </div>
                                    </div>
                                    <br>
                                    


                                    <div class="form-group" >
                                        <div style="margin: 10px"><br>
                                            <hr> 
                                            <h5><i>Login e Permissão</i></h5>   
                                            <hr> 


                                            <br>

                                            <%-- LOGIN--%>
                                            <label for="login" class="alinhamento">Login:</label>
                                            <input type="text" name="login" name="senha"value="${usuarioEditando.login}"  onkeypress="return sonumeros(event)" id="login" maxlength="11"  pattern="[0-9]{11}"placeholder="Por padrão será o CPF"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- SENHA--%>
                                            <label for="senha" class="alinhamento">Senha:</label>
                                            <input type="password" name="senha" value="${usuarioEditando.senha}"  onkeypress="return sonumeros(event)" id="senha" maxlength="11"  pattern="[0-9]{11}"placeholder="Por padrão será o CPF"/>
                                            <span class="style1">*</span>
                                            <br>

                                            <%-- TIPOUSUARIO --%>
                                            <label for="idtipousuario" class="alinhamento">Tipo Usuarios:</label>
                                            <select class="tiposdeusuarios" name ="idtipousuarios" id="idtipousuario" style="width: 70%; height: 30px;">
                                                <option value="${usuarioEditando.tipousuario.idtipousuario}">${usuarioEditando.tipousuario.tipousuario}</option>  
                                                <c:forEach var="tipousuario" items="${tipousuarios}">
                                                    <option value="${tipousuario.idtipousuario}">${tipousuario.tipousuario}</option>
                                                </c:forEach>   
                                            </select>
                                            <span class="style1">*</span>
                                            <br>
                                        </div>
                                    </div>

                                    <%-- submit em display:none --%> 
                                    <input type="submit" class="escondido" name="alterar" value="alterar" id="alterar"/>

                                </fieldset>  
                            </form>
                            <br>
                            <br>
                            <div id="botoes">
                                <%--abre modal --%> 
                                <input type="button" value="Alterar" onclick="abrir()" class="btn btn-outline-success"/>
                                <%--limpa campos --%> 
                                <input type="button" value="Limpar"  onclick="resetar()" name="resetar" class="btn btn-outline-danger"/>
                            </div>
                            <br>

                            <%--inicio modal --%> 
                            <div id="myModal" class="modal">
                                <!-- Modal conteudo -->
                                <div class="modal-content">                                
                                    <span class="close" onclick="fechar()">&times;</span>
                                    <p>Tem certeza que deseja realizar a alteração?</p>
                                    <br>
                                    <div style="float: left">
                                        <%--envia formulario --%> 
                                        <input type="button" value="Confirmar Alteração"  onclick="alterar()" name="alterar" class="btn btn-success"/>
                                        <%--fecha  modal --%> 
                                        <input type="button" value="Revisar"  id="close" name="cancelar"  class="btn btn-danger" onclick="fechar()"/>
                                    </div>                                
                                </div>
                            </div>  
                            <br>
                            <br>

                            <%-- fim modal --%> 
                            <%-- fim formulario de edição --%> 
                        </c:if>


                        <%--inicio tabela de consulta --%> 
                        <form method="post" action="${pageContext.request.contextPath}/cadusuario" onsubmit="return validarform1(this)"><br>
                            <div id="tabelalista" style="overflow: auto; width: 100%; height: 200px; border:solid 1px; margin-left:50px; float: right; box-shadow: 0 0 1em black;">
                                <table class="table table-hover"style="border: 1px solid black; border-collapse: collapse; margin-top: 20px; width:100%; font-size: 15px" border="1" >
                                    <thead class="thead-light">
                                        <tr>
                                            <th>ID</th>
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
                                            <td>${usuario.idusuario}</td>
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

                                            <td>
                                                <%-- botao radio para selecionar usuario listado - ativa botoes editar e excluir--%>
                                                <input type ="radio" name="idusuario" id="idusuario"value ="${usuario.idusuario}" 
                                                       onclick="habilitar(1); habilitar(2)"required="Selecione">
                                            </td>                                          

                                        </tr>
                                    </c:forEach>
                                    </body>

                                </table>  
                            </div> 
                            <%-- botao editar--%>
                            <button type="submit" name="editar" class="btn btn-info" value="Editar" style="font-size: 10px;

                                    width: 60px; margin: 0 auto; float: right;"disabled="disabled" id="1"><i class="fa fa-edit"></i>Editar</button>

                            <%-- botao abrir modal excluir--%>
                            <button type="button" onclick="abrir1()" class="btn btn-danger"value="Excluir" style="font-size: 10px;

                                    width: 60px; margin: 0 auto; float: right;" disabled="disabled" id="2"><i class="fa fa-edit"></i>Excluir</button>  
                            <input type="submit" class="escondido" name="excluir" value="Excluir" id="excluir1"/>

                            <%-- inicio modal--%>
                            <div id="myModal1" class="modal1">
                                <!-- Modal conteudo --> 
                                <div class="modal-content1">
                                    <span class="close1" onclick="fechar1()">&times;</span><br>
                                    <p>Tem certeza que deseja excluir?</p>
                                    <%-- botao confirmar exluir--%>
                                    <input type="submit" value="Confirmar Excluir" name="excluir" class="btn btn-success" style=" border: 1px solid black;
                                           border-radius: 4px;
                                           width: 20%;
                                           top: -500px;"/>
                                    <%-- fechar modal--%>
                                    <input type="button" value="Revisar"name="cancelar"  class="btn btn-danger" onclick="fechar1()"/>
                                </div>
                            </div>
                            <%-- fim modal--%>
                        </form>
                    </div>
                </div>    
                <%-- fim conteudo --%>
            </div>
        </div>
        <jsp:include page="includes/imports.jsp"/>

        <script>
            $(document).ready(function () {
                $(".tiposdeusuarios").select2();
                $(".estados").select2();
                $(".tiporesidencias").select2();
                $(".sexo").select2();
                $(".tiposanguineos").select2();
                $(".dia").select2();
                $(".mes").select2();
                $(".ano").select2();
                $(".grupos").select2();

            });
        </script>

    </body>
</html>