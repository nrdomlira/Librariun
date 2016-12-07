

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoReserva;
import Dao.Reserva;

/**
 * Servlet implementation class AlterarReserva
 */
@WebServlet("/AlterarReserva")
public class AlterarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reserva reserva=new Reserva();
		DaoReserva dao=new DaoReserva();
		try{
		String idAluno=request.getParameter("idAluno");
		String idProduto=request.getParameter("idProduto");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String data=dateFormat.format(date);
		
		Date date1 = new Date();
		String data1=dateFormat.format(date1);
		
		
		GregorianCalendar gc=new GregorianCalendar();
		 gc.add(gc.DATE, 15); 
		 Date d1=gc.getTime();
		
		reserva.setAlunoId(idAluno);
		reserva.setProdutoId(idProduto);
		reserva.setDataReserva(data);
		reserva.setDataLimite(dateFormat.format(d1));
		dao.Update(reserva);
		
		request.setAttribute("ListaReserva", dao.ReadAll());
		 RequestDispatcher rd = request.getRequestDispatcher("ListarReserva.jsp");
		 rd.forward(request, response);
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}
	}

}
