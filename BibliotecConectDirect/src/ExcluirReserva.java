

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoProduto;
import Dao.DaoReserva;
import Dao.Produto;
import Dao.Reserva;

/**
 * Servlet implementation class ExcluirReserva
 */
@WebServlet("/ExcluirReserva")
public class ExcluirReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoReserva dao=new DaoReserva();
		Reserva reserva= new Reserva();
		DaoProduto daoP=new DaoProduto();
		Produto produto=new Produto();
		
		String id=request.getParameter("Id");
		reserva=dao.Read(Integer.parseInt(id));	
		produto=daoP.Read(Integer.parseInt(reserva.getProdutoId()));
		
		daoP.UpdateReservaFalse(produto.getId());
		
		dao.Delete(Integer.parseInt(id));
		response.sendRedirect("ListarReserva.jsp");
	}

}
