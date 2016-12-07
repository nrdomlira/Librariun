

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
 * Servlet implementation class AlterarProduto
 */
@WebServlet("/AlterarProduto")
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Produto produto=new Produto();
		DaoProduto dao=new DaoProduto();
		try{
		int id=Integer.parseInt(request.getParameter("Id"));
		String tipo=request.getParameter("tipoProduto");
		String titulo=request.getParameter("tituloProduto");
		String autor1=request.getParameter("autorProduto");
		String autor2=request.getParameter("autorProduto2");
		String editora=request.getParameter("editoraProduto");
		String data=request.getParameter("Data");
		
		produto.setId(id);
		produto.setTipo(tipo);
		produto.setTitulo(titulo);
		produto.setAutor1(autor1);
		produto.setAutor2(autor2);
		produto.setEditora(editora);
		produto.setDataCadastro(data);
    	dao.Update(produto);
		
    	request.setAttribute("ListarProduto", dao.ReadAll());
		 RequestDispatcher rd = 
		 request.getRequestDispatcher("ListarProduto.jsp");
		 rd.forward(request, response);
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}
    }
	
}
