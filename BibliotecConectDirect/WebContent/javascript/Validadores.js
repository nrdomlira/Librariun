
//adiciona mascara ao telefone
 function MascaraTelefone(tel){  
	 if(mascaraInteiro(tel)==false){
		 event.returnValue = false;
	 }       
	 return formataCampo(tel, '(00) 00000-0000', event);
 }

//adiciona mascara ao CPF
 function MascaraCPF(cpf){
	 if(mascaraInteiro(cpf)==false){
		 event.returnValue = false;
	 }       
	 return formataCampo(cpf, '000.000.000-00', event);
 }
 ////////////////////////////////mascara da matricula
 function MascaraMatricula(matricula){
     if((matricula)==false){
             event.returnValue = false;
     }       
     return formataCampo(matricula, '0000.00000', event);
}
 /////////////////////////////
 function MascaraData(data){
	 if(mascaraInteiro(data)==false){
		 event.returnValue = false;
	 }       
	 return formataCampo(data, '00/00/0000', event);
 }
 ////////////////////////////////valida telefone
 function ValidaTelefone(tel){
	 exp = /\(\d{2}\)\ \d{5}\-\d{4}/
		 if(!exp.test(tel.value))
			 alert('Numero de Telefone Invalido!');
 }
 //////////
 function ValidaData(data){
	 exp = /\d{2}\/\d{2}\/\d{4}/
		 if(!exp.test(data.value))
			 alert('Data Invalida!');                        
 }
//valida o CPF digitado
 function ValidarCPF(Objcpf){
	 var cpf = Objcpf.value;
	 exp = /\.|\-/g
		 cpf = cpf.toString().replace( exp, "" ); 
	 var digitoDigitado = eval(cpf.charAt(9)+cpf.charAt(10));
	 var soma1=0, soma2=0;
	 var vlr =11;

	 for(i=0;i<9;i++){
		 soma1+=eval(cpf.charAt(i)*(vlr-1));
		 soma2+=eval(cpf.charAt(i)*vlr);
		 vlr--;
	 }       
	 soma1 = (((soma1*10)%11)==10 ? 0:((soma1*10)%11));
	 soma2=(((soma2+(2*soma1))*10)%11);

	 var digitoGerado=(soma1*10)+soma2;
	 if(digitoGerado!=digitoDigitado)        
		 alert('CPF Invalido!');         
 }

//valida numero inteiro com mascara
 function mascaraInteiro(){
	 if (event.keyCode < 48 || event.keyCode > 57){
		 event.returnValue = false;
		 return false;
	 }
	 return true;
 }
//formata de forma generica os campos
 function formataCampo(campo, Mascara, evento) { 
	 var boleanoMascara; 

	 var Digitato = evento.keyCode;
	 exp = /\-|\.|\/|\(|\)| /g
		 campoSoNumeros = campo.value.toString().replace( exp, "" ); 

	 var posicaoCampo = 0;    
	 var NovoValorCampo="";
	 var TamanhoMascara = campoSoNumeros.length;; 

	 if (Digitato != 8) { // backspace 
		 for(i=0; i<= TamanhoMascara; i++) { 
			 boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
					 || (Mascara.charAt(i) == "/")) 
					 boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(") 
							 || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " ")) 
							 if (boleanoMascara) { 
								 NovoValorCampo += Mascara.charAt(i); 
								 TamanhoMascara++;
							 }else { 
								 NovoValorCampo += campoSoNumeros.charAt(posicaoCampo); 
								 posicaoCampo++; 
							 }              
		 }      
		 campo.value = NovoValorCampo;
		 return true; 
	 }else { 
		 return true; 
	 }
 }