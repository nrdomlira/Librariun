

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAluno;
import Dao.DaoFuncionario;

/**
 * Servlet implementation class ExcluirFuncionario
 */
@WebServlet("/ExcluirFuncionario")
public class ExcluirFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFuncionario daofuncionario = new DaoFuncionario();
		String id = request.getParameter("Id");
		if(id != null){
			daofuncionario.Delete(Integer.parseInt(id));
		}
		request.setAttribute("ListaContato", daofuncionario.ReadAll());
		 RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionario.jsp");
		 rd.forward(request, response);
	}

}
