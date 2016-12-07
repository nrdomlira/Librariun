<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="Dao.*"%>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotec</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <script src="javascript/funcoes.js"></script>
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
        <li onmouseover="mudaFoto('image/icone-endereco.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="home.jsp"alt="Link da home">Home</a></li>
        <li onmouseover="mudaFoto('image/reserva.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="reserva.html"alt="Link de reservas">Reservas</a></li>
        <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="Emprestimo.html"alt="Link de emprestimos">Emprestimo</a></li>
        <li onmouseover="mudaFoto('image/icone-contato.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="usuarios.html"alt="Link de usuarios">Usuários</a></li>
        <li onmouseover="mudaFoto('image/arquivo.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="Produtos.html"alt="Link de produtos">Produtos</a></li>
        <li onmouseover="mudaFoto('image/contato.png')"onmouseout="mudaFoto('image/icone-endereco.png')"><a href="faleConosco.html"alt="Link de fale conosco">Fale Conosco</a></li>
        <li><a href="index0.html">Sair</a></li>
    </ul>
</nav>
    </header>
    <section id="corpo">
        <article id="noticia">
            <h2>Como surgiu a Bibliotec</h2>
            <p>Curabitur at pulvinar sapien. Duis porttitor orci vel nisl egestas, sit amet cursus tellus faucibus. Sed tincidunt vel massa eget facilisis. Suspendisse potenti. Etiam elementum odio eget diam sodales luctus. Etiam eleifend, quam id dapibus vulputate, lorem lacus sagittis dui, non placerat massa sem eu purus. Sed tincidunt diam a est dapibus, id convallis tortor placerat. Nulla blandit lectus justo, a bibendum nisl venenatis ut. Nulla ut quam pulvinar, blandit eros ut, condimentum sem. Sed mi enim, eleifend facilisis metus et, consectetur congue elit.

                Aenean quis metus ut turpis gravida scelerisque a nec nibh. Integer vitae mi velit. Nullam sollicitudin felis sit amet quam venenatis, nec pellentesque tellus convallis. Vivamus vestibulum tortor ligula, id consectetur justo pellentesque ac. Sed dapibus lacinia congue. Phasellus ultrices augue vel ligula viverra, et egestas diam euismod. Vestibulum pulvinar, neque quis placerat pulvinar, turpis enim posuere ante, vitae sagittis dolor magna eu quam. Nam eu ligula vel erat imperdiet imperdiet ac at arcu. Proin eget cursus leo. Proin dui velit, lacinia id elit non, euismod suscipit turpis. Nam vulputate laoreet nibh eu ultricies. In scelerisque tempor diam, id ornare elit tempus sed. Fusce id cursus est, bibendum euismod nunc. Nullam eget condimentum tellus. Aliquam quis lacus eget leo consequat posuere. Duis vestibulum quis massa sit amet lobortis.</p>
        </article>
    </section>
    <aside>
        <h2>&nbspLista de Entregas:</h2>
        <table id="tabelaFuncionarios"alt="tabelas de entrega para hoje">
            <caption>Entregas para hoje </caption>
            <tr>
            <td class="top">Emprestimo</td> 
            <td class="top">Mat. Aluno</td>
            <td class="top">Saida</td> 
            <td class="top">Retorno</td>
            </tr>
            
            <%
            DaoEmprestimo daoEmp=new DaoEmprestimo();
            List<Emprestimo> listaEmprestimo=daoEmp.ReadAllDoDIa();
            
            for(Emprestimo emprestimo:listaEmprestimo ){
            %>
            <tr>
		    <div>
        	<td class="down""><%out.print(emprestimo.getId()); %></td>	
        	<td class="down""><%out.print(emprestimo.getAlunoId()); %></td>
        	<td class="down""><%out.print(emprestimo.getDataSaida()); %></td>
        	<td class="down""><%out.print(emprestimo.getDataRetorno()); %></td>
			</div>
        </tr>
            <%}
            	%>
        </table>
        <br><br>
        <table id="tabelaFuncionarios"alt="lista de emprestimos">
            <caption>Lista de Emprestimos </caption>
            <tr>
            <td class="top">Emprestimo</td> 
            <td class="top">Mat.Aluno</td>
            <td class="top">Saida</td> 
            <td class="top">Retorno</td> 
            </tr>
            
            <%
           
            List<Emprestimo> listaEmprestimo2=daoEmp.ReadAll();
            
            for(Emprestimo emprestimo:listaEmprestimo2 ){
            %>
            <tr>
		    <div>
        	<td class="down""><%out.print(emprestimo.getId()); %></td>	
        	<td class="down""><%out.print(emprestimo.getAlunoId()); %></td>
        	<td class="down""><%out.print(emprestimo.getDataSaida()); %></td>
        	<td class="down""><%out.print(emprestimo.getDataRetorno()); %></td>
			</div>
        </tr>
            <%}
            	%>
        </table>
    </aside>
    <footer id="rodape">
    <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
    <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
     <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>