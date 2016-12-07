<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotec/Reserva</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
    <script type="text/javascript">
    
    function alteraAluno() {
    	var x;
    	var r=confirm("Deseja prosseguir?");
    	if (r==true){
    		var r=new String(document.getElementById('idproduto').value);
    		var id=new String(document.getElementById('matriculaAluno').value);
    		location.href="/BibliotecConectDirect/AlterarReservaAluno?IdAluno="+id+"&IdProduto="+r;   		  
    	}
	}
    function alteraProduto() {
    	var x;
    	var r=confirm("Deseja prosseguir?");
    	if (r==true){
    		var r=new String(document.getElementById('idProduto').value);
    		location.href="/BibliotecConectDirect/AdicionaEmprestimo.jsp?IdAluno="+id+"&IdProduto="+r;   		  
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

        <img id="icone"src="image/reserva.png"alt="reservas"/>

        <nav id="menu">
            <h1>Menu Principal</h1>
            <ul type="">
                <li onmouseover="mudaFoto('image/icone-endereco.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="home.jsp">Home</a></li>
                <li onmouseover="mudaFoto('image/reserva.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="reserva.html">Reservas</a></li>
               <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="Emprestimo.html">Emprestimo</a></li>
                <li onmouseover="mudaFoto('image/icone-contato.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="usuarios.html">Usuários</a></li>
                <li onmouseover="mudaFoto('image/arquivo.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="Produtos.html">Produtos</a></li>
                <li onmouseover="mudaFoto('image/contato.png')"onmouseout="mudaFoto('image/reserva.png')"><a href="faleConosco.html">Fale Conosco</a></li>
                <li><a href="../index0.html">Sair</a></li>
            </ul>
        </nav>
    </header>

   <h2>Cadastro de Reservas</h2>
    <p>Verifique se os campos estão corretos</p>
<%
DaoProduto daoProduto=new DaoProduto();
DaoAluno daoAluno=new DaoAluno();
DaoReserva daoRe=new DaoReserva();

Reserva reserva=new Reserva();
Aluno aluno=new Aluno();
Produto produto=new Produto();

String idReserva =request.getParameter("Id");
reserva=daoRe.Read(Integer.parseInt(idReserva));
aluno=daoAluno.Read(Integer.parseInt(reserva.getAlunoId()));
produto=daoProduto.Read(Integer.parseInt(reserva.getProdutoId()));

%>
<a href="reserva.html"><input type="submit" value="<-- Voltar"></a>
<form id="formulario"  method="get">
<fieldset id="aluno" class="formulariobaixo"><legend>Reservas</legend>
            <p>Nome do Aluno:
                <input  disabled type="text"name="idAluno" id="txtNomeAluno" 
                value="<%=aluno.getNome()%>"/>
                <input type="submit"value="Alterar"onclick="alteraAluno()">
                </p>
                
            <input type="hidden"name="idAluno" id="matriculaAluno" value="<%=aluno.getMatricula() %>">    
            <input type="hidden" name="idProduto" id="idproduto"value="<%=produto.getId()%>">  
              
            <p>Nome do Produto:
                <input disabled type="text" name="Produto"id="cpfAluno" 
                value="<%= produto.getTitulo() %>"/>
                 <input type="submit"value="Alterar" onclick="<%=produto.getId()%>">
                </p>
                 
   			<input type="submit" value="Enviar">
 </fieldset>
</form>

<br> <br> <br> <br> <br>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>