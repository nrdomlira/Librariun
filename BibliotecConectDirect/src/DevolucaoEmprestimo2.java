

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.Producer;

import Dao.DaoEmprestimo;
import Dao.DaoProduto;
import Dao.Emprestimo;
import Dao.Produto;

/**
 * Servlet implementation class DevolucaoEmprestimo2
 */
@WebServlet("/DevolucaoEmprestimo2")
public class DevolucaoEmprestimo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevolucaoEmprestimo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEmp=Integer.parseInt(request.getParameter("idEm"));
		Emprestimo emp=new Emprestimo();
		DaoEmprestimo dao=new DaoEmprestimo();
		Produto produto=new Produto();
		DaoProduto daoP=new DaoProduto();
		
		try{
			emp=dao.Read(idEmp);
			produto=daoP.Read(emp.getMaterialId());
			daoP.UpdateEmprestimoFalse(produto);
			dao.Delete(idEmp);
			response.sendRedirect("ListarEmprestimo.jsp");
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}
		
	}
}
