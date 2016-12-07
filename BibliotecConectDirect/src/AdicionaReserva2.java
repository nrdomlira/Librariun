

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaReserva2
 */
@WebServlet("/AdicionaReserva2")
public class AdicionaReserva2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaReserva2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String idaluno = request.getParameter("IdAluno");
			String idproduto = request.getParameter("IdProduto");
			
			 RequestDispatcher rd = request.getRequestDispatcher("AdicionarReserva.jsp");
			 rd.forward(request, response);
			}catch(Exception e){
				response.sendRedirect("Erro.html");
			}// TODO Auto-generated method stub
	}

}
