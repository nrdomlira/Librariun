

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;

import Dao.*;

/**
 * Servlet implementation class AdicioaFuncionario
 */
@WebServlet("/AdicionaFuncionario")
public class AdicionaFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaFuncionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcionario funcionario=new Funcionario();
		DaoFuncionario dao=new DaoFuncionario();
		try{
			int matricula=Integer.parseInt(request.getParameter("matriculaFunci"));
			String nome=request.getParameter("nomeFuncionario");
			String cpf=request.getParameter("cpfFunci");
			String dataTexto=request.getParameter("dataFunci");
			String telefone=request.getParameter("telefoneFunci");
			String tipo=request.getParameter("tipoUsuario");

			funcionario.setMatricula(matricula);
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setData(dataTexto);
			funcionario.setTelefone(telefone);
			funcionario.setTipo(tipo);

			Funcionario checagem1=dao.Read(funcionario.getMatricula());
			Funcionario checagem2=dao.ReadCpf(funcionario.getCpf());

			if(checagem1.getCpf()!=null||checagem2.getCpf()!=null){
				request.setAttribute("obj",funcionario);
				RequestDispatcher rd = request.getRequestDispatcher("ErroUsuFuncionario.jsp");
				rd.forward(request, response);
			}else{
				dao.Create(funcionario);
				request.setAttribute("ListaFuncionario", dao.ReadAll());		
				RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionario.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}
	}

}
