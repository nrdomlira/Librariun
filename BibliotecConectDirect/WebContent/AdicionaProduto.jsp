<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotec/Cadastro/Produto</title>
    <link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
</head>
<body>
<div id="interface">
    <header id="cabecalho"> <!-- cabecalho do site-->
        <hgroup>    <!--grupo criado-->
            <h1>Bibliotec</h1>
            <h2>Sistema de Gerenciamento</h2>
        </hgroup>

        <img id="icone"src="image/arquivo.png" alt="produtos"/>

        <nav id="menu">
            <h1>Menu Principal</h1>
            <ul type="">
                <li onmouseover="mudaFoto('image/icone-endereco.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="home.jsp">Home</a></li>
                <li onmouseover="mudaFoto('image/reserva.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="reserva.html">Reservas</a></li>
                <li onmouseover="mudaFoto('image/folder.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="Emprestimo.html">Emprestimo</a></li>
                <li onmouseover="mudaFoto('image/icone-contato.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="usuarios.html">Usu�rios</a></li>
                <li onmouseover="mudaFoto('image/arquivo.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="Produtos.html">Produtos</a></li>
                <li onmouseover="mudaFoto('image/contato.png')"onmouseout="mudaFoto('image/arquivo.png')"><a href="faleConosco.html">Fale Conosco</a></li>
                <li><a href="index0.html">Sair</a></li>
            </ul>
        </nav>
    </header>
    <h2>Cadastro/Altera��o de Produtos</h2>
    <p>� nescess�rio preencher todos os campos</p>
    <%
String comportamento = request.getParameter("Comportamento");

Produto produto = new Produto();
if(comportamento.equals("AlterarProduto"))
{
int id = Integer.parseInt(request.getParameter("Id"));
DaoProduto dao = new DaoProduto();
produto = dao.Read(id);
}

if(comportamento.equals("ExcluirProduto")){
	int id = Integer.parseInt(request.getParameter("Id"));
	DaoProduto dao = new DaoProduto();
	dao.Delete(produto.getId());
}
%>
 <a href="Produtos.html"><input type="submit" id="listarAluno"value="<-- Voltar"></a>
<form id="formulario" action="<%=comportamento%>" method="get">
        <fieldset id="cadastroProduto"class="formulariobaixo"><legend>Produto</legend>
<p><input type="hidden" name="Id" value="<%= comportamento.equals("AlterarProduto") ? produto.getId() : "" %>"/></p>
<p><input type="hidden" name="Data"value="<%= comportamento.equals("AlterarProduto") ? produto.getDataCadastro() : "" %>"></p>
            <p>Tipo de Produto:
            <select id="tipoProdutoCadastro" name=tipoProduto>
                <option value="Livros">Livros</option>
                <option value="Videos">Videos</option>
                <option value="Revistas">Revistas</option>
                <option value="Outros">Outros</option>
            </select></p>
            <p><label for="tituloProdutoCadastro">Titulo:</label>
                <input type="text"id="tituloProdutoCadastro"name="tituloProduto" 
                 value="<%= comportamento.equals("AlterarProduto") ? produto.getTitulo() : "" %>" required size="40" min="2"maxlength="40" placeholder="Titulo do Produto"/></p>
            <p><label for="autorProdutoCadastro">Autor(es):</label>
                <input type="text"id="autorProdutoCadastro" name="autorProduto" 
                 value="<%= comportamento.equals("AlterarProduto") ? produto.getAutor1() : "" %>"required size="40" min="2" maxlength="40" placeholder="Autor"/></p>
            <p><label for="autorProdutoCadastro">Co-Autor:</label>
                <input type="text"id="autorProdutoCadastro2" name="autorProduto2" 
                 value="<%= comportamento.equals("AlterarProduto") ? produto.getAutor2() : "" %>"size="40" maxlength="40" placeholder="Co-Autor"/></p>
            <p><label for="editoraProdutoCadastro">Editora:</label>
                <input type="text" id="editoraProdutoCadastro"name="editoraProduto" size="40" 
                 value="<%= comportamento.equals("AlterarProduto") ? produto.getEditora() : "" %>" required min="2" maxlength="40" placeholder="Nome da Editora"/></p>
                <input type="submit" id="btnCadastroProduto" value="Enviar"">
        </fieldset>
    </form>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | Jos� Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>