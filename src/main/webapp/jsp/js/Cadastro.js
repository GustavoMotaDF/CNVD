/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//valida campos do formulario



function validarform(frm) {
    if (frm.nome.value === null || frm.nome.value.length < 3) {
        alert("Por favor, indique o seu NOME.");
        frm.nome.focus();
        return false;
    }
    if (frm.cpf.value === "") {
        alert("Por favor, digite o CPF!");
        frm.cpf.focus();
        return false;
        
    }
    if (frm.cpf.value.length > 5 && frm.cpf.value.length < 11 || frm.cpf.value.length > 11) {
        alert("Por favor, verifique o CPF digitado");
        frm.cpf.focus();
        return false;
        
    }
    
    if (frm.rg.value === null || frm.rg.value === "" || frm.rg.value.length < 5 || frm.rg.value.length > 9) {
        alert("Por favor, digite o RG de forma correta");
        frm.rg.focus();
        return false;
    }
    
    if (frm.telefone.value === null || frm.telefone.value === "" || frm.telefone.value.length < 11 || frm.telefone.value.length > 12) {
        alert("Por favor, verifique o TELEFONE digitado!");
        frm.telefone.focus();
        return false;
    }
    
     if (frm.cep.value === null || frm.cep.value === "" || frm.cep.value.length < 8 || frm.cep.value.length > 8) {
        alert("Por favor, verifique o CEP digitado!");
        frm.cep.focus();
        return false;
    }
    
    if (frm.endereco.value === "") {
        alert("Por favor, digite o Endereço");
        frm.endereco.focus();
        return false;
        
    }
    
    if (frm.numerocasa.value === "") {
        alert("Por favor, digite o NUMERO ca casa");
        frm.numerocasa.focus();
        return false;
        
    }
    
    
}

function validarform1(excluir) {
    if (excluir.idvacina.value === null || excluir.idvacina.value.length === "") {
        alert("Selecione oque será excluido!.");
        excluir.idvacina.focus();
        return false;
    }
    
}
//envia formulario
function enviar() {
    document.getElementById('cadastrar').click();
}
//alterar
function alterar() {
    document.getElementById('alterar').click();
}
//editar
function editar() {
    document.getElementById('editar').click();
}
//exluir
function excluir() {
    document.getElementById('excluir').click();
}
function excluir1() {
    document.getElementsByName('excluir').click();
}

//limpa campos do formulario
function resetar() {
    document.formulariocadastro.reset();
}


//so permite numeros
//onkeypress="return sonumeros(event)"
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
}

//so permite letras
//onkeypress="return socaracter(event)"
function socaracter(e)
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
	if((tecla >= "48") && (tecla <= "57")){
		return false;
	}
}

