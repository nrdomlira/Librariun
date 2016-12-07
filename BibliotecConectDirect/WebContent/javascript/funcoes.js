/* funcao muda foto do menu*/
function mudaFoto(foto){
	document.getElementById("icone").src=foto;
}
//////funcoes do aluno
function localizaId(){
	alert("ola")
}

function confirmaExclusãoAluno(matricula){
	var x;
	var r=confirm("Deseja Excluir?");
	if (r==true){
		location.href="/BibliotecConectDirect/ExcluirAluno?Id="+matricula ;   		  
	}
}
function confirmaExclusãoFunci(matricula){
	var x;
	var r=confirm("Deseja Excluir?");
	if (r==true){
		location.href="/BibliotecConectDirect/ExcluirFuncionario?Id="+matricula ;   		  
	}
}
//////////////////

