<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.*"%>
       <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="Dao.*"%>
    <%@page import="java.text.DateFormat"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Bibliotec/Emprestimo</title>
    <link rel="stylesheet" href="css/estilo.css"/>
     <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
    <script>
    function confirmaDevolucao(id){
    	var x=confirm("Deseja continuar?")
    	if(x==true){
    		 
    	}
    }
    </script>
</head>
<body>

<div id="interface">
    <header id="cabecalho"> <!-- cabecalho do site-->
<hgroup>    <!--grupo criado-->
<h1>Bibliotec</h1>
<h2>Sistema de Gerenciamento</h2>
</hgroup>

        <img id="icone"src="image/icone-endereco.png" alt="home"/>

<nav id="menu">
    <h1>Menu Principal</h1>
    <ul type="">
        <li onmouseover="mudaFoto('image/icone-endereco.png')"onmouseout="mudaFoto('image/folder.png')"><a href="home.jsp">Home</a></li>
        <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/folder.png')"><a href="reserva.html">Reservas</a></li>
        <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/folder.png')"><a href="Emprestimo.html">Emprestimo</a></li>
        <li onmouseover="mudaFoto('image/icone-contato.png')"onmouseout="mudaFoto('image/folder.png')"><a href="usuarios.html">Usuários</a></li>
        <li onmouseover="mudaFoto('image/arquivo.png')"onmouseout="mudaFoto('image/folder.png')"><a href="Produtos.html">Produtos</a></li>
        <li onmouseover="mudaFoto('image/contato.png')"onmouseout="mudaFoto('image/folder.png')"><a href="faleConosco.html">Fale Conosco</a></li>
        <li><a href="index0.html">Sair</a></li>
    </ul>
</nav>
</header>
<h2>Devolução</h2>
<p>Verifique os dados, para cada dia em atraso o valor da multa é de R$1,50</p>
<%
String idEmp =request.getParameter("Id");

Emprestimo emprestimo=new Emprestimo();
DaoEmprestimo daoEmp=new DaoEmprestimo();

Produto produto=new Produto();
DaoProduto daoProduto=new DaoProduto();

Aluno aluno=new Aluno();
DaoAluno daoAluno=new DaoAluno();

emprestimo=daoEmp.Read(Integer.parseInt(idEmp));
produto=daoProduto.Read(emprestimo.getMaterialId());
aluno=daoAluno.Read(emprestimo.getAlunoId());
%>
<a href="Emprestimo.html"><input type="submit" id="listarAluno"value="<-- Voltar"></a>
<form id="formulario" action="DevolucaoEmprestimo2" method="get">
<fieldset id="aluno" class="formulariobaixo"><legend>Devolução</legend>
            <input type="hidden"name="idEm" id="txtNomeAluno" value=<%=emprestimo.getId() %>>    

            <p>Nome do Aluno:
                <input  disabled type="text"name="idAluno" id="txtNomeAluno" 
                value="<%=aluno.getNome()%>"/>
                </p>
            <p>Nome do Produto:
                <input disabled type="text" name="Produto"id="cpfAluno" 
                value="<%= produto.getTitulo() %>"/></p>
            <p>Data Saida:
            	<input disabled type="text"name="dataSaida"id="saida"size="6"
            	value="<%=emprestimo.getDataSaida()%>">
            </p>
            <p>Data definida para devolução:
            <input disabled type="text" name="dataDevolucao"id="devolucao" size="6"
                value="<%= emprestimo.getDataRetorno()%>"/>
            </p>
                
            <%
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    		Date date = new Date();
    		String data=dateFormat.format(date);
    		
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
   		 Calendar data1 = Calendar.getInstance();
   		 Calendar data2 = Calendar.getInstance();
   		 try {
   		 data1.setTime(sdf.parse(data));
   		 data2.setTime(sdf.parse(emprestimo.getDataRetorno())); 
   		 } catch (Exception e ) {}
   		 int dias = data2.get(Calendar.DAY_OF_YEAR) - 
   		 data1.get(Calendar.DAY_OF_YEAR);
   		 int diasAtraso=Integer.parseInt(String.valueOf(dias));
   		 
   		 double pagar=(1.5*diasAtraso);
    	if(pagar<0){
    		pagar=0;
    	}
            %>
            <p>Data Atual:
            <input disabled type="text" value="<%=data%>" size="6">
            </p>
            <p>Valor a pagar:
            <input disabled type="text" size="6"
            value="<%=pagar%>">
            </p>
   			<input type="submit" value="Enviar">
 </fieldset>
</form>

 <br><br><br><br><br>
      <footer id="rodape">
    <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
    <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
     <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>