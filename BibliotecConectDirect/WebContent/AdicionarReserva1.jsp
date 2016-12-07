 <%@page import="Dao.*"%>
   <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotec/Reserva</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
    <script type="text/javascript">
    function confirmaReserva(matricula){
    	var x;
    	var r=confirm("Deseja prosseguir?");
    	if (r==true){
    		location.href="/BibliotecConectDirect/AdicionaReserva1?Id="+matricula ;   		  
    	}
    }</script>
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
      <h2>Reserva</h2>
	     <a href="reserva.html"><input type="submit" id="listarAluno"value="<-- Voltar"></a>
	  <table id="tabelaFuncionarios">
        <caption>Produtos disponivies para reserva:</caption>
        <tr>
            <td class="top">Id</td>
            <td class="top">Tipo</td>
            <td class="top">Titulo</td>
            <td class="top">Autor</td>
            <td class="top">Co-Autor</td>
            <td class="top">Editora</td>
            <td class="top">Data Cadastro</td>
            <td class="top">Opções</td>
        </tr>
         <%
			DaoProduto dao=new DaoProduto();
        List<Produto> listaProdutos=dao.ReadAllDisponiveisReserva();
			
			%>
		<%for(Produto produto:listaProdutos ){%> 
        <tr>
		    <div>
        	<td class="down"><%out.print(produto.getId()); %></td>	
        	<td class="down"><%out.print(produto.getTipo()); %></td>	
        	<td class="down"><%out.print(produto.getTitulo()); %></td>
        	<td class="down"><%out.print(produto.getAutor1()); %></td>
   			<td class="down"><%out.print(produto.getAutor2()); %></td>
   			<td class="down"><%out.print(produto.getEditora()); %></td>
   			<td class="down"><%out.print(produto.getDataCadastro()); %></td>
   			<td class="down"><a onclick="confirmaReserva(<%=produto.getId()%>)">Reservar</a></td>
   
			</div>
        </tr>
		<%} %>  
    </table>
    <br> <br> <br> <br> <br>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>