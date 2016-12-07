

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAluno;

/**
 * Servlet implementation class Excluir
 */
@WebServlet("/ExcluirAluno")
public class ExcluirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoAluno daoAluno = new DaoAluno();
		String id = request.getParameter("Id");
		if(id != null){
			daoAluno.Delete(Integer.parseInt(id));
		}
		request.setAttribute("ListaContato", daoAluno.ReadAll());
		RequestDispatcher rd = request.getRequestDispatcher("ListarAluno.jsp");
		rd.forward(request, response);
	}

}
