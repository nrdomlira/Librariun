

import java.io.IOException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;

import Dao.*;

/**
 * Servlet implementation class AlterarAluno
 */
@WebServlet("/AlterarAluno")
public class AlterarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Aluno aluno=new Aluno();
		DaoAluno dao=new DaoAluno();
		try{
		int matricula=Integer.parseInt(request.getParameter("matriculaAlunoo"));
		String nome=request.getParameter("NomeAlunoForm");
		String cpf=request.getParameter("cpfAlunoo");
		String dataTexto=request.getParameter("dataAlunoo");
		String telefone=request.getParameter("telefoneAlunoo");
		
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setData(dataTexto);
		aluno.setTelefone(telefone);
		dao.Update(aluno);
		
		
		request.setAttribute("ListaContato", dao.ReadAll());
		 RequestDispatcher rd = 
		 request.getRequestDispatcher("ListarAluno.jsp");
		 rd.forward(request, response);
		}catch(Exception e){
			response.sendRedirect("Erro.html");
		}
	}

}
