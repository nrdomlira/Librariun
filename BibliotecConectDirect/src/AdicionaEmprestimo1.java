

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaEmprestimo1
 */
@WebServlet("/AdicionaEmprestimo1")
public class AdicionaEmprestimo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaEmprestimo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id = request.getParameter("Id");
			 RequestDispatcher rd = request.getRequestDispatcher("EmprestimoAlunos.jsp");
			 rd.forward(request, response);
			}catch(Exception e){
				response.sendRedirect("Erro.html");
			}
	}

}
