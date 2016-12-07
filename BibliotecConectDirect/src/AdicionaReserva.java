

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
import org.apache.coyote.Request;

import Dao.*;
/**
 * Servlet implementation class AdicionaReserva
 */
@WebServlet("/AdicionaReserva")
public class AdicionaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaReserva() {
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
		String idAluno = request.getParameter("idAluno");
		String idProduto = request.getParameter("idProduto");
		
		System.out.println(idAluno);
		System.out.println(idProduto);
		
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
		dao.Create(reserva);
		
		DaoProduto daoP=new DaoProduto();
		daoP.UpdateReservaTrue(Integer.parseInt(reserva.getProdutoId()));
		response.sendRedirect("ListarReserva.jsp");
	}catch(Exception e){
		response.sendRedirect("home.jsp");
	}
	}

}
