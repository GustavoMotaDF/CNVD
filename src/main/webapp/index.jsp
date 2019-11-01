<%-- 
    Document   : index
    Created on : 04/06/2019, 15:44:47
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="iso-8859-1">
  <title>Login</title>
  <link rel="icon" type="imagem/png" href="jsp/imagens/favicon.jpg" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <link rel="stylesheet" type="text/css" href="jsp/css/index.css" />
  
  <link href='https://fonts.googleapis.com/css?family=Comfortaa' rel='stylesheet'>
  <script type="text/javascript" src="jsp/js/Enter.js"></script>
  
  
</head>
<body onKeyDown="AnalizaTeclas()" style="background-image: linear-gradient( #819FF7, #CEE3F6);">
    
  <div class="container" >
     <a class="links" id="paralogin"></a>
      
     <div>${mensagem1}</div>
    <div class="content">      
      <!--FORMULÁRIO DE LOGIN-->
      <div id="login">
        <form method="post" action="${pageContext.request.contextPath}/Login"> 
          <h1>Login</h1>  
          <p> 
            <label for="login">Seu CPF</label>
            <input id="nome_login" onkeypress="return sonumeros(event)" name="login" data-mask="###.###.###-##" required="required" type="tel" placeholder="ex. 000.000.000-00" maxlength="11"/>
          </p>
           
          <p> 
            <label for="senha">Sua senha</label>
            <input id="email_login" onkeypress="return sonumeros(event)" name="senha" required="required" type="password" placeholder="Sua senha" maxlength="11"/> 
          </p>
           
          <p> 
            <input type="checkbox" name="manterlogado" id="manterlogado" value="" /> 
            <label for="manterlogado">Manter-me logado</label>
          </p>
           
          <p> 
            <input type="submit"  class="botao" value="Entrar"> 
          </p>
           
          <p class="link">
            Esqueceu sua senha?
            <a href="#">Recupere sua senha!</a>
          </p>
        </form>
      </div>      
    </div>
  </div>  
</body>
</html>
