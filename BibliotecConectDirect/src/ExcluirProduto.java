

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoProduto;
import Dao.Produto;

/**
 * Servlet implementation class ExcluirProduto
 */
@WebServlet("/ExcluirProduto")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoProduto dao=new DaoProduto();
		String id = request.getParameter("Id");
		if(id != null){
			dao.Delete(Integer.parseInt(id));
		}
		
		request.setAttribute("ListaProduto", dao.ReadAll());
		 RequestDispatcher rd = request.getRequestDispatcher("ListarProduto.jsp");
		 rd.forward(request, response);

	}

}
