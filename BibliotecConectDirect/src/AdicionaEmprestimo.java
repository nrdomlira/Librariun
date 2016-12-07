

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
 * Servlet implementation class AdicionaEmprestimo
 */
@WebServlet("/AdicionaEmprestimo")
public class AdicionaEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaEmprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emprestimo emp=new Emprestimo();
		DaoEmprestimo dao=new DaoEmprestimo();

		try{
			int idAluno=Integer.parseInt(request.getParameter("idAluno"));
			int idProduto=Integer.parseInt(request.getParameter("idProduto"));
			
			DaoProduto daoProduto=new DaoProduto();
			Produto produto =new Produto();
			produto=daoProduto.Read(idProduto);
			daoProduto.UpdateEmprestimoTrue(produto);	
			
			emp.setAlunoId(idAluno);
			emp.setMaterialId(idProduto);
			dao.Create(emp);
			
			response.sendRedirect("ListarEmprestimo.jsp");
			
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}

	}

}
