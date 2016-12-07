<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Bibliotec/Cadastro/Aluno</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/Validadores.js"></script>
    <script src="javascript/funcoes.js"></script>
</head>
<body>
<div id="interface">
    <header id="cabecalho"> <!-- cabecalho do site-->
        <hgroup>    <!--grupo criado-->
            <h1>Bibliotec</h1>
            <h2>Sistema de Gerenciamento</h2>
        </hgroup>

        <img id="icone"src="image/icone-contato.png"alt="usuários"/>

        <nav id="menu">
            <h1>Menu Principal</h1>
            <ul type="">
                <li onmouseover="mudaFoto('image/icone-endereco.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="home.jsp">Home</a></li>
                <li onmouseover="mudaFoto('image/reserva.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="reserva.html">Reservas</a></li>
                <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="Emprestimo.html">Emprestimo</a></li>
                <li onmouseover="mudaFoto('image/icone-contato.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="usuarios.html">Usuários</a></li>
                <li onmouseover="mudaFoto('image/arquivo.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="Produtos.html">Produtos</a></li>
                <li onmouseover="mudaFoto('image/contato.png')"onmouseout="mudaFoto('image/icone-contato.png')"><a href="faleConosco.html">Fale Conosco</a></li>
                <li><a href="index0.html">Sair</a></li>
            </ul>
        </nav>
    </header>
    <h2>Bibliotec</h2>
  
    <fieldset  class="formulariobaixo"><legend>Erro</legend>
    	Já existe um usuario cadastrado com as mesmas informações, verifique e tente novamente.
    	</br></br>
    	 <a href="http://localhost:8080/BibliotecConectDirect/AdicionaAluno.jsp?Comportamento=AdicionarAluno"><input type="submit" id="cadastraAluno"value="OK"></a>
       </fieldset>
    
    <br> <br> <br> <br> <br>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>