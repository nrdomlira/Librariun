package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

public class DaoFuncionario {
	static Connection conn;

	public DaoFuncionario(){
		try{
			if(conn == null){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBiblioTec","root","24556911");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Create(Funcionario obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO tbfuncionario "
					+ "(matriculaFuncionario,cpfFuncionario,nomeFuncionario"
					+ ",nascimentoFuncionario,telefoneFuncionario,tipoUsuario)VALUES"+"(?,?,?,?,?,?)");
			stmt.setInt(1, obj.getMatricula());
			stmt.setString(2, obj.getCpf());
			stmt.setString(3, obj.getNome());
			stmt.setString(4, obj.getData());
			stmt.setString(5, obj.getTelefone());
			stmt.setString(6, obj.getTipo());
			
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public Funcionario Read(int id) {
		Funcionario funcionario=new Funcionario();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbfuncionario where matriculaFuncionario=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int matricula=res.getInt("matriculaFuncionario");
				String cpf=res.getString("cpfFuncionario");
				String nome=res.getString("nomeFuncionario");
				String nascimento=res.getString("nascimentoFuncionario");
				String telefone=res.getString("telefoneFuncionario");
				String tipo=res.getString("tipoUsuario");
				
				funcionario.setMatricula(matricula);
				funcionario.setCpf(cpf);
				funcionario.setNome(nome);
				funcionario.setData(nascimento);
				funcionario.setTelefone(telefone);
				funcionario.setTipo(tipo);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return funcionario;
	}
	public Funcionario ReadCpf(String cpff){
		Funcionario funcionario=new Funcionario();
		
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbfuncionario where cpfFuncionario=?");
			stmt.setString(1, cpff);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int matricula=res.getInt("matriculaFuncionario");
				String cpf=res.getString("cpfFuncionario");
				String nome=res.getString("nomeFuncionario");
				String nascimento=res.getString("nascimentoFuncionario");
				String telefone=res.getString("telefoneFuncionario");
				String tipo=res.getString("tipoUsuario");
				
				funcionario.setMatricula(matricula);
				funcionario.setCpf(cpf);
				funcionario.setNome(nome);
				funcionario.setData(nascimento);
				funcionario.setTelefone(telefone);
				funcionario.setTipo(tipo);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return funcionario;
	}
	public void Update(Funcionario obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbfuncionario SET "
					+ "cpfFuncionario=?,nomeFuncionario=?,nascimentoFuncionario=?,telefoneFuncionario=?,tipoUsuario=? WHERE matriculaFuncionario=?");
			stmt.setString(1,obj.getCpf());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getData());
			stmt.setString(4, obj.getTelefone());
			stmt.setString(5, obj.getTipo());
			stmt.setInt(6, obj.getMatricula());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		try{
			PreparedStatement stmt=conn.prepareStatement("DELETE FROM tbfuncionario WHERE matriculaFuncionario=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public List ReadAll() {
		List<Funcionario> ListContatos=new ArrayList<Funcionario>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbfuncionario");

			while(res.next()){
				int matricula=res.getInt("matriculaFuncionario");
				String cpf=res.getString("cpfFuncionario");
				String nome=res.getString("nomeFuncionario");
				String nascimento=res.getString("nascimentoFuncionario");
				String telefone=res.getString("telefoneFuncionario");
				String tipo=res.getString("tipoUsuario");

				Funcionario funcionario=new Funcionario();

				funcionario.setMatricula(matricula);
				funcionario.setCpf(cpf);
				funcionario.setNome(nome);
				funcionario.setData(nascimento);
				funcionario.setTelefone(telefone);
				funcionario.setTipo(tipo);
				ListContatos.add(funcionario);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ListContatos;
	}
}
