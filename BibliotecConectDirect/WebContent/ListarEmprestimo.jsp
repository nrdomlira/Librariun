<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.*"%>
    <%@page import="Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotec/Reserva</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
    <script>
    function confirmaExclusao(id){
    	var x=confirm("Deseja excluir?")
    	if(x==true){
    		location.href="/BibliotecConectDirect/ExcluirEmprestimo?Id="+id ; 
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
                <li><a href="index0.html">Sair</a></li>
            </ul>
        </nav>
    </header>
    
    <h2>Emprestimo</h2>
            <p>*Ao excluir não será gerada multa caso esteja em atrasado a antrega</p>
     <a href="Emprestimo.html"><input type="submit" value="<-- Voltar"></a>
    <table id="tabelaFuncionarios">
        <caption>Emprestimos cadastrados na Bibliotec</caption>
        <tr>
            <td class="top">Id</td>
            <td class="top">Matricula do Aluno</td>
            <td class="top">Id do Material</td>
            <td class="top">Data de Saida</td>
            <td class="top">Data para Devolução</td>
            <td class="top">Opções</td>
        </tr>
        <%
			DaoEmprestimo dao=new DaoEmprestimo();		
        List<Emprestimo> listaEmprestimos=listaEmprestimos=dao.ReadAll();
			
			%>
		<%for(Emprestimo emprestimo:listaEmprestimos ){%> 
        <tr>
		    <div>
        	<td class="down"><%out.print(emprestimo.getId()); %></td>	
        	<td class="down"><%out.print(emprestimo.getAlunoId()); %></td>	
        	<td class="down"><%out.print(emprestimo.getMaterialId()); %></td>
        	<td class="down"><%out.print(emprestimo.getDataSaida()); %></td>
   			<td class="down"><%out.print(emprestimo.getDataRetorno()); %></td>
   			<td class="down">
       		<a onclick="confirmaExclusao(<%=emprestimo.getId()%>)">Excluir</a></td>
			</div>
        </tr>
		<%} %>           
    </table>
    
    
    <br>    <br>    <br>    <br>    <br>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>