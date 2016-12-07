<%@page import="Dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bibliotec/Cadastro/Aluno</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estilo.css"/>
    <link rel="stylesheet" href="css/form.css">
    <script src="javascript/funcoes.js"></script>
    <script src="javascript/Validadores.js"></script>
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
    <h2>Cadastro/Alteração de Funcionário</h2>
    <p>É nescessário preencher todos os campos</p>
<%
String comportamento = request.getParameter("Comportamento");

Funcionario funcionario = new Funcionario();
if(comportamento.equals("AlterarFuncionario"))
{
int id = Integer.parseInt(request.getParameter("Id"));
DaoFuncionario dao = new DaoFuncionario();
funcionario = dao.Read(id);
}

if(comportamento.equals("ExcluirFuncionario")){
	int id = Integer.parseInt(request.getParameter("Id"));
	DaoFuncionario dao = new DaoFuncionario();;
	dao.Delete(funcionario.getMatricula());
}
%>
    <a href="usuarios.html"><input type="submit" id="listarAluno"value="<-- Voltar"></a>
    <form id="formularioFunc" action="<%=comportamento%>" method="get">
        <fieldset id="funcionarios"class="formulariobaixo"><legend>Funcionários</legend>
            <p>Tipo Usuário:
            <select id="tipoCadastro" name="tipoUsuario">
                <option value="Comum">Comum</option>
                <option value="Administrador">Administrador</option>
            </select></p>
            
            <p>  <label for="matriculaFuncionario" >Matrícula:</label>
                <input type="number"id="matriculaFuncionario" name="matriculaFunci" placeholder="Matricula"
                 size=6 max =99999999 min=999999 required
                 value="<%= comportamento.equals("AlterarFuncionario") ? funcionario.getMatricula() : "" %>"/></p>
            
            <p>   <label for="txtNomeFuncionario" >Nome:</label>
                <input type="text"id="txtNomeFuncionario" name="nomeFuncionario"placeholder="Nome Completo"
               min="2" maxlength="50" size=35 placeholder="Digite o nome completo" required
               value="<%= comportamento.equals("AlterarFuncionario") ? funcionario.getNome() : "" %>"/></p>
               
            <p>  <label for="cpfFuncionario">CPF:</label>
                <input type="text"id="cpfFuncionario"name="cpfFunci"maxlength="14" size=10 required placeholder="CPF"
               onKeyPress="MascaraCPF(formularioFunc.cpfFunci);" onBlur="ValidarCPF(formularioFunc.cpfFunci);" required
                 value="<%= comportamento.equals("AlterarFuncionario") ? funcionario.getCpf() : "" %>"/></p>
                 
            <p>   <label for="dataFuncionario">Data de Nascimento:</label>
                <input type="text"id="dataFuncionario" name="dataFunci" maxlength="10" size=10 placeholder="Nascimento" required
                  onBlur="ValidaData(formularioFunc.dataFunci)" onKeyPress="MascaraData(formularioFunc.dataFunci)"
                 value="<%= comportamento.equals("AlterarFuncionario") ? funcionario.getData() : "" %>"/><br/></p>
                 
                 
            <p>  <label for="telefoneFuncionario" >Telefone:</label>
                <input type="text"id="telefoneFuncionario" name="telefoneFunci"maxlength="15" placeholder="Telefone" required
                onKeyPress="MascaraTelefone(formularioFunc.telefoneFunci);" onBlur="ValidaTelefone(formularioFunc.telefoneFunci);"
                  value="<%= comportamento.equals("AlterarFuncionario") ? funcionario.getTelefone() : "" %>"/></p>
                  
            <input type="submit" id="validaFun"value="Enviar" >
        </fieldset>
    </form>
    <footer id="rodape">
        <p>Copyright &copy; 2016 - by Marcelo Augusto | Lucas de Melo | José Domingos<br/>
            <a href="http://www.google.com" target="_blank">Facebook </a>|<!--o target abre uma nova aba -->
            <a href="http://www.google.com"target="_blank">Twitter</a></p>
    </footer>
</div>
</body>
</html>