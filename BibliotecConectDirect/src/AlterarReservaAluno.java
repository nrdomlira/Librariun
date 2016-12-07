

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarReservaAluno
 */
@WebServlet("/AlterarReservaAluno")
public class AlterarReservaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarReservaAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int idAluno=Integer.parseInt(request.getParameter("IdAluno"));
			int idProduto=Integer.parseInt(request.getParameter("IdProduto"));
			 RequestDispatcher rd = request.getRequestDispatcher("AdicionarReserva4.jsp");
			 rd.forward(request, response);
			}catch(Exception e){
				response.sendRedirect("Erro.html");
			}
	}

}
