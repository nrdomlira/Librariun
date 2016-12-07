<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="Dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <h2>Cadastro/Alteração de alunos</h2>
    <p>É nescessário preencher todos os campos</p>
<%
String comportamento = request.getParameter("Comportamento");

Aluno aluno = new Aluno();
if(comportamento.equals("AlterarAluno"))
{
int id = Integer.parseInt(request.getParameter("Id"));
DaoAluno dao = new DaoAluno();
aluno = dao.Read(id);

}

if(comportamento.equals("ExcluirAluno")){
	int id = Integer.parseInt(request.getParameter("Id"));
	DaoAluno dao = new DaoAluno();
	dao.Delete(aluno.getMatricula());
}
%>
    <a href="usuarios.html"><input type="submit" id="listarAluno"value="<-- Voltar"></a>
<form id="formulario" action="<%=comportamento%>" method="get">
<fieldset id="aluno" class="formulariobaixo"><legend>Alunos</legend>
            <p>  <label for="matriculaAluno">Matrícula:</label>
                <input type="number"id="matriculaAluno"name="matriculaAlunoo"placeholder="Matricula" size=6 max =99999999 min=999999 required
                value="<%= comportamento.equals("AlterarAluno") ? aluno.getMatricula() : "" %>"/></p>
                
            <p><label for="txtNomeAluno">Nome:</label>
                <input type="text"name="NomeAlunoForm" id="txtNomeAluno"  maxlength="50" size=35 placeholder="Digite o nome completo" required
                value="<%= comportamento.equals("AlterarAluno") ? aluno.getNome() : "" %>"/></p>
                
            <p> <label for="cpfAluno">CPF:</label>
                <input type="text" name="cpfAlunoo"id="cpfAluno" onBlur="ValidarCPF(formulario.cpfAlunoo);" required
				onKeyPress="MascaraCPF(formulario.cpfAlunoo);" maxlength="14" placeholder="CPF"
                value="<%= comportamento.equals("AlterarAluno") ? aluno.getCpf() : "" %>"/></p>
                
            <p>  <label for="dataAluno">Data de Nascimento:</label>
                <input type="text"id="dataAluno"name="dataAlunoo" maxlength="10" size=10 placeholder="Nascimento" required
                onBlur="ValidaData(formulario.dataAlunoo)" onKeyPress="MascaraData(formulario.dataAlunoo)"
                value="<%= comportamento.equals("AlterarAluno") ? aluno.getData() : "" %>"/><br/></p>
            
            <p>  <label for="telefoneAluno">Telefone:</label>
                <input type="text"name="telefoneAlunoo"id="telefoneAluno"onKeyPress="MascaraTelefone(formulario.telefoneAlunoo);" required
					maxlength="15"  onBlur="ValidaTelefone(formulario.telefoneAlunoo);"placeholder="Telefone"
                value="<%= comportamento.equals("AlterarAluno") ? aluno.getTelefone() : "" %>"/></p>
            <input type="submit" id="validaAluno"value="Enviar">
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