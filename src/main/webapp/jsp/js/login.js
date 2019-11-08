/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener('keypress', function(e){
    if(e.which == 13){
      Login();
    }
  }, false);

    function sonumeros(e)
{
	var tecla=new Number();
	if(window.event) {
		tecla = e.keyCode;
	}
	else if(e.which) {
		tecla = e.which;
	}
	else {
		return true;
	}
	if((tecla >= "97") && (tecla <= "122")){
		return false;
	}
        
                function enviarpesq() {
                    document.form01.action = '${pageContext.request.contextPath}/pesqusuario';                    
                    document.form01.submit();
                }
                function enviaruser() {
                    document.form01.action = '${pageContext.request.contextPath}/usuario';
                    document.form01.submit();
                }
                
                
                function enviar() {
                    var formulario = document.getElementById('formulario');
                    if(document.getElementById('pesqusuario').checked === true) {
                        formulario.action = "${pageContext.request.contextPath}/pesqusuario";
                    }
                     else {
                        formulario.action = "${pageContext.request.contextPath}/usuario";
                    }		
                        formulario.submit();
                    }

            
}