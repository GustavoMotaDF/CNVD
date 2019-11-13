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
      
     
    <div class="content">      
      <!--FORMULÁRIO DE LOGIN-->
      <div id="login">
        <form method="post" action="" name="formulario" id="formulario">             
            <script>
                
                
                
                function enviar() {
                    var formulario = document.getElementById('formulario');
                    if(document.getElementById('Funcionario').checked === true) {
                        formulario.action = "${pageContext.request.contextPath}/Login";
                    }
                     else {
                        formulario.action = "${pageContext.request.contextPath}/Cidadao";
                    }		
                    formulario.submit();
                    }

            </script>   
            
        <h1>Login</h1>  
        <div style="color: red" id="test" style="text-align: center">${mensagem1}</div>
          <p> 
            <label for="login">Seu CPF</label>
            <input id="nome_login" onkeypress="return sonumeros(event)" name="login" data-mask="###.###.###-##" required="required" type="tel" placeholder="ex. 000.000.000-00" maxlength="11"/>
          </p>
           
          <p> 
            <label for="senha">Sua senha</label>
            <input id="email_login" onkeypress="return sonumeros(event)" name="senha" required="required" type="password" placeholder="Sua senha" maxlength="11"/> 
          </p>
           
          <p> 
            Funcionario:<input type="radio" name="Funcionario" id="Funcionario" value="Funcionario" />
            Cidadão:<input type="radio" name="Cidadao" value="Cidadao" id="Cidadao"/> 
          </p>
           
          <p> 
              <input type="submit"  class="botao" value="Entrar" name="Entrar" onclick="enviar()" > 
          </p>
          <script>$(function(){

                $('#test').hide();

                setTimeout(function(){
                    $('#test').fadeIn('slow');
                },5000);

            });
          </script>
          
          
           
          <p class="link">
            Esqueceu sua senha?
            <a href="#">Recupere sua senha!</a>
          </p>
        </form>
      </div>      
    </div>
  </div>  
          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
</body>
</html>
