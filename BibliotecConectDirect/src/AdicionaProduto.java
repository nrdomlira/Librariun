

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
 * Servlet implementation class AdicionaProduto
 */
@WebServlet("/AdicionaProduto")
public class AdicionaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto produto=new Produto();
		DaoProduto dao=new DaoProduto();
		try{
		String tipo=request.getParameter("tipoProduto");
		String titulo=request.getParameter("tituloProduto");
		String autor=request.getParameter("autorProduto");
		String autor2=request.getParameter("autorProduto2");
		if(autor2==""){
			autor2="Não Possui";
		}
		String editora=request.getParameter("editoraProduto");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String data=dateFormat.format(date);
		
		produto.setTipo(tipo);
		produto.setTitulo(titulo);
		produto.setAutor1(autor);
		produto.setAutor2(autor2);
		produto.setEditora(editora);
		produto.setDataCadastro(data);
		dao.Create(produto);
		
		request.setAttribute("ListaProduto", dao.ReadAll());
		 RequestDispatcher rd = request.getRequestDispatcher("ListarProduto.jsp");
		 rd.forward(request, response);
	}catch(Exception e){
		response.sendRedirect("Erro.html");
	}
	}

}
