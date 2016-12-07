

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoEmprestimo;
import Dao.DaoProduto;
import Dao.Emprestimo;
import Dao.Produto;

/**
 * Servlet implementation class ExcluirEmprestimo
 */
@WebServlet("/ExcluirEmprestimo")
public class ExcluirEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirEmprestimo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoEmprestimo dao=new DaoEmprestimo();
		Emprestimo emp=new Emprestimo();
		DaoProduto daoP=new DaoProduto();
		Produto produto=new Produto();
		
		String id = request.getParameter("Id");
		if(id!=null){
			emp=dao.Read(Integer.parseInt(id));
			produto=daoP.Read(emp.getMaterialId());
			daoP.UpdateEmprestimoFalse(produto);
			dao.Delete(Integer.parseInt(id));
		}
		request.setAttribute("ListaEmprestimos", dao.ReadAll());
		 RequestDispatcher rd = request.getRequestDispatcher("ListarEmprestimo.jsp");
		 rd.forward(request, response);
	}

}
